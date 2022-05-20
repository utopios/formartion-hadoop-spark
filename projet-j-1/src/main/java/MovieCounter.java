import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Map;

public class MovieCounter {
    private static final String path = "data-spark/film.data";
    public static void main(String[] args) {
        JavaRDD<Integer> rdd = Tools.getContext().textFile(path).map(l -> Integer.valueOf(l.split("\t")[2]));
        Map<Integer, Long> result = rdd.countByValue();
    }
}
