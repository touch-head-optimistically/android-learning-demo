package com.ysw793377164.day01_qq;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyAdapter_Welcome extends PagerAdapter {

	private ImageView ivs[];

	public MyAdapter_Welcome(ImageView[] ivs) {
		super();
		this.ivs = ivs;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return ivs.length;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(ivs[position]);
		return ivs[position];

	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(ivs[position]);
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

}
