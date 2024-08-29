package uz.urspi.urspi.eventInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.urspi.urspi.events.Event;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventInfoServiceImplement implements EventInfoService {
    private final EventInfoRepository eventInfoRepository;

    @Override
    public void addEventInfo(EventInfo eventInfo, Event event) {
        eventInfo.setStatus(1);
        eventInfo.setEvent(event);
        eventInfoRepository.save(eventInfo);
    }

    @Override
    public List<EventInfo> getEventInfosByEventId(Long eventInfoId) {
        return List.of();
    }

    @Override
    public void removeEventInfo(Long eventInfoId) {

    }

    @Override
    public void updateEventInfo(EventInfo eventInfo, Long eventInfoId) {

    }

    @Override
    public EventInfo fetchEventById(Long eventInfoId) {
        return eventInfoRepository.findById(eventInfoId).orElse(null);
    }
}
