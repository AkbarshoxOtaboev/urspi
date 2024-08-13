package uz.urspi.urspi.position;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionsRepository extends JpaRepository<Positions, Long> {

    boolean existsByName(String name);
}
