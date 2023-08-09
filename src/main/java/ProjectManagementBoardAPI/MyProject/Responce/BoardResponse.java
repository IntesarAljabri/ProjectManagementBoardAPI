package ProjectManagementBoardAPI.MyProject.Responce;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {

    Integer id;
    String title;


    private Map<Integer, String> columns;
}
