package pl.wganczar.caloriesTracker.knowYourKcals.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MealItemRequest {
    private Long productId;
    private double grams;
}