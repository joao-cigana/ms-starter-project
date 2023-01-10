package dev.cigana.hruser.services;

import dev.cigana.hruser.domain.User;
import dev.cigana.hruser.exceptions.ResourceNotFoundException;
import dev.cigana.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Page<User> findAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado - id: " + id));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado - email: " + email));
    }

    public void deleteById(Long id){
        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException("Usuário não encontrado - id: " + id);
        }
        userRepository.deleteById(id);
    }


}
