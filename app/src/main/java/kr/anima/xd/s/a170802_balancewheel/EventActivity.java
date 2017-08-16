package kr.anima.xd.s.a170802_balancewheel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    private GridView gridView;
    private EventAdapter adapter;
    private ArrayList<EventItem> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        gridView= (GridView) findViewById(R.id.view_grid);
        adapter=new EventAdapter();
        gridView.setAdapter(adapter);
    } // on Create

    class EventItem{
        String[] element;
        String icon;

        public EventItem() {
            element=getResources().getStringArray(R.array.list_element);
        }
    }

} // class Event
