package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{

    Paint pntTextPaint;     // Painting object to handle the paint jobs for graphics
    Paint pntGraphicsPaint; // Painting object to handle the paint jobs for text

    boolean blnShowText;
    int intTextPosition;

    public DrawingArea(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init()
    {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntGraphicsPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntGraphicsPaint.setColor(Color.BLACK);
        pntGraphicsPaint.setStrokeWidth(3);

    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.

        super.onSizeChanged(w, h, oldw, oldh);

    }

    protected void onDraw(Canvas canvas)
    {
        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.

        super.onDraw(canvas);

       /* canvas.drawCircle((float) 300.0, (float) 100.0, (float) 100.0, pntGraphicsPaint);
        canvas.drawRect((float) 275.0, (float) 550, (float) 350.0, (float) 100.0, pntGraphicsPaint);
        canvas.drawRect((float)100.0, (float)300.0, (float)550.0, (float)245.0, pntGraphicsPaint);
        canvas.drawRect((float)100.0, (float)300.0, (float)150.0, (float)125.0, pntGraphicsPaint);
        canvas.drawRect((float)500, (float)300.0, (float)550.0, (float)125.0, pntGraphicsPaint);
        canvas.drawCircle((float)200.0, (float)250.0, (float)40.0, pntGraphicsPaint);
        canvas.drawCircle((float)450.0, (float)250.0, (float)40.0, pntGraphicsPaint);


        for (int i = 0; i <= canvas.getHeight(); i++) {
            canvas.drawRect((float) 0, (float)i*100, (float) canvas.getWidth(), (float) i*100 + 25, pntGraphicsPaint);
            canvas.drawRect((float) i*100, (float) 0, (float) i*100 + 25, (float) canvas.getHeight(), pntGraphicsPaint);
        }
        */

        for (int i = 0; i <= canvas.getHeight(); i+=100) {
            for (int b = 0; b <= canvas.getHeight(); b++) {
                canvas.drawRect((float) i, (float) b*100, (float) i + 50, (float) b*100 + 50, pntGraphicsPaint);
            }
            for (int c = 0; c <= canvas.getHeight(); c++) {
                canvas.drawRect((float) i + 50, (float) c*100 + 50, (float) i + 100, (float) c*100 + 100, pntGraphicsPaint);
            }
        }






    }


}
