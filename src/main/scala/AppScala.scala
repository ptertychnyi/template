package main.scala

import java.time.LocalDate
import java.util.Date

import org.apache.spark.SparkContext
import org.apache.spark.sql.{Row, SparkSession}

object AppScala {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Hirring chalenge").master("local[*]").getOrCreate()
    val sc = spark.sparkContext
    spark.read.json("src\\main\\resources\\meteo_data.json.gz")
      .rdd
      //how map to RDD[ID, StatisticsData] ?)
      .take(5)
      .foreach(println)

   // RDD[StatisticsData]
   // .map(e => (e.date.year, e.temperature))
   // .reduceByKey(_ + _)


  }
}

case class Entry(id: String, statisticsData: StatisticsData)

object Entry{
  def apply(entryRow: Row): Entry = {
    val id = entryRow.getString(0)
    val data = entryRow.getAs[StatisticsData](1)
    new Entry(id, data)
  }
}

case class StatisticsData(date: LocalDate, lat: Double, lon: Double, temp: Double)

object StatisticsData{
  def apply(statRow: Row): StatisticsData = {
    val date = LocalDate.parse(statRow.getAs("date"))
    val lan = statRow.getAs("lat")
    val long = statRow.getAs("long")
    val tC = statRow.getAs("tC")
    new StatisticsData(date, lan, long, tC)
  }
}
