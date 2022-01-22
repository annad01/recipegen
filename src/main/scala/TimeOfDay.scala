//import java.time._
import scala.scalajs.js.Date

object TimeCheck {
    
    val currentHour = new Date().getHours()

    def currTime(currHr: Int): TimeOfDay = {
        if (currentHour >= 5 && currentHour <= 12) {
            Morning
        } else if (currentHour > 12 && currentHour <= 17) {
            Afternoon
        } else if (currentHour > 17 && currentHour <= 21) {
            Evening
        } else Night
    }
}

sealed trait TimeOfDay

case object Morning extends TimeOfDay
case object Afternoon extends TimeOfDay
case object Evening extends TimeOfDay
case object Night extends TimeOfDay
