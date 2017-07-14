package com.example.day05.viewpager;

import android.os.Bundle;
import android.provider.MediaStore.Images;
import android.app.Activity;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

public class MainActivity extends Activity {
   private ViewPager viewpager;
   private int images[]={R.drawable.p1,R.drawable.p2,R.drawable.p3};
   private ImageView views[]=new ImageView[3];  
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager=(ViewPager) findViewById(R.id.viewpager);
        MyAdapter adapter=new MyAdapter(views);
        viewpager.setAdapter(adapter);
        //for生成三个imageview放入数组
       for(int i=0;i<3;i++)
       {
       ImageView image=new ImageView(MainActivity.this);
       image.setImageResource(images[i]);
       }
 
       
       
    }
}
