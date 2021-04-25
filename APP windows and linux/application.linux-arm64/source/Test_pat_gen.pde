void buildTP(){
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
image(pg, 10, 170, x/2.5, y/2.5);
}

else if((x > 1920)||(y > 1080)){
image(pg, 10, 170, x/3.5, y/3.5);
//pg.save("output/PGOUT.png");
}

}
