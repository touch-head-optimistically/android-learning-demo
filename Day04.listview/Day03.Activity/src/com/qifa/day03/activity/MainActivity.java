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
				Intent intent=new Intent(MainActivity.this, SecondActivity.class); //����2��activity������
				//intent.putExtra("hehe1", "ggsumimas"); //string
				                                                 //Intent intent=getIntent();		
				                                                //int age=intent.getIntExtra("hehe1", 1);
				intent.putExtra("hehe1", "ggsimida");
		     //��������  ���Ϳ�ѡ
			//intent.putExtra("hi","ozheyangma"); //char    ��������
			//	intent.putExtra("ha"," 1");//int
			startActivity(intent);              //����������activity
			startActivityForResult(intent, 200); //��Ҫ������activity
			}
		});
    }
    @Override
    //���շ�������
    protected void onActivityResult(int A1, int A2, Intent data) { //onactivityresult
    	// TODO Auto-generated method stub
    	super.onActivityResult(A1, A2, data);   
    	
  
    	String str =data.getStringExtra("hehe2");   //��������dataȷ��getstring
    			Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show(); //toast show �����յ��ķ������
   
    }
    
}
