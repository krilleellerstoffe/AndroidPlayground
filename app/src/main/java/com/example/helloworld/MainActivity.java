package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOne;
    TextView txtxHello;
    EditText editText;
    CheckBox checkBoxHarry;
    CheckBox checkBoxMatrix;
    CheckBox checkBoxDune;
    
    RadioGroup radioGroupRelationship;

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOne = findViewById(R.id.button1);
        btnOne.setOnClickListener(this);
        progressBar = findViewById(R.id.progressBar);
//        Thread thread = new Thread(() -> {
//
//        });
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    progressBar.incrementProgressBy(2);
                    SystemClock.sleep(100);
                }
                progressBar.setVisibility(View.GONE);
                // Stuff that updates the UI

            }
        });
//        thread.start();
        txtxHello = findViewById(R.id.textHello);
        editText = findViewById(R.id.editTextName);
        checkBoxHarry = findViewById(R.id.checkHarry);
        checkBoxMatrix = findViewById(R.id.checkMatrix);
        checkBoxDune = findViewById(R.id.checkDune);
        radioGroupRelationship = findViewById(R.id.radioGroup);
        radioGroupRelationship.setOnCheckedChangeListener((radioGroup, i) -> {
            switch (i) {
                case R.id.radioMarried:
                    Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.radioSingle:
                    Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        });
        checkBoxHarry.setOnCheckedChangeListener((compoundButton, b) -> {
            if(b) {
                Toast.makeText(MainActivity.this, "Watched Harry", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "You should watch Harry", Toast.LENGTH_SHORT).show();
            }
        });
        checkBoxMatrix.setOnClickListener(this);
        checkBoxDune.setOnClickListener(this);
        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();

    }

    private void toastAlternatives(String movie) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Toast.makeText(this, "CLICK!", Toast.LENGTH_SHORT).show();
                txtxHello.setText("Hello " + editText.getText().toString());
                hideKeyboard();
                break;
            default:
                break;
        }
    }
    public void hideKeyboard() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

    }
}