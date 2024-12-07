import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    
    @Autowired
    private GeneroRepository generoRepository;

    public List <Genero> listarTodos(Genero genero){
        return generoRepository.findAll();
    }
}
