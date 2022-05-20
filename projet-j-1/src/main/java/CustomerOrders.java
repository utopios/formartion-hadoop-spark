import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import scala.Tuple2;

import java.util.List;

public class CustomerOrders {

    private static String path = "data-spark/customer-orders.csv";

    public static void main(String[] args) {
        JavaPairRDD rdd = Tools.getContext().textFile(path).mapToPair(l -> {
            String[] data = l.split(",");
            return new Tuple2(Integer.valueOf(data[0]), Double.valueOf(data[2]));
        }).reduceByKey((e1, e2) -> {
            return (Double)e1 + (Double) e2;
        });

        List result = rdd.collect();
    }
}
