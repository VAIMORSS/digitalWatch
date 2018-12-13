package com.map524s1a.digitalclock;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.Calendar;
import java.util.Date;

import static android.graphics.Color.rgb;


public class ClockView extends View {

    int date, month, year, hour, minute, second;
    String amOrPm="AM";

    Paint minutePaint = new Paint();
    Paint hourPaint = new Paint();
    Paint secondPaint = new Paint();
    Paint digitalClockPaint = new Paint();
    Paint fullRing = new Paint();



    Paint text = new Paint();

    int centarPoint=750;
    int radiusForSecond=500, radiusForMinute=400,radiusForHour=300,textRadius=600, digitalClockPlace=180, fullRingRad=550;
    Calendar currentTime;



    RectF hourRectF;
    RectF minuteRectF;
    RectF secondRectF;
    RectF fullRingF;

    public ClockView(Context context){
        super(context);
        this.date=0;
        this.hour=0;
        this.month=0;
        this.year=0;
        this.minute=0;
        this.second=0;

        hourPaint.setStyle(Paint.Style.STROKE);
        hourPaint.setStrokeWidth(20);
        hourPaint.setColor(Color.MAGENTA);

        minutePaint.setColor(Color.GREEN);
        minutePaint.setStyle(Paint.Style.STROKE);
        minutePaint.setStrokeWidth(20);

        secondPaint.setColor(Color.RED);
        secondPaint.setStyle(Paint.Style.STROKE);
        secondPaint.setStrokeWidth(20);

        fullRing.setColor(Color.GRAY);
        fullRing.setStyle(Paint.Style.STROKE);
        fullRing.setStrokeWidth(10);

        text.setColor(Color.BLACK);
        text.setTextSize(150);

        digitalClockPaint.setTextSize(65);



        hourRectF = new RectF(centarPoint-radiusForHour, centarPoint-radiusForHour, centarPoint+radiusForHour, centarPoint+radiusForHour);
        minuteRectF = new RectF(centarPoint-radiusForMinute, centarPoint-radiusForMinute, centarPoint+radiusForMinute, centarPoint+radiusForMinute);
        secondRectF =  new RectF(centarPoint-radiusForSecond, centarPoint-radiusForSecond, centarPoint+radiusForSecond, centarPoint+radiusForSecond);
        fullRingF =  new RectF(centarPoint-fullRingRad, centarPoint-fullRingRad, centarPoint+fullRingRad, centarPoint+fullRingRad);


    }

    public void timeSetter(){

        currentTime=Calendar.getInstance();
        minute=currentTime.get(Calendar.MINUTE);
        hour=currentTime.get(Calendar.HOUR);
        second=currentTime.get(Calendar.SECOND);
        month=currentTime.get(Calendar.MONTH);
        date=currentTime.get(Calendar.DATE);
        year=currentTime.get(Calendar.YEAR);
        if(currentTime.get(Calendar.AM_PM)==Calendar.PM){
            amOrPm="PM";
        }
        digitalClockPaint.setColor(rgb(128,(second*4)%128,0+((second*3)%128)));


    }

    @Override
    public void onDraw(Canvas canvas){



        canvas.drawArc (hourRectF, 270, (hour+(minute/60))*30, false, hourPaint);
        canvas.drawArc (minuteRectF, 270, (minute+(second/60))*6, false, minutePaint);
        canvas.drawArc (secondRectF, 270, second*6, false, secondPaint);
        canvas.drawArc (fullRingF, 0, 360, false, fullRing);


        canvas.drawText("12", centarPoint-70, textRadius-radiusForSecond+70, text);
        canvas.drawText("3", centarPoint+textRadius-40, centarPoint+70, text);
        canvas.drawText("9", centarPoint-textRadius-40, centarPoint+70, text);
        canvas.drawText("6", centarPoint, textRadius+centarPoint+70, text);

        canvas.drawText( String.format("%02d",hour)+" : "+String.format("%02d",minute)+" : "+String.format("%02d",second)+" "+amOrPm,centarPoint-digitalClockPlace,centarPoint,digitalClockPaint);
        canvas.drawText( "DATE : "+String.format("%02d",date) +"/"+String.format("%02d",month)+"/"+year,centarPoint-digitalClockPlace-70,centarPoint+800,digitalClockPaint);




        //canvas.DrawLine(cx, cy, x, y, paint);

        //canvas.drawText(String.valueOf(hour),100,100,color);
        //canvas.drawText(String.valueOf(minute),100,300,color);
        //canvas.drawText(String.valueOf(second),100,800,color);
    }







}
