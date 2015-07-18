package edu.nyu.scps.jaxon.jul11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class JaxonActivity extends AppCompatActivity {

    private int[] sample = {
            R.drawable.joey_l_0,
            R.drawable.abdoulaye_l_1,
            R.drawable.asa_l_2,
            R.drawable.keenen_l_3,
            R.drawable.mark_l_4,
            R.drawable.alrick_l_5,
            R.drawable.david_l_6,
            R.drawable.deepali_l_7,
            R.drawable.jaxon_l_8,
            R.drawable.jeffrey_l_9
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jaxon);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Create an ImageView containing a Drawable from the above array.
                ImageView imageView = new ImageView(JaxonActivity.this);
                imageView.setImageResource(JaxonActivity.this.sample[position % sample.length]);


                //Insert the ImageView into a Toast.
                Toast toast = new Toast(JaxonActivity.this);
                toast.setView(imageView);
                toast.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jaxon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
