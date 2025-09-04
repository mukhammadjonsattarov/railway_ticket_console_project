import db.DataBase;
import model.User;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginService loginService = new LoginService();
        TrainService trainService = new TrainService();
        TicketService ticketService = new TicketService();
        WalletService walletService = new WalletService();

        User loggedInUser = null;
        System.out.println("====================================");
        System.out.println("    Railway Ticket System Login   ");
        System.out.println("====================================");

        while (loggedInUser == null) {
            System.out.print("👤 Username: ");
            String uname = sc.nextLine();
            System.out.print("🔑 Password: ");
            String pass = sc.nextLine();

            loggedInUser = loginService.login(uname, pass);

            if (loggedInUser == null) {
                System.out.println(" Noto‘g‘ri username yoki parol! Qayta urinib ko‘ring.\n");
            }
        }

        System.out.println("\n Login successful! Xush kelibsiz, " + loggedInUser.getName() + " ");
        DataBase.user = loggedInUser;
        int choice;
        do {
            System.out.println("\n====  Poyezd Bilet Sotish Tizimi ====");
            System.out.println("1. Reyslar ro‘yxatini ko‘rish");
            System.out.println("2. Bilet band qilish");
            System.out.println("3. Biletlarni ko‘rish");
            System.out.println("4. Biletni bekor qilish");
            System.out.println("5. Wallet balansini ko‘rish");
            System.out.println("6. Wallet to‘ldirish");
            System.out.println("7. Wallet tarixi");
            System.out.println("0. Chiqish");
            System.out.print(" Tanlang: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> trainService.showTrains();
                case 2 -> {
                    trainService.showTrains();
                    System.out.print("Reys raqamini kiriting: ");
                    int id = sc.nextInt();
                    ticketService.bookTicket(id);
                }
                case 3 -> ticketService.showTickets();
                case 4 -> {
                    ticketService.showTickets();
                    System.out.print("Bekor qilinadigan bilet raqamini kiriting: ");
                    int idx = sc.nextInt();
                    ticketService.cancelTicket(idx);
                }
                case 5 -> walletService.showBalance();
                case 6 -> {
                    System.out.print("Summani kiriting: ");
                    double sum = sc.nextDouble();
                    walletService.fillWallet(sum);
                }
                case 7 -> walletService.showWalletHistory();
            }
        } while (choice != 0);

        System.out.println(" Dastur tugadi!");
    }
}
