package ProjectManagementBoardAPI.MyProject.Service;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CardService {

        @Autowired
        CardRepository cardRepository;

        @Autowired
        BoardService boardService;

        //add new Card
    public Card addCard(Integer boardId, Card card) {
        try {
            Board board = boardService.getBoardById(boardId);
            card.setBoard(board);
            return cardRepository.save(card);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //get all Card
    public Card getCardByBoardIdAndCardID(Integer cardId, Integer boardID) {
        try {
            return cardRepository.findByIdAndBoardId(cardId, boardID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Card> getAllCardsByBoard(Integer boardId) {
        try {
            return cardRepository.findByBoardId(boardId);
        } catch (Exception e) {
            e.printStackTrace();

            return Collections.emptyList();
        }
    }

        //get Card by id
        public Card getCardById(Integer id) {
            return cardRepository.findById(id).get();
        }


        //delete Card
    public String deleteCard(Integer id) {
        try {
            cardRepository.deleteById(id);
            return "Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting the card";
        }
    }
        // Update information about card
    public Card updateCard(Integer cardId, Integer boardId, Card updatedCard) {
            try {
                Card card = cardRepository.findByIdAndBoardId(cardId, boardId);

                if (card != null) {
                    card.setTitle(updatedCard.getTitle());
                    card.setDescription(updatedCard.getDescription());
                    card.setSection(updatedCard.getSection());

                    cardRepository.save(card);
                    return card;
                } else {
                    return null;
                }
            } catch (Exception e) {

                e.printStackTrace();
                return null;
            }
        }
}
