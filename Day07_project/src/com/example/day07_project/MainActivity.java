package com.example.day07_project;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;


import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.widget.Toast;

public class MainActivity extends Activity {
	 private  ListView listView;
    private  ListAdapter adapter;
    private List<Feed> totalList=new ArrayList<Feed>();
	private String path="http://litchiapi.jstv.com/api/GetFeeds?column=1&PageSize=10&pageIndex=1";
   private boolean flag=false;
    private String path2="&val=100511D3BE5301280E0992C73A9DEC41";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    loadData();
    listView=(ListView) findViewById(R.id.listview);
   adapter=new  MyAdapter (MainActivity.this, totalList);
listView.setAdapter(adapter);
    }
/*  loadData(path+currentPage+path2);
   listView.setOnScrollListener(new OnScrollListener() {
	
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		// TODO Auto-generated method stub
		if(flag&&arg1==0)
		{
			currentPage++;
			loadData(path+currentPage+path2);
		}
	}
	*/
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		flag=arg1+arg2==arg3;
	
	}

   
    
    
    
    
    
    
    public void loadData()
    {
    	//    网络加载工具类
    	HttpUtils httpUtils=new HttpUtils();
    	//设定家在方法，网络路径和家在结果
	   httpUtils.send(HttpMethod.GET, path,new RequestCallBack<String>() {
		   @Override
		public void onFailure(HttpException arg0, String arg1) {
			// TODO Auto-generated method stub
			Toast.makeText(MainActivity.this, "duanwang", Toast.LENGTH_SHORT).show();
			
		}
		   @Override
		public void onSuccess(ResponseInfo<String> arg0) {
			// TODO Auto-generated method stub
			   //fastJSON解析
			First  object=JSONObject.parseObject(arg0.result, First.class);
			//获取需要的数据，集合形式
			List<Feed> list=object.getParamz().getFeeds();
			totalList.addAll(list);
		 //注释	adapter.notifyDataSetChanged();
			
		   // MyAdapter adapter=new MyAdapter(MainActivity.this, list);
		    //listView.setAdapter(adapter);
		}
		 
       });//callback;
    }
  

  
    
}
