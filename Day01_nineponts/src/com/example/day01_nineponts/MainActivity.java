package com.example.day01_nineponts;

import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button btn_buy,btn_start;
    private  ImageButton b11,b12,b13,b21,b23,b31,b32,b33;
    private  ImageButton images[]=new ImageButton[8];
    private Handler handler;
    private  AnimThread animThread;
    private StopAnim stopAnim;
    private int count=1;
    private  String  name[]={"EXO","吴亦凡","皮卡丘","基德","西瓜","哆啦A梦","恐龙","小新"};
    private String namez,namex,duzhuz;
    private  int money,duzhuz1;
    private TextView  text_money;
    private int loc;

    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView(); 
        //handler,接收次线程msg
        //text_money.setText();
        money=10000;
        text_money=(TextView ) findViewById(R.id.textmoney);
    
        
        
        handler=new Handler()    //handler
        {
        	public void handleMessage(Message msg) {
        		super.handleMessage(msg);
        		if(msg.what==11)
        		{
        			animThread.isStop=false;
        			String stopName=getResult();
        			namex=stopName;
        			//判断时候相同
        			if(namex.equals(namez))
        			{
        				duzhuz1=Integer.parseInt(duzhuz);
        			    money=money+duzhuz1;
        			   Toast.makeText(MainActivity.this, "恭喜,是"+stopName+"，你赢了"+duzhuz1, Toast.LENGTH_SHORT).show();
        			   text_money.setText("剩余"+money+"金币");
        			}
        			else
        			{
        				duzhuz1=Integer.parseInt(duzhuz);
        			    money=money-duzhuz1;
        				Toast.makeText(MainActivity.this, "你输了!  不是"+namez+"，你输了"+duzhuz1, Toast.LENGTH_SHORT).show();
        				 text_money.setText("剩余"+money+"金币");
        				 if(money<0)
        				 {
        					 
        				 }
        			}
        		
        			
        		}
        		else
        		{
        		anim(msg.what);
        		}
        	}
        };
        //animthread
        animThread=new AnimThread();
        stopAnim=new StopAnim();
        //buy跳转
        btn_buy.setOnClickListener(new OnClickListener() {
			//buybutton
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,xiazhu.class);
				startActivityForResult(intent, 200);
			}
		});
        //start跳转
        btn_start.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(count==1)
				 {
					animThread.start();
				    stopAnim.start();
				    count=2;
				 }
				else
				{
					if(animThread.isStop)
					{
						Toast.makeText(MainActivity.this, "别再点了，呵呵", Toast.LENGTH_SHORT).show();
					}
					else{
					animThread=new AnimThread();
			        stopAnim=new StopAnim();
				    animThread.start();
				    animThread.isStop=true;
				    stopAnim.start();
					}
				}
				
			}
		});
      
     }
    //view集体定义
    public void  intView()
    {
    	b11=(ImageButton) findViewById(R.id.b11);
    	b12=(ImageButton) findViewById(R.id.b12);
    	b13=(ImageButton) findViewById(R.id.b13);
    	b21=(ImageButton) findViewById(R.id.b21);
    	b23=(ImageButton) findViewById(R.id.b23);
    	b31=(ImageButton) findViewById(R.id.b31);
    	b32=(ImageButton) findViewById(R.id.b32);
    	b33=(ImageButton) findViewById(R.id.b33);
    	
    	btn_buy=(Button) findViewById(R.id.btn_1);
    	btn_start=(Button) findViewById(R.id.btn_2);
      	images[0]=b11;
      	images[1]=b12;
      	images[2]=b13;
      	images[3]=b23;
      	images[4]=b33;
      	images[5]=b32;
      	images[6]=b31;
      	images[7]=b21;
      	
    }
  //主线程anim
    public void anim(int a ) 
    {
    	for(int j=0;j<8;j++)
    	{
    		images[j].setClickable(false);
    	}
    	int i=0;
    	i=loc; //全局变量，怎么把值传递过来
      for( i=0;i<8;i++)
    	{
    		if(i==a)
    		{  
    			images[i].setBackgroundResource(R.drawable.btn_bg);         		
    			images[i].setClickable(true);
    		}
    		else
    		{
    		   images[i].setBackgroundColor(Color.TRANSPARENT);//tans透明
    		   images[i].setClickable(false);
          	}
    	}
    }
    class AnimThread extends Thread //执行线程animthread
    {
  
           public boolean isStop=true;
           	public void run() {      //run
           		// TODO Auto-generated method stub
           		super.run();
           		int index=0;
           		while (isStop)
           		{
           		   handler.sendEmptyMessage(index++);
           		   try {
					Thread.sleep(200);
			    	} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			    	}
           		   if(index>7)
           		   {
           			   index=0;
           		   }
           		}
           	}
      }
    class StopAnim extends Thread//结束进程
    {
    	public void run()
    	{
    		super.run();
    		try {
    			Random rand =new Random();
    			int  time=rand.nextInt(7)+2;
				Thread.sleep(1000*time);//设置动画的生命周期
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		handler.sendEmptyMessage(11);
    		
    	}
    }
    public String getResult()
    {
    	String now_name=null;
    	for(int i=0;i<8;i++)
    	{	
    		if(images[i].isClickable())
    		{
    			now_name=name[i];
    		}	
    	}
		return now_name;
    }
    //反馈结果
    protected void onActivityResult(int A1, int A2, Intent data) { //onactivityresult
    	// TODO Auto-generated method stub
    	super.onActivityResult(A1, A2, data);   
       namez=data.getStringExtra("name");
       duzhuz=data.getStringExtra("duzhu");
       //可去"
    	Toast.makeText(MainActivity.this, "你下注"+namez+duzhuz, Toast.LENGTH_LONG).show(); //toast show 出接收到的反馈结果
  
    }
    
    
    
}
