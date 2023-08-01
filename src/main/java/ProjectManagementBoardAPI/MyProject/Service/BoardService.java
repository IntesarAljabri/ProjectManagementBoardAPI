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

        //delete Board
        public String deleteBoard(Integer id) {
            boardRepository.deleteById(id);
            return "Deleted  Successfully";
        }

         // Update information about Board
         public Board updateBoard(Board updateData) {
             Board board = boardRepository.findById(updateData.getId()).orElse(null);
             if (board != null) {
                 if (updateData.getId() != null) {
                     board.setId(updateData.getId());
                 }
                 if (updateData.getTitle() != null) {
                     board.setTitle(updateData.getTitle());
                 }

                 return boardRepository.save(board);
             }
             return null;
         }

}
