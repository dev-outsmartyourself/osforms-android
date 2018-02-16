package br.com.outsmart.osforms_android.formFields;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

import br.com.outsmart.osforms_android.R;
import br.com.outsmart.osforms_android.ValidableFormField;

/**
 * Created by kalunga on 16/02/2018.
 */

public class EmailField extends TextInputLayout implements ValidableFormField {

    public static final String KEY = "email";

    public EditText emailField;


    public EmailField(Context context) {
        super(context);
        init();
    }

    public EmailField(Context context, AttributeSet attr) {
        super(context, attr);
        init();
    }

    private void init() {
        emailField = new EditText(getContext());
        emailField.setHint(R.string.email);

        emailField.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        emailField.setOnFocusChangeListener((view, hasFocus) -> {
            if (!hasFocus) {
                validate();
            }
        });
        addView(emailField);
    }




    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    @Override
    public String getValue() {
        return emailField.getText().toString();
    }

    @Override
    public void clear() {
        emailField.setText("");
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public boolean isValid() {
        return isValidEmail(emailField.getText());
    }

    @Override
    public void validate() {
        if (!isValid())
            setError("Email is not valid");
        else
            setError(null);
    }
}
