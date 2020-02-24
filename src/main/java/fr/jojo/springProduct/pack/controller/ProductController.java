package fr.jojo.springProduct.pack.controller;


import fr.jojo.springProduct.pack.entity.Product;
import fr.jojo.springProduct.pack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("product")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @PutMapping("product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        Product productMAJ = productService.getProductById(id);
        productMAJ.setNom(newProduct.getNom());
        productMAJ.setDescription(newProduct.getDescription());
        productMAJ.setPrix(newProduct.getPrix());

        return productService.saveProduct(productMAJ);
    }


}
