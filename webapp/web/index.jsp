<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.aksndr.datalayer.Point" %>
<%@ page import="ru.aksndr.geo2json.impl.GeoJsonParser" %>
<head>
    <%--<%Point point = new Point(1241234L, 39.598469, 47.234793, "строка1", "строка2");%>--%>
    <%--<%String text = GeoJsonParser.getPointGeoJson(point);%>--%>
    <%--<div><%=text%></div>--%>
    <title>Гео Точки и маршрут.</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <script src="//yandex.st/jquery/2.1.1/jquery.min.js" type="text/javascript"></script>
    <script src="//api-maps.yandex.ru/2.1/?lang=ru_RU&coordorder=longlat"></script>
    <style type="text/css">
        html, body, #YMapsID {
            width: 100%;
            height: 100%;
        }
    </style>

    <script type="text/javascript">
        ymaps.ready()
                .done(function (ym) {
                    var myMap = new ym.Map('YMapsID', {
                        center: [39.598469, 47.234793],
                        zoom: 30
                    });

                    jQuery.getJSON('http://localhost:8080/geojsonservice', function (json) {
                        /** Сохраним ссылку на геообъекты на случай, если понадобится какая-либо постобработка.
                         * @see http://api.yandex.ru/maps/doc/jsapi/2.1/ref/reference/GeoQueryResult.xml
                         */
                        var geoObjects = ym.geoQuery(json)
                                .addToMap(myMap)
                                .applyBoundsToMap(myMap, {
                                    checkZoomRange: true
                                });
                    });
                });
    </script>
</head>
<body>
<div id="YMapsID"></div>
</body>
</html>