package ru.bonsystems.deliverance.BanterEngine.templates;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.Display;

/**
 * Created by vnutr on 15.05.2015.
 */
public interface GeneralActivity {
    public AssetManager getAssets();
    public Resources getResources();
    public Display getDefaultDisplay();
    public Context getApplicationContext();
}
