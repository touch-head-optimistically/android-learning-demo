package com.example.day06_fragment2;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private Button btn_mes,btn_fri,btn_zone;
	private Firstfragment first; //firstfragment
	// private  FragmentManager manager;
	 //private FragmentTransaction action ;
    private int button;    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_mes=(Button) findViewById(R.id.mes);
        btn_fri=(Button) findViewById(R.id.friend);
        btn_zone=(Button) findViewById(R.id.zone);
        btn_fri.setOnClickListener(this);
        btn_mes.setOnClickListener(this);
        btn_zone.setOnClickListener(this);
        FragmentManager  manager=getFragmentManager(); //控制
        FragmentTransaction  action =manager.beginTransaction();//开始事务
       first=new Firstfragment();
       action.add(R.id.fragment, first);//把first添加进fragment
       action.commit();//提交aciton
        
		  btn_mes.setBackgroundColor(Color.rgb(1,1,1));
		  
		  btn_fri.setBackgroundColor(Color.rgb(2,2,2));
		  btn_zone.setBackgroundColor(Color.rgb(2,2,2));
		  
        
        
    }
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		 FragmentManager  manager=getFragmentManager(); //控制
	        FragmentTransaction  action =manager.beginTransaction();//开始事务

	    switch (view.getId()) {
		case R.id.mes:
			action.replace(R.id.fragment, first);//替换
			   action.commit();
			   
			break;
			
		case R.id.friend:
			action.replace(R.id.fragment, new Secondfragment());
			   action.commit();		
			break;
			
		case R.id.zone:
			action.replace(R.id.fragment, new Thirdfragment());
			   action.commit();
			break;
			
		default:
			break;
		}
	}


   
    
}
