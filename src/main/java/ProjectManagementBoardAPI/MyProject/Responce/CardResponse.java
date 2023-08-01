package ProjectManagementBoardAPI.MyProject.Responce;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Model.Card;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResponse {

    Integer id;
    String title;
    String description;
    String section;

    public static CardResponse convertRequestToResponse(Card cardRequest) {
        return CardResponse.builder()
                .id(cardRequest.getId())
                .title(cardRequest.getTitle())
                .description(cardRequest.getDescription())
                .section(cardRequest.getSection())
                .build();
    }
}
