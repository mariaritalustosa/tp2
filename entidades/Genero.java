import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "genero")
public class Genero {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
}
