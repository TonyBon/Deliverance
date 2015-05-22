package ru.bonsystems.deliverance.BanterEngine.stuff;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import ru.bonsystems.deliverance.BanterEngine.BanterEngine;

/**
 * Created by vnutr on 16.05.2015.
 */
public class BESurface extends SurfaceView implements SurfaceHolder.Callback {

    public BESurface(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        BanterEngine.getInstance().setSurfaceHolder(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
