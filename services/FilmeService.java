import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> listarTodos(){
        return filmeRepository.findAll();
    }
}

    

