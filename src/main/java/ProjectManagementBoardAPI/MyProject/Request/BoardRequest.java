package ProjectManagementBoardAPI.MyProject.Request;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    Integer Id;
    String title;

    public Board ConvertToBoard(){
        Board board = new Board();
        board.setId(this.getId());
        board.setTitle(this.getTitle());
        return board;
    }

}
