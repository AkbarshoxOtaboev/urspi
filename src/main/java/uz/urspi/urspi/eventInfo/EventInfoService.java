package uz.urspi.urspi.eventInfo;

import uz.urspi.urspi.events.Event;

import java.util.List;

public interface EventInfoService {

    void addEventInfo(EventInfoDTO eventInfoDTO, Event event);

    List<EventInfo> getEventInfosByEventId(Long eventId);

    void removeEventInfo(Long eventInfoId);

    void updateEventInfo(EventInfoDTO eventInfoDTO, Long eventInfoId);

    EventInfo fetchEventById(Long eventInfoId);
}
