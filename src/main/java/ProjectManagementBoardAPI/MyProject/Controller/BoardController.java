package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Responce.BoardResponse;
import ProjectManagementBoardAPI.MyProject.Service.BoardService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    // Add new board
    @PostMapping
    public BoardResponse createBoard(@RequestBody Board board) {
        boardService.createBoard(board);

        // Map the createdBoard attributes to a new BoardResponse object
        BoardResponse boardResponse = new BoardResponse(
                board.getId(),
                board.getTitle()
        );

        return boardResponse;
    }
    //Get All Board
    @GetMapping
    public List<BoardResponse> getAllBoard() {
        List<Board> boardList = boardService.getAllBoard();
        List<BoardResponse> boardResponseList = new ArrayList<>();

        for(Board board : boardList){
            BoardResponse boardResponse = new BoardResponse();
            boardResponse.setId(board.getId());
            boardResponse.setTitle(board.getTitle());

            boardResponseList.add(boardResponse);
        }
        return boardResponseList;
    }

    //Get Board by id
    @GetMapping(value = "/{id}")
    public Board getBoardById(@PathVariable Integer id) {
        return boardService.getBoardById(id);
    }

    // Delete board by id
    @DeleteMapping("/{id}")
    public String deleteBoardById(@PathVariable Integer id) {
        boardService.deleteBoardById(id);
        return "Deleted Successfully";
 }


    // Update information about board
    @PutMapping("/{boardId}")
    public BoardResponse updateBoard(@PathVariable Integer boardId, @RequestBody Board updatedBoard) {
        Board board = boardService.getBoardById(boardId);
        board.setTitle(updatedBoard.getTitle());
        boardService.createBoard(board);
        BoardResponse boardResponse = new BoardResponse();
        boardResponse.setId(board.getId());
        boardResponse.setTitle(updatedBoard.getTitle());

        return boardResponse;
    }
}


