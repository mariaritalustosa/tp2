import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api_filmes/filmes")
public class FilmeController {

    private final FilmeRepository filmeRepository;

    @GetMapping("")
    public List<Filme> recuperarFilmes() {
        return filmeRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Filme salvarFilme(@RequestBody Filme filmeSalvar) {
        return filmeRepository.save(filmeSalvar);
    }
    
    @PutMapping("{id}")
    public Filme atualizarFilme(@PathVariable("id") Long id, @RequestBody Filme paraAtualizar) {
        return filmeRepository.findById(id)
            .map(filmeExistente -> {
                paraAtualizar.setId(filmeExistente.getId());
                return filmeRepository.save(paraAtualizar);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado: " + id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("id")Long id){
        filmeRepository.findById(id).map(filme ->{
            filmeRepository.delete(filme);
            return filme;
        }).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "filme não encontrado")
        );
    }
    
}
