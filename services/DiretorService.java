import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {
    @Autowired
    private DiretorRepository diretorRepository;
    
    public List<Diretor> listarTodos(Long id){
        return diretorRepository.findAll();
    }
    
    public Diretor salvar(Diretor diretor){
        return diretorRepository.save(diretor);
    }

    public Diretor atualizar(Long id, Diretor diretor){
        if(!diretorRepository.existsById(id)){
            diretor.setId(id);
            return diretorRepository.save(diretor);
        }
        throw new DiretorNaoEncontradoException("O diretor não foi encontrado");
    }

}
