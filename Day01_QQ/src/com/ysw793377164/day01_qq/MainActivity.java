package com.ysw793377164.day01_qq;


import com.ysw793377164.day01_qq.MainActivity;
import com.ysw793377164.day01_qq.RegisterActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private Button btn_login, btn_register, btn_forget;
	private EditText name, password;
	String str_regname, str_regpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        btn_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str_name = name.getText().toString().trim();
				String str_password = password.getText().toString().trim();
				//SharedPreferences............
				SharedPreferences sp = getSharedPreferences("–≈œ¢", Context.MODE_PRIVATE);
				String str_regname = sp.getString("’À∫≈", null); //–¥»Î’À∫≈√‹¬Î
				String str_regpassword = sp.getString("√‹¬Î", null);
				//.............................
			    if (str_name.equals(str_regname) && str_password.equals(str_regpassword))
		        {
		        	Intent intent_login = new Intent(MainActivity.this, LoginActivity.class);
					startActivity(intent_login);
		        }
		        else
		        {
		        	Toast.makeText(MainActivity.this, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬ ‰»Î£°", Toast.LENGTH_LONG).show();
		        }
			}
		});
        
        btn_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent_register = new Intent(MainActivity.this, RegisterActivity.class);
			//	startActivityForResult(intent_register, 1000);
				startActivity(intent_register);
			}
		});
        
        btn_forget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "…µ±∆£°Õ¸º«√‹¬Î¡À∞…£°∞°π˛π˛π˛~", Toast.LENGTH_LONG).show();
			}
		});
    }
    public void InitView()
    {
    	btn_login = (Button) findViewById(R.id.login);
        btn_register = (Button) findViewById(R.id.register);
        btn_forget = (Button) findViewById(R.id.forget);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
    }
    
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
//    	super.onActivityResult(requestCode, resultCode, data);
//    	if (requestCode == 1000 && resultCode == 2000)
//    	{
//    		str_regname = data.getStringExtra("’À∫≈");
//	        str_regpassword = data.getStringExtra("√‹¬Î");
//    	}
//    }

}
