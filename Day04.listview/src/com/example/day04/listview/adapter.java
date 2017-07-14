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
		return names[arg0]; //arg0λ�ö�Ӧ�����±�
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	
	public View getView(int position, View view, ViewGroup arg2) {
		// TODO Auto-generated method stub
		//��item��ʽ�ŵ�List������ת����
		ViewHolder holder=null;
		//���ڵ�һ������ȫ����
		if(view==null)
		{
			view=LayoutInflater.from(context).inflate(R.layout.cai, null);
			holder=new ViewHolder();
			holder.image=(ImageView)view.findViewById(R.id.icon);
			holder.name=(TextView) view.findViewById(R.id.name);
			holder.sign=(TextView) view.findViewById(R.id.sign);
			//��סholder�Ŀؼ�
			view.setTag(holder);
		}
		else
		{
			//�Ժ�ֱ��ȡ��tagֱ��ʹ��
			holder=(ViewHolder) view.getTag();
		}
		//����ģ��
		holder.image.setImageResource(icons[position]);
		holder.name.setText(names[position]);
		holder.sign.setText(signs[position]);
		return view;
	}
	//�ڲ��ඨ��
  class ViewHolder
  {
	  TextView name,sign;
	  ImageView image;
  }
}
