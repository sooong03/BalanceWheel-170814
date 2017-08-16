package kr.anima.xd.s.a170802_balancewheel;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    private Context context;
    private ArrayList<String> list;

    private RecyclerView recyclerView;
    private SettingListAdapter adapter;

    public SettingFragment(Context context) {
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting, container, false);

        List<String> list=null;

        // TODO : ArrayList<List<String>> lists
        // lists.get(i) return VIEW_TYPE_HEADLINE;
        // lists.get(i).get(j) return VIEW_TYPE_SWITCH;

        recyclerView=view.findViewById(R.id.view_setting_account);
        recyclerView.setVerticalScrollBarEnabled(false);
        list=new ArrayList<String>(Arrays.asList(context.getResources().getStringArray(R.array.set_account)));
//        list= (ArrayList<String>) Arrays.asList(context.getResources().getStringArray(R.array.set_account));
        adapter=new SettingListAdapter(context, (ArrayList<String>) list);
        recyclerView.setAdapter(adapter);

        recyclerView=view.findViewById(R.id.view_setting_display);
        list= new ArrayList<String>(Arrays.asList(context.getResources().getStringArray(R.array.set_display)));
        adapter=new SettingListAdapter(context, (ArrayList<String>) list);
        recyclerView.setAdapter(adapter);

        recyclerView=view.findViewById(R.id.view_setting_content);
        list= new ArrayList<String>(Arrays.asList(context.getResources().getStringArray(R.array.set_content)));
        adapter=new SettingListAdapter(context, (ArrayList<String>) list);
        recyclerView.setAdapter(adapter);

        recyclerView=view.findViewById(R.id.view_setting_admin);
        list= new ArrayList<String> (Arrays.asList(context.getResources().getStringArray(R.array.set_admin)));
        adapter=new SettingListAdapter(context, (ArrayList<String>) list);
        recyclerView.setAdapter(adapter);

        return view;
    }

} // class Setting Fragment
