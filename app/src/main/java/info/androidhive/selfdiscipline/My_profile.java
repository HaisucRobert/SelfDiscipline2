package info.androidhive.selfdiscipline;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class My_profile extends AppCompatActivity {

    Cursor resultdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        DataBaseHelper db = new DataBaseHelper(getApplicationContext());

        resultdata = db.getallPInfo();





        Button buton_calc = (Button) findViewById(R.id.next_food);
        buton_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readNext();
            }
        });

        }

        public void readNext(){
            TextView age =(TextView) findViewById(R.id.age);
            TextView weight =(TextView) findViewById(R.id.weight);
            TextView lifestyle =(TextView) findViewById(R.id.lifestyle);
            TextView calories =(TextView) findViewById(R.id.calories);


            if (resultdata.moveToNext()){
                age.setText(resultdata.getString(1));
                weight.setText(resultdata.getString(3));
                lifestyle.setText(resultdata.getString(5));
                calories.setText(resultdata.getString(6));

            }
        }

    }

