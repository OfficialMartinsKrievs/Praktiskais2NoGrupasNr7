package lv.GrupaNr7.praktiskais2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView txtA2NameText = findViewById(R.id.txtA2Name);
        txtA2NameText.setText(getResources().getString(R.string.txt_a2_name));

        Button btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity1.setText(getResources().getString(R.string.btn_activity1));



        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
