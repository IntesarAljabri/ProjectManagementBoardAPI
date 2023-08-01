package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Repository.CardRepository;
import ProjectManagementBoardAPI.MyProject.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
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

}
