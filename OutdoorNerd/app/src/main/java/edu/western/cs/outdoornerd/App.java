package edu.western.cs.outdoornerd;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Realm initilization
        Realm.init(this);

        //Table init
        RealmConfiguration config =
                new RealmConfiguration.Builder().name("AllStationsTable.realm").build();

        Realm.setDefaultConfiguration(config);

    }



}
