import org.apache.spark.sql.{Row, SparkSession}
import org.scalatest.{FunSuite, Matchers}

class MovieRatingJobTest extends FunSuite with Matchers {

  test("should sum movie scores and write to file") {
    val session = SparkSession
      .builder()
      .appName("test")
      .master("local")
      .getOrCreate()

    val ratedMovies: Array[Row] = MovieRatingJob(session).collect()
    ratedMovies.size shouldBe 3
    val topRated = ratedMovies.head
    topRated.getAs[Int]("totalScore") shouldBe 9
  }
}
