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
    
}
