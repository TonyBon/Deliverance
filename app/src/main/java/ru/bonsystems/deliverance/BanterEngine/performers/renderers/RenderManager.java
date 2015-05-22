package ru.bonsystems.deliverance.BanterEngine.performers.renderers;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import ru.bonsystems.deliverance.BanterEngine.data.system.Display;

/**
 * Created by vnutr on 15.05.2015.
 */
public class RenderManager {
    private Display display;

    public RenderManager(Display display){
        this.display = display;
        initBufferFrames();
    }


    /*
    * Инициализация буферных изображений для плавной отрисовки
    **/
    private Bitmap bufferBitmap;
    private Canvas bufferCanvas;
    private Bitmap finalBitmap;
    private Canvas finalCanvas;
    private void initBufferFrames() {
        bufferBitmap = Bitmap.createBitmap(display.getWidth(), display.getHeight(), Bitmap.Config.RGB_565);
        bufferCanvas = new Canvas(bufferBitmap);
        finalBitmap = Bitmap.createBitmap(display.getWidth(), display.getHeight(), Bitmap.Config.RGB_565);
        finalCanvas = new Canvas(finalBitmap);
    }


    /*
    * Отрисовка кадров
    **/
    public void render(){

    }

}
