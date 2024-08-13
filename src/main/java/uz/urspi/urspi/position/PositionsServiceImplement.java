package uz.urspi.urspi.position;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionsServiceImplement implements PositionsService {

    private final PositionsRepository positionsRepository;

    @Override
    public void createPositions(Positions positions) {
        positions.setStatus(1);
        positionsRepository.save(positions);
    }

    @Override
    public void updatePositions(Positions positions, Long positionId) {
        var position = positionsRepository.findById(positionId).orElseThrow();
        position.setName(positions.getName());
        position.setStatus(positions.getStatus());
        positionsRepository.saveAndFlush(position);
    }

    @Override
    public void deletePositions(Long positionId) {
        var position = positionsRepository.findById(positionId).orElseThrow();
        position.setStatus(0);
        positionsRepository.saveAndFlush(position);
    }

    @Override
    public Positions getPositions(Long positionId) {
        return positionsRepository.findById(positionId).orElseThrow();
    }

    @Override
    public List<Positions> getAllPositions() {
        return positionsRepository.findAll();
    }

    @Override
    public boolean isPositionExistsByName(String positionName) {
        return positionsRepository.existsByName(positionName);
    }
}
