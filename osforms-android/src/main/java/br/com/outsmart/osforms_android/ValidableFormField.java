package br.com.outsmart.osforms_android;

import br.com.outsmart.osforms_android.FormField;

/**
 * Created by carlos on 16/02/18.
 */

public interface ValidableFormField extends FormField {
    boolean isValid();
    void validate();
}
