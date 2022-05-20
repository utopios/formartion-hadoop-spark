import org.apache.spark.api.java.JavaRDD;

import java.util.Arrays;

public class WordCounter {

    public static void main(String[] args) {
        JavaRDD rdd = Tools.getContext().textFile("data-spark/book.txt").flatMap(e -> Arrays.stream(e.split(" ")).iterator());

        Integer result = rdd.collect().size();
    }
}
