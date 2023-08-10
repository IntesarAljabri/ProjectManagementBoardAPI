package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Request.CardRequest;
import ProjectManagementBoardAPI.MyProject.Responce.CardResponse;
import ProjectManagementBoardAPI.MyProject.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/boards/{boardId}/cards")
public class CardController {

        @Autowired
        CardService cardService;

        // Add new Card
        @PostMapping
        public CardResponse createCard(@PathVariable Integer boardId , @RequestBody Card card) {

            cardService.addCard(boardId, card);

            CardResponse cardResponse = new CardResponse(
                    card.getId(),
                    card.getTitle(),
                    card.getDescription(),
                    card.getSection()
            );
            return cardResponse;
        }

        //Get All Card
        @GetMapping
        public List<Card> getAllCards(@PathVariable("boardId") Integer boardID) {
            List<Card> cards = cardService.getAllCardsByBoard(boardID);
            return cards;
        }

        //Get Card by Id
       @GetMapping("/{cardId}")
        public Card getCardById(@PathVariable("boardId") Integer boardId,
                                @PathVariable("cardId") Integer cardId) {
            return cardService.getCardByBoardIdAndCardID(cardId, boardId);
        }

        // Delete Card by id
        @DeleteMapping("/{id}")
        public String deleteCard(@PathVariable Integer id) {
            cardService.deleteCard(id);
            return "Deleted Successfully";
        }

         //Update card information
        @PutMapping("/{cardId}")
        public Card updateCard(
                @PathVariable Integer boardId,
                @PathVariable Integer cardId,
                @RequestBody Card cardRequest
        ) {
            Card updateCard = cardService.updateCard(cardId, boardId, cardRequest);

            return updateCard;
        }
}
