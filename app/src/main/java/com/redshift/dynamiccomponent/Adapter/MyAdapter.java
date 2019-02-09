package com.redshift.dynamiccomponent.Adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;
import com.redshift.dynamiccomponent.AppUtils;
import com.redshift.dynamiccomponent.Models.TestModel;
import com.redshift.dynamiccomponent.R;

import java.util.ArrayList;
import java.util.List;

class ViewHolder extends RecyclerView.ViewHolder{

    RelativeLayout button ;
    ExpandableLinearLayout expandableLayout;
    LinearLayout dl;

    public ViewHolder(View itemView) {
        super(itemView);

        button = itemView.findViewById(R.id.collapse_button);
        expandableLayout = itemView.findViewById(R.id.expandable_lay);
        dl = itemView.findViewById(R.id.dynamic_lay_main);
    }
}


public class MyAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<TestModel> items;
    Context context;
    boolean expandState = false;


    public MyAdapter(List<TestModel>items){
        this.items = items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_view_holder_one,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.setIsRecyclable(false);
        viewHolder.expandableLayout.setInRecyclerView(true);
        viewHolder.expandableLayout.setExpanded(false);
        for (int i =0; i<3;i++){
            TextView label = AppUtils.createLabel(context,"Name");
            EditText editText = AppUtils.createInput(context,"Enter name here");
            if (label.getParent() != null){
                ((ViewGroup)label.getParent()).removeView(label);
            }
            viewHolder.dl.addView(label);
            viewHolder.dl.addView(editText);
        }
        viewHolder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {

            @Override
            public void onPreOpen() {
                changeRotate(viewHolder.button,0f,180f).start();
                expandState = true;
            }

            @Override
            public void onPreClose() {
                changeRotate(viewHolder.button,180f,0f).start();
                expandState = false;

            }

        });
        viewHolder.button.setRotation(expandState ? 180f:0f);
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                viewHolder.expandableLayout.toggle();
            }
        });


    }

    private ObjectAnimator changeRotate(RelativeLayout button, float v, float v1) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(button,"rotation",v,v1);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
