package kz.iitu.ex8.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data

public class WareHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    @OneToMany(mappedBy = "wareHouse", fetch = FetchType.LAZY)
    private List<Brands> brandsList;



}
