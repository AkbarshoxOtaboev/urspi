package uz.urspi.urspi.position;

import java.util.List;

public interface PositionsService {

    void createPositions(Positions positions);

    void updatePositions(Positions positions, Long positionId);

    void deletePositions(Long positionId);

    Positions getPositions(Long positionId);

    List<Positions> getAllPositions();

    boolean isPositionExistsByName(String positionName);
}
