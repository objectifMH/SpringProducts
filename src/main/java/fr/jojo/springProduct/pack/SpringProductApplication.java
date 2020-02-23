package fr.jojo.springProduct.pack;

import fr.jojo.springProduct.pack.entity.Product;
import fr.jojo.springProduct.pack.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProductApplication implements CommandLineRunner {

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringProductApplication.class, args);
	}

	private static void accept(Product product) {
		System.out.println(product.getNom());
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Début d'initilisation du micro Service Product :");
		productRepository.save(new Product(null, " Monproduit", "Description de mon produit", 123d));
		productRepository.save(new Product(null, " Ipad AIR 2020", "tablette Apple", 823d));
		productRepository.save(new Product(null, " Ipad PRO 2019", "tablette Pro Apple", 1123d));
		productRepository.save(new Product(null, " Sony Vaio Z20", "Ordinateur portable Sony", 2223d));
		productRepository.save(new Product(null, " Mac Book Pro 2020", "Ordintateur portable Apple", 2200d));

		for (Product product : productRepository.findAll()) {
			System.out.println(product.getNom());
		}

		System.out.println("************** **************");


	}
}
