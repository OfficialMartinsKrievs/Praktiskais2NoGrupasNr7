package lv.GrupaNr7.praktiskais2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtA1NameText = findViewById(R.id.txtA1Name);
        txtA1NameText.setText(getResources().getString(R.string.txt_a1_name));

        Button btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity2.setText(getResources().getString(R.string.btn_activity2));

        Button btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setText(getResources().getString(R.string.btn_dialog));

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast toast = Toast.makeText(context, "You clicked button three.", Toast.LENGTH_SHORT);
               // toast.setGravity(Gravity.CENTER, 0, 0);
                //toast.show();
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);

            }
        });
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast toast = Toast.makeText(context, "You clicked button three.", Toast.LENGTH_SHORT);
                // toast.setGravity(Gravity.CENTER, 0, 0);
                //toast.show();
                // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setTitle(R.string.app_name);

                // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
                builder.setPositiveButton(R.string.app_name2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        Toast toast = Toast.makeText(MainActivity.this, "Jūs nospiedat pogu Atcelt!.", Toast.LENGTH_SHORT);
                        toast.show();
                        dialog.cancel();
                    }
                });
                builder.setNegativeButton(R.string.app_name1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Toast toast = Toast.makeText(MainActivity.this, "Jūs izvēlejaties!.", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
               //final ArrayList selectedItems = new ArrayList(R.array.team_member_names);
                final String [] selectedItems = getResources().getStringArray(R.array.team_member_names);


                builder.setMultiChoiceItems(R.array.team_member_names, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    Toast.makeText(MainActivity.this, "Izvēlēts "+ selectedItems[which],Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "Neizvēlēts "+ which,Toast.LENGTH_LONG).show();

                                }

                                    // Else, if the item is already in the array, remove it


                            }
                        });


                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}
