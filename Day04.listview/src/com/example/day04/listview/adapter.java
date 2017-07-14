package com.example.day04.listview;

import android.R.string;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class adapter extends BaseAdapter {
	private  String names[];
	private Context context;
	private String  signs[];
	private  int icons[];
	
	public adapter(String[] names, Context context, String[] signs, int[] icons) {
		super();
		this.names = names;
		this.context = context;
		this.signs = signs;
		this.icons = icons;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length ;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return names[arg0]; //arg0位置对应数组下标
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		//把item样式放到List，布局转化器
		ViewHolder holder=null;
		//仅在第一次是完全加载
		if(view==null)
		{
			view=LayoutInflater.from(context).inflate(R.layout.cai, null);
			holder=new ViewHolder();
			holder.image=(ImageView)view.findViewById(R.id.icon);
			holder.name=(TextView) view.findViewById(R.id.name);
			holder.sign=(TextView) view.findViewById(R.id.sign);
			//记住holder的控件
			view.setTag(holder);
		}
		else
		{
			//以后直接取出tag直接使用
			holder=(ViewHolder) view.getTag();
		}
		//调用模板
		holder.image.setImageResource(icons[position]);
		holder.name.setText(names[position]);
		holder.sign.setText(signs[position]);
		return view;
	}
	//内部类定义
  class ViewHolder
  {
	  TextView name,sign;
	  ImageView image;
  }
}
