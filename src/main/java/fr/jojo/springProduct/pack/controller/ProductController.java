package fr.jojo.springProduct.pack.controller;


import fr.jojo.springProduct.pack.entity.Product;
import fr.jojo.springProduct.pack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("products")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("product/{id}")
    public Product findProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

}
