package pl.wganczar.caloriesTracker.knowYourKcals.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMealRequest {
    private String name;
    private List<MealItemRequest> items;
}
