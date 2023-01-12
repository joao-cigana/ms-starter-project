package dev.cigana.hroauth.feignclients;

import dev.cigana.hroauth.domain.Role;
import dev.cigana.hroauth.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user-role", path = "/roles")
public interface RoleFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id);

}
