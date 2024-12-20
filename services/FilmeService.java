import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> listarTodos(){
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id){
        return filmeRepository.findById
        .orElseThrow(()-> new RuntimeException("Filme não encontrado" +id));
    }

    public Filme salvar(Filme filme){
        return filmeRepository.save(filme);
    }

    public Filme atualizar(Long id, Filme filme){
        if(filmeRepository.existsById(id)){
            filme.setId(id);
            return filmeRepository.save(filme);
        }
        throw new FilmeNaoEncontradoException("O filme não foi encontrado");
    } 

    public void deletar(Long id){
        if(!filmeRepository.existsById(id)){
            throw new RuntimeException("Filme não encontrado" + id);
        }
        filmeRepository.deletedById(id);
    }


}

    

