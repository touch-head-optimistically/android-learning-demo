package com.ysw793377164.day01_qq;


import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game3_Main extends Activity {

	private ImageView game3_imv_1, game3_imv_2, game3_imv_3, game3_imv_4,
	                  game3_imv_6, game3_imv_7, game3_imv_8, game3_imv_9;
	private Button game3_bet, game3_start;
	private TextView game3_money;
	private ImageView game3_IVS[] = new ImageView[8];
	private Handler game3_handler;
	private CircleThread game3_circlethread;
	private StopThread game3_stopthread;
	private int game3_count = 1;
	private String game3_name[] = {"»úÆ÷ÈË","ÎüÑª¹í","½£¼§","ÑÇË÷","Ö©Öë","°¢Àê","»Æ¼¦","·¢Ìõ"};
	private String game3_resname, game3_nowmoney, game3_betname = null, game3_betmoney = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game3_main);
		InitView();
		
		game3_handler = new Handler()
		{
			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				if (msg.what == 8)
				{
					game3_circlethread.isStop = false;
					if (game3_betname != null && game3_betmoney !=null)
					{
						game3_resname = GetResult();
						if (game3_resname.equals(game3_betname))
						{
							Toast.makeText(Game3_Main.this, "¹§Ï²£¡ÊÇ"+game3_resname+"Å¶~", Toast.LENGTH_LONG).show();
							game3_money.setText(Integer.toString(Integer.valueOf(game3_nowmoney).intValue() + (Integer.valueOf(game3_betmoney).intValue()) * 2));
							game3_nowmoney = game3_money.getText().toString().trim();
						}
						else
						{
							Toast.makeText(Game3_Main.this, "Äã¿ÉÕæÊÇ¸ö´ÀÂ¿£¡", Toast.LENGTH_LONG).show();
						}
						game3_betname = null;
						game3_betmoney = null;
					}
				}
			 	else
				{
					Circle(msg.what);
				}
			}
		};
		
		game3_bet.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Game3_Main.this, Game3_Bet.class);
				startActivityForResult(intent, 1000);
			}
		});
		
		game3_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (game3_count == 1)
				{
					game3_circlethread.start();
					game3_stopthread.start();
					game3_count = 2;
				}
				else
				{
					if (game3_circlethread.isStop)
					{
						Toast.makeText(Game3_Main.this, "NO!!!", Toast.LENGTH_SHORT).show();
					}
					else
					{
						game3_circlethread = new CircleThread();
						game3_stopthread = new StopThread();
						game3_circlethread.isStop = true;
						game3_circlethread.start();
						game3_stopthread.start();
					}
				}
			}
		});
	}
	
	public void InitView()
	{
		game3_imv_1 = (ImageView) findViewById(R.id.game3_image_1);
		game3_imv_2 = (ImageView) findViewById(R.id.game3_image_2);
		game3_imv_3 = (ImageView) findViewById(R.id.game3_image_3);
		game3_imv_4 = (ImageView) findViewById(R.id.game3_image_4);
		game3_imv_6 = (ImageView) findViewById(R.id.game3_image_6);
		game3_imv_7 = (ImageView) findViewById(R.id.game3_image_7);
		game3_imv_8 = (ImageView) findViewById(R.id.game3_image_8);
		game3_imv_9 = (ImageView) findViewById(R.id.game3_image_9);
		game3_IVS[0] = game3_imv_2;
		game3_IVS[1] = game3_imv_3;
		game3_IVS[2] = game3_imv_6;
		game3_IVS[3] = game3_imv_9;
		game3_IVS[4] = game3_imv_8;
		game3_IVS[5] = game3_imv_7;
		game3_IVS[6] = game3_imv_4;
		game3_IVS[7] = game3_imv_1;
		game3_circlethread = new CircleThread();
		game3_stopthread = new StopThread();
		game3_bet = (Button) findViewById(R.id.game3_bet);
		game3_start = (Button) findViewById(R.id.game3_start);
		game3_money = (TextView) findViewById(R.id.game3_money);
		game3_nowmoney = game3_money.getText().toString().trim();
	}
	
	public void Circle (int a)
	{
		for (int j = 0; j < 8; j++)
		{
			game3_IVS[j].setClickable(false);
		}
		for (int i = 0; i < 8; i++)
		{
			if (i == a)
			{
				game3_IVS[i].setBackgroundResource(R.drawable.shape);
				game3_IVS[i].setClickable(true);
			}
			else
			{
				game3_IVS[i].setBackgroundColor(Color.TRANSPARENT);
				game3_IVS[i].setClickable(false);
			}
		}
	}
	
	class CircleThread extends Thread
	{
		public boolean isStop = true;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			int index = 0;
			while (isStop)
			{
				game3_handler.sendEmptyMessage(index);
				index = (index + 1) % 8;
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	class StopThread extends Thread
	{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try {
				Random rand = new Random();
				int time = rand.nextInt(7) + 2;
				sleep(time * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			game3_handler.sendEmptyMessage(8);
		}
	}
	
	public String GetResult()
	{
		String now_name = "";
		for (int i = 0; i < 8; i++)
		{
			if (game3_IVS[i].isClickable())
			{
				now_name = game3_name[i];
			}
		}
		return now_name;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1000 && resultCode == 2000)
		{
			game3_betname = data.getStringExtra("Ó¢ÐÛ");
			game3_betmoney = data.getStringExtra("½ð±Ò"); 
			game3_money.setText(Integer.toString(Integer.valueOf(game3_nowmoney).intValue() - Integer.valueOf(game3_betmoney).intValue()));
			game3_nowmoney = game3_money.getText().toString().trim();
		}
	}
}
