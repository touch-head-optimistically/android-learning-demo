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
	//����imageview,�ڴ�ͳ�����������ؿؼ�.�����䶯���д���ִ�ж���
	private ImageView  ima_rocket;
	//��ͳ�����Ķ�����
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
        
      //��ȡ��ͳ����������.
       anim_fire=(AnimationDrawable) ima_rocket.getBackground();
       anim_boom=(AnimationDrawable) ima_boom.getBackground();
       anim_shot=AnimationUtils.loadAnimation(MainActivity.this, R.anim.move);
       //��ը
       btn_open.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ima_rocket.setVisibility(View.VISIBLE);
				ima_boom.setVisibility(View.INVISIBLE);
				//�ж��Ƿ���˵��
				if(anim_fire.isRunning())
				{ //����
					Toast.makeText(MainActivity.this, "�Ѿ��л���", Toast.LENGTH_SHORT).show();
				}
				else
				{
						//��������ͳ������
						anim_fire.start();		//��ͳ������������.start
				}
			}
		});
       btn_fire.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(anim_fire.isRunning())
			{
				ima_rocket.startAnimation(anim_shot);      //���䶯���������.start.(������)
			}
			else
			{
				Toast.makeText(MainActivity.this, "�㻹û���", Toast.LENGTH_SHORT).show();
			}
			
		}
	});
        anim_shot.setAnimationListener(new AnimationListener() {
			//����ǰ��˳��
			@Override
			public void onAnimationStart(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				//��ʧ�Ļ��
				ima_rocket.setVisibility(View.INVISIBLE);
				ima_boom.setVisibility(View.VISIBLE);
				anim_boom.start();
			}
		});
  
		
		
        		
    }
    
    
    
}
