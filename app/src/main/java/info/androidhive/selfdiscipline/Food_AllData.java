package info.androidhive.selfdiscipline;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Food_AllData extends AppCompatActivity {
    Cursor results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__all_data);
        configureMealButton();
        DataBaseHelper db = new DataBaseHelper(getApplicationContext());
        results = db.getallInfo();


        Button buton_calc = (Button) findViewById(R.id.next_food);
        buton_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readNext();
            }
        });
    }


    private void configureMealButton(){
        Button random_menu = (Button) findViewById(R.id.random_menu);
        random_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Food_AllData.this , Meals_generator.class));
            }
        });
    }


    public void readNext() {
        TextView name = (TextView) findViewById(R.id.name);
        TextView kcalorii = (TextView) findViewById(R.id.kcal);
        TextView proteine = (TextView) findViewById(R.id.proteine);
        TextView lipide = (TextView) findViewById(R.id.lipide);
        TextView glucide = (TextView) findViewById(R.id.glucide);

        if (results.moveToNext()) {
            name.setText(results.getString(1));
            kcalorii.setText(results.getString(2));
            proteine.setText(results.getString(3));
            lipide.setText(results.getString(4));
            glucide.setText(results.getString(5));
        }
    }
}
