package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
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
        public Card createCard(@PathVariable Integer boardId , @RequestBody Card card) {
            card.setBoard(new Board(boardId)); // Set the board for the card
            cardService.addCard(card);

            Card createdCard = cardService.addCard(card);
            CardResponse cardResponse = new CardResponse(
                    createdCard.getId(),
                    createdCard.getTitle(),
                    createdCard.getDescription(),
                    createdCard.getSection()
            );
            return createdCard;
        }

        //Get All Card
        @GetMapping
        public List<Card> getAllCard() {
            return cardService.getAllCard();
        }

        //Get Card by Id
        @GetMapping("/{id}")
        public Card getCardById(Integer id) {
            return cardService.getCardById(id);
        }

        // Delete Card by id
        @DeleteMapping("/{id}")
        public String deleteCard(@PathVariable Integer id) {
            cardService.deleteCard(id);
            return "Deleted Successfully";
        }

         //Update card information
        @PutMapping("/boardId")
        public ResponseEntity<Object> updateCard(
                @PathVariable Integer boardId,
                @PathVariable Integer cardId,
                @RequestBody Card card
        ) {
            if (!card.getId().equals(cardId)) {
                return ResponseEntity.badRequest().build();
            }
            card.setId(cardId);
            Board updatedBoard = cardService.updateCard(card).getBoard();
            if (updatedBoard != null) {
                return ResponseEntity.ok(updatedBoard);
            }
            return ResponseEntity.notFound().build();
        }
}
