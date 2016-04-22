package traceToKml;

import java.util.Date;

/**
 * Created by xsoroka on 4/20/2016.
 * Class that holds single point from trace file
 */
public class Trace {

    Date timestamp;
    Double xCoord;
    Double yCoord;

    public Double getxCoord() {
        return xCoord;
    }

    public void setxCoord(Double xCoord) {
        this.xCoord = xCoord;
    }

    public Double getyCoord() {
        return yCoord;
    }

    public void setyCoord(Double yCoord) {
        this.yCoord = yCoord;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    Trace (String line)
    {
        String[] data = line.split(" ");
        setTimestamp(new Date (Long.parseLong(data[0])));
        setxCoord(Double.parseDouble(data[1]));
        setyCoord(Double.parseDouble(data[2]));
    }
}
