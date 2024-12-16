import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api_filmes/diretor")
public class DiretorController {
    private final DiretorRepository diretorRepository;

    @GetMapping("")
    public List<Diretor> recuperarDiretor() {
        return diretorRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Diretor salvarDiretor(@RequestBody @Valid Diretor diretorSalvar) {
        return diretorRepository.save(diretorSalvar);
    }

    @PutMapping("{id}")
    public Diretor atualizarDiretor(@PathVariable("id") Long id, @RequestBody Diretor paraAtualizar) {
        return diretorRepository.findById(id)
            .map(diretorExistente -> {
                paraAtualizar.setId(diretorExistente.getId());
                return diretorRepository.save(paraAtualizar);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diretor não encontrado: " + id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("id")Long id){
        diretorRepository.findById(id).map(diretor ->{
            diretorRepository.delete(diretor);
            return diretor;
        }).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diretor não encontrado")
        );
    }
    
}
