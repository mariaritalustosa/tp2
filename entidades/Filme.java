import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
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

    @ManyToOne
    @JoinColumn(name = "diretor_id", referencedColumnName = "id")
    private Diretor diretor;

    @ManyToOne
    @JoinColumn(name = "distribuidora_nome", referencedColumnName = "id")
    private Distribuidora distribuidora;

    @ManyToMany
    @JoinTable(
        name = "filme_genero",
        joinColumns = @JoinColumn(name= "filme_id"),
        inverseJoinColumns = @JoinColumn (name = "genero_id")
    )
    private List<Genero> generos;

    public Filme(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }


}
