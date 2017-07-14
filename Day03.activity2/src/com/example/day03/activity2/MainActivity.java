package com.example.day03.activity2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText ad_1;
	private Button   btn_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ad_1=(EditText) findViewById(R.id.ad1);
        btn_1=(Button) findViewById(R.id.btn1);
        btn_1.setOnClickListener(new  OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				  String str=ad_1.getText().toString().trim(); //tostring ，trim去空格       
			       Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
			}
		}); /*String str1=make_1.getText().toString().trim(); //tostring ，trim去空格    
	    String str2=make_2.getText().toString().trim(); //tostring ，trim去空格    
        Toast.makeText(SecondActivity.this, str1, Toast.LENGTH_SHORT).show();
        Toast.makeText(SecondActivity.this, str2, Toast.LENGTH_SHORT).show();
        Intent intent1=new Intent();   //新建intent对象
			intent1.putExtra("hehe2", "ok,getit"); //返回值
			setResult(2000, intent1); //设置结果码
			finish();   //finish结			
	*/
        
        
        
        
        
        
        
        
        
    }


   
    
}
