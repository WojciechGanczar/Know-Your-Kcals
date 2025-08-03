package pl.wganczar.caloriesTracker.knowYourKcals.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class MealItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private double grams;

    private double calculatedKcal;
    private double calculatedProtein;
    private double calculatedFats;
    private double calculatedCarbs;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    @JsonBackReference
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public MealItem(Product product, double grams) {
        this.product = product;
        this.grams = grams;

        this.calculatedKcal = product.getKcal() * grams / 100;
        this.calculatedProtein = product.getProtein() * grams / 100;
        this.calculatedFats = product.getFats() * grams / 100;
        this.calculatedCarbs = product.getCarbs() * grams / 100;
    }
}
