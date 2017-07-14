package com.example.day05.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MyAdapter extends PagerAdapter {
    private ImageView views[];
    
    
	
	public MyAdapter(ImageView[]  views) {
		super();
		this.views = views;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return  views.length;
	}
	@Override
  //加载
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(views[position]);
		//展示一张
		return views[position];
	     
	
	}
    @Override
   //回收
    public void destroyItem(ViewGroup container, int position, Object object) {
    	// TODO Auto-generated method stub
    	//要删掉
   
    	container.removeView(views[position]);
    	
          
    }
	@Override
	//判断时候加载新的
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		//判断
		return arg0==arg1;
	}

}
