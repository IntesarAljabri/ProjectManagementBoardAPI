package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService;
}
