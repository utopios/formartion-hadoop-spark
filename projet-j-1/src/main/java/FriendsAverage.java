import org.apache.spark.api.java.JavaPairRDD;
import scala.Tuple2;

import java.util.List;

public class FriendsAverage {

    private static String path = "data-spark/friends.csv";
    public static void main(String[] args) {
        JavaPairRDD rdd = Tools.getContext().textFile(path).mapToPair( l -> {
            String[] data = l.split(",");
            return new Tuple2(Integer.valueOf(data[2]), Integer.valueOf(data[3]));
        })
                // (age, (total, 1))
                .mapValues(v -> new Tuple2(v, 1))
                //(age, (totalFriends, totalInstances)
                .reduceByKey((e1, e2) -> {
                    Tuple2 t1 = (Tuple2) e1;
                    Tuple2 t2 = (Tuple2) e2;
                    return new Tuple2(Integer.valueOf(t1._1().toString()) + Integer.valueOf(t2._1().toString()), Integer.valueOf(t1._2().toString()) + Integer.valueOf(t2._2().toString()));
                })
                //(age, average)
                .mapValues(v -> {
                    return (int)(((Tuple2)v)._1()) / (int)(((Tuple2)v)._2());
                })
                ;

        List result = rdd.collect();
    }
}
