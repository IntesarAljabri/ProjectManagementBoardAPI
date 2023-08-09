package ProjectManagementBoardAPI.MyProject.Responce;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResponse {

    Integer id;
    String title;
    String description;
    Integer section;

    public String getSectionName() {
        return Board.getSectionName(this.section);
    }

}
