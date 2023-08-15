package ProjectManagementBoardAPI.MyProject.Model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boards")
public class Board  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    String title;

    @OneToMany(mappedBy = "board")
    List<Card> cards;

    public Board(Integer id) {
        this.id = id;
    }

    public Board(Integer id, String title, Map<Integer, String> columns) {
        this.id = id;
        this.title = title;
    }

    // Helper method to get section name by section index
    public static String getSectionName(int sectionIndex) {
        switch (sectionIndex) {
            case 1:
                return "To Do";
            case 2:
                return "In Progress";
            case 3:
                return "Done";
            default:
                return "Unknown";
        }
    }
}
