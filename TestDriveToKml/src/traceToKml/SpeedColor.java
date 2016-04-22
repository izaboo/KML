package traceToKml;

/**
 * Created by xsoroka on 4/22/2016.
 * Class for defining color of speed on kml
 * 
 * Note: Google was used for method of string to hex as byte[] transition 
 */
public class SpeedColor {

    public static final byte[] LOWSPEED = hexStringToByteArray("5014F05A");
    public static final byte[] NORMALSPEED = hexStringToByteArray("5014F0FF");
    public static final byte[] HIGHSPEED = hexStringToByteArray("501400FF");

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
