package br.com.outsmart.osforms_android;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kalunga on 16/02/2018.
 */

public class EmailField extends AppCompatEditText {

    public EmailField(final Context context) {
        super(context);
        setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(!hasFocus)
                {
                    isValidEmail(getText());
                }
            }
        });
    }


    public static boolean isValidEmail(CharSequence target){
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
