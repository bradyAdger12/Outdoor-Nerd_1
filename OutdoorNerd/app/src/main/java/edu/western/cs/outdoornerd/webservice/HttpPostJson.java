package edu.western.cs.outdoornerd.webservice;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import edu.western.cs.outdoornerd.globalVals.ConstUrl;
import edu.western.cs.outdoornerd.models.DataW;
import io.realm.Realm;

/**
 * Created by honginpark on 2/26/18.
 */

public class HttpPostJson {

    private String mUrl;
    private JSONObject mInputJason;
    private Context mContext;
    private String JsonResponse=null;

    public HttpPostJson(String url, JSONObject inputJson, Context context){
        mUrl=url;
        mInputJason=inputJson;
        mContext=context;
    }

    public void execute() {

        Realm realm = Realm.getDefaultInstance();
        Log.d("ddd", "***post json="+mInputJason.toString()+"/"+mUrl);

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(mUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);

            // is output buffer writter
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");

            //set headers and method
            Writer writer = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            writer.write(mInputJason.toString());
            // json data
            writer.close();

            InputStream inputStream = urlConnection.getInputStream();
            //input stream
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while ((inputLine = reader.readLine()) != null)
                buffer.append(inputLine + "\n");
            if (buffer.length() == 0) {
                // Stream was empty. No point in parsing.

            }
            JsonResponse = buffer.toString();
            //response data
            Log.d("ddd",JsonResponse);


                try {
                    JSONArray mJsonArrayTDs = new JSONArray(JsonResponse);
                    for(int i=0; i<mJsonArrayTDs.length(); i++){
                        JSONObject jsonObject = mJsonArrayTDs.getJSONObject(i);

                        DataW dw = new DataW();
                        Log.d("MICA", "making objects");

                        dw.setId(jsonObject.getInt("id"));
                        dw.setStationName(jsonObject.getString("stationName"));
                        dw.setTriplet(jsonObject.getString("triplet"));
                        dw.setDateTime(jsonObject.getString("dateTime"));
                        dw.setTemp(jsonObject.getString("temp"));
                        dw.setWindA(jsonObject.getString("windA"));
                        dw.setSnowD(jsonObject.getString("snowD"));
                        dw.setWaterEq(jsonObject.getString("waterEq"));
                        //if id exist in realm, remove it
//                        if(ID_list.contains(td.getId())) {
//                            ID_list.remove(td.getId());
//                        }

                        //when same id(p.key) exist, update object or add a new object
                        realm.beginTransaction();
                        realm.copyToRealmOrUpdate(dw);
                        realm.commitTransaction();
                        Log.d("MICA", "committed");

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }





        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.d("ddd", "Error closing stream", e);
                }
            }
        }



    }//execute


    public String getResponse(){
        return JsonResponse;
    }


}