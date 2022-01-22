// Unit varies
// calories: (kCal), sodium: mg, the rest are g
// By 1 cup

final case class NutritionFacts(calories: Int, fat: Double, sodium: Double, 
    carb: Double, 
    fiber: Double,
    sugars: Double,
    protein: Double) 

object NutritionLookup {
    val default = NutritionFacts(0,0,0,0,0,0,0)

    val repo: Map[String, NutritionFacts] = Map (
        "pasta" -> NutritionFacts(221, 1.3, 1, 43.2, 2.5, 0.8, 8.1),
        "rice" -> NutritionFacts(242, 0.4, 0, 53.4, 0.6, 0.0, 4.4),
        "potato" -> NutritionFacts(164, 0.2, 24, 37, 4, 1.9, 4.6),
        "no starch" -> NutritionFacts(0, 0, 0, 0, 0, 0, 0),
        "string beans" -> NutritionFacts(31, 0.2, 6, 7, 2.7, 3.3, 1.8),
        "broccolini" -> NutritionFacts(29, 0.4, 16, 1.3, 2.7, 1.5, 3.2),
        "okra" -> NutritionFacts(18, 0.2, 5, 3.6, 2, 1.9, 1.5),
        "bell pepper" -> NutritionFacts(39, 0,5, 6, 3.1, 6.3, 1.5),
        "snap peas" -> NutritionFacts(27, 0.1, 2.5, 4.8, 1.6, 2.5, 1.8),
        "broccoli" -> NutritionFacts(31, 0.3, 30, 6, 2.4, 1.5, 2.5),
        "asparagus" -> NutritionFacts(20, 0.2, 13, 3.7, 1.8, 1.2, 2.2),
        "carrot" -> NutritionFacts(25, 0, 42, 6, 1.5, 2.9, 0.5),
        "beef" -> NutritionFacts(218, 13, 76, 0, 0, 0, 24),
        "pork" -> NutritionFacts(122, 3, 48, 0, 0, 0, 22),
        "chicken" -> NutritionFacts(135, 7.5, 234, 0, 0, 0, 16.9),
        "veal" -> NutritionFacts(196, 9.7, 74, 0, 0, 0, 26),
        "tofu" -> NutritionFacts(181, 11, 17.6, 3.5, 2.9, 0, 21.8),
        "egg" -> NutritionFacts(78, 5, 62, 0.6, 0, 0.5, 6),
        "cashew" -> NutritionFacts(157, 12, 3.4, 8.6, 0.9, 1.7, 5.2),
        "pine nut" -> NutritionFacts(191, 19, 0.6, 3.7, 1.1, 1, 3.9),
        "walnut" -> NutritionFacts(183, 18, 0.6, 3.8, 1.9, 0.7, 4.3),
        "white wine" -> NutritionFacts(34, 2.9, 111.5, 1.1, 0.1, 0.1, 0.2),
        "red wine" -> NutritionFacts(55, 1.9, 66, 3.1, 0.5, 0.9, 0.9),
        "cream" -> NutritionFacts(400, 43, 32.3, 3.35, 0, 3.45, 3),
        "tomato-based sauce" -> NutritionFacts(29, 0.4, 581, 6.5, 1.8, 4.4, 1.5),
        "gravy" -> NutritionFacts(27, 1.5, 222, 3, 0.1, 0.2, 0.4)
    )
}