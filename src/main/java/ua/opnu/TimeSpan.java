package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    private void setTimeFromTotalMinutes(int totalMinutes) {
        if (totalMinutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = totalMinutes / 60;
            this.minutes = totalMinutes % 60;
        }
    }

    public TimeSpan() {
        this(0, 0);
    }

    public TimeSpan(int minutes) {
        this(0, minutes);
    }

    public TimeSpan(int hours, int minutes) {
        int totalMinutes = hours * 60 + minutes;
        setTimeFromTotalMinutes(totalMinutes);
    }

    public TimeSpan(TimeSpan other) {
        if (other != null) {
            this.hours = other.hours;
            this.minutes = other.minutes;
        } else {
            this.hours = 0;
            this.minutes = 0;
        }
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getTotalMinutes() {
        return (minutes + hours * 60);
    }

    public double getTotalHours() {
        return (hours + minutes / 60.0);
    }

    public void add(int hours, int minutes) {
        int currentTotalMinutes = this.getTotalMinutes();
        int addedTotalMinutes = hours * 60 + minutes;
        setTimeFromTotalMinutes(currentTotalMinutes + addedTotalMinutes);
    }

    public void add(int minutes) {
        this.add(0, minutes);
    }

    public void add(TimeSpan other) {
        if (other != null) {
            this.add(other.hours, other.minutes);
        }
    }

    public void subtract(int hours, int minutes) {
        int currentTotalMinutes = this.getTotalMinutes();
        int subtractedTotalMinutes = hours * 60 + minutes;

        if (subtractedTotalMinutes < 0) {
            return;
        }

        setTimeFromTotalMinutes(currentTotalMinutes - subtractedTotalMinutes);
    }

    public void subtract(int minutes) {
        this.subtract(0, minutes);
    }

    public void subtract(TimeSpan other) {
        if (other != null) {
            this.subtract(other.hours, other.minutes);
        }
    }

    public void scale(int factor) {
        if (factor <= 0) {
            return;
        }
        int currentTotalMinutes = this.getTotalMinutes();
        setTimeFromTotalMinutes(currentTotalMinutes * factor);
    }
}
