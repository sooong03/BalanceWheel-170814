package kr.anima.xd.s.a170802_balancewheel;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

/**
 * Created by alfo6-10 on 8/14/2017.
 */

public class DashboardListAdapter extends RecyclerView.Adapter {

//    public final int VIEW_TYPE_STATE_EMOTION = 21; // item_dash_state
//    public final int VIEW_TYPE_STATE_BODY = 22;
//    public final int VIEW_TYPE_TASK_PREVIOUS = 0; // item_dash_card
//    public final int VIEW_TYPE_TASK_CURRENT = 1;
//    public final int VIEW_TYPE_TASK_NEXT = 2;
//    public final int VIEW_TYPE_WEATHER = 3; // item_dash_weather

    public final int VIEW_TYPE_TASK=0;
    public final int VIEW_TYPE_STATE=1;
    public final int VIEW_TYPE_ETC=2;

    private ArrayList<Item> items=new ArrayList<>();

    private Context context;


    public DashboardListAdapter(Context context) {

        this.context = context;
        setList();
    }

    public void setList(){
        // TODO : itemName => string.xml
        items.add(new Item(Item.ITEM_TYPE_TASK, Item.ITEM_NAME_PREV, true));
        items.add(new Item(Item.ITEM_TYPE_TASK, Item.ITEM_NAME_CURRENT, true));
        items.add(new Item(Item.ITEM_TYPE_TASK, Item.ITEM_NAME_NEXT, true));

        items.add(new Item(Item.ITEM_TYPE_STATE, Item.ITEM_NAME_EMOTIONAL, true));
        items.add(new Item(Item.ITEM_TYPE_STATE, Item.ITEM_NAME_BODY, true));

        items.add(new Item(Item.ITEM_TYPE_ETC, Item.ITEM_NAME_WEATHER, true));
    }

    @Override
    public int getItemViewType(int position) {
        if(items.get(position).itemType==VIEW_TYPE_TASK) return VIEW_TYPE_TASK;
        else if(items.get(position).itemType==VIEW_TYPE_STATE) return VIEW_TYPE_STATE;
        else return VIEW_TYPE_ETC;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=null;
        ViewHolder holder=null;

        // TODO : switch ? if-else?
        switch (viewType){
            case VIEW_TYPE_TASK: // task list
                view=LayoutInflater.from(context).inflate(R.layout.item_dash_task, parent, false);
                holder=new ViewHolder(view);
                return holder;
            case VIEW_TYPE_STATE: // emotional, body state list
                view=LayoutInflater.from(context).inflate(R.layout.item_dash_state, parent, false);
                // TODO : items equals string
                holder=new ViewHolder(view);
                return holder;
            case VIEW_TYPE_ETC:
                view=LayoutInflater.from(context).inflate(R.layout.item_dash_weather, parent, false);
                holder=new ViewHolder(view);
                return holder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView img_state;

        public ViewHolder(View itemView) {
            super(itemView);
            img_state=itemView.findViewById(R.id.img_state);
            img_state.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            // TODO : select state icon

        }
    } // class ViewHolder




    class Item{

        public static final int ITEM_TYPE_TASK=0;
        public static final int ITEM_TYPE_STATE=1;
        public static final int ITEM_TYPE_ETC =2;

        public static final int ITEM_NAME_PREV=11;
        public static final int ITEM_NAME_CURRENT=12;
        public static final int ITEM_NAME_NEXT=13;

        public static final int ITEM_NAME_EMOTIONAL=21;
        public static final int ITEM_NAME_BODY=22;

        public static final int ITEM_NAME_WEATHER=31;

        int itemType;
        int itemName;
        Boolean isSet=true;
        ArrayList<StateList> list;

        public Item(int itemType, int itemName, Boolean isSet) {
            this.itemType = itemType; // ==ViewType
            this.itemName = itemName;
            this.isSet = isSet;
            switch (itemType){
                case ITEM_TYPE_TASK:
                    break;
                case ITEM_TYPE_STATE:
                    list=new ArrayList<>();

                    switch (itemName){
                        case ITEM_NAME_EMOTIONAL:
                            list.add(new StateList("good", R.drawable.ic_emotion_dissatisfied));
                            list.add(new StateList("good", R.drawable.ic_emotion_neutral));
                            list.add(new StateList("good", R.drawable.ic_emotion_very_satisfied));
                            break;
                        case ITEM_NAME_BODY:
                            list.add(new StateList("state", R.drawable.ic_body_run));
                            list.add(new StateList("state", R.drawable.ic_body_accessible));
                            list.add(new StateList("state", R.drawable.ic_body_walk));
                            list.add(new StateList("state", R.drawable.ic_body_pool));
                            break;
                    }
                    break;
                case ITEM_TYPE_ETC:
                    break;
            }
        }

        class StateList{
            String state;
            int imgId;
            Boolean isSelect=false;

            public StateList(String state, int imgId) {
                this.state = state;
                this.imgId = imgId;
            }
        }

    } // class Item

} // class Dashboard List Adapter
