package com.hankkin.textviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hankkin.textviewdemo.view.TitleBarView;
import com.hankkin.textviewdemo.view.TitleBarView1;

public class MainActivity extends AppCompatActivity implements TitleBarView1.BtnClickListener{

    private Button btnLeft,btnRight;
    private TitleBarView titleBarView;
    private TitleBarView1 titleBarView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = (Button) findViewById(R.id.btn_left);
        btnRight = (Button) findViewById(R.id.btn_right);
        titleBarView = (TitleBarView) findViewById(R.id.title_bar);
        titleBarView.setOnTitleBarClickListener(new TitleBarView.TitleBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(getApplicationContext(),"left",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(getApplicationContext(),"right",Toast.LENGTH_SHORT).show();
            }
        });
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleBarView.setLeftBtnVisable(false);
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleBarView.setRightBtnVisable(false);
            }
        });

        titleBarView1 = (TitleBarView1) findViewById(R.id.tbv_titlebar);
        titleBarView1.setTitleBarListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void leftClick() {
        Toast.makeText(getApplicationContext(),"left",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightClick() {
        Toast.makeText(getApplicationContext(),"right",Toast.LENGTH_SHORT).show();
    }
}
