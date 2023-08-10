package ProjectManagementBoardAPI.MyProject.Service;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Board getBoardById(Integer boardId) {
        return boardRepository.findById(boardId).orElse(null);

    }
        // Delete Board
        public String deleteBoardById(Integer boardid) {
            boardRepository.deleteById(boardid);
            return "Deleted Successfully";
        }

        //Update Board
    public Board updateBoard(Long boardId, Board updatedBoard) {
        Board existingBoard = boardRepository.findById(Math.toIntExact(boardId)).orElse(null);
        if (existingBoard == null) {
            return null; // Board not found
        }

        existingBoard.setTitle(updatedBoard.getTitle());
        return boardRepository.save(existingBoard);
    }
}
    
