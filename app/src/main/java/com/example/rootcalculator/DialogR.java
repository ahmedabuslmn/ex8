package com.example.rootcalculator;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class DialogR extends AppCompatDialogFragment  {
    private EditText number ;
    private DialogListener dialogListener ;
    RootDataBase rdp ;
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder buildre =  new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater() ;
        View view = inflater.inflate(R.layout.layout_dialog,null) ;
        buildre.setView(view).setTitle("root calculater").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String numberToCal = number.getText().toString() ;
                dialogListener.applayDialog(numberToCal);
                RootCalculater newR = new RootCalculater(Integer.parseInt(numberToCal));
                rdp =myApp.getApp().getDp()  ;
                rdp.addToDp(newR);
                WorkManager workManager = WorkManager.getInstance(myApp.getApp());
                Data.Builder data = new Data.Builder();
                data.putString("key", numberToCal);
                data.putString("id", newR.getId());
                OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MainCalculating.class).
                        setInputData(data.build()).addTag(newR.getId()).build();
                workManager.enqueue(request);
            }
        });
        number = view.findViewById(R.id.addroot) ;
        return  buildre.create() ;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            dialogListener = (DialogListener) context ;
        } catch (ClassCastException  e) {
            throw  new  ClassCastException(context.toString()+ "must implemnt DialogListner ");
        }
    }

    public  interface  DialogListener
    {
        void applayDialog(String number);
    }



}



