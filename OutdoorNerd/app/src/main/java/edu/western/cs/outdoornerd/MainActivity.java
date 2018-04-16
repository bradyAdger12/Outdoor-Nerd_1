package edu.western.cs.outdoornerd;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import org.json.JSONObject;

import edu.western.cs.outdoornerd.models.DataW;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    //shortcut logt
    private static final String TAG = "MainActivity";
    //Constant
    private static final int ERROR_DIALOG_REQUEST = 9001;
    private JSONObject testObject;

    private Realm mRealm;
    private RealmResults<Data> mResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isServicesOK()){
            init();
        }

        Realm realm = Realm.getDefaultInstance();
        RealmResults results = realm.where(DataW.class).findAll();
        Log.d("MICA", String.valueOf(results.size()));


    }
    private void init(){
        Button bttnMap = (Button) findViewById(R.id.mapButton);
        bttnMap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QueryActivity.class);
                startActivity(intent);
            }
        });

    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);

        if(available == ConnectionResult.SUCCESS) {
            //Service is ok, user can make map request
            Log.d(TAG, "isServicesOk: Google Play services is working");
            return true;
        }else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            //error occured but it can be resolved
            Log.d(TAG, "isServicesOK: an error occured but it can be fixed");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
        }else{
            //Nothing you can do, wont connect
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
}
