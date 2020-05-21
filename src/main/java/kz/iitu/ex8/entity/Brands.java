package kz.iitu.ex8.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pop;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @OneToMany(mappedBy = "brands", fetch = FetchType.LAZY)
    private List<Product> productList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    private WareHouse wareHouse;




}


