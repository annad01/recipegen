import scala.scalajs.js
import js.JSConverters._

object NutritionCounter {

    val dailyRecIntake: NutritionFacts = NutritionFacts(
        calories = 2000,
        fat = 70d,
        sodium = 2300.0,
        carb = 260d,
        fiber = 30d,
        sugars = 90d,
        protein = 50d
    )


  def calculate(food: String): ChartDrawer.dataElem = {

    val combined = food.split(",").map { f => 
          NutritionLookup.repo.getOrElse(f, NutritionLookup.default)
        }.foldLeft(NutritionLookup.default) { (curr, nextFood) =>
            combine(curr, nextFood)
        }

    js.Array(combined.calories * 100 / dailyRecIntake.calories, combined.fat * 100/ dailyRecIntake.fat, 
        combined.sodium * 100 / dailyRecIntake.sodium,
        combined.carb * 100 / dailyRecIntake.carb, 
        combined.fiber * 100 / dailyRecIntake.fiber, 
        combined.sugars * 100 / dailyRecIntake.sugars, 
        combined.protein * 100 / dailyRecIntake.protein)
  }

  def combine(x: NutritionFacts, y: NutritionFacts): NutritionFacts = {
      NutritionFacts(x.calories + y.calories, x.fat + y.fat, x.sodium + y.sodium, 
        x.carb + y.carb,
        x.fiber + y.fiber,
        x.sugars + y.sugars,
        x.protein + y.protein)
  }
  
}
