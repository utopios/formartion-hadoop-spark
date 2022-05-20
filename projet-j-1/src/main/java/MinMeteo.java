import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MinMeteo {
    private static final String path = "data-spark/meteo.csv";
    public static void main(String[] args) {
        JavaRDD<InfoMeteo> rdd = Tools.getContext().textFile(path).map(l -> {
            String[] data = l.split(";");
            return new InfoMeteo(Float.valueOf(data[3]),data[0], data[2]);
        }).filter(e -> e.getTypeInfo().equals("TMIN"));
        List result = rdd.collect();
    }
}

class InfoMeteo implements Serializable {

    private float value;
    private String stationId;
    private String typeInfo;

    public InfoMeteo(float value, String stationId, String typeInfo) {
        this.value = value;
        this.stationId = stationId;
        this.typeInfo = typeInfo;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getTypeInfo() {
        return typeInfo;
    }

    public void setTypeInfo(String typeInfo) {
        this.typeInfo = typeInfo;
    }
}
