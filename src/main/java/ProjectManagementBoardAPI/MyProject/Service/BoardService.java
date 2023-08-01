package ProjectManagementBoardAPI.MyProject.Service;

import ProjectManagementBoardAPI.MyProject.Model.Board;
import ProjectManagementBoardAPI.MyProject.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    //add new board
    public Board addBoard(Board board) {
        return boardRepository.save(board);
    }
    //get all Board
    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }


    //get Board by id
    public Board getBoardById(Integer id) {
        return boardRepository.findById(id).get();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    //delete Board
    public String deleteBoard(Integer id) {
        boardRepository.deleteById(id);
        return "Deleted  Successfully";
    }

   

}
