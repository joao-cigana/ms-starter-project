package dev.cigana.hroauth.domain;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();

}
