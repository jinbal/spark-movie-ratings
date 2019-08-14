name := "spark-movie-ratings"

version := "0.1"

scalaVersion := "2.12.9"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "com.github.tototoshi" %% "scala-csv" % "1.3.6" % "test",
  "org.apache.spark" %% "spark-sql" % "2.4.3",
  "org.apache.spark" %% "spark-core" % "2.4.3"
)
