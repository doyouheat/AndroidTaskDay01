package task.bwie.com.androidtaskday01.utils;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 1. 类的用途
 * 2. @author : do  you  heat
 * 3. @date 2017/3/8 18:59
 */
public class HttpUtils {

    public  static  void  getUrlConnect(String  url, final HttpConnect   connect){

        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                connect.getConnect(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

   public  interface   HttpConnect{
        public  void   getConnect(String  result);
    }
}
