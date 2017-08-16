package kr.anima.xd.s.a170802_balancewheel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by alfo6-10 on 8/4/2017.
 */

public class TrackerOpenPagerAdapter extends PagerAdapter {

    Context context;

    public TrackerOpenPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View item=null;
        switch (position){
            case 0:
                item= LayoutInflater.from(context).inflate(R.layout.tracker_item, container, false);
                break;
            case 1:
                item= LayoutInflater.from(context).inflate(R.layout.tracker_item, container, false);
                break;
            case 2:
                item= LayoutInflater.from(context).inflate(R.layout.tracker_item, container, false);
                break;
        }

        container.addView(item);

        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

} // class Tracker Open Pager
