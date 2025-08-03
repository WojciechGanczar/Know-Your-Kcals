package pl.wganczar.caloriesTracker.knowYourKcals.service;

import org.springframework.stereotype.Service;
import pl.wganczar.caloriesTracker.knowYourKcals.dto.CreateMealRequest;
import pl.wganczar.caloriesTracker.knowYourKcals.dto.MealItemRequest;
import pl.wganczar.caloriesTracker.knowYourKcals.model.Meal;
import pl.wganczar.caloriesTracker.knowYourKcals.model.MealItem;
import pl.wganczar.caloriesTracker.knowYourKcals.model.Product;
import pl.wganczar.caloriesTracker.knowYourKcals.repository.MealRepository;
import pl.wganczar.caloriesTracker.knowYourKcals.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    private final ProductRepository productRepository;
    private final MealRepository mealRepository;

    public MealService(ProductRepository productRepository, MealRepository mealRepository) {
        this.productRepository = productRepository;
        this.mealRepository = mealRepository;
    }

    public Meal createMeal(CreateMealRequest request) {
        Meal meal = new Meal();
        meal.setName(request.getName());

        List<MealItem> items = new ArrayList<>();

        for (MealItemRequest itemRequest : request.getItems()) {
            Product product = productRepository.findById(itemRequest.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            MealItem item = new MealItem(product, itemRequest.getGrams());
            item.setMeal(meal); // powiązanie z posiłkiem
            items.add(item);
        }

        meal.setMealItems(items);
        return mealRepository.save(meal);
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
}