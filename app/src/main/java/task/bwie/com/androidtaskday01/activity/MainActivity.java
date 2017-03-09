package task.bwie.com.androidtaskday01.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;
import java.util.List;
import task.bwie.com.androidtaskday01.R;
import task.bwie.com.androidtaskday01.adapter.MyAdapter;
import task.bwie.com.androidtaskday01.bean.Phone;
import task.bwie.com.androidtaskday01.utils.HttpUtils;

public class MainActivity extends AppCompatActivity implements  PullToRefreshExpandableListView.OnRefreshListener2<ExpandableListView>,HttpUtils.HttpConnect{
    public  String  url="https://mock.eolinker.com/success/rq7m6GNqurs93zYkEANkY8Z4358Aihf1";
    private  List<Phone.DataBean> dataBeanList;
    private PullToRefreshExpandableListView pull;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        HttpUtils.getUrlConnect(url,this);
        pull = (PullToRefreshExpandableListView) findViewById(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu:
                Toast.makeText(this, "Menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.my:
                Toast.makeText(this, "My", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void getConnect(String result) {
        Phone phone = new Gson().fromJson(result, Phone.class);
        dataBeanList = phone.getData();
        adapter = new MyAdapter(dataBeanList,this);
        pull.getRefreshableView().setAdapter(adapter);
    }
    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
       adapter.notifyDataSetChanged();
    }
    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {

    }
}
