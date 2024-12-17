import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Representação de um Gênero")
public class GeneroDTO {

    @Schema(description = "Nome do gênero", example = "Drama")
    private String nome;
}
