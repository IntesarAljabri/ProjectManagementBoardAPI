package ProjectManagementBoardAPI.MyProject.Controller;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Responce.BoardResponse;
import ProjectManagementBoardAPI.MyProject.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
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
        try {
            boardService.createBoard(board);
            BoardResponse boardResponse = new BoardResponse(
                    board.getId(),
                    board.getTitle()
            );
            return boardResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return new BoardResponse(-1, "Error creating board");
        }
    }


    //Get All Board
    @GetMapping
    public List<BoardResponse> getAllBoard() {
        try {
            List<Board> boardList = boardService.getAllBoard();
            List<BoardResponse> boardResponseList = new ArrayList<>();

            for (Board board : boardList) {
                BoardResponse boardResponse = new BoardResponse();
                boardResponse.setId(board.getId());
                boardResponse.setTitle(board.getTitle());

                boardResponseList.add(boardResponse);
            }
            return boardResponseList;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable Integer id) {
        Board board = boardService.getBoardById(id);

        if (board == null) {
            // Create a default board and save it
            Board defaultBoard = new Board();
            defaultBoard.setTitle("Default Board Title");
            board = boardService.createBoard(defaultBoard);
            return new ResponseEntity<>(board, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(board, HttpStatus.OK);
    }


    // Delete board by id
    @DeleteMapping("/{id}")
    public String deleteBoardById(@PathVariable Integer id) {
        try {
            boardService.deleteBoardById(id);
            return "Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting the board";
        }
    }


    // Update information about board
    @PutMapping("/{boardId}")
    public BoardResponse updateBoard(@PathVariable Integer boardId, @RequestBody Board updatedBoard) {
        try {
            Board board = boardService.getBoardById(boardId);
            board.setTitle(updatedBoard.getTitle());
            boardService.createBoard(board);

            BoardResponse boardResponse = new BoardResponse();
            boardResponse.setId(board.getId());
            boardResponse.setTitle(updatedBoard.getTitle());

            return boardResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return new BoardResponse(-1, "Error updating board");

        }
    }
}


