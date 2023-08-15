package ProjectManagementBoardAPI.MyProject.Controller;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Responce.CardResponse;
import ProjectManagementBoardAPI.MyProject.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/boards/{boardId}/cards")
public class CardController {

        @Autowired
        CardService cardService;

        // Add new Card
        @PostMapping
        public CardResponse createCard(@PathVariable Integer boardId, @RequestBody Card card) {
            try {
            cardService.addCard(boardId, card);

            CardResponse cardResponse = new CardResponse(
                    card.getId(),
                    card.getTitle(),
                    card.getDescription(),
                    card.getSection()
            );
            return cardResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return new CardResponse(-1, "Error creating cad","null",1);
        }
    }


       //Get All Card
        @GetMapping
        public List<Card> getAllCards(@PathVariable("boardId") Integer boardID) {
            try {
                List<Card> cards = cardService.getAllCardsByBoard(boardID);
                return cards;
            } catch (Exception e) {

                e.printStackTrace();
                return Collections.emptyList();
            }
    }

        //Get Card by Id
        @GetMapping("/{cardId}")
        public Card getCardById(@PathVariable("boardId") Integer boardId,
                                @PathVariable("cardId") Integer cardId) {
        try {
            return cardService.getCardByBoardIdAndCardID(cardId, boardId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


        // Delete Card by id
        @DeleteMapping("/{id}")
        public String deleteCard(@PathVariable Integer id) {
            try {
                cardService.deleteCard(id);
                return "Deleted Successfully";
            } catch (Exception e) {
                e.printStackTrace();
                return "Error deleting the card";
            }
        }


         //Update card information
        @PutMapping("/{cardId}")
        public Card updateCard(
                @PathVariable Integer boardId,
                @PathVariable Integer cardId,
                @RequestBody Card cardRequest
        ) {
            try {
                Card updatedCard = cardService.updateCard(cardId, boardId, cardRequest);
                return updatedCard;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}
