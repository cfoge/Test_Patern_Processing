import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import interfascia.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tesp_pattern_11 extends PApplet {





PGraphics pg;

GUIController c;
IFButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10 , b11 , b12 , b13 , b14 , b15, export;
IFTextField w,h;


//Start defining the elements we want off and on
boolean crossON = true; 
boolean outlineON = false; 
boolean outline2ON = false;
boolean centXON = false; 
boolean circON = false;
boolean circQUAD =false;
boolean gridON = false;
boolean bigGRID = false;
boolean GridtextON = false;
boolean cheker = false; 
boolean barsON = false; 
boolean RBGREAD = false; 
boolean colBARSON = true;
boolean highFreq = true;
boolean framesizeTXT = true;
boolean exportbool = false;

boolean loadTP = true;

int enter1 = 0;

//DEFINE TEST PATTERN
int x = 640;
int y = 480;

int bg = color(150, 150, 150);
int bgHL = color(230, 230, 0);

int checkker = color(204, 102, 0);
int lineA = color(200, 200, 200);

int div = 10;

//crosshair definitions
int chBOLD = 1;
int crosshair = color(255, 0, 0);
// end crosshair defintions

//outline definitions
int olBOLD = 1;
int outline = color(255, 255, 255);

//end outline definitions

//circles
int circBOLD = 1;
int circ = color(0, 255, 0);
int circsize = 8;
//end circles

//grid
//find greatest common denominator



//

int grid1 = color(80, 80, 80);
int videoScale1 = 16; //lower numbers = tighter grid// must be 5,10,16,20,32

int grid2 = color(200, 200, 200);
int videoScale2 = 32; //lower numbers = tighter grid// must be 5,10,16,20,32

PImage img;  // Declare variable "a" of type PImage


//grid done

// use pre defined selections and a case statement to get the corect size

//end define
public void setup(){
  



//noStroke();
//frameRate(25);
textSize(11);
thread("guiSetup");

//noLoop();
}

public void draw(){

if(enter1 == 0){
   noStroke();
   fill(130);
   rect(0, 0, width, 150);
   fill(40);
   rect(0, 150, width, height);
   textSize(15);
   fill(255,255,0);
   text("Size:", 268 , 40);  
   text("x", 382 , 40);
   text("px", 467 , 40);
  //thread("buildGUIdisp");    
  buildTP();
  enter1 = 1;
}
//clear();

textSize(11);
}




public void actionPerformed (GUIEvent e) {
  if (e.getSource() == b1) {
    crossON = !crossON;
    buildTP();
    //redraw();
  } else if (e.getSource() == b2) {
    
    outlineON = !outlineON;
    buildTP();
    //redraw();
  
  
    } else if (e.getSource() == b3) {
    
    outline2ON = !outline2ON;
    buildTP();
    //redraw();
  
  
    } else if (e.getSource() == b4) {
    
    centXON = !centXON;
     buildTP();
    //redraw();
  } else if (e.getSource() == b5) {
    
    circON = !circON;
     buildTP();
    //redraw();
  }  else if (e.getSource() == b6) {
    
    circQUAD = !circQUAD;
     buildTP();
    //redraw();
  } else if (e.getSource() == b7) {
    
    gridON = !gridON;
     buildTP();
    //redraw();
  } else if (e.getSource() == b8) {
    
    bigGRID = !bigGRID;
     buildTP();
    //redraw();
  } else if (e.getSource() == b9) {
    
    GridtextON = !GridtextON;
     buildTP();
    //redraw();
  } else if (e.getSource() == b10) {
    
    cheker = !cheker;
     buildTP();
    //redraw();
  } else if (e.getSource() == b11) {
    
    barsON = !barsON;
     buildTP();
    //redraw();
  } else if (e.getSource() == b12) {
    
    RBGREAD = !RBGREAD;
     buildTP();//redraw();
  } else if (e.getSource() == b13) {
    
    colBARSON = !colBARSON;
     buildTP();//redraw();
  } else if (e.getSource() == b14) {
    
    highFreq = !highFreq;
     buildTP();//redraw();
  } else if (e.getSource() == b15) {
    
    framesizeTXT = !framesizeTXT;
     buildTP();//redraw();
  } 
  if (e.getMessage().equals("Completed")) {
    x= PApplet.parseInt(w.getValue());
    y= PApplet.parseInt(h.getValue());
     buildTP();
    //redraw();
    w.setValue("");
    h.setValue("");
  }


if (e.getSource() == export) {
    
    exportbool = true;
    buildTP();
    exportbool = false;
   
  } 
  
}
public void crosshairs(int x,int y) {

//crosshairs
pg.stroke(crosshair);
pg.strokeWeight(chBOLD);  

//center cross
  
pg.line(x/2 - 10, y/2, x/2 + 10, y/2);
pg.line(x/2 , y/2 - 10, x/2 , y/2 + 10);

//side lines
pg.line(0, y/2, 10, y/2);
pg.line(x, y/2, x-10, y/2);

//top and bottom
pg.line(x/2, 0, x/2, 10);
pg.line(x/2, y-10, x/2, y);

}

public void outline(int x,int y) {
//outline
pg.stroke(outline);
pg.strokeWeight(olBOLD);  
pg.noFill();
pg.rect(0, 0, x-1, y-1);
}

public void centerX(int x,int y) {
//outline
pg.stroke(outline);
pg.strokeWeight(olBOLD);  
pg.line(0, 0, x, y);
pg.line(0, y, x, 0);
}

public void outlineINSIDE(int x,int y) {
//outline
pg.stroke(outline);
pg.strokeWeight(olBOLD);  
pg.noFill();
pg.rectMode(CENTER);
pg.rect(x/2, y/2, (x/1.1f),(y/1.1f));
pg.rectMode(CORNER);
}


public void circ(boolean fiveCirc, int x,int y) {
pg.stroke(circ);
pg.strokeWeight(circBOLD);  
pg.ellipseMode(RADIUS);
pg.circle(x/2, y/2, y/circsize);

if(fiveCirc ==true){
//other circ
pg.circle(20+(y/circsize), 20+(y/circsize), y/circsize);
pg.circle(20+(y/circsize), y-20-(y/circsize), y/circsize);

pg.circle(x-20-(y/circsize), 20+(y/circsize), y/circsize);
pg.circle(x-20-(y/circsize), y-20-(y/circsize), y/circsize);

}
}

public void grid(boolean bigGRID, boolean textON, int x,int y){
pg.textSize(10);

if(bigGRID == true){
int cols = x/videoScale1;
 int  rows = y/videoScale1;

  // Begin loop for columns
  for (int i = 0; i < cols; i++) {
    // Begin loop for rows
    for (int j = 0; j < rows; j++) {

      // Scaling up to draw a rectangle at (x,y)
      int xg = i*videoScale1;
      int yg = j*videoScale1;
      if ((cheker == true) && ((j%2 == 0) ^  (i%2 == 0))) {
        pg.fill(grid1);
      } else {
        pg.noFill();
      }
     
      pg.stroke(grid1);
      // For every column and row, a rectangle is drawn at an (x,y) location scaled and sized by videoScale.
      pg.rect(xg, yg, videoScale1, videoScale1);
    }
  }
  }

  
 int colsB = x/videoScale2;
 int  rowsB = y/videoScale2;

  // Begin loop for columns
  for (int i = 0; i < colsB; i++) {
    // Begin loop for rows
    for (int j = 0; j < rowsB; j++) {

      // Scaling up to draw a rectangle at (x,y)
      int xg = i*videoScale2;
      int yg = j*videoScale2;
     pg.noFill();
      pg.stroke(grid2);
      // For every column and row, a rectangle is drawn at an (x,y) location scaled and sized by videoScale.
      pg.rect(xg, yg, videoScale2, videoScale2);
      
       if (textON == true) {
      pg.fill(255);
      pg.text(i + ((j-1)*colsB), xg, yg);        
      }   
    }
  }
}


public void bars(int x,int y) {
//grey bars
//devide width by numbe rof bars
int numcols = 10;
int cothick = 25;
int numbars = x/(numcols);

 pg.noStroke();
 
for (int i = 1; i < numcols-1; i++) {
  pg.fill((255/numcols+1)*i);
pg.rect(numbars*i, y/4, numbars, cothick);
}
//end grey bars

//colour bars
//devide width by numbe rof bars



if(RBGREAD == true){
  pg.noStroke();
for (int i = 4; i < (numcols*4)-7; i++) {

pg.fill(255-(i*numcols*1.5f)%255,0,(i*numcols*1.5f)%255);///work out colour mode for rainbow

pg.rect(numbars*i/4, y/4+cothick, numbars, cothick);
}
//end colur bars
}
}

public void colorBars(int x,int y){
  pg.noStroke();
for (int i = 0; i < 8; i++) {

switch(i) {
  case 0: 
    pg.fill(255,255,255);///work out colour mode for rainbow
  break;
  case 1: 
    pg.fill(255,255,0);///work out colour mode for rainbow
  break;
  case 2: 
    pg.fill(0,255,255);///work out colour mode for rainbow
  break;
  case 3: 
    pg.fill(0,255,0);///work out colour mode for rainbow
  break;
  case 4: 
    pg.fill(255,0,255);///work out colour mode for rainbow
  break;
  case 5: 
   pg.fill(255,0,0);///work out colour mode for rainbow
  break;
  case 6: 
    pg.fill(0,0,255);///work out colour mode for rainbow
  break;
  case 7: 
    pg.fill(0,0,0);///work out colour mode for rainbow
  break;  
  }

pg.rect(x/10 * i + (x/10), y-y/2.5f, x/10, y/5);
}
}

public void highFreq(int x,int y){
  pg.strokeCap(SQUARE);
  //use push pop matrix to plac
  
pg.pushMatrix();
pg.translate(x/15, y/15);
 for (int i = 0; i <= 17; i++) {
   pg.stroke((i%2)*255);
    pg.strokeWeight(i/2);  
      pg.line(i*i/4,0,i*i/4 ,20);
  }
pg.popMatrix();

pg.pushMatrix();
pg.translate(x/15, y - y/10);
 for (int i = 0; i <= 17; i++) {
      pg.stroke((i%2)*255);
      pg.strokeWeight(i/2);  
      pg.line(i*i/4,0,i*i/4 ,20);
  }
pg.popMatrix();

pg.pushMatrix();
pg.translate(x - x/15, y - y/10);
 for (int i = 17; i >= 0; i--) {
      pg.stroke((i%2)*255);
      pg.strokeWeight(i/2);  
      pg.line(-i*i/4,0,-i*i/4 ,20);
  }
pg.popMatrix();

pg.pushMatrix();
pg.translate(x - x/15, y/15);
 for (int i = 17; i >= 0; i--) {
      pg.stroke((i%2)*255);
      pg.strokeWeight(i/2);  
     pg.line(-i*i/4,0,-i*i/4 ,20);
  }
pg.popMatrix();

 
}

public void framesizeTXT(int x,int y){
pg.fill(255);
pg.strokeWeight(1); 
pg.stroke(255,0,0);
pg.rectMode(CENTER);
pg.rect(x/2, y - y/8, 100 ,20);
pg.rectMode(CORNER);
pg.fill(0);
String wid = str(x);
String hig = str(y);
String dimiXY = wid + " X " + hig;
pg.textAlign(CENTER);
pg.textSize(16);
pg.text(dimiXY, x/2 , y - y/8 + 6);  
pg.textSize(11);
pg.textAlign(LEFT);
}
public void buildTP(){
      img = loadImage("LOGO.png");  // Load the image into the program 
  image(img, 10, 0, img.width/2, img.height/2);

 if((x > 2000)||(y > 2000)){
x= 1920;
y= 1080;
}  

 
pg = createGraphics(x, y, P2D);
//pg.smooth(4);
pg.beginDraw();
pg.background(100);

if(gridON == true){
  grid(bigGRID, GridtextON,x,y);
}

if(outlineON == true){
  outline(x,y);
}

if(outline2ON == true){
  outlineINSIDE(x,y);
}

if(centXON == true){
  centerX(x,y);
}

if(circON == true){
  circ(circQUAD,x,y);
}

if(crossON == true){
crosshairs(x,y);
}

if(barsON == true){
bars(x,y);
}

if(colBARSON == true){
colorBars(x,y);
}

if(highFreq == true){
highFreq(x,y);
}

if(framesizeTXT == true){
framesizeTXT(x,y);
}


if(exportbool == true){
    String wid = str(x);
    String hig = str(y);
    String outNAME ="output/Test_Pattern" + wid + "x" + hig + ".jpg";
    pg.save(outNAME); 
}


pg.endDraw();
enter1 = 0; 

if((x <= 800)&&(y <= 480)){

image(pg, 10, 170, x, y);
}

else if(((x > 800)||(y > 480))&&((x <= 1920)||(y <= 1080))){
image(pg, 10, 170, x/2.5f, y/2.5f);
}

else if((x > 1920)||(y > 1080)){
image(pg, 10, 170, x/3.5f, y/3.5f);
//pg.save("output/PGOUT.png");
}

}
public void buildGUIdisp(){
  pushMatrix();
  translate(35, 50);
  
  
  stroke(255,0,0);
  line(10 , 0,  10, 20);
  line(0 , 10, 20 , 10);
  
  stroke(255);
  noFill();
  rect(67, 0, 20, 20);
 
  popMatrix();
  
  pushMatrix();
  translate(165, 50);
  
  
  stroke(255);
  line(0 , 0,  20, 20);
  line(0 , 20, 20 , 0);
  

 
  popMatrix();
  
}
public void guiSetup(){

  
  c = new GUIController (this);
  
  IFLookAndFeel defaultLook, guiLook;
  
  int guiYpos = 82;
  int guiXstartPos = 10;
  int guibuttwidth =67;
  int buttHeight = 25;
  int txtStart = 25;
  
  
  guiLook = new IFLookAndFeel(this, IFLookAndFeel.DEFAULT);
  guiLook.baseColor = color(240, 240, 150);
  guiLook.highlightColor = color(220, 220, 30);
  
  c.setLookAndFeel(guiLook);

  w = new IFTextField("Width", 300+ guiXstartPos, txtStart, guibuttwidth);

  h = new IFTextField("Height", 300+ guibuttwidth + 30, txtStart, guibuttwidth);
  
  export = new IFButton ("Export .JPG", 550, 25, guibuttwidth*2-3, buttHeight+10);
  
  b1 = new IFButton ("Cross", guiXstartPos, guiYpos, guibuttwidth, buttHeight);
  b2 = new IFButton ("Outline", guiXstartPos + guibuttwidth , guiYpos, guibuttwidth, buttHeight);
  b3 = new IFButton ("Box", guiXstartPos + guibuttwidth , guiYpos+ buttHeight,guibuttwidth, buttHeight);
  b4 = new IFButton ("X", guiXstartPos + guibuttwidth*2 , guiYpos,guibuttwidth, buttHeight);
  b5 = new IFButton ("Circels", guiXstartPos + guibuttwidth*3 , guiYpos,guibuttwidth,buttHeight);
  b6 = new IFButton ("Quad", guiXstartPos + guibuttwidth*3 , guiYpos+buttHeight,guibuttwidth, buttHeight);
  
  b7 = new IFButton ("Grid", guiXstartPos + guibuttwidth*4 , guiYpos,guibuttwidth, buttHeight);
  b9 = new IFButton ("Grid Text", guiXstartPos + guibuttwidth*4 , guiYpos+buttHeight,guibuttwidth,buttHeight);
  
  b8 = new IFButton ("Big Grid", guiXstartPos + guibuttwidth*5 , guiYpos,guibuttwidth, buttHeight);
  b10 = new IFButton ("Chekker", guiXstartPos + guibuttwidth*5 , guiYpos+buttHeight,guibuttwidth, buttHeight);
  
  
  b11 = new IFButton ("B/W Bars", guiXstartPos + guibuttwidth*6 , guiYpos,guibuttwidth, buttHeight);
  b12 = new IFButton ("R/B Bars", guiXstartPos + guibuttwidth*6 , guiYpos+buttHeight,guibuttwidth, buttHeight);
  b13 = new IFButton ("Color Bars", guiXstartPos + guibuttwidth*7 , guiYpos,guibuttwidth, buttHeight);
  b14 = new IFButton ("High Freq", guiXstartPos + guibuttwidth*8 , guiYpos,guibuttwidth, buttHeight);
  b15 = new IFButton ("Frame Size", guiXstartPos + guibuttwidth*9 , guiYpos,guibuttwidth, buttHeight);
  

  export.addActionListener(this);
  w.addActionListener(this);
  h.addActionListener(this);
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  b4.addActionListener(this);
  b5.addActionListener(this);
  b6.addActionListener(this);
  b7.addActionListener(this);
  b8.addActionListener(this);
  b9.addActionListener(this);
  b10.addActionListener(this);
  b11.addActionListener(this);
  b12.addActionListener(this);
  b13.addActionListener(this);
  b14.addActionListener(this);
  b15.addActionListener(this);


  c.add(w);

  c.add(h);

  c.add (export);
  c.add (b1);
  c.add (b2);
  c.add (b3);
  c.add (b4);
  c.add (b5);
  c.add (b6);
  c.add (b7);
  c.add (b8);
  c.add (b9);
  c.add (b10);
  c.add (b11);
  c.add (b12);
  c.add (b13);
  c.add (b14);
  c.add (b15);

}
  public void settings() { 
size(900, 780, P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tesp_pattern_11" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
