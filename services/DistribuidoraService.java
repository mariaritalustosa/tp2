import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistribuidoraService {
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public List<Distribuidora> listarTodos(){
        return distribuidoraRepository.findAll();
    }

    public Distribuidora salvar(Distribuidora distribuidora){
        return distribuidoraRepository.save(distribuidora);
    }

    public Distribuidora atualizar(Long id, Distribuidora distribuidora){
        if(!distribuidoraRepository.existsById(id)){
            distribuidora.setId();
            return distribuidoraRepository.save(distribuidora);
        }
        throw new DistribuidoraNaoEncontradaException("A distribuidora não foi encontrada");
    }
}