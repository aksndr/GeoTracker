package ru.aksndr.geo2json.api;

/**
 * Created by aksndr on 01.07.14.
 */

import ru.aksndr.datalayer.Point;
import ru.aksndr.datalayer.User;

public interface IGeoJson {
//    public String getPointGeoJson(Point point);
    public String getUserTrackGeoJson(Long imei, Long timelimit);


}
