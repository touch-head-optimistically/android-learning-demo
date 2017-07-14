package com.example.day07_iamgeurl;

import com.lidroid.xutils.BitmapUtils;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView image;
	private String path="http://img01.store.sogou.com/net/a/04/link?url=http%3A%2F%2Fimg03.sogoucdn.com%2Fapp%2Fa%2F100520024%2F9a490e1b464978d93580c09642cde5f5&appid=122";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.image);
        BitmapUtils utils=new BitmapUtils(MainActivity.this);
        utils.display(image, path);
    
    
    
    
    
    
    }
    
    
    
    
}
