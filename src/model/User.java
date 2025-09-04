package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String userName;
    private String password;
    private double wallet;
    private List<Ticket> tickets;
    private List<String> walletHistory;

    public User(int id,String name,String userName,String password, double wallet) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.wallet = wallet;
        this.tickets = new ArrayList<>();
        this.walletHistory = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() { return name; }
    public double getWallet() { return wallet; }
    public List<Ticket> getTickets() { return tickets; }
    public List<String> getWalletHistory() { return walletHistory; }

    public void addBalance(double amount) {
        wallet += amount;
        walletHistory.add("Wallet to‘ldirildi: +" + amount + " so'm");
    }

    public void spend(double amount) {
        wallet -= amount;
        walletHistory.add("Chipta uchun yechildi: -" + amount + " so'm");
    }
}
