package com.example.sw19_morning05;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class TTBRectPlayer implements TTBGameObject
{
    private Rect rectangle;
    private int color;

    public TTBRectPlayer(Rect rectangle, int color)
    {
        this.rectangle = rectangle;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
    }

    @Override
    public void update() {

    }

    public void update(Point point)
    {
        rectangle.set(point.x, point.y, point.x + rectangle.width(), point.y + rectangle.height());
    }
}
