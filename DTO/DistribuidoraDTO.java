import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Representação de uma Distribuidora")
public class DistribuidoraDTO {

    @Schema(description = "Nome da distribuidora", example = "Paramount Pictures")
    private String nome;
}
