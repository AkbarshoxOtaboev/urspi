package uz.urspi.urspi.structure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StructureRepository extends JpaRepository<Structure, Long> {
    boolean existsByName(String name);
}
