package com.example.day01_nineponts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
		view=LayoutInflater.from(context).inflate(R.layout.hehe, null);
		ImageView image=(ImageView)view.findViewById(R.id.icon);
		TextView name =(TextView) view.findViewById(R.id.name);
		TextView sign =(TextView) view.findViewById(R.id.sign);
		image.setImageResource(icons[position]);
		name.setText(names[position]);
		sign.setText(signs[position]);
		return view;
	}

}
