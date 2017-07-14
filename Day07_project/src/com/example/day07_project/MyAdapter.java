package com.example.day07_project;

import java.util.List;

import com.lidroid.xutils.BitmapUtils;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
//需要资源数组和context
	private Context context;
	private List<Feed> list;
	
	public MyAdapter(Context context, List<Feed> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return  list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ViewHolder holder=null;
		if(arg1==null)
		{
		arg1=LayoutInflater.from(context).inflate(R.layout.hehe, null);
		holder=new ViewHolder();
		holder.image=(ImageView)arg1.findViewById(R.id.image);
		holder.text_title=(TextView) arg1.findViewById(R.id.title);
		holder.text_content=(TextView)arg1. findViewById(R.id.content);
		holder.text_time=(TextView)arg1. findViewById(R.id.time);
		arg1.setTag(holder);
		}
		else
		{
			holder=(ViewHolder) arg1.getTag();
		}
		holder.text_title.setText(list.get(arg0).getData().getSubject());
		holder.text_content.setText(list.get(arg0).getData().getSummary());
		holder.text_time.setText(list.get(arg0).getData().getChanged());
		String image_path="http://litchiapi.jstv.com"+list.get(arg0).getData().getCover();
		BitmapUtils utils=new BitmapUtils(context);
		utils.display(holder.image,image_path);
		return arg1;
	}
	class ViewHolder
	{
		TextView text_title,text_content,text_time;
		ImageView  image;
	}
	
}
