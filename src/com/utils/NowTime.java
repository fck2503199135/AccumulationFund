package com.utils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime {

    public static void ATime(){

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String cdate = simpleDateFormat.format(date);

    }



}
