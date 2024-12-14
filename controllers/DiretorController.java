import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api_filmes/diretor")
public class DiretorController {
    private final DiretorRepository diretorRepository;
}
