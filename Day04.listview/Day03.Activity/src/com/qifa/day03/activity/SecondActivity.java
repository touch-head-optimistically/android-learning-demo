package com.qifa.day03.activity;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
		 private TextView text1;
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_second);
			text1=(TextView) findViewById(R.id.te1);
			Intent intent=getIntent();		
			String str2=intent.getStringExtra("hehe1");
		    Toast.makeText(SecondActivity.this,str2,Toast.LENGTH_LONG ).show();	
			int age=intent.getIntExtra("hi", 1);//int类型文本接收
			text1.setText(age+"");  //文本格式要求
			
			text1.setOnClickListener(new OnClickListener() { //反馈结果
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent1=new Intent();   //新建intent对象
					intent1.putExtra("hehe2", "ok,getit"); //返回值
					setResult(2000, intent1); //设置结果码
					finish();   //finish结束
				}
			});
		}
		
}

