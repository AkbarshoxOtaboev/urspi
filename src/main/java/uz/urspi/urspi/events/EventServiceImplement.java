package uz.urspi.urspi.events;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImplement implements EventService {

    private final EventRepository eventRepository;

    @Override
    public void create(Event event) {
        event.setStatus(1);
        eventRepository.save(event);
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Event> fetchAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void update(Event event, Long id) {
        Event updateEvent = eventRepository.findById(id).orElseThrow();
        updateEvent.setTitle(event.getTitle());
        updateEvent.setDescription(event.getDescription());
        updateEvent.setStatus(event.getStatus());
        eventRepository.saveAndFlush(updateEvent);
    }

    @Override
    public void delete(Long id) {
        Event deleteEvent = eventRepository.findById(id).orElseThrow();
        deleteEvent.setStatus(0);
        eventRepository.saveAndFlush(deleteEvent);
    }
}
