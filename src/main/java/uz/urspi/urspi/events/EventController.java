package uz.urspi.urspi.events;

import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.urspi.urspi.eventInfo.EventInfo;
import uz.urspi.urspi.eventInfo.EventInfoDTO;
import uz.urspi.urspi.eventInfo.EventInfoService;
import uz.urspi.urspi.user.User;
import uz.urspi.urspi.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final UserService userService;
    private final EventInfoService eventInfoService;

    @GetMapping("/events")
    public String getEventsPage(Model model) {
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        model.addAttribute("title", "Events");
        List<Event> events = eventService.fetchAllEvents();
        model.addAttribute("events", events);
        Event event = new Event();
        model.addAttribute("event", event);
        return "admin/events";
    }

    @PostMapping("/event/create")
    public String createEvent(@ModelAttribute("event") Event event) {
        eventService.create(event);
        return "redirect:/dashboard/events";
    }

    @GetMapping("/event/getOne")
    @ResponseBody
    public Event getOneEvent(Long id) {
        return eventService.getEvent(id);
    }

    @PostMapping("/event/edit")
    public String updateEvent(@ModelAttribute("event") Event event) {
        eventService.update(event, event.getId());
        return "redirect:/dashboard/events";
    }

    @GetMapping("/event/delete")
    public String deleteEvent(@RequestParam("id") Long id) {
        eventService.delete(id);
        return "redirect:/dashboard/events";
    }

    @GetMapping("/event/addEventInfo")
    public String addEventInfo(Model model, @RequestParam("id") Long id) {
        model.addAttribute("event", eventService.getEvent(id));
        User user =userService.getCurrentUser();
        model.addAttribute("user", user);
        EventInfoDTO eventInfoDTO = new EventInfoDTO();
        model.addAttribute("eventInfoDTO", eventInfoDTO);
        List<EventInfo> eventInfos = eventInfoService.getEventInfosByEventId(id);
        model.addAttribute("eventInfos", eventInfos);
        return "admin/eventInfo";
    }
    @PostMapping("/event/eventInfo/create")
    public String createEventInfo(EventInfoDTO eventInfoDTO, Model model, Long id) {
        eventInfoService.addEventInfo(eventInfoDTO, eventService.getEvent(id));
        return addEventInfo(model, id);
    }
}
