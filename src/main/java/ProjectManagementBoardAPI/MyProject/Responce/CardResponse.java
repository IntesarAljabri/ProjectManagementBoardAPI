package ProjectManagementBoardAPI.MyProject.Responce;

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
}
