import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return User.builder()
                   .username("admin")
                   .password("password")  
                   .roles("ADMIN")
                   .build();
    }
}
