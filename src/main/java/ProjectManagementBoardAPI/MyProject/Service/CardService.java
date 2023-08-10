package ProjectManagementBoardAPI.MyProject.Service;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Repository.BoardRepository;
import ProjectManagementBoardAPI.MyProject.Repository.CardRepository;
import ProjectManagementBoardAPI.MyProject.Request.CardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

        @Autowired
        CardRepository cardRepository;

        @Autowired
        BoardService boardService;

        //add new Card
        public Card addCard(Integer boardId, Card card) {
            Board board = boardService.getBoardById(boardId);
            card.setBoard(board);
            return cardRepository.save(card);
        }

        //get all Card
        public Card getCardByBoardIdAndCardID(Integer cardId, Integer boardID) {
            return cardRepository.findByIdAndBoardId(cardId, boardID);
        }

        public List<Card> getAllCardsByBoard(Integer boardId){
            return cardRepository.findByBoardId(boardId);
        }


        //get Card by id
        public Card getCardById(Integer id) {
            return cardRepository.findById(id).get();
        }


        //delete Card
        public String deleteCard(Integer id) {
            cardRepository.deleteById(id);
            return "Deleted  Successfully";
        }

        // Update information about card
        public Card updateCard(Integer cardId, Integer boardId, Card updatedCard) {
            Card card = cardRepository.findByIdAndBoardId(cardId, boardId);

            card.setTitle(updatedCard.getTitle());
            card.setDescription(updatedCard.getDescription());
            card.setSection(updatedCard.getSection());

            cardRepository.save(card);
            return card;
        }
}
