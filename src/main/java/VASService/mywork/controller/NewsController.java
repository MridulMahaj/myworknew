package VASService.mywork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@CrossOrigin(origins = {
        "*"
})
public class NewsController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/news")
    public ResponseEntity<Object> getNewsData(@RequestBody Map<String, String> body) {
        String story = body.get("story");
        String url = "http://localhost:8081/api/news/full-story?story=" + story;
        Object response = restTemplate.getForObject(url, Object.class);
        return ResponseEntity.ok(Map.of("echo",story));
    }
}
