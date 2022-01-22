import scala.util.Random

object Randomize {
  
    def run(includeNuts: Boolean, includeSauce: Boolean): String = {
        val rand = new Random
        
        val starch = getRandomElement(Starch.acceptable, rand)
        val vegetable = getRandomElement(Vegetable.acceptable, rand)
        val protein = getRandomElement(Protein.acceptable, rand)
        val sauce = if (includeSauce) getRandomElement(Sauce.acceptable, rand) else "no sauce"
        val nuts = if (includeNuts) getRandomElement(Nut.acceptable, rand) else "no nuts"

        Vector(starch, vegetable, protein, sauce, nuts).mkString(",")
    }

    def getRandomElement[A](seq: Seq[A], random: Random): A = 
        seq(random.nextInt(seq.length))

}
