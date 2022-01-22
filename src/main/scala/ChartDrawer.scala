import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import com.raquo.laminar.api.L._
import org.scalajs.dom
import org.scalajs.dom.document
import org.scalajs.dom.HTMLCanvasElement

import scalajs.js.|
import typings.chartJs.mod.{^ => Chart, _}
//import typings.chartJs.mod._

object ChartDrawer {

    type dataElem = js.Array[js.UndefOr[js.Array[Double] | typings.chartJs.mod.ChartPoint | Double | Null]]
    type labelElem = js.Array[String | js.Array[js.Date | Double | typings.moment.mod.Moment | String] | Double | js.Date | typings.moment.mod.Moment]

    val config: ChartConfiguration = ChartConfiguration()
                        .setType(ChartType.bar)
                        .setData(
                            ChartData().setLabels(js.Array("calories", "fat", "sodium", "carb", "fiber", "sugars", "protein"))
                            .setDatasets(
                                js.Array[ChartDataSets](
                                    ChartDataSets().setLabel("Actual")
                                        .setData(js.Array(0, 0 ,0 ,0 ,0 ,0, 0))
                                        .setBackgroundColor(js.Array(
                                            "rgb(255, 82, 82)",
                                            "rgb(255, 82, 82)",
                                            "rgb(255, 82, 82)",
                                            "rgb(255, 82, 82)",
                                            "rgb(255, 82, 82)",
                                            "rgb(255, 82, 82)",
                                            "rgb(255, 82, 82)"
                                        ))
                                        .setBorderWidth(1)
                                        ,
                                    ChartDataSets()
                                        .setLabel("Recommended")
                                        .setData(js.Array(100, 100, 100, 100, 100, 100, 100))
                                        .setBackgroundColor(js.Array(
                                            "rgb(0, 151, 167)",
                                            "rgb(0, 151, 167)",
                                            "rgb(0, 151, 167)",
                                            "rgb(0, 151, 167)",
                                            "rgb(0, 151, 167)",
                                            "rgb(0, 151, 167)",
                                            "rgb(0, 151, 167)"
                                        ))
                                )
                            )
                        )
                        .setOptions(
                            ChartOptions().setScales(
                                ChartScales().setYAxes(js.Array(
                                    CommonAxe()
                                        .setStacked(true)
                                        .setTicks(TickOptions().setMax(100)),
                                    )
                                ).setXAxes(js.Array(ChartXAxe().setStacked(true)))
                            )
                        )

}
