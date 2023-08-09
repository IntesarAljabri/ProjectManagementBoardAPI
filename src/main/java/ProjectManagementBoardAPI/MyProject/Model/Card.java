package ProjectManagementBoardAPI.MyProject.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String description;
    Integer section;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    Board board;


    // Getter for section name
    public String getSectionName() {
        return Board.getSectionName(this.section);
    }
}
