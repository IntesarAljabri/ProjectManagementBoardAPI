package ProjectManagementBoardAPI.MyProject.Responce;

import ProjectManagementBoardAPI.MyProject.Model.Card;
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
    String section;

    public static CardResponse convertRequestToResponse(Card cardRequest) {
        return CardResponse.builder()
                .id(cardRequest.getId())
                .title(cardRequest.getTitle())
                .description(cardRequest.getDescription())
                .section(cardRequest.getSection())
                .build();
    }

    public static List<CardResponse> convertRequestListToResponseList(List<Card> cardsRequest) {
        List<CardResponse> cardResponseList = new ArrayList<>();
        if (!cardsRequest.isEmpty()) {
            for (Card cardRequest : cardsRequest) {
                cardResponseList.add(convertRequestToResponse(cardRequest));
            }
        }
        return cardResponseList;
    }
}
