import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;
import java.util.List;

public class FirstDemo {
    public static void main(String[] args) {

        //Création d'un context spark pour les intéractions avec notre cluster.
        JavaSparkContext sc = new JavaSparkContext("local[*]", "demo-app");
        JavaRDD<Integer> firstRDD = sc.parallelize(Arrays.asList(1,2,4,3));
        JavaRDD<Integer> secondRDD = firstRDD.map(e -> e * 5);
        List result = secondRDD.collect();

    }
}
