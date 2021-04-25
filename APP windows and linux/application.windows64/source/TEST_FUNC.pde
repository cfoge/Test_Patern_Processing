void crosshairs(int x,int y) {

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

void outline(int x,int y) {
//outline
pg.stroke(outline);
pg.strokeWeight(olBOLD);  
pg.noFill();
pg.rect(0, 0, x-1, y-1);
}

void centerX(int x,int y) {
//outline
pg.stroke(outline);
pg.strokeWeight(olBOLD);  
pg.line(0, 0, x, y);
pg.line(0, y, x, 0);
}

void outlineINSIDE(int x,int y) {
//outline
pg.stroke(outline);
pg.strokeWeight(olBOLD);  
pg.noFill();
pg.rectMode(CENTER);
pg.rect(x/2, y/2, (x/1.1),(y/1.1));
pg.rectMode(CORNER);
}


void circ(boolean fiveCirc, int x,int y) {
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

void grid(boolean bigGRID, boolean textON, int x,int y){
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


void bars(int x,int y) {
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

pg.fill(255-(i*numcols*1.5)%255,0,(i*numcols*1.5)%255);///work out colour mode for rainbow

pg.rect(numbars*i/4, y/4+cothick, numbars, cothick);
}
//end colur bars
}
}

void colorBars(int x,int y){
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

pg.rect(x/10 * i + (x/10), y-y/2.5, x/10, y/5);
}
}

void highFreq(int x,int y){
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

void framesizeTXT(int x,int y){
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
