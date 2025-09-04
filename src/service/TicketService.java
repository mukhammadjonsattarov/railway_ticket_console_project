package service;

import model.Ticket;
import model.Train;
import db.DataBase;

public class TicketService {
    private TrainService trainService = new TrainService();

    public void bookTicket(int trainId) {
        Train train = trainService.findTrainById(trainId);

        if (train == null || train.getSeats() == 0) {
            System.out.println("Reys topilmadi yoki joy qolmagan!");
            return;
        }

        if (DataBase.user.getWallet() < train.getPrice()) {
            System.out.println("Balans yetarli emas!");
            return;
        }

        DataBase.user.spend(train.getPrice());
        train.setSeats(train.getSeats() - 1);
        DataBase.user.getTickets().add(new Ticket(train));
        System.out.println(" Bilet muvaffaqiyatli band qilindi!");
    }

    public void showTickets() {
        if (DataBase.user.getTickets().isEmpty()) {
            System.out.println("Sizda band qilingan bilet yo‘q!");
        } else {
            System.out.println("Sizning biletlaringiz:");
            int i = 1;
            for (Ticket ticket : DataBase.user.getTickets()) {
                System.out.println((i++) + ". " + ticket);
            }
        }
    }

    public void cancelTicket(int index) {
        if (index < 1 || index > DataBase.user.getTickets().size()) {
            System.out.println("Noto‘g‘ri tanlov!");
            return;
        }

        Ticket ticket = DataBase.user.getTickets().remove(index - 1);

        // Bekor qilishda 80% pul qaytariladi
        double percent = 0.8;
        double refundAmount = ticket.getTrain().getPrice() * percent;
        DataBase.user.addBalance(refundAmount);

        ticket.getTrain().setSeats(ticket.getTrain().getSeats() + 1);

        System.out.println("Bilet bekor qilindi: " + ticket);
        System.out.println(refundAmount + " so‘m qaytarildi (" + (100 - percent * 100) + "% xizmat haqi ushlab qolindi).");
    }
}
