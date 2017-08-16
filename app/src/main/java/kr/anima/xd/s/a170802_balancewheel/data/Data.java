package kr.anima.xd.s.a170802_balancewheel.data;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import kr.anima.xd.s.a170802_balancewheel.R;

/**
 * Created by alfo6-10 on 8/9/2017.
 */

public class Data extends AppCompatActivity{

    String Name; // 미션명
    ArrayList<Element> elements=new ArrayList<>(); // 요소와 각 요소의 해당여부

    public Data() {
        // TODO : xml
        elements.add(new Element("건강", true));
        elements.add(new Element("재정", true));
        elements.add(new Element("환경", true));
        elements.add(new Element("감정", true));
        elements.add(new Element("정신", true));
        elements.add(new Element("관계", true));
        elements.add(new Element("교육", true));
        elements.add(new Element("사업", true));
        elements.add(new Element("외면", true));

    }

    // TODO : element 요소

    class ElementFromArray{
        String[] element;
        Boolean included;

        public ElementFromArray() {
            element=getResources().getStringArray(R.array.list_element);
        }
    }

    class Element{
        String name;
        Boolean included;
        String[] element;

        public Element(String name, Boolean included) {
            element=getResources().getStringArray(R.array.list_element);
            this.name = name;
            this.included = included;
        }
    } // class Element

}
