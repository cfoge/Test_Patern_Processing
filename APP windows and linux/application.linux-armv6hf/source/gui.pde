void guiSetup(){

  
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
