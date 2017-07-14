package com.ysw793377164.day01_qq;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity implements OnClickListener {
	
	private Button btn_game1, btn_game2, btn_game3;
	private Drawable dota_off, dota_on, mt_off, mt_on, sina_off, sina_on;
	private Fragment_Game1 fragment_game1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		InitView();
	}
	public void InitView()
	{
		btn_game1 = (Button) findViewById(R.id.btn_game1);
		btn_game2 = (Button) findViewById(R.id.btn_game2);
		btn_game3 = (Button) findViewById(R.id.btn_game3);
		btn_game1.setOnClickListener(this);
		btn_game2.setOnClickListener(this);
		btn_game3.setOnClickListener(this);
		sina_off = getResources().getDrawable(R.drawable.sina_off);
		sina_on = getResources().getDrawable(R.drawable.sina_on);
		mt_off = getResources().getDrawable(R.drawable.mt_off);
		mt_on = getResources().getDrawable(R.drawable.mt_on);
		dota_off = getResources().getDrawable(R.drawable.dota_off);
		dota_on = getResources().getDrawable(R.drawable.dota_on);
		FragmentManager manager = getFragmentManager();
		FragmentTransaction action = manager.beginTransaction();
		fragment_game1 = new Fragment_Game1();
		action.add(R.id.fragment, fragment_game1);
		action.commit();
	}
	@SuppressLint("NewApi")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		FragmentManager manager = getFragmentManager();
		FragmentTransaction action = manager.beginTransaction();
		
		btn_game1.setCompoundDrawablesRelativeWithIntrinsicBounds(null, mt_off, null, null);
		btn_game2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, sina_off, null, null);
		btn_game3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, dota_off, null, null);
		switch (arg0.getId()) {
		case R.id.btn_game1:
			action.replace(R.id.fragment, new Fragment_Game1());
			btn_game1.setCompoundDrawablesRelativeWithIntrinsicBounds(null, mt_on, null, null);
			break;
		case R.id.btn_game2:
			action.replace(R.id.fragment, new Fragment_Game2());
			btn_game2.setCompoundDrawablesRelativeWithIntrinsicBounds(null, sina_on, null, null);
			break;
		case R.id.btn_game3:
			action.replace(R.id.fragment, new Fragment_Game3());
			btn_game3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, dota_on, null, null);
			break;
		}
		action.commit();
	}
}
