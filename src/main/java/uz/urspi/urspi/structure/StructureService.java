package uz.urspi.urspi.structure;

import java.util.List;

public interface StructureService {
    void create(Structure structure);
    void update(Structure structure, Long id);
    List<Structure> getAllStructures();
    Structure getStructureById(Long id);
    void delete(Long id);
    boolean isStructureExist(String name);
}
