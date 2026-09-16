package site_user_postman.demo.pack;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public SiteUser saveSiteUser(String username, String password, String email) {
        SiteUser user = new SiteUser();
        user.setUsername(username);
        // 정상적으로 해시 알고리즘(BCrypt 등)으로 비밀번호 암호화
        user.setPassword(passwordEncoder.encode(password));

        user.setEmail(email);
        return userRepository.save(user);

    }
}
