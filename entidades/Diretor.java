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
    @Column(name ="id", nullable = false, unique = true)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;


    public Diretor(String nome) {
        this.nome = nome;
    }

}
