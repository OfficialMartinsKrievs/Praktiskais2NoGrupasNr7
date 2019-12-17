package lv.GrupaNr7.praktiskais3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static String ievads = "teksts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView txtA2NameText = findViewById(R.id.txtA2Name);
        txtA2NameText.setText(getResources().getString(R.string.txt_a2_name));

        Button btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity1.setText(getResources().getString(R.string.btn_activity1));

        final TextView txt_a2_ievadlauks = findViewById(R.id.txt_a2_ievadlauks);


        Button btn_nolasit = findViewById(R.id.btn_nolasit);
        btn_nolasit.setText(getResources().getString(R.string.btn_nolasit));

        btn_nolasit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
                txt_a2_ievadlauks.setText(sharedpreferences.getString("ievads", "Nav vertibu"));

                Toast toast = Toast.makeText(Activity2.this, "Teksts tika iekopets!.", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
