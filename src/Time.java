import java.text.DecimalFormat;

public class Time {
    DecimalFormat df = new DecimalFormat("00");

    // STATIC VARIABLES:
    private static final int S_IN_M=60;
    private static final int S_IN_H=3600;
    private static final int S_IN_D=86400;

    // INSTANCE VARIABLE:
    private int s; // Seconds

    // CONSTRUCTOR:
    public Time(int hours, int minutes, int seconds) {
        s = toS(hours, minutes, seconds);
    }

    // GETTER:

    public int getS() {
        return s;
    }

    // OTHER PUBLIC METHODS:

    public void tick () {s++;}

    public void add(Time addTime) {s+=addTime.getS();}

    // Overriden toString():
    public String toString() {

        int seconds = s%S_IN_M;
        int minutes = s%S_IN_H/S_IN_M;
        int hours = s%S_IN_D/S_IN_H;

        return df.format(hours) + ":" + df.format(minutes) + ":" + df.format(seconds);
    }

    // PRIVATE HELPERS:
    private int toS(int hours, int minutes, int seconds) { // Calculate seconds in given hours, minutes, seconds
        return ( (hours*60)+minutes )*60 + seconds;
    }


}