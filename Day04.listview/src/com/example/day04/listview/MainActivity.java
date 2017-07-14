package com.example.day04.listview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {

	 private  ListView listView;
	private int images[]={R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,
			                                   R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8} ;
	
   
	private String   sign[]={"wo1","wo2","wo3","wo4","wo5","wo6","wo7","wo8"};
	private String  name[]={"monkey1","monkey2","monkey3","m4","m5","m6","m7","m8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listview);
        //error
        adapter adapter=new adapter(name, MainActivity.this,  sign,images);
        listView.setAdapter(adapter);
  	}
      

    
}
