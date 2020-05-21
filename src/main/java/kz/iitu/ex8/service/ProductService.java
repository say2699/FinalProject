package kz.iitu.ex8.service;

import kz.iitu.ex8.entity.Product;
import kz.iitu.ex8.entity.User;
import kz.iitu.ex8.repository.ProductRepository;

import kz.iitu.ex8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;



@Service
public class ProductService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;



    public List<Product> allProducts() {
        return productRepository.findAll();
    }



    public Product findProductById(Long productId) {
        Optional<Product> productFromDb = productRepository.findById(productId);
        return productFromDb.orElse(new Product());
    }




}
