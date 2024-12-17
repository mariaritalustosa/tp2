import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api_filmes/filmes")
@Tag(name = "Filmes", description = "Gerenciamento de filmes no catálogo")
public class FilmeController {

    private final FilmeRepository filmeRepository;


    @Operation(summary = "Listar todos os filmes", description = "Recupera todos os filmes do catálogo.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista de filmes recuperada com sucesso."),
        @ApiResponse(responseCode = "500", description = "Erro.")
    })
    @GetMapping("")
    public List<Filme> recuperarFilmes() {
        return filmeRepository.findAll();
    }

    @Operation(summary = "Adicionar um novo filme", description = "Adiciona um novo filme ao catálogo.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Filme criado com sucesso."),
        @ApiResponse(responseCode = "400", description = "Dados inválidos.")
    })
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Filme salvarFilme(
            @Parameter(description = "Dados do filme a ser criado", required = true) 
            @Valid @RequestBody Filme filmeSalvar) {
        return filmeRepository.save(filmeSalvar);
    }

    @Operation(summary = "Atualizar um filme", description = "Atualiza as informações de um filme existente.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Filme atualizado com sucesso."),
        @ApiResponse(responseCode = "404", description = "Filme não encontrado.")
    })
    @PutMapping("{id}")
    public Filme atualizarFilme(
            @Parameter(description = "ID do filme a ser atualizado", required = true) 
            @PathVariable("id") Long id,
            @Parameter(description = "Novos dados para o filme", required = true) 
            @Valid @RequestBody Filme paraAtualizar) {
        return filmeRepository.findById(id)
            .map(filmeExistente -> {
                paraAtualizar.setId(filmeExistente.getId());
                return filmeRepository.save(paraAtualizar);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado: " + id));
    }

    @Operation(summary = "Remover um filme", description = "Remove um filme existente pelo ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Filme removido com sucesso."),
        @ApiResponse(responseCode = "404", description = "Filme não encontrado.")
    })
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(
            @Parameter(description = "ID do filme a ser removido", required = true) 
            @PathVariable("id") Long id) {
        filmeRepository.findById(id).map(filme -> {
            filmeRepository.delete(filme);
            return filme;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }
}
