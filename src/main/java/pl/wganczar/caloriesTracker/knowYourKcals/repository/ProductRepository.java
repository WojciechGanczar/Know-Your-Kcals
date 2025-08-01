package pl.wganczar.caloriesTracker.knowYourKcals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wganczar.caloriesTracker.knowYourKcals.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}