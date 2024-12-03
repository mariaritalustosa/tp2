import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "diretor")
public class Diretor {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    private Long id;
    private String nome;
}
