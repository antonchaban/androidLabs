package kpi.fict.achaban.androidlabsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button confirmButton = (Button) findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(view -> {
            TextView myTextView = (TextView) findViewById(R.id.textView2);
            if (getValueOfPass().isEmpty()) {
                Toast.makeText(MainActivity.this,
                        "Enter your password", Toast.LENGTH_LONG).show();
                myTextView.setText(null);
            } else {

                myTextView.setText(getValueOfPass());
            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            EditText passField = (EditText) MainActivity.this.findViewById(R.id.editTextTextPassword);
            if (R.id.radioButton == checkedId) {
                passField.setTransformationMethod(null);

            }
            if (R.id.radioButton2 == checkedId) {
                passField.setTransformationMethod(new PasswordTransformationMethod());
            }

        });

    }

    private String getValueOfPass() {
        EditText passField = (EditText) findViewById(R.id.editTextTextPassword);
        return passField.getText().toString();
    }

}