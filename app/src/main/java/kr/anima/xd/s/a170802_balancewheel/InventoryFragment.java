package kr.anima.xd.s.a170802_balancewheel;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InventoryFragment extends Fragment implements View.OnClickListener{

    private Context context;

    private ListView listView;
    private MissionListAdapter adapter;
    private LinearLayout btn_level;
    private LinearLayout btn_storage;
    private LinearLayout btn_event;
    private CardView view_total;
    private CardView view_tracker_open;
    private CardView view_tracker_all;

    public InventoryFragment(Context context) {
        // Required empty public constructor
        adapter=new MissionListAdapter(context);
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_inventory, container, false);
        findId(view);


        return view;
    }

    public void findId(View v){
        listView=v.findViewById(R.id.list_mission);
        listView.setAdapter(adapter);

        btn_level=v.findViewById(R.id.btn_level);
        btn_storage=v.findViewById(R.id.btn_storage);
        btn_event=v.findViewById(R.id.btn_event);

        view_total=v.findViewById(R.id.view_inven_total);
        view_tracker_open=v.findViewById(R.id.view_inven_tracker_open);
        view_tracker_all=v.findViewById(R.id.view_inven_tracker_all);

        btn_level.setOnClickListener(this);
        btn_storage.setOnClickListener(this);
        btn_event.setOnClickListener(this);

        view_total.setOnClickListener(this);
        view_tracker_open.setOnClickListener(this);
        view_tracker_all.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent=null;

        switch (view.getId()){
            case R.id.view_inven_total:
                break;
            case R.id.view_inven_tracker_open:
                break;
            case R.id.view_inven_tracker_all:
                break;
            case R.id.btn_level:
                intent=new Intent(context, LevelActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_storage:
                intent=new Intent(context, StorageActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_event:
                intent=new Intent(context, EventActivity.class);
                startActivity(intent);
                break;
        }
    } // on Click




} // class Inventory
