package ru.aksndr.tests;

import org.json.JSONObject;
import ru.aksndr.datalayer.Point;
import ru.aksndr.datalayer.Trace;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by aksndr on 01.07.14.
 */
public class PointToJSONObjectTest {
    @org.junit.Test
    public void test() throws Exception {
        Point point = new Point(1241234L, 55.4, 53.2, "строка1", "строка2");
        Point point2 = new Point(12234L, 53.4, 51.2, "строка3", "строка4");
        Trace trace = new Trace(23123L, new Double[][]{{39.598469, 47.234793},{39.598469, 47.234793},{39.598469, 47.234793}},"хинт","балун");

        String retVal = "";

        JSONObject jsonObj = new JSONObject();
        jsonObj.append("features", point);
        jsonObj.append("features", point2);
        jsonObj.append("features", trace);
        jsonObj.put("type", "FeatureCollection");

        retVal = jsonObj.toString();
        System.out.print(retVal);
        assertNotNull(retVal);
    }

}
