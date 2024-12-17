import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Representação de um Diretor")
public class DiretorDTO {

    @Schema(description = "ID do diretor", example = "1")
    private Long id;

    @Schema(description = "Nome do diretor", example = "Quentin Tarantino")
    private String nome;
}
