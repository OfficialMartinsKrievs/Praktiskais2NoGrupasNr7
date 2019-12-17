package lv.GrupaNr7.praktiskais3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView txt_a1_ievadlauks;

    public static final String mypreference = "mypref";
    public static String ievads = "teksts";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView txt_a1_ievadlauks = findViewById(R.id.txt_a1_ievadlauks);



        TextView txtA1NameText = findViewById(R.id.txtA1Name);
        txtA1NameText.setText(getResources().getString(R.string.txt_a1_name));


        Button btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity2.setText(getResources().getString(R.string.btn_activity2));

        final Button btn_saglabat = findViewById(R.id.btn_saglabat);
        btn_saglabat.setText(getResources().getString(R.string.btn_saglabat));

        btn_saglabat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("ievads",txt_a1_ievadlauks.getText().toString());
                editor.commit();

                Toast toast = Toast.makeText(MainActivity.this, "Jūs saglabajat!.", Toast.LENGTH_SHORT);
                toast.show();

            }
        });


        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);

            }
        });





            }
        }
