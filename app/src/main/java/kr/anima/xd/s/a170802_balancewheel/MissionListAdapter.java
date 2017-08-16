package kr.anima.xd.s.a170802_balancewheel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import kr.anima.xd.s.a170802_balancewheel.data.Data;

/**
 * Created by alfo6-10 on 8/9/2017.
 */

public class MissionListAdapter extends BaseAdapter implements View.OnClickListener{

//    ArrayList<Data> datas=new ArrayList<>();
    private ArrayList<String> datas=new ArrayList<>();
    private Context context;

    private TextView txt_title;
    private TextView txt_num_task;


    public MissionListAdapter(Context context) {
        this.context = context;
        addList();
    }

    public void addList(){
        datas.add("1");
        datas.add("2");
        datas.add("3");
        datas.add("4");
        datas.add("5");
        datas.add("6");
        datas.add("7");
        datas.add("8");
        datas.add("9");
        datas.add("10");
    }

    @Override
    public int getCount() {
        // TODO : 미션 갯수
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_for_mission_list, viewGroup, false);
            view.setOnClickListener(this);
            view.setLayoutParams(new AbsListView.LayoutParams(viewGroup.getWidth(), viewGroup.getHeight()/4));
        }

        txt_title=view.findViewById(R.id.txt_mission_title);
        txt_title.setText(datas.get(position));

        txt_num_task=view.findViewById(R.id.txt_num_task);
        txt_num_task.setText(datas.get(position));

        return view;
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(context, MissionDetailActivity.class);
        context.startActivity(intent);
    }
}
