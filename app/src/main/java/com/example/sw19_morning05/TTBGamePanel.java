package com.example.sw19_morning05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TTBGamePanel extends SurfaceView implements SurfaceHolder.Callback
{
    private TTBMainThread thread;
    private TTBRectPlayer player; //player is the spawned rectangle
    private Point playerPoint;    //point where the rectangle spawns

    public TTBGamePanel(Context context)
    {
        super(context);
        getHolder().addCallback(this);

        thread = new TTBMainThread(getHolder(), this);

        player = new TTBRectPlayer(new Rect(0, 0, 300, 300), Color.rgb(50, 50, 255));
        playerPoint = new Point(500, 900);
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        thread = new TTBMainThread(getHolder(), this);

        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        boolean retry = true;
        while (true) {
            try {
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            //the action, where the app gets the finger position
            case MotionEvent.ACTION_MOVE:
                playerPoint.set((int)event.getX(), (int)event.getY());
        }

        return true;
        //return super.onTouchEvent(event);
    }

    public void update()
    {
        player.update(playerPoint);
    }


    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        //sets the canvas to white
        canvas.drawColor(Color.WHITE);

        player.draw(canvas);
    }
}

