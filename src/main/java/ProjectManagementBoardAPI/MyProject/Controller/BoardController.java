package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    // Add new board
    @PostMapping(value = "add")
    public String Board(@RequestBody Board board) {
        boardService.addBoard(board);
        return "Board added";
    }

    //Get All Board
    @GetMapping(value = "getAll")
    public List<Board> getAllBoard() {
        return boardService.getAllBoard();
    }

    //Get Board by Id
    @GetMapping(value = "getById")
    public Board getBoardById(Integer id) {
        return boardService.getBoardById(id);
    }

    // Delete board by id
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Integer id) {
        boardService.deleteBoard(id);
        return "Deleted Successfully";
    }

    
    // Update information about board
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBoard(@PathVariable Integer id, @RequestBody Board board) {
        board.setId(id);
        Board updatedBoard = boardService.updateBoard(board);

        if (updatedBoard != null) {
            return ResponseEntity.ok(updatedBoard);
        }
        return ResponseEntity.notFound().build();
    }
}

