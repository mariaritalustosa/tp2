import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> listarTodos(Filme filme){
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id){
        return filmeRepository.findById
        .orElseThrow(()-> new RuntimeException("Filme não encontrado" +id));
    }

    
}

    

