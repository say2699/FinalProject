package kz.iitu.ex8.entity;

import org.springframework.security.core.GrantedAuthority;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String getAuthority() {
        return name;
    }
}
