package com.dt.day02_anim;

import java.security.PublicKey;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_open;
	private Button btn_fire;
	//声明imageview,在传统动画里代表承载控件.在区间动画中代表执行动画
	private ImageView  ima_rocket;
	//传统动画的动画类
	private AnimationDrawable anim_fire=null;
    private  Animation  anim_shot=null;
    private AnimationDrawable anim_boom=null;
    private ImageView ima_boom;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_open=(Button) findViewById(R.id.open);
        btn_fire=(Button) findViewById(R.id.fire);
        ima_rocket=(ImageView) findViewById(R.id.ps2);
        ima_boom = (ImageView)findViewById(R.id.ps3);
        
      //获取传统动画的内容.
       anim_fire=(AnimationDrawable) ima_rocket.getBackground();
       anim_boom=(AnimationDrawable) ima_boom.getBackground();
       anim_shot=AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
       //爆炸
       btn_open.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ima_rocket.setVisibility(View.VISIBLE);
				ima_boom.setVisibility(View.INVISIBLE);
				//判定是否点了点火
				if(anim_fire.isRunning())
				{ //反馈
					Toast.makeText(MainActivity.this, "已经有火了", Toast.LENGTH_SHORT).show();
				}
				else
				{
						//启动（传统）动画
						anim_fire.start();		//传统动画：动画名.start
				}
			}
		});
       btn_fire.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(anim_fire.isRunning())
			{
				ima_rocket.startAnimation(anim_shot);      //区间动画：物件名.start.(动画名)
			}
			else
			{
				Toast.makeText(MainActivity.this, "你还没点火", Toast.LENGTH_SHORT).show();
			}
			
		}
	});
        anim_shot.setAnimationListener(new AnimationListener() {
			//动画前后顺序
			@Override
			public void onAnimationStart(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				//消失的火箭
				ima_rocket.setVisibility(View.INVISIBLE);
				ima_boom.setVisibility(View.VISIBLE);
				anim_boom.start();
			}
		});
  
		
		
        		
    }
    
    
    
}
