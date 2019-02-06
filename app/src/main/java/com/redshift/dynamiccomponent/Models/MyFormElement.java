package com.redshift.dynamiccomponent.Models;

import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MyFormElement {
    String type;
    String label;
    ArrayList<String> options;
    EditText editText;
    Spinner spinner;

    public MyFormElement(String type, String label) {
        this.type = type;
        this.label = label;


    }

    public MyFormElement(String type, String label, ArrayList<String> options) {
        this.type = type;
        this.label = label;
        this.options = options;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }
}
