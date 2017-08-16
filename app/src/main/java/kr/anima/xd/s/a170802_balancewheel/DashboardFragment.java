package kr.anima.xd.s.a170802_balancewheel;


import android.content.Context;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements View.OnClickListener{

    private Context context;
    private Calendar calendar;

    private Toolbar toolbar;
    private ToggleButton btn_tracker;
    private ToggleButton btn_calendar;
    private TextView date;
    private Fragment[] dashboard=new Fragment[3];

    public DashboardFragment() {
        // Required empty public constructor
    } // Constructor

    public DashboardFragment(Context context) {
        this.context = context;
        dashboard[0]=new TrackerOpenFragment(context);
        dashboard[1]=new DashboardListFragment(context);
        dashboard[2]=new CalendarFragment(context);
     
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getChildFragmentManager().beginTransaction().replace(R.id.view_dash, dashboard[1]).commit();
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);

        // TODO : View Transition
        toolbar=view.findViewById(R.id.layout_dash_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar=((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        toolbar.setTitle(CalendarFragment.CURRENT_YEAR+" "+CalendarFragment.CURRENT_MONTH);

        btn_tracker=view.findViewById(R.id.btn_tracker);
        btn_calendar=view.findViewById(R.id.btn_calendar);
        btn_tracker.setOnClickListener(this);
        btn_calendar.setOnClickListener(this);


        //TODO : DATE

        return view;
    } // on CreateView


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_tracker:
                btn_calendar.setChecked(false);
                if(btn_tracker.isChecked()) {
                    getChildFragmentManager().beginTransaction().replace(R.id.view_dash, dashboard[0]).commit();
                }
                else getChildFragmentManager().beginTransaction().replace(R.id.view_dash, dashboard[1]).commit();

                break;
            case R.id.btn_calendar:
                btn_tracker.setChecked(false);
                if(btn_calendar.isChecked()) {
                    getChildFragmentManager().beginTransaction().replace(R.id.view_dash, dashboard[2]).commit();
                }
                else getChildFragmentManager().beginTransaction().replace(R.id.view_dash, dashboard[1]).commit();
                break;
        }

    } // onClick




} // class Dashboard Fragment
