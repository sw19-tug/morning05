package com.example.sw19_morning05;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

public class TTBRectPlayer implements TTBGameObject
{
    private Rect moving_block;
    private int color;

    public TTBRectPlayer(Rect moving_block, int color)
    {
        this.moving_block = moving_block;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(moving_block, paint);
    }

    @Override
    public void update() {

    }

    public void update(Point point)
    {
        moving_block.set(point.x, point.y, point.x + moving_block.width(),
                point.y + moving_block.height());
    }
}
