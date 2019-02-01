package bdEvent;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.SparkConf;

public class AppJava {

    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setAppName("event");
        JavaSparkContext sc = new JavaSparkContext(conf);

       // JavaRDD<String> data = sc.textFile(<<path>>);

    }
}
