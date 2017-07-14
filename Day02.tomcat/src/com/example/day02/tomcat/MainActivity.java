package com.example.day02.tomcat;


import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.transition.Visibility;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	   private Button btn_breath;
	   private Button btn_look;
	   private Button btn_fart;
	   private Button btn_poke;
	   private AnimationDrawable  ani_breath;
	   private ImageView pic_breath;
	   private AnimationDrawable  ani_fart;
	   private ImageView pic_fart;
	   private AnimationDrawable  ani_look;
	   private ImageView pic_look;
	   private AnimationDrawable  ani_poke;
	   private ImageView pic_poke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_breath=(Button) findViewById(R.id.breath1);
        btn_look=(Button) findViewById(R.id.look1);
        btn_fart=(Button) findViewById(R.id.fart1);
        btn_poke=(Button) findViewById(R.id.poke1);
        pic_breath=(ImageView) findViewById(R.id.picbreath);
        pic_fart=(ImageView) findViewById(R.id.picfart);
        pic_look=(ImageView) findViewById(R.id.piclook);
        pic_poke=(ImageView) findViewById(R.id.picpoke);
        ani_breath=(AnimationDrawable) pic_breath.getBackground();
        ani_look=(AnimationDrawable) pic_look.getBackground();
        ani_poke=(AnimationDrawable) pic_poke.getBackground();
        ani_fart=(AnimationDrawable) pic_fart.getBackground();
        btn_breath.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pic_fart.setVisibility(View.INVISIBLE);
				pic_look.setVisibility(View.INVISIBLE);
				pic_poke.setVisibility(View.INVISIBLE);
				pic_breath.setVisibility(View.VISIBLE);
				ani_breath.start();
			}
		});
        btn_fart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated met*hod stub
				pic_breath.setVisibility(View.INVISIBLE);
				pic_look.setVisibility(View.INVISIBLE);
				pic_poke.setVisibility(View.INVISIBLE);
				pic_fart.setVisibility(View.VISIBLE);
				ani_fart.start();
			}
		});
        btn_look.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pic_breath.setVisibility(View.INVISIBLE);
				pic_poke.setVisibility(View.INVISIBLE);
				pic_fart.setVisibility(View.INVISIBLE);
				pic_look.setVisibility(View.VISIBLE);
				ani_look.start();
			}
		});
        btn_poke.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				pic_breath.setVisibility(View.INVISIBLE);
				pic_poke.setVisibility(View.VISIBLE);
				pic_fart.setVisibility(View.INVISIBLE);
				pic_look.setVisibility(View.VISIBLE);
				ani_poke.start();
				
			}
		});
        
    }


   
    
}
