package ru.aksndr.geo2json.impl;

import org.json.JSONObject;
import ru.aksndr.datalayer.Point;
import ru.aksndr.datalayer.Trace;
import ru.aksndr.datalayer.User;
import ru.aksndr.geo2json.api.IGeoJson;

/**
 * Created by aksndr on 01.07.14.
 */
public class GeoJsonParser{

    JSONObject rootObject;

    public GeoJsonParser() {
        this.rootObject = new JSONObject();
        rootObject.put("type", "FeatureCollection");
    }

    public boolean addPoint(Point point) {
        try {
            rootObject.append("features", point);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean addUserTrack(Trace trace) {
        try {
            rootObject.append("features", trace);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public String getGeoJson(){
        return rootObject.toString();
    }

}
