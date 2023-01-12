package dev.cigana.hroauth.services;

import dev.cigana.hroauth.domain.User;
import dev.cigana.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null){
            StringBuilder sbError = new StringBuilder();
            sbError.append("Usuário não encontrado = email: ").append(email);
            logger.error(sbError.toString());
            throw new IllegalArgumentException(sbError.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Usuário encontrado - email: ").append(email);
        logger.info(sb.toString());
        return user;
    }

}
