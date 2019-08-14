import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object MovieRatingJob {

  def apply(spark: SparkSession) = {
    val moviesDF = spark.read.format("csv")
      .option("inferSchema", "true")
      .option("header", "true")
      .load("src/main/resources/movies.csv")

    val movieRatings = spark.read
      .option("inferSchema", "true")
      .option("header", "true")
      .csv("src/main/resources/movie-ratings.csv")

    val m = moviesDF
      .join(movieRatings, moviesDF("id") === movieRatings("movieId"))
      .groupBy("id")
      .sum("score")
      .withColumnRenamed("sum(score)", "totalScore")
      .orderBy(desc("totalScore"))
    m.show()
    m
  }

}
