package uz.urspi.urspi.eventInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.urspi.urspi.events.Event;
import uz.urspi.urspi.storage.StorageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventInfoServiceImplement implements EventInfoService {
    private final EventInfoRepository eventInfoRepository;
    private final StorageService storageService;

    @Override
    public void addEventInfo(EventInfoDTO eventInfoDTO, Event event) {
        String filePath = storageService.store(eventInfoDTO.getFile());
        EventInfo eventInfo = new EventInfo();
        eventInfo.setName(eventInfoDTO.getName());
        eventInfo.setPath(filePath);
        eventInfo.setStatus(1);
        eventInfo.setEvent(event);
        eventInfoRepository.save(eventInfo);
    }

    @Override
    public List<EventInfo> getEventInfosByEventId(Long eventId) {
        return eventInfoRepository.findByEventId(eventId);
    }

    @Override
    public void removeEventInfo(Long eventInfoId) {
        EventInfo eventInfo = eventInfoRepository.findById(eventInfoId).orElseThrow(null);
        eventInfo.setStatus(0);
        eventInfoRepository.saveAndFlush(eventInfo);
    }

    @Override
    public void updateEventInfo(EventInfoDTO eventInfoDTO, Long eventInfoId) {
        EventInfo updEventInfo = eventInfoRepository.findById(eventInfoId).orElseThrow(null);
    }

    @Override
    public EventInfo fetchEventById(Long eventInfoId) {
        return eventInfoRepository.findById(eventInfoId).orElse(null);
    }
}
