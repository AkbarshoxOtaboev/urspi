package uz.urspi.urspi.structure;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StructureServiceImplement implements StructureService {
    private final StructureRepository structureRepository;

    @Override
    public void create(Structure structure) {
        structure.setStatus(1);
        structureRepository.save(structure);
    }

    @Override
    public void update(Structure structure, Long id) {
        Structure oldStructure = structureRepository.findById(id).orElseThrow();
        oldStructure.setStatus(structure.getStatus());
        oldStructure.setName(structure.getName());
        structureRepository.saveAndFlush(oldStructure);
    }

    @Override
    public List<Structure> getAllStructures() {
        return structureRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Structure getStructureById(Long id) {
        return structureRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        Structure structure = structureRepository.findById(id).orElse(null);
        structure.setStatus(0);
        structureRepository.saveAndFlush(structure);
    }

    @Override
    public boolean isStructureExist(String name) {
        return structureRepository.existsByName(name);
    }
}
