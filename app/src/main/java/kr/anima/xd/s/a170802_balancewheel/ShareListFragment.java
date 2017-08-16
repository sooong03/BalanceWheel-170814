package kr.anima.xd.s.a170802_balancewheel;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShareListFragment extends Fragment {

    private Context context;

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ShareListAdapter adapter;

    public ShareListFragment() {
    }

    public ShareListFragment(Context context) {
        // Required empty public constructor
        this.context=context;
        adapter=new ShareListAdapter(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_share_list, container, false);

        toolbar=view.findViewById(R.id.layout_share_toolbar);
        recyclerView=view.findViewById(R.id.view_share_recycler);
        recyclerView.setAdapter(adapter);

//      add animation at add recycler item
//        recyclerView.setItemAnimator();

        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar=((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        View viewTool=getActivity().getLayoutInflater().inflate(R.layout.toolbar_share_list, null);
        actionBar.setCustomView(viewTool);

        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.share_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
} // class Share List Fragment
