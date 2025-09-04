package service;

import model.Train;
import db.DataBase;

public class TrainService {
    public void showTrains() {
        for (Train t : DataBase.trains) {
            System.out.println(t);
        }
    }

    public Train findTrainById(int id) {
        return DataBase.trains.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }
}
