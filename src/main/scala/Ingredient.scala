sealed trait Ingredient {
    def acceptable: Vector[String]
}

final case object Starch extends Ingredient {
    val acceptable: Vector[String] = Vector(
        "pasta",
        "rice",
        "potato", // do not accept potato as vegetable :D,
        "no starch" // surprise!
    )
}

final case object Vegetable extends Ingredient {
    val acceptable: Vector[String] = Vector(
        "string beans",
        "broccolini",
        "okra",
        "bell pepper",
        "snap peas",
        "broccoli",
        "asparagus",
        "carrot"
    )

}

final case object Protein extends Ingredient {
    val acceptable: Vector[String] = Vector(
        "beef",
        "pork",
        "chicken",
        "veal"
    )

}

final case object Nut extends Ingredient {
    val acceptable: Vector[String] = Vector(
        "cashew",
        "pine nut",
        "walnut"
    )

}

final case object Sauce extends Ingredient {
    val acceptable: Vector[String] = Vector(
        "white wine",
        "red wine",
        "cream",
        "tomato-based sauce",
        "gravy"
    )

}