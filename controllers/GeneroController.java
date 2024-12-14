import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api_filmes/generos")
public class GeneroController {
    
    private final GeneroRepository generoRepository;

    @GetMapping("")
    public List<Genero> recuperarGeneros() {
        return generoRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Genero salvarGenero(@RequestBody Genero generoSalvar) {
        return generoRepository.save(generoSalvar);
    }

    @PutMapping("{id}")
    public Genero atualizarGenero(@PathVariable ("id") Long id, @RequestBody Genero paraAtualizar) {
        return generoRepository.findById(id)
            .map(generoExistente -> {
                paraAtualizar.setId(generoExistente.getId());
                return generoRepository.save(paraAtualizar);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genero não encontrado: " + id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("id")Long id){
        generoRepository.findById(id).map(genero ->{
            generoRepository.delete(genero);
            return genero;
        }).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Genero não encontrado")
        );
    }
    
    
}

