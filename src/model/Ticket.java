package model;

public class Ticket {
    private Train train;

    public Ticket(Train train) {
        this.train = train;
    }

    public Train getTrain() { return train; }

    @Override
    public String toString() {
        return train.getFrom() + " -> " + train.getTo() + " | Narx: " + train.getPrice() + " so'm";
    }
}
