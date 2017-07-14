package com.ysw793377164.day01_qq;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity {
	
	private EditText regname, regpassword;
	private Button btn_reg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		btn_reg = (Button) findViewById(R.id.reg);
		regname = (EditText) findViewById(R.id.regname);
		regpassword = (EditText) findViewById(R.id.regpassword);
		btn_reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str_regname = regname.getText().toString().trim();
				String str_regpassword = regpassword.getText().toString().trim();
				//SharedPreferences..............
				SharedPreferences sp =getSharedPreferences("–≈œ¢", Context.MODE_PRIVATE);
				Editor editor = sp.edit();
				editor.putString("’À∫≈", str_regname);
				editor.putString("√‹¬Î", str_regpassword);
				editor.commit();
				//................................
//				Intent intent = new Intent();
//				intent.putExtra("’À∫≈", str_regname);
//				intent.putExtra("√‹¬Î", str_regpassword);
//				setResult(2000, intent);
				finish();
			}
		});
	}
}
