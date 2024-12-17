import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Representação de um Filme")
public class FilmeDTO {

    @Schema(description = "Título do filme", example = "O Poderoso Chefão")
    private String titulo;

    @Schema(description = "Ano de lançamento do filme", example = "1972")
    private int anoLancamento;

    @Schema(description = "Nome do diretor", example = "Francis Ford Coppola")
    private String diretor;

    @Schema(description = "Gênero do filme", example = "Drama")
    private String genero;

}

