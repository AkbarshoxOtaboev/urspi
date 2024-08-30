package uz.urspi.urspi.eventInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventInfoRepository extends JpaRepository<EventInfo, Long> {
    List<EventInfo> findByEventId(Long eventId);
}
