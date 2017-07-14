package com.example.day02.last;

import java.util.List;
import android.R.array;
import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
/**
 * listview的使用步骤：
 * 1、在布局文件添加listview控件
 * 2、声明实例化该空间
 * 3、准备资源文件（数组等）
 * 4、构建适配器
 * 5、添加适配器
 *
 */
public class MainActivity extends Activity {
    private  ListView listview;
    private  String  food[]={"11","22","33","44","55","66"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=(ListView) findViewById(R.id.list);
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, food);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
		        Toast.makeText(MainActivity.this, food[arg2], Toast.LENGTH_SHORT).show();
			}
		});
        
    }

    
}
