package kr.anima.xd.s.a170802_balancewheel;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.anima.xd.s.a170802_balancewheel.data.SharedList;

/**
 * Created by alfo6-10 on 8/4/2017.
 */

public class ShareListAdapter extends RecyclerView.Adapter <ShareListAdapter.ViewHolder>{

    Context context;
    ArrayList<SharedList> lists=new ArrayList<>();
    // TODO : add cardView background color arrayList

    public ShareListAdapter(Context context) {
        this.context = context;
        lists.add(new SharedList("title", "sub", "txttxttxttxttxttxttxttxttxttxttxttxttxttxttxt", false, null));
        lists.add(new SharedList("title", "sub", "txt", false, null));
        lists.add(new SharedList("title", "sub", "txt", false, null));
        lists.add(new SharedList("title", "sub", "txt", false, null));

    }

    @Override
    public ShareListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.share_shared_list, parent, false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ShareListAdapter.ViewHolder holder, int position) {
        holder.title.setText(lists.get(position).title);
        holder.title_sub.setText(lists.get(position).title_sub);
        if(lists.get(position).hasImg) {
            // TODO : IMAGE set
        }
        holder.txt.setText(lists.get(position).txt);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView title_sub;
        private ImageView img;
        private TextView txt;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(listener);
            title=itemView.findViewById(R.id.txt_title);
            title_sub=itemView.findViewById(R.id.txt_subtitle);
            img=itemView.findViewById(R.id.img);
            txt=itemView.findViewById(R.id.txt);
        }

        private View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, SharedItemActivity.class);
                // TODO : add data of lists in position
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions.makeSceneTransitionAnimation((Activity) context, new Pair<View, String>(itemView, "itemView"));
                    context.startActivity(intent);
                } else context.startActivity(intent);
            }
        };

    }


}
