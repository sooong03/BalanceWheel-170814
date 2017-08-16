package kr.anima.xd.s.a170802_balancewheel;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardListFragment extends Fragment {

    private RecyclerView recyclerView;
    private DashboardListAdapter adapter;
    private Context context;



    public DashboardListFragment() {
        // Required empty public constructor
    }

    public DashboardListFragment(Context context) {
        this.context = context;
        adapter=new DashboardListAdapter(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dashboard_board_list, container, false);

        recyclerView=view.findViewById(R.id.view_dash_recycler);

        return view;
    }

}
