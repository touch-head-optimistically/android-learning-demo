package com.qifa.day03.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1=(Button) findViewById(R.id.start);
        btn_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this, SecondActivity.class); //建立2个activity的连接
				//intent.putExtra("hehe1", "ggsumimas"); //string
				                                                 //Intent intent=getIntent();		
				                                                //int age=intent.getIntExtra("hehe1", 1);
				intent.putExtra("hehe1", "ggsimida");
		     //发送数据  类型可选
			//intent.putExtra("hi","ozheyangma"); //char    几个类型
			//	intent.putExtra("ha"," 1");//int
			startActivity(intent);              //不需求结果的activity
			startActivityForResult(intent, 200); //需要反馈的activity
			}
		});
    }
    @Override
    //接收反馈部分
    protected void onActivityResult(int A1, int A2, Intent data) { //onactivityresult
    	// TODO Auto-generated method stub
    	super.onActivityResult(A1, A2, data);   
    	
  
    	String str =data.getStringExtra("hehe2");   //根据上面data确定getstring
    			Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show(); //toast show 出接收到的反馈结果
   
    }
    
}
