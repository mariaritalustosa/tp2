import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name = "distribuidora")
public class Distribuidora {
    @Id
    @GeneratedValue(strategy = GeneratedType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "o nome da distribuidora é obrigatório")
    @Size(max = 100, message = "o nome da distribuidora não pode ter mais que 100 caracteres")
    @Column(name = "nome", nullable = false)
    private String nome;

    public Distribuidora(String nome){
        this.nome=nome;
    }

}
