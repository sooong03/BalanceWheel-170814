package kr.anima.xd.s.a170802_balancewheel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alfo6-10 on 8/7/2017.
 */

public class SettingListAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> arrayList;

    private final int VIEW_TYPE_HEADLINE = 0;
    private final int VIEW_TYPE_SWITCH=1;
    private final int VIEW_TYPE_ETC=2;

    public SettingListAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList=arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) return VIEW_TYPE_HEADLINE;
        else return VIEW_TYPE_SWITCH;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                view= LayoutInflater.from(context).inflate(R.layout.setting_headline, parent, false);
                HeadlineViewHolder headHolder=new HeadlineViewHolder(view);
                return headHolder;
            case 1:
                view=LayoutInflater.from(context).inflate(R.layout.setting_switch, parent, false);
                ViewHolder holder=new ViewHolder(view);
                return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(position==0){ //headline
            ((HeadlineViewHolder)holder).txt_set_title.setText(arrayList.get(position));
        } else {
            ((ViewHolder)holder).txt.setText(arrayList.get(position));
        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class HeadlineViewHolder extends RecyclerView.ViewHolder{
        TextView txt_set_title;
        public HeadlineViewHolder(View itemView) {
            super(itemView);
            txt_set_title=itemView.findViewById(R.id.txt_set_title);
        }
    } // class Headline View Holder

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt;
        Switch aSwitch;
        public ViewHolder(View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
            aSwitch=itemView.findViewById(R.id.btn_switch);
        }
    } // class list ViewHolder

} // class Setting List Adapter
