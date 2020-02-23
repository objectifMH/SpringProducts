package fr.jojo.springProduct.pack.service;

import fr.jojo.springProduct.pack.dao.ProductRepository;
import fr.jojo.springProduct.pack.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //On sauve un produit :
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //On sauve une liste de produits :
    public List<Product> addProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    //On renvoie une liste de produits :
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    //On renvoie un produit :
    public Product getProductById(Long id){
        //return productRepository.findById(id).get();
        return productRepository.findById(id).orElse(null);
    }

    //On renvoie un produit :
    public Product getProductByName(String name){
        return productRepository.findByNom(name);
    }

    //On supprime un produit :
    public void deleteProductById(Long id){
        productRepository.deleteById(id);

    }

    //On met à jour un produit :
    public Product update(Product productMaj){
        Product product = productRepository.findById(productMaj.getId()).orElse(null);
        productMaj.setNom(product.getNom());
        productMaj.setDescription(product.getDescription());
        productMaj.setPrix(product.getPrix());

        return productRepository.save(productMaj);


    }






}
