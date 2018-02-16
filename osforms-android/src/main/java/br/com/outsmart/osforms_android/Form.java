package br.com.outsmart.osforms_android;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kalunga on 16/02/2018.
 */

public class Form extends LinearLayout {
    private List<FormField> fieldList = new ArrayList<>();

    public Form(Context context) {
        super(context);
        setOrientation(LinearLayout.VERTICAL);
    }

    public Form(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.VERTICAL);
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.Form);
        apply(typedArray);
    }

    private void add(View view) {
        if(!(view instanceof FormField))
            throw new IllegalArgumentException("Just FormFields");
        else
            fieldList.add((FormField)view);
    }

    @Override
    public void addView(View view) {
        super.addView(view);
        add(view);
    }

    public void addView(View view, LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        add(view);
    }

    public Map<String, String> getValue() {
        Map<String, String> values = new HashMap<>();
        boolean isValid = true;
        for (FormField fiel : fieldList) {
            if (fiel instanceof ValidableFormField) {
                ValidableFormField validable = (ValidableFormField) fiel;
                if (!validable.isValid()) {
                    validable.validate();
                    isValid = false;
                }
            }
            values.put(fiel.getKey(), fiel.getValue());
        }
        return isValid ? values : Collections.emptyMap();
    }

    public void clear() {
        for (FormField formField : fieldList) {
            formField.clear();
        }
    }

    public boolean isValid() {
        boolean isValid = true;
        for (FormField fiel : fieldList) {
            if (fiel instanceof ValidableFormField) {
                ValidableFormField validable = (ValidableFormField) fiel;
                isValid = isValid && validable.isValid();
            }
        }
        return isValid;
    }


    public void setStyle(@StyleRes int style) {
        TypedArray typedArray = getContext().obtainStyledAttributes(style, R.styleable.Form);
        apply(typedArray);
    }


    private void apply(TypedArray typedArray) {
        setBackgroundColor(typedArray.getColor(R.styleable.Form_backgroundColor, 0));
    }
}
