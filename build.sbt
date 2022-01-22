import scala.sys.process

ThisBuild / scalaVersion := "2.13.7"
ThisBuild / version := "0.1.0"
ThisBuild / organization := "com.github.annad01"
ThisBuild / name := "recipegen"

val V = new {

    val laminar = "0.14.2"
    val time = "2.2.2"

}

lazy val root = project.in(file("."))
    .enablePlugins(ScalaJSPlugin, ScalablyTypedConverterExternalNpmPlugin)
    .settings(
        ////useYarn := true,
        scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) },
        scalaJSLinkerConfig ~= { _.withSourceMap(false) },
        scalaJSUseMainModuleInitializer := true,
        externalNpm := {
            process.Process("npm", baseDirectory.value).!
            baseDirectory.value
        },
        libraryDependencies ++= Seq(
            "com.raquo"     %%% "laminar"       % V.laminar,
            "io.github.cquiroz" %%% "scala-java-time" % V.time
        )
    )