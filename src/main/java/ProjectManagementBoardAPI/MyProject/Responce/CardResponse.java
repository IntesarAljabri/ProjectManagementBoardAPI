package ProjectManagementBoardAPI.MyProject.Responce;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {

    Integer id;
    String title;
    String description;
    Integer section;

    public String getSectionName() {
        return Board.getSectionName(this.section);
    }

}
