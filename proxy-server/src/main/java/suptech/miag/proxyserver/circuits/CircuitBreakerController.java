package suptech.miag.proxyserver.circuits;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CircuitBreakerController {

    @GetMapping("/defaultPosts")
    public Map<String,String> posts(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("message","default post");
        map.put("posts","[post1, post2, ...]");
        return map ;
    }

}
