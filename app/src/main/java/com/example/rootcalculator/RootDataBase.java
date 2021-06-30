package com.example.rootcalculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class RootDataBase {
    ArrayList<RootCalculater> rdb = new ArrayList<>();
    Context context;
    SharedPreferences sp;

    RootDataBase(Context c) {
        this.context = c;
        this.sp = context.getSharedPreferences("roots_dp", Context.MODE_PRIVATE);
        rdb.clear();
        Set<String> k =  sp.getAll().keySet();
        for(String v:k)
        {
            RootCalculater newR= new RootCalculater(0);
            String rcStrig = sp.getString(v,null);
            if(rcStrig !=null){
            newR.setRootCalculater(rcStrig);
            rdb.add(newR);
            }
        }

    }


    public void addToDp(RootCalculater r){
            rdb.add(r);
        SharedPreferences.Editor e = sp.edit();

        e.putString(r.getId(), r.rootCalToString());
        e.apply();
        BroadcastDbChanged();
        }


// send broadCast
    public void BroadcastDbChanged() {
        Intent bc = new Intent("dp_has_changed");
        context.sendBroadcast(bc);
    }


    public void setStatus(String id, String s) {
        for(RootCalculater r:rdb)
        {
            if(r.getId().equals(id) )
            {
                r.setStatus(s);
                SharedPreferences.Editor e = sp.edit();
                e.putString(r.getId(), r.rootCalToString());
                e.apply();
                BroadcastDbChanged();
            }
        }

    }
    public void deletFromDb(String id)
    {
        for(RootCalculater r:rdb)
        {
            if(r.getId().equals(id) )
            {
                rdb.remove(r);
                SharedPreferences.Editor e = sp.edit();
                e.remove(r.getId());
                e.apply();
                BroadcastDbChanged();
            }
        }


    }
    public void setBar(String id, int i) {
        for(RootCalculater r:rdb)
        {
            if(r.getId().equals(id) )
            {
                r.setBar(i);
                SharedPreferences.Editor e = sp.edit();
                e.putString(r.getId(), r.rootCalToString());
                e.apply();
                BroadcastDbChanged();
            }
        }
    }
}