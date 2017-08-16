package kr.anima.xd.s.a170802_balancewheel;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldf.calendar.Utils;
import com.ldf.calendar.component.CalendarAttr;
import com.ldf.calendar.component.CalendarViewAdapter;
import com.ldf.calendar.interf.OnSelectDateListener;
import com.ldf.calendar.model.CalendarDate;
import com.ldf.calendar.view.Calendar;
import com.ldf.calendar.view.MonthPager;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {

    public static int CURRENT_YEAR;
    public static int CURRENT_MONTH;

    CoordinatorLayout content;
    MonthPager monthPager;
    RecyclerView rvToDoList;

    private ArrayList<Calendar> currentCalendars = new ArrayList<>();
    private MyCalendarAdapter calendarAdapter;
    private OnSelectDateListener onSelectDateListener;
    private int mCurrentPage = MonthPager.CURRENT_DAY_INDEX;
    private Context context;
    private CalendarDate currentDate;
    private boolean initiated = false;


    public CalendarFragment() {
        // Required empty public constructor
    }

    public CalendarFragment(Context context) {
        this.context=context;
        initCurrentDate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dashboard_calendar, container, false);
        findId(view);
        return view;
    }

    public void findId(View view){
        content = view.findViewById(R.id.content);
        monthPager = view.findViewById(R.id.calendar_view);
        monthPager.setViewheight(Utils.dpi2px(context, 270));

        rvToDoList =view.findViewById(R.id.list);
        rvToDoList.setHasFixedSize(true);
        rvToDoList.setAdapter(new TaskListAdapter(context));

        initCalendarView();
//        initToolbarClickListener();
    }

//
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && !initiated) {
//            refreshMonthPager();
//            initiated = true;
//        }
//    }

//    private void initToolbarClickListener() {
////        backToday.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                onClickBackToDayBtn();
////            }
////        });
//        scrollSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (calendarAdapter.getCalendarType() == CalendarAttr.CalendayType.WEEK) {
//                    Utils.scrollTo(content, rvToDoList, monthPager.getViewHeight(), 200);
//                    calendarAdapter.switchToMonth();
//                } else {
//                    Utils.scrollTo(content, rvToDoList, monthPager.getCellHeight(), 200);
//                    calendarAdapter.switchToWeek(monthPager.getRowIndex());
//                }
//            }
//        });
//        themeSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                refreshSelectBackground();
//            }
//        });
//        nextMonthBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                monthPager.setCurrentItem(monthPager.getCurrentPosition() + 1);
//            }
//        });
//        lastMonthBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                monthPager.setCurrentItem(monthPager.getCurrentPosition() - 1);
//            }
//        });
//    }

    private void initCurrentDate() {
        currentDate = new CalendarDate();
        CURRENT_YEAR=currentDate.getYear();
        CURRENT_MONTH=currentDate.getMonth();

//        textViewYearDisplay.setText(currentDate.getYear() + "年");
//        textViewMonthDisplay.setText(currentDate.getMonth() + "");
    }

    private void initCalendarView() {
        initListener();
        MyCalendarView myCalendarView = new MyCalendarView(context, R.layout.calendar_day);
        calendarAdapter = new MyCalendarAdapter(
                context,
                onSelectDateListener,
                CalendarAttr.CalendayType.MONTH,
                myCalendarView);
        initMarkData();
        initMonthPager();
    }

    private void initMarkData() {
        HashMap<String, String> markData = new HashMap<>();
//        markData.put("2017-8-9", "1");
//        markData.put("2017-7-9", "0");
//        markData.put("2017-6-9", "1");
//        markData.put("2017-6-10", "0");
        calendarAdapter.setMarkData(markData);
    }

    private void initListener() {
        onSelectDateListener = new OnSelectDateListener() {
            @Override
            public void onSelectDate(CalendarDate date) {
                refreshClickDate(date);
            }

            @Override
            public void onSelectOtherMonth(int offset) {
                //偏移量 -1表示刷新成上一个月数据 ， 1表示刷新成下一个月数据
                monthPager.selectOtherMonth(offset);
            }
        };
    }

    private void refreshClickDate(CalendarDate date) {
        currentDate = date;
//        textViewYearDisplay.setText(date.getYear() + "年");
//        textViewMonthDisplay.setText(date.getMonth() + "");
    }

    private void initMonthPager() {
        monthPager.setAdapter(calendarAdapter);
        monthPager.setCurrentItem(MonthPager.CURRENT_DAY_INDEX);
        monthPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                position = (float) Math.sqrt(1 - Math.abs(position));
                page.setAlpha(position);
            }
        });
        monthPager.addOnPageChangeListener(new MonthPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPage = position;
                currentCalendars = calendarAdapter.getPagers();
                if (currentCalendars.get(position % currentCalendars.size()) instanceof Calendar) {
                    CalendarDate date = currentCalendars.get(position % currentCalendars.size()).getSeedDate();
                    currentDate = date;
//                    textViewYearDisplay.setText(date.getYear() + "年");
//                    textViewMonthDisplay.setText(date.getMonth() + "");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

//    public void onClickBackToDayBtn() {
//        refreshMonthPager();
//    }

    private void refreshMonthPager() {
        CalendarDate today = new CalendarDate();
        calendarAdapter.notifyDataChanged(today);
    }

    private void refreshSelectBackground() {
        ThemeDayView themeDayView = new ThemeDayView(context, R.layout.calendar_day_focus);
        calendarAdapter.setCustomDayRenderer(themeDayView);
        calendarAdapter.notifyDataSetChanged();
        calendarAdapter.notifyDataChanged(new CalendarDate());
    }

}
