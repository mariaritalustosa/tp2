import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    if(!"admin".equals(username)){
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
    return User.builder()
               .username("admin")
               .password(new BCryptPasswordEncoder().encode("password"))
               .roles("ADMIN")
               .build();
    
}
}