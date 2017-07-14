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
 * listview��ʹ�ò��裺
 * 1���ڲ����ļ����listview�ؼ�
 * 2������ʵ�����ÿռ�
 * 3��׼����Դ�ļ�������ȣ�
 * 4������������
 * 5�����������
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
