package br.com.outsmart.osforms_android;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by kalunga on 16/02/2018.
 */

public class Form extends LinearLayout {

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

    public void setStyle(@StyleRes int style) {
        TypedArray typedArray = getContext().obtainStyledAttributes(style, R.styleable.Form);
        apply(typedArray);
    }


    public void apply(TypedArray typedArray) {
        setBackgroundColor(typedArray.getColor(R.styleable.Form_backgroundColor, 0));
    }
}
