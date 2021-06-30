package com.example.rootcalculator;
import java.util.UUID;
public class RootCalculater {
     int number ;
     String id ;
     String Status  ;
     int proBar ;
    public RootCalculater(int num )
    {
        this.number = num ;
        this.Status="calculating root for number: " +num ;
        this.id = UUID.randomUUID().toString() ;
        this.proBar=0;
    }
    public  void setStatus(String str)
    {
        this.Status = str ;
    }

    public  void setRootCalculater(String root)
    {
        String[] arrOfStr = root.split("#");
        this.number = Integer.parseInt(arrOfStr[0]) ;
        this.id = arrOfStr[1];
        this.Status = arrOfStr[2];
        this.proBar =Integer.parseInt(arrOfStr[3]);
    }
    public String rootCalToString()
    {
        return this.number +"#"+this.id+"#"+this.Status+"#"+this.proBar ;
    }

    public String getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public String getStatus() {
        return this.Status;
    }

    public void setBar(int i) {
            this.proBar = i ;
    }
}
