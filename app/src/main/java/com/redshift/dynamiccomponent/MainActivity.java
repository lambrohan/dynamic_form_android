package com.redshift.dynamiccomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.redshift.dynamiccomponent.Models.MyFormElement;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    LinearLayout linearLayout;
    Button button;
    ArrayList<EditText>editTexts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.form_parent_layout);
        button = findViewById(R.id.button);
        editTexts = new ArrayList<>();

        //on click listeners
        final ArrayList<MyFormElement> formElements = new ArrayList<>();
        formElements.add(new MyFormElement("et","Name"));
        formElements.add(new MyFormElement("et","No"));
        ArrayList<String>countries = new ArrayList<>();
        countries.add("INDIA");
        countries.add("JAPAN");
        countries.add("CHINA");
        formElements.add(new MyFormElement("spinner","Country",countries));
        formElements.add(new MyFormElement("et","Address"));


        for (int i = 0; i < formElements.size(); i++){

            if (formElements.get(i).getType().equals("et")){
                TextView label = new TextView(this);
                label.setText(formElements.get(i).getLabel());
                formElements.get(i).setEditText(new EditText(this));
                EditText editText = formElements.get(i).getEditText();
                editText.setHint(formElements.get(i).getLabel());

                if (label.getParent() != null){
                    ((ViewGroup)label.getParent()).removeView(label);
                }
                linearLayout.addView(label);
                linearLayout.addView(editText);

            }else if (formElements.get(i).getType().equals("spinner")){
                TextView label = new TextView(this);
                label.setText(formElements.get(i).getLabel());
                formElements.get(i).setSpinner(new Spinner(this));
                Spinner spinner = formElements.get(i).getSpinner();
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item
                        , formElements.get(i).getOptions());
                spinner.setAdapter(arrayAdapter);

                if (label.getParent() != null){
                    ((ViewGroup)label.getParent()).removeView(label);
                }

                linearLayout.addView(label);
                linearLayout.addView(spinner);


            }


        }

        final HashMap<String,String> data = new HashMap<>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyFormElement formElement;
                for (int i =0; i<formElements.size(); i++){
                    formElement = formElements.get(i);
                    if (formElement.getType().equals("et")){
                        data.put(formElement.getLabel(),formElement.getEditText().getText().toString());

                    }else {
                        data.put(formElement.getLabel(),formElement.getSpinner().getSelectedItem().toString());
                    }
                }
                Log.d(TAG, "onClick: "+ data.toString());
            }

        });





    }


}
