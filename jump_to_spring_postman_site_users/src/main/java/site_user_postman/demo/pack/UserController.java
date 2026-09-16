package site_user_postman.demo.pack;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public SiteUser createUser(@RequestBody UserJoinRequest request) {
        return userService.saveSiteUser(request.getUsername(), request.getPassword(), request.getEmail());
    }

}
