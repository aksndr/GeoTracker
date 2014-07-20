package ru.aksndr.datalayer;

import org.json.JSONObject;

/**
 * Created by aksndr on 01.07.14.
 * { "type": "Feature",
 "geometry": {
 "type": "LineString",
 "coordinates": [
 [102.0, 0.0], [103.0, 1.0], [104.0, 0.0], [105.0, 1.0]
 ]
 },
 "properties": {
 "prop0": "value0",
 "prop1": 0.0
 }
 },
 */
public class Trace extends JSONObject {
    public Trace(Long id, Double[][] coordinates, String hintContent, String balloonContent){
        this.put("id",id);
        this.put("type","Feature");
        this.put("geometry", new Geometry(coordinates));
        this.put("properties", new Properties(hintContent, balloonContent));
    }

    private class Geometry extends JSONObject{
        public Geometry(Double[][] coordinates){
            this.put("type","LineString");
            this.put("coordinates",coordinates);
        }

    }
    private class Properties extends JSONObject{
        public Properties(String hintContent, String balloonContent){
            this.put("hintContent", hintContent);
            this.put("balloonContent ", balloonContent);
        }
    }

}
