package ProjectManagementBoardAPI.MyProject.Service;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Board createBoard(Board board) {
        try {
            return boardRepository.save(board);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<Board> getAllBoard() {
        try {
            return boardRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Board getBoardById(Integer boardId) {
        try {
            return boardRepository.findById(boardId).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Delete Board
    public String deleteBoardById(Integer boardId) {
        try {
            boardRepository.deleteById(boardId);
            return "Deleted Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting the board";
        }
    }

    //Update Board
    public Board updateBoard(Long boardId, Board updatedBoard) {
        try {
            Board existingBoard = boardRepository.findById(Math.toIntExact(boardId)).orElse(null);
            if (existingBoard == null) {
                return null;
            }
            existingBoard.setTitle(updatedBoard.getTitle());
            return boardRepository.save(existingBoard);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return updatedBoard;
    }
}
    
