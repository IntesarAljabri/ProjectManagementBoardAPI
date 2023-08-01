package ProjectManagementBoardAPI.MyProject.Request;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {
    Integer id;
    String title;
    String description;
    String section;

    public Card toCard() {
        Card card = new Card();
        card.setId(this.getId());
        card.setTitle(this.getTitle());
        card.setDescription(this.getDescription());
        card.setSection(this.getSection());

        return card;
    }

    public static List<Card> convert(List<CardRequest> requestList) {
        List<Card> cards = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (CardRequest cardRequest : requestList) {
                cards.add((Card) convert((List<CardRequest>) cardRequest));
            }
        }
        return cards;
    }

}
