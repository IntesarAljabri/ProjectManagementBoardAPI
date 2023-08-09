package ProjectManagementBoardAPI.MyProject.Service;

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
        public Card updateCard(Card updatedCard) {
            Card existingCard = cardRepository.findById(updatedCard.getId()).orElse(null);
            if (existingCard == null) {
                return null; // Card not found
            }
            existingCard.setTitle(updatedCard.getTitle());
            existingCard.setDescription(updatedCard.getDescription());
            existingCard.setSection(updatedCard.getSection());

            return cardRepository.save(existingCard);
        }
}
