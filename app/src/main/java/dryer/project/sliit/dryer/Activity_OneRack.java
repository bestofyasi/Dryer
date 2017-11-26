package dryer.project.sliit.dryer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Activity_OneRack extends AppCompatActivity {

    String INDEX;
    JSONObject RACK;
    TextView rackID,rackRatio;

    private ListView listview_images;
    ArrayList<RackImage> imagelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__one_rack);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout);

//        imageView = (ImageView)findViewById(R.id.image);
        listview_images = (ListView)findViewById(R.id.list_rack_images);
        imagelist = new ArrayList<>();


        rackID = (TextView)findViewById(R.id.one_rack_id);
        rackRatio = (TextView)findViewById(R.id.one_rack_ratio);

        Bundle extras = getIntent().getExtras();
        INDEX= extras.getString("index");

        try{




            RACK = Constants.RACK_LIST.getJSONObject(Integer.parseInt(INDEX));


            rackID.setText("Rack ID : " + RACK.getString("rack_id"));
            rackRatio.setText("Percentage : " + RACK.getString("ratio"));
//            Toast.makeText(getApplicationContext(),RACK.getString("timestamp"),Toast.LENGTH_SHORT).show();

            imagelist.add(new RackImage(RACK.getString("f_image_1"),RACK.getString("r_image_1")));
            //imagelist.add(new RackImage(RACK.getString("f_image_2"),RACK.getString("r_image_2")));
            //imagelist.add(new RackImage(RACK.getString("f_image_3"),RACK.getString("r_image_3")));
            //imagelist.add(new RackImage(RACK.getString("f_image_4"),RACK.getString("r_image_4")));
            //imagelist.add(new RackImage(RACK.getString("f_image_5"),RACK.getString("r_image_5")));
            //imagelist.add(new RackImage(RACK.getString("f_image_6"),RACK.getString("r_image_6")));
            //imagelist.add(new RackImage(RACK.getString("f_image_7"),RACK.getString("r_image_7")));
            //imagelist.add(new RackImage(RACK.getString("f_image_8"),RACK.getString("r_image_8")));



            RackImageAdampter myAdapter=new RackImageAdampter(getApplicationContext(),R.layout.one_rack_image,imagelist);

            listview_images.setAdapter(myAdapter);

            //Picasso.with(getApplicationContext()).load("http://slitt.192.168.1.106.xip.io:8090/images/f1.jpg").into(imageView);

        }
        catch (Exception e){
            e.printStackTrace();
        }




    }
}
