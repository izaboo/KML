package traceToKml;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

/**
 * Created by xsoroka on 4/22/2016.
 */
public class CalculationsHelper {
/**
 * This function define speed value between 2 coordinates
 * @param traceStart - start point (with timestamp of movement and coordinates)
 * @param traceEnd - end point (with timestamp of movement and coordinates)
 * @return - Decision string whether movement was at low speed, normal or high
 * 
 * Note: distance calculation was taken from Google.
 */
    public static String defineSpeedBetweenPoints(Trace traceStart, Trace traceEnd)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long diff = traceEnd.getTimestamp().getTime() - traceStart.getTimestamp().getTime();
        long diffTime = timeUnit.convert(diff, TimeUnit.MILLISECONDS); //time in seconds
        double distance = distance(traceStart.getxCoord(),traceStart.getyCoord(), traceEnd.getxCoord(),traceEnd.getyCoord()) * 1000; //distance in metres
        double speed = distance/diffTime;
        if (speed < 16.66)
            return "Low speed on distance " + df.format(distance) + " metres as " + df.format(speed) + " m/s";
        else
        if ((speed > 16.66) && (speed < 25))
            return "Normal speed on distance " + df.format(distance) + " metres as " + df.format(speed) + " m/s";
        else
            return "High speed on distance " + df.format(distance) + " metres as " + df.format(speed) + " m/s";
    }

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function calculates distance in kilometres between 2 points with their coordinates            :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts decimal degrees to radians             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts radians to decimal degrees             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
