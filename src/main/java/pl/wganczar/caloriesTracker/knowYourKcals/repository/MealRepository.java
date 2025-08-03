package pl.wganczar.caloriesTracker.knowYourKcals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wganczar.caloriesTracker.knowYourKcals.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
