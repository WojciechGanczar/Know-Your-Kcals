package pl.wganczar.caloriesTracker.knowYourKcals.controller;

import org.springframework.web.bind.annotation.*;
import pl.wganczar.caloriesTracker.knowYourKcals.model.Product;
import pl.wganczar.caloriesTracker.knowYourKcals.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping()
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
