package main.scala

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object AppScala {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("Hirring chalenge").master("local[*]").getOrCreate()
    val sc = spark.sparkContext

    val result = task1(sc, spark)
    println(result)

  }

  def task1(sc: SparkContext, spark: SparkSession) = ???

}
