package com.redshift.dynamiccomponent;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AppUtils {
    private static final String TAG = "AppUtils";

    public static EditText createInput(Context context,String hint){
        Log.d(TAG, "createInput: ");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(25,16,25,24);


        EditText editText = new EditText(context);
        editText.setTextSize(14f);
        editText.setBackground(context.getDrawable(R.drawable.input_style));
        editText.setHint(hint);
        editText.setLayoutParams(params);
        editText.setPadding(16,24,0,24);

        return editText;
    }


    public  static TextView createLabel (Context context,String val){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(25,16,25,0);
        Log.d(TAG, "createLabel: ");
        TextView textView = new TextView(context);
        textView.setText(val);
        textView.setTextColor(context.getResources().getColor(android.R.color.white));
        textView.setLayoutParams(params);
        return textView;


    }
}
