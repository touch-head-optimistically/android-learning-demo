package com.example.day01_buttom;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
//声明控件
	private Button btn_1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化控件
        btn_1 = (Button) findViewById(R.id.btn);
        btn_1.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				btn_1.setBackgroundColor(Color.rgb(3, 5, 9));
				btn_1.setText("碧君");
				btn_1.setTextColor(Color.BLUE);
				
			}
		});
    }
}
