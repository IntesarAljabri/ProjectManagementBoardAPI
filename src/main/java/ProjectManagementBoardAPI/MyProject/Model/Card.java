package ProjectManagementBoardAPI.MyProject.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class Card extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String description;
    Integer section;

    @JsonIgnore
    @ManyToOne
    //@JoinColumn(name = "board_id")
    Board board;
}
