package edu.nyu.scps.jaxon.jul11;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        String[] a = {
                "Abdoulaye",
                "Alrick",
                "Jeffrey",
                "Jaxon",
                "Deepali",
                "Joey",
                "David",
                "Mark",
                "Asa",
                "Keenen"
                };

        Arrays.sort(a);


        // ARGUMENTS FOR THE ADAPTER ARE THE CONTEXT OF THE CLASS, SOME SORT OF LAYOUT,
        // AND THE INFORMATION FROM AN ARRAY

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                a
        );

        // SETTIN THE ADDAPTER TO THE VIEW - LISTVIEW IN THIS CASE
        listView.setAdapter(arrayAdapter);

        // WE CAN TAKE THE LIST VIEW AND GIVE IT AN ITEM CLICK LISTENER
        // IN THE ARGUMENTS PARENT IS ? PARENT SEEMS TO BE THE TEXT CONTENT  YOU HAVE  VIEW AND THE POSITION AND ID

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                //Get the selected name from the TextView that was clicked on.
                TextView textView = (TextView)view; //downcast
                CharSequence charSequence = textView.getText();
                String name = charSequence.toString();
                */

                //Get the selected name from the Array of Strings in the ArrayAdapter<String>.
                String name = (String)parent.getItemAtPosition(position); //downcast

                if (position !=5) {



                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(
                        "edu.nyu.scps." + name + ".jul11",            //name of package
                        "edu.nyu.scps." + name + ".jul11." + name + "Activity" //name of class
                );
                intent.setComponent(componentName);
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException activityNotFoundException) {
                    Toast toast = Toast.makeText(MainActivity.this, activityNotFoundException.toString(), Toast.LENGTH_LONG);
                    toast.show();
                } // END CATCH

                } // END IF
                else{
                    Intent intent = new Intent(MainActivity.this, JaxonActivity.class);
                    startActivity(intent);

                } // END ELSE

                String s = "Selected " + name + ", position = " + position + ", id = " + id + ".";
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
