package ProjectManagementBoardAPI.MyProject.Request;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Responce.BoardResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ProjectManagementBoardAPI.MyProject.Responce.BoardResponse.convertRequestToResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    Integer Id;
    String title;

    public Board convertToBoard () {
        Board board = new Board();
        board.setId(this.getId());
        board.setTitle(this.getTitle());
        return board;
    }

    public static List<Board> convert(List<BoardRequest> requestList) {
        List<Board> boards = new ArrayList<>();
        if (!requestList.isEmpty()) {
            for (BoardRequest boardRequest : requestList) {
                boards.add((Board) convert((List<BoardRequest>) boardRequest));
            }
        }
        return boards;
    }

}
