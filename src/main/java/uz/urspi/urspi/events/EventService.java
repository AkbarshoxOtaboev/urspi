package uz.urspi.urspi.events;

import java.util.List;

public interface EventService {
    void create(Event event);

    Event getEvent(Long id);

    List<Event> fetchAllEvents();

    void update(Event event, Long id);

    void delete(Long id);
}
