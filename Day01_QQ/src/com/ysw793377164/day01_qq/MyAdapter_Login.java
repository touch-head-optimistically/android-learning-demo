package com.ysw793377164.day01_qq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter_Login extends BaseAdapter {

	private int icons[];
	private String names[], words[];
	private Context context;
		
	public MyAdapter_Login(int[] icons, String[] names, String[] words,
			Context context) {
		super();
		this.icons = icons;
		this.names = names;
		this.words = words;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return names.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return names[arg0];
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		arg1 = LayoutInflater.from(context).inflate(R.layout.item_login, null);
		ImageView icon = (ImageView) arg1.findViewById(R.id.item_icon);
		TextView name = (TextView) arg1.findViewById(R.id.item_name);
		TextView word = (TextView) arg1.findViewById(R.id.item_word);
		icon.setImageResource(icons[arg0]);
		name.setText(names[arg0]);
		word.setText(words[arg0]);
		return arg1;
	}

}
