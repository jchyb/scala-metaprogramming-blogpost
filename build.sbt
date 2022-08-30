
val scala2 = "2.13.8"
val scala3 = "3.1.3"

lazy val `ex1-scala2-macro` = project
  .in(file("ex1-scala2/macros"))
  .settings(
    scalaVersion := scala2,
    libraryDependencies += "org.scala-lang" % "scala-reflect" % scala2
  )

lazy val `ex1-scala2` = project
  .in(file("ex1-scala2/main"))
  .settings(scalaVersion := scala2)
  .dependsOn(`ex1-scala2-macro`)

lazy val `ex1-scala3-inline` = project
  .in(file("ex1-scala3-inline"))
  .settings(scalaVersion := scala3)

lazy val `ex1-scala3-transparent-inline` = project
  .in(file("ex1-scala3-transparent-inline"))
  .settings(scalaVersion := scala3)

lazy val `ex1-scala3-macro` = project
  .in(file("ex1-scala3-macro"))
  .settings(scalaVersion := scala3)

lazy val `ex2-scala3` = project
  .in(file("ex2-scala3"))
  .settings(scalaVersion := scala3)
