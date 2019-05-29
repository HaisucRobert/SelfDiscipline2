package info.androidhive.selfdiscipline;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Meals_generator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_generator);

        DataBaseHelper db = new DataBaseHelper(getApplicationContext());


        if(db.isTableFoodEmpty()) {
            db.insertDummyIntoFoodTable();
        }
        new Thread(() -> {
            android.os.Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
            String finalcalories = getSharedPreferences("robert", Context.MODE_PRIVATE).getString("finalcalories", "");
            List<Food> allData = null;
            if(finalcalories.isEmpty()) {
                allData = db.getAllData();
            } else {
                allData = db.calculateMeal2(Integer.parseInt(finalcalories));
            }
            final RecyclerAdapter recyclerAdapter = new RecyclerAdapter(allData);
            final RecyclerView recyclerView = findViewById(R.id.recyclerView);
            runOnUiThread(() -> {
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                findViewById(R.id.progressBar2).setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
            });

        }).start();


        SharedPreferences storage = getSharedPreferences("recalculation", Context.MODE_PRIVATE);
        String recalculation = storage.getString("recalculation", "Go to Kcal calculator to calculate your necessary");

        TextView textView =(TextView) findViewById(R.id.txt_recal);
        textView.setText("Your calorie requirements according with your goal is " + recalculation + " calories a day");
    }
}
