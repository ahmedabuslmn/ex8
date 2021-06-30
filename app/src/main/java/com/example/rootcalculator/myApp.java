package com.example.rootcalculator;
import android.app.Application;
public class myApp extends Application {
    private  static  myApp app ;
    RootDataBase dp ;
    @Override
    public void onCreate() {
        super.onCreate();
        dp = new RootDataBase(this) ;
        app = this;

    }
    public  static myApp getApp()
    {
        return app ;
    }

    public RootDataBase getDp() {
        return dp;
    }
}
