package kz.iitu.ex8.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private int amount;
    @Column(name = "brand_id")
    private Long brandId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", insertable = false, updatable = false)
    private Brands brands;


    @ManyToMany(mappedBy = "basket", fetch = FetchType.LAZY)
    private Set<User> userList;

}

