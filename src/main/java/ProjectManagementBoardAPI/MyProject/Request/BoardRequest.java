package ProjectManagementBoardAPI.MyProject.Request;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
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
