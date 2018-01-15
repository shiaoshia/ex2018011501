package tw.com.shiaoshia.ex2018011501;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb = (ProgressBar)findViewById(R.id.progressBar);
        iv = (ImageView)findViewById(R.id.imageView);
    }

    public void click01(View v) {
        pb.setVisibility(View.VISIBLE);
        iv.setVisibility(View.INVISIBLE);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        ImageRequest request = new ImageRequest("https://upload.wikimedia.org/wikipedia/en/f/f2/Ubercon_vlad_rgb_250.gif",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        iv.setImageBitmap(response);
                        pb.setVisibility(View.INVISIBLE);
                        iv.setVisibility(View.VISIBLE);
                    }
                }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }

    public void click02(View v) {
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        StringRequest request = new UTF8StringRequest("https://www.mobile01.com/rss/news.xml",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("NET",response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
    }
}
