package ProjectManagementBoardAPI.MyProject.Service;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;


    //add new Card
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    //get all Card
    public List<Card> getAllCard() {
        return cardRepository.findAll();
    }

    //get Card by id
    public Card getCardById(Integer id) {
        return cardRepository.findById(id).get();
    }

    
}
