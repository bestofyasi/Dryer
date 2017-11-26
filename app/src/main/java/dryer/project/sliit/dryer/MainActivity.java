package dryer.project.sliit.dryer;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity {

    final private static String TAG = "MAIN_ACTIVITY_DRYER";

    private ListView lv;
    ListView listview_racks;

    ArrayList<Rack> racklist;

//    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // display = (TextView)findViewById(R.id.display);

    //    contactList = new ArrayList<>();
//        lv = (ListView) findViewById(R.id.list);


        listview_racks = (ListView) findViewById(R.id.list);





       getRackList.execute();



    }


    public AsyncTask<Void,Void,Void> getRackList = new AsyncTask<Void, Void, Void>() {


        @Override
        protected Void doInBackground(Void... voids) {


            HttpHandler sh = new HttpHandler();

            String url = Constants.BASE_URL;
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
//                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONArray jsonArray = new JSONArray(jsonStr);

                    Constants.RACK_LIST = jsonArray;

                    racklist = new ArrayList<>();

                    // Getting JSON Array node

                    for(int i = 0; i < jsonArray.length(); i++){

                        Log.d("IN JSON", jsonArray.getJSONObject(i).getString("id"));
                        racklist.add(new Rack(jsonArray.getJSONObject(i).getInt("id")
                                ,jsonArray.getJSONObject(i).getString("rack_id")
                                ,jsonArray.getJSONObject(i).getString("ratio")
                                ,jsonArray.getJSONObject(i).getString("timestamp")));


                    }



                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),

                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            RackAdapter myAdapter=new RackAdapter(getApplicationContext(),R.layout.item_rack,racklist);
            listview_racks.setAdapter(myAdapter);



        }
    };

}
