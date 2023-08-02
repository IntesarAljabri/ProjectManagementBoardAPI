package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards/{board_id}/cards")
public class CardController {

        @Autowired
        CardService cardService;

        // Add new Card
        @PostMapping(value = "add")
        public String Card(@RequestBody Card card) {
            cardService.addCard(card);
            return "Card added";
        }

        //Get All Card
        @GetMapping(value = "getAll")
        public List<Card> getAllCard() {
            return cardService.getAllCard();
        }

        //Get Card by Id
        @GetMapping(value = "getById")
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
        @PutMapping("/{boardId}/cards/{cardId}")
        public ResponseEntity<Object> updateCard(
                @PathVariable Integer boardId,
                @PathVariable Integer cardId,
                @RequestBody Card card
        ) {
            if (!card.getId().equals(cardId)) {
                return ResponseEntity.badRequest().build();
            }
            card.setId(cardId);
            Board updatedBoard = cardService.updateCard(card);
            if (updatedBoard != null) {
                return ResponseEntity.ok(updatedBoard);
            }
            return ResponseEntity.notFound().build();
        }
}
