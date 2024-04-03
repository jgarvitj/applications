package cabBooking.model;

public class Location {
    int x;
    int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distance(Location loc) {
        return (int) Math.sqrt((loc.x - this.x) *(loc.x - this.x) + (loc.y - this.y)*(loc.y - this.y));
    }
}
