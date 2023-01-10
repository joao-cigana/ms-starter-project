package dev.cigana.hruser.services;

import dev.cigana.hruser.domain.Role;
import dev.cigana.hruser.exceptions.ResourceNotFoundException;
import dev.cigana.hruser.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository RoleRepository;

    public Page<Role> findAll(Pageable pageable){
        return RoleRepository.findAll(pageable);
    }

    public Role findById(Long id){
        return RoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permissão não encontrada - id: " + id));
    }

    public void deleteById(Long id){
        if (!RoleRepository.existsById(id)){
            throw new ResourceNotFoundException("Permissão não encontrada - id: " + id);
        }
        RoleRepository.deleteById(id);
    }


}
