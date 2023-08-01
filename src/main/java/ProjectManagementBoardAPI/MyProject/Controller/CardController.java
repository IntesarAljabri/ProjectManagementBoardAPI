package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import ProjectManagementBoardAPI.MyProject.Repository.CardRepository;
import ProjectManagementBoardAPI.MyProject.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
