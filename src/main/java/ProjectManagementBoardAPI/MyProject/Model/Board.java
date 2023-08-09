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
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;

    @OneToMany
    List<Card> cards;

    @ElementCollection
    @CollectionTable(name = "board_columns_mapping", joinColumns = @JoinColumn(name = "board_id"))
    @MapKeyColumn(name = "column_index")
    @Column(name = "column_name")
    private Map<Integer, String> columns;

    public Board(Integer id) {
        this.id = id;
    }

    public Board(Integer id, String title, Map<Integer, String> columns) {
        this.id = id;
        this.title = title;
        this.columns = columns;
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
