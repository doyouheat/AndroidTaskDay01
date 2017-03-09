package task.bwie.com.androidtaskday01.application;

import android.app.Application;

import org.xutils.x;

/**
 * 1. 类的用途
 * 2. @author : do  you  heat
 * 3. @date 2017/3/8 18:59
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
