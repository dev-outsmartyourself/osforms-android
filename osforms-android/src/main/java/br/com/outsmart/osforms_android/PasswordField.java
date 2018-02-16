package br.com.outsmart.osforms_android;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.widget.EditText;

/**
 * Created by carlos on 16/02/18.
 */

public class PasswordField extends TextInputLayout {
    private EditText editText;

    public PasswordField(Context context) {
        super(context);
        setPasswordVisibilityToggleEnabled(true);
        editText = new EditText(context);
        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        editText.setHint(context.getString(R.string.password));
        addView(editText);
    }
}
