package org.example.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Flight {

    private String id;
    List<Passenger> passengerList = new ArrayList<>();

    public Flight(String id) {
    }

    public String getId() {
        return id;
    }

    public List<Passenger> getPassengerList() {
        return Collections.unmodifiableList(passengerList);
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

}
