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
public class BoardResponse {

    Integer id;
    String title;

    public static BoardResponse convertRequestToResponse(Board boardRequest) {
        return BoardResponse.builder()
                .id(boardRequest.getId())
                .title(boardRequest.getTitle())
                .build();
    }
    public static List<BoardResponse> convertRequestListToResponseList(List<Board> boardsRequest) {
        List<BoardResponse> boardResponseList = new ArrayList<>();
        if (!boardsRequest.isEmpty()) {
            for (Board boardRequest : boardsRequest) {
                boardResponseList.add(convertRequestToResponse(boardRequest));
            }
        }
        return boardResponseList;
    }
}
