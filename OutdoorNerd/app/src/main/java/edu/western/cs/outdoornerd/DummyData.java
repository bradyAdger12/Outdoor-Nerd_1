package edu.western.cs.outdoornerd;

import java.util.ArrayList;

/**
 * Created by micalinscheid on 4/2/18.
 */

public class DummyData {
    public ArrayList<String> timing = new ArrayList<>();
    public ArrayList<Integer> temp = new ArrayList<>();
    public ArrayList<Integer> wind = new ArrayList<>();
    public ArrayList<Integer> rain = new ArrayList<>();

    public DummyData(ArrayList<String> timing, ArrayList<Integer> temp, ArrayList<Integer> wind,ArrayList<Integer> rain){

        this.timing = timing;
        this.wind = wind;
        this.temp = temp;
        this.rain = rain;

    }

    public ArrayList<String> getTiming() {
        return timing;
    }

    public ArrayList<Integer> getTemp() {
        return temp;
    }

    public ArrayList<Integer> getWind() {
        return wind;
    }

    public ArrayList<Integer> getRain() {
        return rain;
    }
}
