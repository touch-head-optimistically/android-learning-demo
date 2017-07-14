package com.ysw793377164.day01_qq;

import java.util.List;

import com.lidroid.xutils.BitmapUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter_Game2 extends BaseAdapter {

	private List<Game2_Feed> feeds;
	private Context context;
	
	public MyAdapter_Game2(List<Game2_Feed> feeds, Context context) {
		super();
		this.feeds = feeds;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return feeds.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return feeds.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (arg1 == null)
		{
			arg1 = LayoutInflater.from(context).inflate(R.layout.item_game2, null);
			holder = new ViewHolder();
			holder.pic = (ImageView) arg1.findViewById(R.id.pic);
			holder.subject = (TextView) arg1.findViewById(R.id.subject);
			holder.summary = (TextView) arg1.findViewById(R.id.summary);
			holder.format = (TextView) arg1.findViewById(R.id.format);
			holder.changed = (TextView) arg1.findViewById(R.id.changed);
			arg1.setTag(holder);
		}
		else
		{
			holder = (ViewHolder) arg1.getTag();
		}
		holder.subject.setText(feeds.get(arg0).getData().getSubject());
		holder.summary.setText(feeds.get(arg0).getData().getSummary());
		holder.format.setText(feeds.get(arg0).getData().getFormat());
		holder.changed.setText(feeds.get(arg0).getData().getChanged());
		String path = "http://litchiapi.jstv.com" + feeds.get(arg0).getData().getCover();
		BitmapUtils utils = new BitmapUtils(context);
		utils.display(holder.pic, path);
		return arg1;
	}
	class ViewHolder
	{
		ImageView pic;
		TextView subject, summary, format, changed;
	}

}
