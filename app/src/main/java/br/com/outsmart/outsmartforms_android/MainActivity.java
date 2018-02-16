package br.com.outsmart.outsmartforms_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Map;

import br.com.outsmart.osforms_android.formFields.EmailField;
import br.com.outsmart.osforms_android.Form;
import br.com.outsmart.osforms_android.formFields.PasswordField;

public class MainActivity extends AppCompatActivity {

    private Form form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout mainContainer = findViewById(R.id.main_container);

        form = new Form(this);
        form.addView(new EmailField(this));
        form.addView(new PasswordField(this));

        mainContainer.addView(form);
        Button buttonValue = findViewById(R.id.button);
        buttonValue.setOnClickListener(view -> {
            if(form.isValid()) {
                Map<String, String> values = form.getValue();
                Log.d(MainActivity.class.getSimpleName(), values.toString());
                Log.d(MainActivity.class.getSimpleName(), values.get(EmailField.KEY));
                form.clear();
            } else {
                Log.d(MainActivity.class.getSimpleName(), "Not valid form");
            }
        });


        findViewById(R.id.button2).setOnClickListener(view -> {
           startActivity(new Intent(MainActivity.this, DeclarativeActivity.class));
        });
    }
}
