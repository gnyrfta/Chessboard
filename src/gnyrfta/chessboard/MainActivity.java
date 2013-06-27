package gnyrfta.chessboard;
/*movePiece is called twice in both ChessBoard and RetardedChess.*/
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener {
	public static int width;
	public static int height;
	public static HashMap<String,String> hm = new HashMap<String,String>();
	boolean starting=true;
	public String fromSquare="";//Square to move a piece from.
	public String toSquare="";	//Square to move a piece to.
	public String square; 		//Current touched square.
	public String thisIsThePieceToBeMoved;//Exactly what it sounds like.
	TextView tv;
	public static ChessBoard chessboard;//class that paints the chess board. 
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);//MumboJumbo
		Log.d("in onCreate","entering");
		DisplayMetrics metrics = new DisplayMetrics();//Get the dimensions of the screen.
		getWindowManager().getDefaultDisplay().getMetrics(metrics);       
		width=metrics.widthPixels;
		height=metrics.heightPixels;
		if(starting)//run this when the game is first launched. Maybe onCreate is only run when game is first launched? 
		{
			gameStart();//fills the hash map with strings "white king" "black pawn" et.c with keys "e1" "f7" etc.
			starting=false;
		}
		chessboard = new ChessBoard(this);
		setContentView(chessboard);
		chessboard.setOnTouchListener(this);
		Log.d("on Create","exiting");
	}

	@Override//Is this method necessary?:
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);//Mumbo Jumbo
		Log.d("in OnCreateOptionsMenu","");
		return true;
	}

	public String querySquare(String coordinates) //What piece is on the square?
	{
		Log.d("inquerySquare","entering");
		String thisIsAnswer = hm.get(coordinates);
		Log.d("in querySquare","this is answer_ "+thisIsAnswer);
		Log.d("inquerySquare","exiting");
		return thisIsAnswer;
	}
	public static void gameStart()//Fills the hash map according to the form <key> <value> = "a1","white rook"
	{
		Log.d("in gameStart","entering");	
		hm.put("a2","white pawn");
		hm.put("b2","white pawn");
		hm.put("c2","white pawn");
		hm.put("d2","white pawn");
		hm.put("e2","white pawn");
		hm.put("f2","white pawn");
		hm.put("g2","white pawn");
		hm.put("h2","white pawn");
		hm.put("a1","white rook");
		hm.put("b1","white knight");
		hm.put("c1","white bishop");
		hm.put("d1","white queen");
		hm.put("e1","white king");
		hm.put("f1","white bishop");
		hm.put("g1","white knight");
		hm.put("h1","white rook");
		//
		hm.put("a7", "black pawn");
		hm.put("b7", "black pawn");
		hm.put("c7", "black pawn");
		hm.put("d7", "black pawn");
		hm.put("e7", "black pawn");
		hm.put("f7", "black pawn");
		hm.put("g7", "black pawn");
		hm.put("h7", "black pawn");
		hm.put("a8", "black rook");
		hm.put("b8","black knight");
		hm.put("c8","black bishop");
		hm.put("d8","black queen");
		hm.put("e8","black king");
		hm.put("f8", "black bishop");
		hm.put("g8", "black knight");
		hm.put("h8","black rook");
		//
		hm.put("a3","empty");
		hm.put("b3","empty");
		hm.put("c3","empty");
		hm.put("d3","empty");
		hm.put("e3","empty");
		hm.put("f3","empty");
		hm.put("g3","empty");
		hm.put("h3","empty");
		//
		hm.put("a4","empty");
		hm.put("b4","empty");
		hm.put("c4","empty");
		hm.put("d4","empty");
		hm.put("e4","empty");
		hm.put("f4","empty");
		hm.put("g4","empty");
		hm.put("h4","empty");
		//
		hm.put("a5","empty");
		hm.put("b5","empty");
		hm.put("c5","empty");
		hm.put("d5","empty");
		hm.put("e5","empty");
		hm.put("f5","empty");
		hm.put("g5","empty");
		hm.put("h5","empty");
		//
		hm.put("a6","empty");
		hm.put("b6","empty");
		hm.put("c6","empty");
		hm.put("d6","empty");
		hm.put("e6","empty");
		hm.put("f6","empty");
		hm.put("g6","empty");
		hm.put("h6","empty");
		Log.d("testing","testing");
		//placing the extra pieces
		hm.put("i1","white king");
		hm.put("i2","white queen");
		hm.put("i3","white bishop");
		hm.put("j1","white knight");
		hm.put("j2","white rook");
		hm.put("j3","white pawn");
		//placing the extra black pieces:
		hm.put("i6","black king");
		hm.put("i7","black queen");
		hm.put("i8","black bishop");
		hm.put("j6","black knight");
		hm.put("j7","black rook");
		hm.put("j8","black pawn");
		//empty squares rows 9 and 10:
		hm.put("i4","empty");
		hm.put("i5","empty");
		hm.put("j4","empty");
		hm.put("j5","empty");

		Log.d("ingameStart","exiting");
	}
	public void movePiece(String from,String to)//Make changes to the hash map, vacating one square and occupying a
	{
		Log.d("this is from square "+from,"this is to square "+to);
		String number = from.substring(0,1);
		Log.d("in movePiece","this is number: "+number);
		if(!((number.equals("i"))||(number.equals("j"))))
		{	
			hm.put(from,"empty");//piece leaving square
			hm.put(to,thisIsThePieceToBeMoved);//piece arriving at square.
			Log.d("peekaboo","dude");
		}
		else
		{	
			hm.put(to,thisIsThePieceToBeMoved);	
			Log.d("in movePiece","this is outside the board");	
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) //is called on Touch.
	{
		Log.d("in onTouch","entering");
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			float xCo = event.getX();
			float yCo = event.getY();
			float squareWidthF;
			String row="";
			int i;
			int j;
			if(width<height)
			{
				squareWidthF=width/8;
			}
			else
			{
				squareWidthF=height/8;
			}
			Log.d("in OnTouch","A");
			for (i=1;i<9;i++)
			{	
				if (squareWidthF*i-squareWidthF < xCo && xCo < squareWidthF*i)
				{
					int k=i; 
					Log.d("in OnTouch","this is column "+i);
					for (j=1;j<11;j++)
					{	
						if (squareWidthF*j-squareWidthF < yCo && yCo < squareWidthF*j)
						{	
							switch(j)
							{
							case 1: row="a";
							break;
							case 2: row="b";
							break;
							case 3: row="c";
							break;
							case 4: row="d";
							break;
							case 5: row="e";
							break;
							case 6: row="f";
							break;
							case 7: row="g";
							break;
							case 8: row="h";
							break;
							case 9: row="i";
							break;
							case 10: row="j";
							break;   			
							}
							Log.d("in OnTouch","this is "+row+k);
							square = row+k;
						}
					}
				}
			}

			Log.d("in onTouch","B touch registered");
			String thisIsOnSquare = querySquare(square);
			Log.d("in onTouch","this is on this square: "+thisIsOnSquare);
			if (thisIsOnSquare.equals("empty"))
			{
				Log.d("in OnTouch","C EMPTY ");
				if(fromSquare.equals(""))
				{
					/*do nothing*/
				}
				else 
				{ 
					toSquare=square;
					/*        		fromSquare="e2";
        		toSquare="e4";*/
					Log.d("this is toSquare kkkkk+","obikabomi"+toSquare);
					Log.d("in else part","ok");
					thisIsThePieceToBeMoved=querySquare(fromSquare);
					movePiece(fromSquare,toSquare);
					chessboard.invalidate();
				}
				Log.d("in OnTouch","D");
			} 

			else
			{
				if(fromSquare.equals(""))
				{	
					fromSquare=square;
					Log.d("in OnTouch","fromSquare: "+square);
				}
				else
				{ 
					toSquare=square;
					/*        		fromSquare="e2";
        		toSquare="e4";*/
					Log.d("in onTouch","this is toSquare"+toSquare);
					thisIsThePieceToBeMoved=querySquare(fromSquare);
					movePiece(fromSquare,toSquare);
					chessboard.invalidate();
				}	
			}

			//Does this do anything?:
			boolean moveItConditionOne = !(fromSquare.equals(""))&&!(fromSquare.equals("empty"));
			boolean moveItConditionTwo = !(toSquare.equals(""))&&!(fromSquare.equals("empty"));     
			System.out.println("c1"+moveItConditionOne);
			System.out.println("c2"+moveItConditionTwo);
			if(moveItConditionTwo&&moveItConditionOne)
			{
				Log.d("in OnTouch","E");
				movePiece(fromSquare,toSquare);
				Log.d("in OnTouch","F");
				chessboard.invalidate();
				Log.d("in conditionloop","invalidating");
				Log.d("in OnTouch","G");
				fromSquare="";
				toSquare="";
			}
			Log.d("at end of on touch","this should only show once for every touch");
		}
		Log.d("in onTouch","exiting");
		return true;
	}
}
