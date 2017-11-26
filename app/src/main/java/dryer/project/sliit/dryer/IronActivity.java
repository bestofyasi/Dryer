package dryer.project.sliit.dryer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

public class IronActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3, cb4, cb5;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iron);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);
        cb5 = (CheckBox) findViewById(R.id.checkBox5);

        b2 = (Button) findViewById(R.id.button2);

//gzonetechnologies.com/Research
        new DownloadImageFromInternet((ImageView) findViewById(R.id.imageView))
                .execute("http://gzonetechnologies.com/che/image/cloth.jpg");

        new DownloadImageFromInternet((ImageView) findViewById(R.id.imageView2))
                .execute("http://gzonetechnologies.com/che/2.jpg");

        new DownloadImageFromInternet((ImageView) findViewById(R.id.imageView3))
                .execute("http://gzonetechnologies.com/che/3.jpg");

        new DownloadImageFromInternet((ImageView) findViewById(R.id.imageView4))
                .execute("http://gzonetechnologies.com/che/4.jpg");


        new DownloadImageFromInternet((ImageView) findViewById(R.id.imageView5))
                .execute("http://gzonetechnologies.com/che/5.jpg");


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean x1 = false;
                boolean x2 = false;
                boolean x3 = false;
                boolean x4 = false;
                boolean x5 = false;

                if (cb1.isChecked()) {
                    x1 = true;
                }
                if (cb2.isChecked()) {
                    x2 = true;
                }
                if (cb3.isChecked()) {
                    x3 = true;
                }
                if (cb4.isChecked()) {
                    x4 = true;
                }
                if (cb5.isChecked()) {
                    x5 = true;
                }


                String str = " Iorning Progress Cloth No  ";

                if (String.valueOf(x1) == "true") {
                    str = str + "1, ";
                }
                if (String.valueOf(x2) == "true") {
                    str = str + "2, ";
                }
                if (String.valueOf(x3) == "true") {
                    str = str + "3, ";
                }
                if (String.valueOf(x4) == "true") {
                    str = str + "4, ";
                }
                if (String.valueOf(x5) == "true") {
                    str = str + "5";
                }

                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
            Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...", Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }


}

