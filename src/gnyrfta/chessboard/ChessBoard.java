package gnyrfta.chessboard;
//
//Draws the chess board and the pieces.
//

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
public class ChessBoard extends View {
	//Constructor: 
	Paint p = new Paint();
	private Drawable whitePawn;
	private Drawable blackPawn;
	private Drawable whiteRook;
	private Drawable blackRook;
	private Drawable whiteKnight;
	private Drawable blackKnight;
	private Drawable whiteBishop;
	private Drawable blackBishop;
	private Drawable whiteQueen;
	private Drawable blackQueen;
	private Drawable whiteKing;
	private Drawable blackKing;

	public float squareWidthF;
	public int squareWidthI;
	private Bitmap drawGraph;
	private boolean starting=true;
	public ChessBoard(Context context) {
		super(context);
		setFocusable(true);
		Log.d("in constructor","beginning");
		//Define square width:
		int width = MainActivity.width;
		int height = MainActivity.height;
		Log.d("this is MainActivity.width",""+width);
		Log.d("this is MainActivity.height",""+height);
		Bitmap bitmap = Bitmap.createBitmap(height,width,Bitmap.Config.RGB_565);
		if(width<height)
		{
			squareWidthF=width/8;
		}
		else
		{
			squareWidthF=height/8;
		}
		squareWidthI=(int)squareWidthF;
		//Get the pawn image:
			whitePawn = context.getResources().getDrawable(R.drawable.pawnwwooden);
			whiteRook = context.getResources().getDrawable(R.drawable.rookwwooden);
			whiteKnight = context.getResources().getDrawable(R.drawable.knightwwooden);
			blackPawn = context.getResources().getDrawable(R.drawable.pawnbwooden);
			blackRook = context.getResources().getDrawable(R.drawable.rookbwooden);
			blackKnight = context.getResources().getDrawable(R.drawable.knightbwooden);
			whiteBishop = context.getResources().getDrawable(R.drawable.bishopwwooden);
			blackBishop = context.getResources().getDrawable(R.drawable.bishopbwooden);
			whiteQueen = context.getResources().getDrawable(R.drawable.queenwwooden);
			blackQueen = context.getResources().getDrawable(R.drawable.queenbwooden);
			whiteKing = context.getResources().getDrawable(R.drawable.kingwwooden);
			blackKing = context.getResources().getDrawable(R.drawable.kingbwooden);
			Log.d("in constructor","exiting");
	}
	protected void onDraw(Canvas canvas) {
		Log.d("in onDraw","entering");
		// super.onDraw(canvas);
		Canvas singleUseCanvas = new Canvas();      
		//is this bitmap ever used?:
		drawGraph = Bitmap.createBitmap(canvas.getWidth(),canvas.getHeight(),Bitmap.Config.ARGB_8888);      
		singleUseCanvas.setBitmap(drawGraph);   

		canvas.drawBitmap(drawGraph, 100, 100, null);
		canvas.drawColor(Color.BLUE);//Background      
		p.setColor(Color.WHITE);
		drawBoard(canvas);
		if(starting)
		{	
			drawGameStart(canvas);
			starting=false;
		}
		else
		{
			drawCurrentPosition(canvas);
		}

		Log.d("in onDraw","exiting");
	}
	private void drawBoard(Canvas canvas)
	{
		Log.d("In drawBoard","entering");

		int i=0;
		int j=0;
		for (j=0;j<8;j++)
		{
			for (i=0;i<8;i++)
			{
				if(i%2==0)
				{   
					if(j%2==0)
					{	
						p.setColor(Color.BLACK);
					}
					else if (j%2==1)
					{
						p.setColor(Color.WHITE);
					}
				}
				else if(i%2==1)
				{   
					if(j%2==0)
					{	
						p.setColor(Color.WHITE);
					}
					else if(j%2==1)
					{
						p.setColor(Color.BLACK);     		
					}
				}


				canvas.drawRect(new RectF(0+i*squareWidthI,0+j*squareWidthI,i*squareWidthI+squareWidthI,squareWidthI+j*squareWidthI),p);

			}
		} 
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		int boardLength = squareWidthI*8;

		Log.d("this is canvas width",""+w);
		Log.d("this is canvas height",""+h);
		Log.d("this is board length: ",""+boardLength);
		Log.d("in drawBoard","exiting");
	}

	private void drawWhitePawn(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		whitePawn.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		whitePawn.draw(canvas);
	}
	private void drawWhiteRook(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		whiteRook.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		whiteRook.draw(canvas);
	}
	private void drawBlackRook(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		blackRook.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		blackRook.draw(canvas);
	}
	private void drawWhiteKnight(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		whiteKnight.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		whiteKnight.draw(canvas);
	}
	private void drawBlackKnight(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		blackKnight.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		blackKnight.draw(canvas);
	}
	private void drawWhiteBishop(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		whiteBishop.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		whiteBishop.draw(canvas);
	}
	private void drawBlackBishop(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		blackBishop.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		blackBishop.draw(canvas);
	}
	private void drawBlackQueen(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		blackQueen.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		blackQueen.draw(canvas);
	}
	private void drawWhiteQueen(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		whiteQueen.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		whiteQueen.draw(canvas);
	}
	private void drawWhiteKing(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		whiteKing.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		whiteKing.draw(canvas);
	}
	private void drawBlackKing(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		blackKing.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		blackKing.draw(canvas);
	}
	private void drawBlackPawn(Canvas canvas,int posX, int posY)
	{
		//I want the image to be the same size as the square, so I don't need to worry about positioning.  
		// Rect imageBounds = canvas.getClipBounds();  // Adjust this for where you want it
		blackPawn.setBounds(posX,posY,posX+squareWidthI,posY+squareWidthI);
		blackPawn.draw(canvas);
	}

	private void drawGameStart(Canvas canvas)
	{
		Log.d("in drawGameStart","entering");
		//White Pieces:
		int i;
		//Draw white pawns on top row:
		for(i=0;i<8;i++)
		{
			drawWhitePawn(canvas,squareWidthI,i*squareWidthI);
			drawBlackPawn(canvas,squareWidthI*6,i*squareWidthI);
		}
		drawWhiteRook(canvas,0,0);
		drawWhiteRook(canvas,0,7*squareWidthI);
		drawWhiteKnight(canvas,0,squareWidthI);
		drawWhiteKnight(canvas,0,squareWidthI*6);
		drawWhiteBishop(canvas,0,2*squareWidthI);   	
		drawWhiteBishop(canvas,0,5*squareWidthI); 
		drawWhiteQueen(canvas,0,3*squareWidthI);
		drawWhiteKing(canvas,0,4*squareWidthI);    
		//Black Pieces:

			//Draw  pawns on top and bottom row:

		drawBlackRook(canvas,squareWidthI*7,0);
		drawBlackRook(canvas,squareWidthI*7,7*squareWidthI);
		drawBlackKnight(canvas,squareWidthI*7,squareWidthI);
		drawBlackKnight(canvas,squareWidthI*7,squareWidthI*6);
		drawBlackBishop(canvas,squareWidthI*7,2*squareWidthI);   	
		drawBlackBishop(canvas,squareWidthI*7,5*squareWidthI); 
		drawBlackQueen(canvas,squareWidthI*7,3*squareWidthI);
		drawBlackKing(canvas,squareWidthI*7,4*squareWidthI);
		Log.d("inDrawGameStart","extra pieces follow now.");
		//Drawing white extra pieces:
		drawWhiteKing(canvas,0,8*squareWidthI);
		drawWhiteQueen(canvas,squareWidthI,8*squareWidthI);
		drawWhiteBishop(canvas,squareWidthI*2,8*squareWidthI);
		drawWhiteKnight(canvas,0,9*squareWidthI);
		drawWhiteRook(canvas,squareWidthI,9*squareWidthI);
		drawWhitePawn(canvas,squareWidthI*2,9*squareWidthI);
		//Drawing black extra pieces:
		drawBlackKing(canvas,squareWidthI*5,8*squareWidthI);
		drawBlackQueen(canvas,squareWidthI*6,8*squareWidthI);
		drawBlackBishop(canvas,squareWidthI*7,8*squareWidthI);
		drawBlackKnight(canvas,squareWidthI*5,9*squareWidthI);
		drawBlackRook(canvas,squareWidthI*6,9*squareWidthI);
		drawBlackPawn(canvas,squareWidthI*7,9*squareWidthI);
		Log.d("inDrawGameStart","exiting");
	}
	private void drawCurrentPosition(Canvas canvas)
	{
		Log.d("in drawCurrentPosition","entering");
		//make sure the reserve pieces are where they should be:
		MainActivity.hm.put("i1","white king");
		MainActivity.hm.put("i2","white queen");
		MainActivity.hm.put("i3","white bishop");
		MainActivity.hm.put("j1","white knight");
		MainActivity.hm.put("j2","white rook");
		MainActivity.hm.put("j3","white pawn");

		MainActivity.hm.put("i6","black king");
		MainActivity.hm.put("i7","black queen");
		MainActivity.hm.put("i8","black bishop");
		MainActivity.hm.put("j6","black knight");
		MainActivity.hm.put("j7","black rook");
		MainActivity.hm.put("j8","black pawn");
		//empty squares rows i and j:
		MainActivity.hm.put("i4","empty");
		MainActivity.hm.put("i5","empty");
		MainActivity.hm.put("j4","empty");
		MainActivity.hm.put("j5","empty");
		//iterate through the board squares: 
		String[] rows = {"a","b","c","d","e","f","g","h"};
		String[] columns = {"1","2","3","4","5","6","7","8"};
		String piece="";
		int i;
		int j;
		for(i=0;i<8;i++)
		{	
			//this should go in an own method:
			for(j=0;j<8;j++)
			{	
				String test = rows[i]+columns[j];
				Log.d("this is test: ",test);
				try
				{
					piece = MainActivity.hm.get(test);
					Log.d("the piece on the square is"+piece,"in drawCurrenPosition");
				}catch(Exception ex){}
				if(piece.equals("white pawn"))
				{
					drawWhitePawn(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("white rook"))
				{
					drawWhiteRook(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("white knight"))
				{
					drawWhiteKnight(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("white bishop"))
				{
					drawWhiteBishop(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("white queen"))
				{
					drawWhiteQueen(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("white king"))
				{
					drawWhiteKing(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("black pawn"))
				{
					drawBlackPawn(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("black rook"))
				{
					drawBlackRook(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("black knight"))
				{
					drawBlackKnight(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("black bishop"))
				{
					drawBlackBishop(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("black queen"))
				{
					drawBlackQueen(canvas,squareWidthI*j,squareWidthI*i);
				}
				if(piece.equals("black king"))
				{
					drawBlackKing(canvas,squareWidthI*j,squareWidthI*i);
				}
			}
		}
		//Drawing white extra pieces:
		drawWhiteKing(canvas,0,8*squareWidthI);
		drawWhiteQueen(canvas,squareWidthI,8*squareWidthI);
		drawWhiteBishop(canvas,squareWidthI*2,8*squareWidthI);
		drawWhiteKnight(canvas,0,9*squareWidthI);
		drawWhiteRook(canvas,squareWidthI,9*squareWidthI);
		drawWhitePawn(canvas,squareWidthI*2,9*squareWidthI);
		//Drawing black extra pieces:
		drawBlackKing(canvas,squareWidthI*5,8*squareWidthI);
		drawBlackQueen(canvas,squareWidthI*6,8*squareWidthI);
		drawBlackBishop(canvas,squareWidthI*7,8*squareWidthI);
		drawBlackKnight(canvas,squareWidthI*5,9*squareWidthI);
		drawBlackRook(canvas,squareWidthI*6,9*squareWidthI);
		drawBlackPawn(canvas,squareWidthI*7,9*squareWidthI);
		Log.d("in drawCurrentPosition","exiting");
	}    
}

