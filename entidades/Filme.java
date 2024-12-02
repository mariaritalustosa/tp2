import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name= "filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "anoLancamento")
    private int anoLancamento;

    
}
