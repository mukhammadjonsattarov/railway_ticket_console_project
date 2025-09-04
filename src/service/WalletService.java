package service;

import db.DataBase;

public class WalletService {
    public void showBalance() {
        System.out.println(" Wallet balans: " + DataBase.user.getWallet() + " so'm");
    }

    public void fillWallet(double amount) {
        DataBase.user.addBalance(amount);
        System.out.println(" Wallet to‘ldirildi! Balans: " + DataBase.user.getWallet() + " so'm");
    }

    public void showWalletHistory() {
        if (DataBase.user.getWalletHistory().isEmpty()) {
            System.out.println(" Wallet tarixi bo‘sh!");
        } else {
            System.out.println(" Wallet tarixi:");
            DataBase.user.getWalletHistory().forEach(System.out::println);
        }
    }
}
