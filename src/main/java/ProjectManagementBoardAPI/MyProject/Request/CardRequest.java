package ProjectManagementBoardAPI.MyProject.Request;

import ProjectManagementBoardAPI.MyProject.Model.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {
    Integer id;
    String title;
    String description;
    Integer section;

    public Card convertToCard(){
        Card card = new Card();
        card.setId(this.getId());
        card.setTitle(this.getTitle());
        card.setDescription(this.getDescription());
        card.setSection(this.getSection());

        return card;
    }


}
