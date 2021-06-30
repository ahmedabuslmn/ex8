package com.example.rootcalculator;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RootHolder extends RecyclerView.ViewHolder {

   ImageView x;
   ImageView trash ;
   TextView stauts ;
   ProgressBar pB ;
    public RootHolder(View view)
    {
        super(view) ;
        x= view.findViewById(R.id.x) ;
        trash= view.findViewById(R.id.trash) ;
        stauts=view.findViewById(R.id.pro);
        pB = view.findViewById(R.id.pBar) ;
    }
}
