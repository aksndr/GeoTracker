package ru.aksndr.geojsonservice;

import java.io.IOException;
import java.io.Writer;
import ru.aksndr.datalayer.Point;
import ru.aksndr.datalayer.Trace;
import ru.aksndr.geo2json.impl.GeoJsonParser;

/**
 * Created by aksndr on 01.07.14.
 */
public class GeoJsonService extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            doGet(request, response);
        }
        protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
            response.setContentType("text/javascript");
            response.setCharacterEncoding("UTF-8");
            Writer out = response.getWriter();
            Point point = new Point(1241234L, 39.598469, 47.234793, "строка1", "строка2");

            Point point2 = new Point(12234L, 39.61, 47.24, "строка3", "строка4");
            Trace trace = new Trace(23123L, new Double[][]{{39.53, 47.22},{39.54, 47.23},{39.55, 47.23}},"хинт","балун");


            GeoJsonParser geoJsonParser = new GeoJsonParser();
            geoJsonParser.addPoint(point);
            geoJsonParser.addPoint(point2);
            geoJsonParser.addUserTrack(trace);

            String message = geoJsonParser.getGeoJson();
            out.write(message);
        }
}
