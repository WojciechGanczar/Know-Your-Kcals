package pl.wganczar.caloriesTracker.knowYourKcals.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wganczar.caloriesTracker.knowYourKcals.dto.CreateMealRequest;
import pl.wganczar.caloriesTracker.knowYourKcals.model.Meal;
import pl.wganczar.caloriesTracker.knowYourKcals.service.MealService;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public ResponseEntity<Meal> createMeal(@RequestBody CreateMealRequest request) {
        Meal saved = mealService.createMeal(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals(); // musisz dodać metodę w serwisie
    }
}
