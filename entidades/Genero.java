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
    private Long id;
}
