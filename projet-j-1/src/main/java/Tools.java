import org.apache.spark.api.java.JavaSparkContext;

public class Tools {
    private static JavaSparkContext context = new JavaSparkContext("local[*]", "demo");
    public static JavaSparkContext getContext() {
        return context;
    }
}
