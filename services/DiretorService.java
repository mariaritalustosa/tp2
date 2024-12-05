import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;
    
    public List<Diretor> listarTodos(Long id){
        return diretorRepository.findAll();
    }
    
}
