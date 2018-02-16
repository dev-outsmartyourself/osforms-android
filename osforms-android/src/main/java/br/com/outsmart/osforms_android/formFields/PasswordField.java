package br.com.outsmart.osforms_android.formFields;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

import br.com.outsmart.osforms_android.FormField;
import br.com.outsmart.osforms_android.R;

/**
 * Created by carlos on 16/02/18.
 */

public class PasswordField extends TextInputLayout implements FormField {
    public static final String KEY = "password";

    private EditText editText;

    public PasswordField(Context context) {
        super(context);
        init();
    }

    public  PasswordField(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setPasswordVisibilityToggleEnabled(true);
        editText = new EditText(getContext());
        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        editText.setHint(getContext().getString(R.string.password));
        addView(editText);
    }

    @Override
    public String getValue() {
        return editText.getText().toString();
    }

    @Override
    public void clear() {
        editText.setText("");
    }

    @Override
    public String getKey() {
        return KEY;
    }
}
