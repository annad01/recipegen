import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

import com.raquo.laminar.api.L._
import org.scalajs.dom
import org.scalajs.dom.{document, HTMLCanvasElement}
import typings.chartJs.mod.{^ => Chart, _}

object Main {

    val jumbo: HtmlElement = {

        val $timer = EventStream.periodic(3600)

        div(
            cls("jumbotron"),
            h1(
                child.text <-- $timer.mapTo ( TimeCheck.currentHour.toInt match {
                    case x if x >=5 && x <= 12 => "Good morning!"
                    case x if x > 12 && x <= 17 => "Good afternoon"
                    case x if x > 17 && x <= 21 => "Good evening!"
                    case _ => "Hello!"
                })
            )
        )
    }


    val app: HtmlElement = {
        val recipeVar  = Var("Thinking...")
        val nutsVar    = Var(false)
        val sauceVar   = Var(true)

        lazy val chart = new Chart(
            document.getElementById("nutriguide").asInstanceOf[HTMLCanvasElement],
            ChartDrawer.config
        )

        def updateChart(newFood: String): Unit = {
            chart.data.datasets.get(0).data = NutritionCounter.calculate(newFood)
            chart.update()
        }

        div(
            cls := "container",
            div(
                p(
                    label("Want nuts?"),
                    span("  "),
                    input(
                        typ("checkbox"),
                        onInput.mapToChecked --> nutsVar
                    )
                ),
                p(
                    label("Want sauce?"),
                    span("  "),
                    input(
                        typ("checkbox"),
                        onInput.mapToChecked --> sauceVar
                    )
                ),
                p(
                    button(
                        typ("button"),
                        "Click to generate recipe",
                        onClick.mapTo(Randomize.run(nutsVar.now(), sauceVar.now())) --> recipeVar
                    )   
                ),
                p(
                    "Your recipe: ",
                    child.text <-- recipeVar
                )
            )

            , div(
                canvas(idAttr := "nutriguide"),
                child.text <-- recipeVar.signal.map { x => 
                    chart.data.datasets.get(0).data = NutritionCounter.calculate(x)
                    chart.update()
                    ""
                }
            )
        )
    }

    



    def main(args: Array[String]): Unit = {
        render(dom.document.getElementById("jumbo"), jumbo)
        render(dom.document.getElementById("app"), app)
    
    }

}