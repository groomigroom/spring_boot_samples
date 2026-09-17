package ReactSpring.ReactSpring.pack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/data")
    public Map<String, Object> getData() {
        Map<String, Object> response = new HashMap<>();
        response.put("id", 1);
        response.put("title", "스프링 부트와 리액트 연동");
        response.put("message", "데이터 전송 성공!");
        return response; // 자동으로 JSON 변환됨
    }
}
