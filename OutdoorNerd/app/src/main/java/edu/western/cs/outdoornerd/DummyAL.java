package edu.western.cs.outdoornerd;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by micalinscheid on 4/2/18.
 */

public class DummyAL {

    public ArrayList<String> dummytime1 = new ArrayList<>();
    public ArrayList<Integer> dummywind1 = new ArrayList<>();
    public ArrayList<Integer> dummytemp1 = new ArrayList<>();
    public ArrayList<Integer> dummyrain1 = new ArrayList<>();


    public void setDummytime1(ArrayList<String> dummytime1) {
        this.dummytime1 = dummytime1;
        dummytime1.add("2018-04-02 00:00:00");
        dummytime1.add("2018-04-02 01:00:00");
        dummytime1.add("2018-04-02 02:00:00");
        dummytime1.add("2018-04-02 03:00:00");
        dummytime1.add("2018-04-02 04:00:00");
        dummytime1.add("2018-04-02 05:00:00");
        dummytime1.add("2018-04-02 06:00:00");
        dummytime1.add("2018-04-02 07:00:00");
        dummytime1.add("2018-04-02 08:00:00");
        dummytime1.add("2018-04-02 09:00:00");
        dummytime1.add("2018-04-02 10:00:00");
        dummytime1.add("2018-04-02 11:00:00");
        dummytime1.add("2018-04-02 12:00:00");
        dummytime1.add("2018-04-02 13:00:00");
        dummytime1.add("2018-04-02 14:00:00");
        dummytime1.add("2018-04-02 15:00:00");
        dummytime1.add("2018-04-02 16:00:00");
        dummytime1.add("2018-04-02 17:00:00");
        dummytime1.add("2018-04-02 18:00:00");
        dummytime1.add("2018-04-02 19:00:00");
        dummytime1.add("2018-04-02 20:00:00");
        dummytime1.add("2018-04-02 21:00:00");
        dummytime1.add("2018-04-02 22:00:00");
        dummytime1.add("2018-04-02 23:00:00");

        //return dummytime1;

    }

    public ArrayList<String> getDummytime1() {
        setDummytime1(dummytime1);
        return dummytime1;
    }



    public void setDummytemp1(ArrayList<Integer> dummytemp){
        this.dummytemp1 = dummytemp;
        dummytemp.add(40);
        dummytemp.add(38);
        dummytemp.add(37);
        dummytemp.add(36);
        dummytemp.add(32);
        dummytemp.add(26);
        dummytemp.add(22);
        dummytemp.add(23);
        dummytemp.add(28);
        dummytemp.add(37);
        dummytemp.add(44);
        dummytemp.add(51);
        dummytemp.add(60);
        dummytemp.add(72);
        dummytemp.add(40);
        dummytemp.add(60);
        dummytemp.add(473);
        dummytemp.add(83);
        dummytemp.add(21);
        dummytemp.add(56);
        dummytemp.add(69);
        dummytemp.add(420);
        dummytemp.add(666);
        dummytemp.add(76);
    }

    public ArrayList<Integer> getDummytemp1(){
        setDummytemp1(dummytemp1);
        return dummytemp1;
    }



    public void setDummywind1(ArrayList<Integer> dummywind){
        this.dummywind1 = dummywind;
        dummywind.add(34);
        dummywind.add(41);
        dummywind.add(42);
        dummywind.add(45);
        dummywind.add(44);
        dummywind.add(40);
        dummywind.add(38);
        dummywind.add(32);
        dummywind.add(21);
        dummywind.add(18);
        dummywind.add(12);
        dummywind.add(9);
    }

    public ArrayList<Integer> getDummywind1(){
        setDummywind1(dummywind1);
        return dummywind1;
    }



    public void setDummyrain1(ArrayList<Integer> dummyrain1){
        this.dummyrain1 = dummyrain1;
        dummyrain1.add(1);
        dummyrain1.add(2);
        dummyrain1.add(5);
        dummyrain1.add(1);
        dummyrain1.add(2);
        dummyrain1.add(4);
        dummyrain1.add(2);
        dummyrain1.add(5);
        dummyrain1.add(1);
        dummyrain1.add(4);
        dummyrain1.add(2);
        dummyrain1.add(3);
    }

    public ArrayList<Integer> getDummyrain1(){
        setDummyrain1(dummyrain1);
        return dummyrain1;
    }

}
