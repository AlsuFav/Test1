import java.util.Objects;

class BroadcastsTime implements Comparable<BroadcastsTime> {
    private byte hour;
    private byte minutes;
    private String toString;

    public BroadcastsTime(String s) {
        this.hour = Byte.parseByte(s.substring(0, 2));
        this.minutes = Byte.parseByte(s.substring(3));
        this.toString = s;
    }

    public boolean after(BroadcastsTime t) {
        if (hour > t.getHour()) {
            return true;
        } else if (hour == t.getHour() && minutes > t.getMinutes()) {
            return true;
        }
        return false;
    }

    public boolean before(BroadcastsTime t) {
        if (hour < t.getHour()) {
            return true;
        } else if (hour == t.getHour() && minutes < t.getMinutes()) {
            return true;
        }
        return false;
    }

    public boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        return this.after(t1) && this.before(t2);
    }


    public byte getHour() {
        return hour;
    }

    public byte getMinutes() {
        return minutes;
    }

    @Override
    public int compareTo(BroadcastsTime other) {
        if (this.getHour() != other.getHour()) {
            return Byte.compare(this.getHour(), other.getHour());
        }
        return Byte.compare(this.getMinutes(), other.getMinutes());
    }

    @Override
    public String toString() {
        return toString;
    }

    public boolean equals(BroadcastsTime other) {
        return hour == other.getHour() && minutes == other.getMinutes();
    }
}