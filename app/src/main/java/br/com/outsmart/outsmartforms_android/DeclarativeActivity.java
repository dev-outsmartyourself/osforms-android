package br.com.outsmart.outsmartforms_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Map;

import br.com.outsmart.osforms_android.Form;
import br.com.outsmart.osforms_android.formFields.EmailField;

public class DeclarativeActivity extends AppCompatActivity {
    private Form form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declarative);
        form = findViewById(R.id.form);
        /*******
         * TODO: colocar os elementos no xml ainda não esta ponto
         */

        findViewById(R.id.button).setOnClickListener(view -> {
            if(form.isValid()) {
                Map<String, String> values = form.getValue();
                Log.d(MainActivity.class.getSimpleName(), values.toString());
                Log.d(MainActivity.class.getSimpleName(), values.get(EmailField.KEY));
                form.clear();
            } else {
                Log.d(MainActivity.class.getSimpleName(), "Not valid form");
            }
        });

    }
}
