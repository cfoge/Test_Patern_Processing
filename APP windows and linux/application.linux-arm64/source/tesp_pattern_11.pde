

import interfascia.*;

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

color bg = color(150, 150, 150);
color bgHL = color(230, 230, 0);

color checkker = color(204, 102, 0);
color lineA = color(200, 200, 200);

int div = 10;

//crosshair definitions
int chBOLD = 1;
color crosshair = color(255, 0, 0);
// end crosshair defintions

//outline definitions
int olBOLD = 1;
color outline = color(255, 255, 255);

//end outline definitions

//circles
int circBOLD = 1;
color circ = color(0, 255, 0);
int circsize = 8;
//end circles

//grid
//find greatest common denominator



//

color grid1 = color(80, 80, 80);
int videoScale1 = 16; //lower numbers = tighter grid// must be 5,10,16,20,32

color grid2 = color(200, 200, 200);
int videoScale2 = 32; //lower numbers = tighter grid// must be 5,10,16,20,32

PImage img;  // Declare variable "a" of type PImage


//grid done

// use pre defined selections and a case statement to get the corect size

//end define
void setup(){
  
size(900, 780, P2D);


//noStroke();
//frameRate(25);
textSize(11);
thread("guiSetup");

//noLoop();
}

void draw(){

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




void actionPerformed (GUIEvent e) {
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
    x= int(w.getValue());
    y= int(h.getValue());
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
