package com.example.day01.anim02;

import android.R.anim;
import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView rock_1;
	private Animation  anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock_1=(ImageView) findViewById(R.id.ps1);
        anim=AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
        rock_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				rock_1.startAnimation(anim);
			}
		});
        
    }


  
    
}
