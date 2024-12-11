import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api_filmes/filmes")
public class FilmeController {

    @Autowired
    public FilmeController(FilmeRepository repository){
        this.repository=repository;
    }
}
