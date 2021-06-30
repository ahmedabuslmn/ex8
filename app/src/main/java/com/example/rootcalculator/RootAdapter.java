package com.example.rootcalculator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class RootAdapter extends RecyclerView.Adapter<RootHolder> {
    @NonNull
    @Override
    public RootHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.calculating, parent, false);
        return new RootHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RootHolder holder, int position) {
       RootCalculater v = myApp.getApp().getDp().rdb.get(position);
       holder.stauts.setText(v.getStatus());
       holder.x.setVisibility(View.GONE);
       holder.trash.setVisibility(View.VISIBLE);
       holder.pB.setMax(v.number);
       holder.pB.setProgress(v.proBar);
       holder.trash.setOnClickListener( r->
       {
        myApp.getApp().getDp().deletFromDb(v.id);
       });

    }
    @Override
    public int getItemCount() {
        return myApp.getApp().getDp().rdb.size();

    }

}
