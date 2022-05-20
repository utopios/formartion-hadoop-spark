import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class MovieCounter {
    private static final String path = "data-spark/film.data";
    public static void main(String[] args) {
        JavaRDD<Integer> rdd = Tools.getContext().textFile(path)
                //.flatMap(e -> Arrays.stream(e.split("\n")).iterator())
                .map(l -> Integer.valueOf(l.split("\t")[2]));
        Map<Integer, Long> result = rdd.countByValue();
    }
}
