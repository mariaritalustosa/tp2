import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api_filmes/distribuidora")
public class DistribuidoraController {

    private final DistribuidoraRepository distribuidoraRepository;

    @GetMapping("")
    public List<Distribuidora> recuperarDistribuidoras() {
        return distribuidoraRepository.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Distribuidora salvarDistribuidora(@RequestBody Distribuidora distribuidoraSalvar) {
        return distribuidoraRepository.save(distribuidoraSalvar);
    }
    
    @PutMapping("{id}")
    public Distribuidora atualizarDistribuidora(@PathVariable("id") Long id, @RequestBody Distribuidora paraAtualizar) {
        return distribuidoraRepository.findById(id)
            .map(distribuidoraExistente -> {
                paraAtualizar.setId(distribuidoraExistente.getId());
                return distribuidoraRepository.save(paraAtualizar);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Distribuidora não encontrada " + id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable("id")Long id){
        distribuidoraRepository.findById(id).map(distribuidora ->{
            distribuidoraRepository.delete(distribuidora);
            return distribuidora;
        }).orElseThrow(
            ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Distribuidora não encontrada")
        );
    }
    
}
