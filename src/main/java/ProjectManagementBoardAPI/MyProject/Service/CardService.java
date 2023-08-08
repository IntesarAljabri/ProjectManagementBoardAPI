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


        //delete Card
        public String deleteCard(Integer id) {
            cardRepository.deleteById(id);
            return "Deleted  Successfully";
        }


        // Update information about card
        public Board updateCard(Card updateData) {
            Card card = cardRepository.findById(updateData.getId()).orElse(null);
            if (card != null) {
                if (updateData.getId() != null) {
                    card.setId(updateData.getId());
                }
                if (updateData.getTitle() != null) {
                    card.setTitle(updateData.getTitle());
                }
                if (updateData.getDescription() != null) {
                    card.setTitle(updateData.getDescription());
                }
                if (updateData.getSection() != null) {
                    card.setTitle(updateData.getSection());
                }
                return cardRepository.save(card).getBoard();
            }
            return null;
        }
}
