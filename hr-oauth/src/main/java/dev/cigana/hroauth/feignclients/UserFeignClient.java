package dev.cigana.hroauth.feignclients;

import dev.cigana.hroauth.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "hr-user", name = "hr-user", path = "/users")
public interface UserFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email);

}
