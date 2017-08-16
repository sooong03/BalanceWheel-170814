package kr.anima.xd.s.a170802_balancewheel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class SharedItemActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_item);
        toolbar= (Toolbar) findViewById(R.id.layout_share_item_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        //TODO : set HomeAsUp

    } // on Create


    public void clickBtn(View v){
        switch (v.getId()){
            case R.id.img_star:

                break;
            case R.id.img_num_download:
                break;
            case R.id.img_comment:
                break;
            case R.id.img_download:
                break;
        }
    } // click Btn


} // class Shared Item
