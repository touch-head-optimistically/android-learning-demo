package com.ysw793377164.day01_qq;

import java.util.Random;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Game1_Main extends Activity {
	private ImageView image;
	private AnimationDrawable aq;
	private TextView text[] = new TextView[4];
	private Button again;
	private int count = 0, t[] = new int[4];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game1_main);
		image = (ImageView) findViewById(R.id.game1_image);
		aq = (AnimationDrawable) image.getBackground();
		aq.start();
		text[0] = (TextView) findViewById(R.id.game1_t0);
		text[1] = (TextView) findViewById(R.id.game1_t1);
		text[2] = (TextView) findViewById(R.id.game1_t2);
		text[3] = (TextView) findViewById(R.id.game1_t3);
		again = (Button) findViewById(R.id.game1_again);
		
		again.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				for (int i = 0; i < 4; i++)
				{
					text[i].setVisibility(View.INVISIBLE);
				}
				again.setVisibility(View.INVISIBLE);
				image.setClickable(true);
				count = 0;
			}
		});

		image.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub							
				Random rand = new Random();
				int r = rand.nextInt(99) + 1;
				t[count] = r;
				text[count].setText("室友" + (count+1) + "抽到了" + t[count]);
				text[count].setVisibility(View.VISIBLE);
				if (count == 3)
				{
					int index = MinIndex(t);
					if (index == -1)
					{
						Toast.makeText(Game1_Main.this, "最小值相同，请重新开始！", Toast.LENGTH_LONG).show();
					}
					else
					{
						Toast.makeText(Game1_Main.this, "最小值为" + t[index] + "，室友" + (index+1) + "请去拿外卖！", Toast.LENGTH_LONG).show();
					}
					again.setVisibility(View.VISIBLE);
					image.setClickable(false);
				}
				else
					count++;
			}
		});
	}
	//返回数组最小值的下标，若两个最小值相同，则返回-1
	public int MinIndex(int t[])
	{
		int min = t[0], index = 0;
		boolean flag = true;
		for (int i = 1; i < t.length; i++)
		{
			if (t[i] == min)
			{
				flag = false;
				break;
			}
			else if (t[i] < min)
			{
				min = t[i];
				index = i;
			}
		}
		if (flag)
			return index;
		else
			return -1;
	}
}