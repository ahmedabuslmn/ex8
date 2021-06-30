package com.example.rootcalculator;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.ArrayList;

public class MainCalculating extends Worker {
    public MainCalculating(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        String key = getInputData().getString("key");
        String id = getInputData().getString("id");
        RootDataBase rdb = myApp.getApp().getDp();
        if(key == null)
        {
            return Result.failure() ;
        }
        int k = Integer.parseInt(key) ;
        int[] a = {0,0} ;
        for (int i = 2; i < k/2; i++) {
            if (k % i == 0) {
                a[0]=i;
                a[1]=k/i ;
                break;
            }
            if (i % 1000000 == 0) {
                rdb.setBar(id, i);
            }
        }
        rdb.setBar(id, (int) k);

        if (a[0]!= 0 ) {
            rdb.setStatus(id, "Roots for "+ k+" : = " +a[0] + "*" + a[1]);
        } else {
            rdb.setStatus(id, k + " :  is prime");

        }
        return Result.success();
    }
}
