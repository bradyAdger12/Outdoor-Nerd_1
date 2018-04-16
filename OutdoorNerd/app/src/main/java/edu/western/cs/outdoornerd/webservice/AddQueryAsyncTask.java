package edu.western.cs.outdoornerd.webservice;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.common.api.Response;

import org.json.JSONObject;

import edu.western.cs.outdoornerd.globalVals.ConstUrl;

public class AddQueryAsyncTask extends AsyncTask<Void, Integer, String> {

    private String triplet;
    private Context mContext;
    private String mResponse;


    public AddQueryAsyncTask(String triplet) {
        this.triplet = triplet;
    }


    @Override
    protected String doInBackground(Void... voids) {

        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("triplet", triplet);

            HttpPostJson httpPostJson = new HttpPostJson(ConstUrl.GETDATA2, jsonObject, mContext);
            httpPostJson.execute();
            mResponse = httpPostJson.getResponse();
            Log.d("ddd","*****response="+mResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return mResponse;

    }

    @Override
    public void onPostExecute(String response) {
        super.onPostExecute(response);
        returnResponse(response);
    }


    private String returnResponse(String response) {
        return response;
    }

}
