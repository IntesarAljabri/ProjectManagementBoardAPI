package ProjectManagementBoardAPI.MyProject.Repository;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Card findByIdAndBoardId(Integer cardId, Integer boardId);

    List<Card> findByBoardId(Integer boardId);
}
