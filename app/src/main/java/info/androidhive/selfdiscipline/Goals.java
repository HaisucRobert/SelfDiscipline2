package info.androidhive.selfdiscipline;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Goals extends AppCompatActivity {
    private static String TAG = Goals.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        // Take value from Kcal_calculator activity
        SharedPreferences storage = getSharedPreferences("robert", Context.MODE_PRIVATE);
        String finalcalories = storage.getString("finalcalories", "Go to Kcal calculator to calculate your necessary");
        ((TextView) findViewById(R.id.txtkcal)).setText("To maintain your weight you need " + finalcalories + " calories");



        // Take the value from spinner when you choose the goal
        Spinner spinner = (Spinner) findViewById(R.id.goal_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.establish_goal, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        // Take the valeu from spineer whe you choose hard or light
        Spinner spinner2 = (Spinner) findViewById(R.id.hard_light);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.hard_light, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);



        Spinner spinner3 = (Spinner) findViewById(R.id.goal_spinner);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                            String goal_spinner2 = spinner3.getSelectedItem().toString();
                                            if (goal_spinner2.equals("Losing weight") || goal_spinner2.equals("Gaining some muscle")) {
                                                spinner2.setVisibility(View.VISIBLE);
                                            }
                                            if (goal_spinner2.equals("Maintain weight")) {
                                                spinner2.setVisibility(View.GONE);
                                            }
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });



        //Calling the method
        Button buton_calc = (Button) findViewById(R.id.button_recalculate);
        buton_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recalculate_kcal();
            }
        });
    }
    // In this method will be calculate nr of kcalories in depend of goal
    // take  finalcalories and if the customer chose  lose weigh  - and  if he choose gain muscle +
    // if he chose in 2nd spinner hard   finalcalories + 0.2 * finalcalories
    // same with light but for light is 0.1 and fianlcalories - 0.1 * finalcalories


    public void recalculate_kcal(){
        Double hard = 0.2;
        Double light = 0.1;
        Double recalculation = 0.0;


        Spinner spn = (Spinner) findViewById(R.id.goal_spinner);
        String goal_spinner = spn.getSelectedItem().toString();

        Spinner spn_act = (Spinner) findViewById(R.id.hard_light);
        String hard_light = spn_act.getSelectedItem().toString();


              //Tests
        System.out.println(goal_spinner);
        System.out.println(hard_light);


        SharedPreferences storage = getSharedPreferences("robert", Context.MODE_PRIVATE);
        String finalcalories = storage.getString("finalcalories", "Go to Kcal calculator to calculate your necessary");
        Double finalcaloriesint = Double.parseDouble(finalcalories);

        System.out.println(finalcalories);
        if (goal_spinner.equals("Losing weight") && hard_light.equals("Hard")){
            recalculation = finalcaloriesint - (hard * finalcaloriesint);
            System.out.println(recalculation);
        }
        if (goal_spinner.equals("Losing weight") && hard_light.equals("Light")){
            recalculation = finalcaloriesint - (light * finalcaloriesint);
        }
        if (goal_spinner.equals("Gaining some muscle") && hard_light.equals("Hard")){
            recalculation = finalcaloriesint + (hard * finalcaloriesint);
        }
        if (goal_spinner.equals("Gaining some muscle") && hard_light.equals("Light")){
            recalculation = finalcaloriesint + (light * finalcaloriesint);
        }
        if (goal_spinner.equals("Maintain weight")) {
            recalculation = finalcaloriesint;
        }



        System.out.println(recalculation);
        TextView textView =(TextView) findViewById(R.id.text_recalculate);
        textView.setText("Congratulation to setting your goal, to achieve it you need " + recalculation + " calories a day");


        SharedPreferences.Editor edit = getSharedPreferences("recalculation", Context.MODE_PRIVATE).edit();
        edit.putString("recalculation", String.valueOf(recalculation));
        edit.apply();










    }
}
