package uz.urspi.urspi.eventInfo;

import uz.urspi.urspi.events.Event;

import java.util.List;

public interface EventInfoService {

    void addEventInfo(EventInfo eventInfo, Event event);

    List<EventInfo> getEventInfosByEventId(Long eventInfoId);

    void removeEventInfo(Long eventInfoId);

    void updateEventInfo(EventInfo eventInfo, Long eventInfoId);

    EventInfo fetchEventById(Long eventInfoId);
}
