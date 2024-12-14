import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Diretor salvarDiretor(@RequestBody Diretor diretorSalvar) {
        return diretorRepository.save(diretorSalvar);
    }
    

    
}
