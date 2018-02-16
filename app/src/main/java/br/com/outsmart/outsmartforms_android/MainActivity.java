package br.com.outsmart.outsmartforms_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.outsmart.osforms_android.EmailField;
import br.com.outsmart.osforms_android.Form;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout mainContainer = findViewById(R.id.main_container);

        Form form = new Form(this);
        form.addView(new EmailField(this));
        form.addView(new EmailField(this));


        //form.add(new  PasswordField());



        mainContainer.addView(form);
    }
}
