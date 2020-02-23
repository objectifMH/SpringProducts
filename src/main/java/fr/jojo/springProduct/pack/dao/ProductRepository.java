package fr.jojo.springProduct.pack.dao;

import fr.jojo.springProduct.pack.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
