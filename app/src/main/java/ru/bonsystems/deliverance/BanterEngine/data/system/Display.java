package ru.bonsystems.deliverance.BanterEngine.data.system;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceView;

/**
 * Created by vnutr on 15.05.2015.
 */
public class Display {
    private int width;
    private int height;
    private float scaleByWidth;
    private float scaleByHeight;

    /*
    * Получаем размеры экрана
    **/
    public Display(android.view.Display display) {
        Rect size = new Rect();
        display.getRectSize(size);
        width = size.width();
        height = size.height();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getScaleByWidth() {
        return scaleByWidth;
    }

    public float getScaleByHeight() {
        return scaleByHeight;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setScaleByWidth(float scaleByWidth) {
        this.scaleByWidth = scaleByWidth;
    }

    public void setScaleByHeight(float scaleByHeight) {
        this.scaleByHeight = scaleByHeight;
    }

}
