package com.ysw793377164.day01_qq;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AbsListView.OnScrollListener;

public class Fragment_Game2 extends Fragment {

	private String path1 = "http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=10&pageIndex=";
	private int currentPage = 1;
	private String path2 = "&val=100511D3BE5301280E0992C73A9DEC41";
	private ListView list;
	private MyAdapter_Game2 ad;
	private List<Game2_Feed> totalfeeds = new ArrayList<Game2_Feed>();
	private boolean flag = false;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment_game2, container, false);
		list = (ListView) view.findViewById(R.id.list_game2);
		ad = new MyAdapter_Game2(totalfeeds, getActivity());
		list.setAdapter(ad);
		LoadData(path1+currentPage+path2);
		list.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView arg0, int arg1) {
				// TODO Auto-generated method stub
				if (flag & arg1 == 0)
				{
					currentPage++;
					LoadData(path1+currentPage+path2);
				}
			}
			
			@Override
			//arg1 = first visible item in the screen
			//arg2 = visible item count in one screen
			//arg3 = total item count in one ListView
			public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				flag = arg1+arg2==arg3;
			}
		});
		return view;
	}

	public void LoadData(String path)
	{
		HttpUtils utils = new HttpUtils();
		utils.send(HttpMethod.GET, path, new RequestCallBack<String>() {

			@Override
			public void onFailure(HttpException arg0, String arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "Õ¯¬Áº”‘ÿ ß∞‹£¨«ÎºÏ≤ÈÕ¯¬Á£°", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onSuccess(ResponseInfo<String> arg0) {
				Game2_First obj = JSONObject.parseObject(arg0.result, Game2_First.class);
				List<Game2_Feed> feeds = obj.getParamz().getFeeds();
				totalfeeds.addAll(feeds);
				ad.notifyDataSetChanged();
			}
		});
		
	}
}