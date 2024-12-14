import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api_filmes/generos")
public class GeneroController {
    
    private final GeneroRepository generoRepository;

    @GetMapping("")
    public List<Genero> recuperarGeneros() {
        return generoRepository.findAll();
    }
    
}

