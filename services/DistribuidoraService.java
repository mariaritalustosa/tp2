import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistribuidoraService {
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public List<Distribuidora> listarTodos(){
        return distribuidoraRepository.findAll();
    }
}
