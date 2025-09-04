package model;

public class Train {
    private int id;
    private String from;
    private String to;
    private double price;
    private int seats;

    public Train(int id, String from, String to, double price, int seats) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.seats = seats;
    }

    public int getId() { return id; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public double getPrice() { return price; }
    public int getSeats() { return seats; }

    public void setSeats(int seats) { this.seats = seats; }

    @Override
    public String toString() {
        return id + ". " + from + " -> " + to + " | Narx: " + price + " so'm | O'rinlar: " + seats;
    }
}
