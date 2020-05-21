package kz.iitu.ex8.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "t_user")
public class User implements  UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Transient
    private String passwordConfirm;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_product",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
    )
    private Set<Product> basket = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;



    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public Set<Product> getBasket() {
        return basket;
    }

    public void setBasket(Set<Product> basket) {
        this.basket = basket;
    }
}
