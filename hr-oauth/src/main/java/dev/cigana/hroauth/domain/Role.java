package dev.cigana.hroauth.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {

    private Long id;
    private String roleName;

}
