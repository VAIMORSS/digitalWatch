package com.map524s1a.digitalclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.Calendar;
import java.util.Date;


public class ClockView extends View {

    int date, month, year, hour, minute, second;
    Paint minutePaint = new Paint();
    Paint hourPaint = new Paint();
    Paint secondPaint = new Paint();

    Paint text = new Paint();

    int centarPoint=750;
    int radiusForSecond=450, radiusForMinute=350,radiusForHour=250,textRadius=550;
    Date currentTime;



    RectF hourRectF;
    RectF minuteRectF;
    RectF secondRectF;

    public ClockView(Context context){
        super(context);
        this.date=0;
        this.hour=0;
        this.month=0;
        this.year=0;
        this.minute=0;
        this.second=0;

        hourPaint.setColor(Color.MAGENTA);
        hourPaint.setStyle(Paint.Style.STROKE);
        hourPaint.setStrokeWidth(20);

        minutePaint.setColor(Color.GREEN);
        minutePaint.setStyle(Paint.Style.STROKE);
        minutePaint.setStrokeWidth(20);

        secondPaint.setColor(Color.RED);
        secondPaint.setStyle(Paint.Style.STROKE);
        secondPaint.setStrokeWidth(20);

        text.setColor(Color.BLACK);
        text.setTextSize(150);




        hourRectF = new RectF(centarPoint-radiusForHour, centarPoint-radiusForHour, centarPoint+radiusForHour, centarPoint+radiusForHour);
        minuteRectF = new RectF(centarPoint-radiusForMinute, centarPoint-radiusForMinute, centarPoint+radiusForMinute, centarPoint+radiusForMinute);
        secondRectF =  new RectF(centarPoint-radiusForSecond, centarPoint-radiusForSecond, centarPoint+radiusForSecond, centarPoint+radiusForSecond);
    }

    public void timeSetter(){
        currentTime = new Date();
        currentTime=Calendar.getInstance().getTime();
        minute=currentTime.getMinutes();
        hour=currentTime.getHours();
        if(hour>12){
            hour-=12;
        }
        second=currentTime.getSeconds();

    }

    @Override
    public void onDraw(Canvas canvas){



        canvas.drawArc (hourRectF, 270, (hour+(minute/60))*30, false, hourPaint);
        canvas.drawArc (minuteRectF, 270, (minute+(second/60))*6, false, minutePaint);
        canvas.drawArc (secondRectF, 270, second*6, false, secondPaint);

        canvas.drawText("12", centarPoint-70, textRadius-radiusForSecond+70, text);
        canvas.drawText("3", centarPoint+textRadius-40, centarPoint+70, text);
        canvas.drawText("9", centarPoint-textRadius-40, centarPoint+70, text);
        canvas.drawText("6", centarPoint, textRadius+centarPoint+70, text);


        //canvas.drawText(String.valueOf(hour),100,100,color);
        //canvas.drawText(String.valueOf(minute),100,300,color);
        //canvas.drawText(String.valueOf(second),100,800,color);
    }







}
