package task.bwie.com.androidtaskday01.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import java.util.List;
import task.bwie.com.androidtaskday01.R;
import task.bwie.com.androidtaskday01.bean.Phone;
/**
 * 1. 类的用途
 * 2. @author : do  you  heat
 * 3. @date 2017/3/8 18:57
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private List<Phone.DataBean> list;

    private Context  context;

    public MyAdapter(List<Phone.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return  list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return   list.get(groupPosition).getDatas().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return  list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getDatas().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return  childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return   true;
    }

  @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
 Phone.DataBean dataBean = list.get(groupPosition);
        ViewHolder  v;
        if (convertView==null)
        {
            v=new ViewHolder();
            convertView=View.inflate(context, R.layout.iteamlayout,null);
            v.name= (TextView) convertView.findViewById(R.id.name);
            v.phone_id= (TextView) convertView.findViewById(R.id.phone_id);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();
        }
        v.name.setText(dataBean.getTitle());
        v.phone_id.setText(dataBean.getTitle_id());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder  v;
        if (convertView==null)
        {
            v=new ViewHolder();
            convertView=View.inflate(context, R.layout.childlayout,null);
            v.cname= (TextView) convertView.findViewById(R.id.cname);
            v.msg= (TextView) convertView.findViewById(R.id.msg);
            v.price= (TextView) convertView.findViewById(R.id.price);
            v.time= (TextView) convertView.findViewById(R.id.time);
            convertView.setTag(v);
        }else {
            v= (ViewHolder) convertView.getTag();

        }
        v.cname.setText(list.get(groupPosition).getDatas().get(childPosition).getType_name());
        v.msg.setText(list.get(groupPosition).getDatas().get(childPosition).getMsg());
        v.price.setText(list.get(groupPosition).getDatas().get(childPosition).getPrice()+".00$");
        v.time.setText(list.get(groupPosition).getDatas().get(childPosition).getAdd_time());
        return convertView;
    }

    class   ViewHolder{
        TextView name,phone_id,msg,price,time,cname;
    }
}
