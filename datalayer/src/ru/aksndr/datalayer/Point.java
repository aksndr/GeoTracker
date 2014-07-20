package ru.aksndr.datalayer;

/**
 * Created by aksndr on 01.07.14.
 */
import org.json.JSONObject;

public class Point extends JSONObject{

    public Point(Long id, Double latitude, Double longitude, String clusterCaption, String hintContent){
        this.put("id",id);
        this.put("type","Feature");
        this.put("geometry", new Geometry(latitude,longitude));
        this.put("properties", new Properties(clusterCaption,hintContent));
    }

    public class Geometry extends JSONObject{

        public Geometry(Double latitude, Double longitude){
            this.accumulate("coordinates", new Double[]{latitude,longitude});
            this.put("type", "Point");
        }

    }

    public class Properties extends JSONObject{

        public Properties(String clusterCaption, String hintContent){
            this.put("clusterCaption", clusterCaption);
            this.put("hintContent", hintContent);
        }
    }

    /*{
        "type": "Feature",
            "id": 2,
            "geometry": {
                "type": "Point",
                "coordinates": [
                    55.763338,
                    37.565466
                ]
            },
            "properties": {
                "clusterCaption": "абаЕ аОаДаНаА аМаЕбаКаА",
                "hintContent": "аЂаЕаКбб аПаОаДбаКаАаЗаКаИ"
            }
    },*/

}
