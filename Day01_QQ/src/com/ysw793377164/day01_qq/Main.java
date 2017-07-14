 package com.ysw793377164.day01_qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Main extends Activity {
	private ViewPager viewpager;
	private int images[] = {R.drawable.c1, R.drawable.c2, R.drawable.c3 };
	private ImageView ivs[] = new ImageView[3];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		viewpager = (ViewPager) findViewById(R.id.viewpager);
		for (int i = 0; i < 3; i++)
		{
			ImageView image = new ImageView(Main.this);
			image.setImageResource(images[i]);
			ivs[i] = image;
			ivs[i].setScaleType(ScaleType.FIT_XY);
		}
		MyAdapter_Welcome ad = new MyAdapter_Welcome(ivs);
		viewpager.setAdapter(ad);
		ivs[2].setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Main.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}

}