package traceToKml;

import com.google.earth.kml._2.*;
import javax.xml.bind.JAXBElement;


/**
 * Created by xsoroka on 4/21/2016.
 * Class which allow create Placemark element for kml file
 */
public class PlaceMark {

    public static PlacemarkType makeFromTrace (Trace traceStart, Trace traceEnd, String speed, boolean addPoint) {

        ObjectFactory factory = new ObjectFactory();
        PlacemarkType placeMark = new PlacemarkType();
        placeMark.setName(speed);

        StyleType style = new StyleType();
//lineStyle
        LineStyleType lineStyle = new LineStyleType();
        if (speed.contains("Low"))
            lineStyle.setColor(SpeedColor.LOWSPEED);
        else if (speed.contains("Normal"))
            lineStyle.setColor(SpeedColor.NORMALSPEED);
        else
            lineStyle.setColor(SpeedColor.HIGHSPEED);
        lineStyle.setWidth(5.0F);

        style.setLineStyle(lineStyle);

        JAXBElement<StyleType> lineStyleEl = factory.createStyle(style);

//lineString
        LineStringType lineString = new LineStringType();
        JAXBElement<LineStringType> lineStringEl = factory.createLineString(lineString);

        lineString.getCoordinates().add(traceStart.getxCoord().toString() + "," + traceStart.getyCoord().toString() + ",0 ");
        lineString.getCoordinates().add(traceEnd.getxCoord().toString() + "," + traceEnd.getyCoord().toString() + ",0 ");

        lineStringEl.setValue(lineString);
        placeMark.setGeometry(lineStringEl);

        placeMark.getStyleSelector().add(lineStyleEl);

        if (addPoint) {
            //Point
            PointType point = new PointType();
            JAXBElement<PointType> pointEl = factory.createPoint(point);
            point.getCoordinates().add(traceStart.getxCoord().toString() + "," + traceStart.getyCoord().toString() + ",0 ");
            placeMark.setGeometry(pointEl);
        }
        return placeMark;
    }
}
