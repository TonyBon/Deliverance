package ru.bonsystems.deliverance.BanterEngine;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.SurfaceHolder;
import android.widget.LinearLayout;

import ru.bonsystems.deliverance.BanterEngine.data.system.Display;
import ru.bonsystems.deliverance.BanterEngine.performers.renderers.DialogRenderer;
import ru.bonsystems.deliverance.BanterEngine.performers.renderers.GameRenderer;
import ru.bonsystems.deliverance.BanterEngine.performers.renderers.MenuRenderer;
import ru.bonsystems.deliverance.BanterEngine.performers.renderers.RenderManager;
import ru.bonsystems.deliverance.BanterEngine.performers.threads.ThreadManager;
import ru.bonsystems.deliverance.BanterEngine.stuff.BESurface;
import ru.bonsystems.deliverance.BanterEngine.templates.Dialog;
import ru.bonsystems.deliverance.BanterEngine.templates.GeneralActivity;
import ru.bonsystems.deliverance.BanterEngine.templates.Menu;
import ru.bonsystems.deliverance.BanterEngine.templates.SimpleGame;
import ru.bonsystems.deliverance.R;

/**
 * Created by TonyBon on 15.05.2015.
 */
public class BanterEngine{
    private static BanterEngine ourInstance = new BanterEngine();
    private SurfaceHolder surfaceHolder;
    private GeneralActivity activity;

    public static BanterEngine getInstance() {
        return ourInstance;
    }

    /*
    * ���������� ���������� ����������� �������������
    * ��� ���������� ����� �������������� ����� ������������������ get � set
    * Game - ��������� ����� ����
    * Menu - �������� ������ ����
    * Dialog - ��������� ������ ����������� ���� (�������� � �.�.)
    **/
    private SimpleGame game;
    private Menu menu;
    private Dialog dialog;


    /*
    * "���������" �������
    * ��������� �� ��� ����� ���������� � �������� ������������ ������������� ���� ������
    * ������ ������ �� ������������ ������
    **/
    private Display display;
    private RenderManager renderManager;
    private GameRenderer gameRenderer;
    private MenuRenderer menuRenderer;
    private DialogRenderer dialogRenderer;
    private ThreadManager threadManager;


    private BanterEngine() {
        super();
    }


    private boolean alreadyInitialized = false;
    public void init(GeneralActivity activity){
        if (!alreadyInitialized) {
            this.activity = activity;
            createSurfaceView();
            loadResources();
        } else {
            System.out.println("�� ��� ���������������� ������� �������");
        }
    }

    public void run(){

    }

    /*
    * ������������ ����� ������������ ����
    **/

    private void createSurfaceView() {
        Activity tmp = (Activity) activity;
        BESurface surface = new BESurface(activity.getApplicationContext());
        LinearLayout linearLayout = (LinearLayout) tmp.findViewById(R.id.be_general_layout);
        linearLayout.addView(surface);
    }

    private void loadResources() {
        if (loadingListener != null) loadingListener.OnEngineStartLoading();
        LoadResourcesTask resourcesTask = new LoadResourcesTask();
        resourcesTask.execute();
    }


    /*
    * ������ ������� � �������
    **/
    synchronized public RenderManager getRenderManager(){
        return renderManager;
    }

    synchronized public GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    synchronized public MenuRenderer getMenuRenderer() {
        return menuRenderer;
    }

    synchronized public DialogRenderer getDialogRenderer() {
        return dialogRenderer;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public SurfaceHolder getSurfaceHolder() {
        return surfaceHolder;
    }

    public ThreadManager getThreadManager() {
        return threadManager;
    }


    /*
    * ����������� ������ �������� ��� �������� ���� ��������� � ������ �������-������������,
    * ������� ����� ����������������
    **/
    class LoadResourcesTask extends AsyncTask<Void, Void, LoadedResources>{

        @Override
        protected LoadedResources doInBackground(Void... params) {
            LoadedResources resources = new LoadedResources();
            resources.display = new Display(activity.getDefaultDisplay());
            resources.renderManager = new RenderManager(display);
            resources.gameRenderer = new GameRenderer();
            resources.menuRenderer = new MenuRenderer();
            resources.dialogRenderer = new DialogRenderer();
            resources.threadManager = new ThreadManager();
            return resources;
        }

        @Override
        protected void onPostExecute(LoadedResources loadedResources) {
            super.onPostExecute(loadedResources);
            display = loadedResources.display;
            renderManager = loadedResources.renderManager;
            gameRenderer = loadedResources.gameRenderer;
            menuRenderer = loadedResources.menuRenderer;
            dialogRenderer = loadedResources.dialogRenderer;
            threadManager = loadedResources.threadManager;

            if (loadingListener != null) loadingListener.OnEngineEndLoading();
            alreadyInitialized = true;
        }
    }


    /*
    * ��� ��, ��� ����� ���������� ����� ������ �������� ������
    **/
    class LoadedResources {
        public Display display;
        public RenderManager renderManager;
        public GameRenderer gameRenderer;
        public MenuRenderer menuRenderer;
        public DialogRenderer dialogRenderer;
        public ThreadManager threadManager;
    }


    /*
    * ��� ����� ������� ������� ��������� ��������
    **/
    interface EngineLoadingListener {
        public void OnEngineStartLoading();
        public void OnEngineEndLoading();
    }

    private EngineLoadingListener loadingListener;

    public void setLoadingListener(EngineLoadingListener loadingListener){
        this.loadingListener = loadingListener;
    }
}
