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
  //����
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		container.addView(views[position]);
		//չʾһ��
		return views[position];
	     
	
	}
    @Override
   //����
    public void destroyItem(ViewGroup container, int position, Object object) {
    	// TODO Auto-generated method stub
    	//Ҫɾ��
   
    	container.removeView(views[position]);
    	
          
    }
	@Override
	//�ж�ʱ������µ�
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		//�ж�
		return arg0==arg1;
	}

}
