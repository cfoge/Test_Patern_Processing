void buildGUIdisp(){
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
