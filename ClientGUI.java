/*
 * Game Client Side GUI
 *
 * Representation of Screen Quadrants and Doors
 *  *********************
 *  *  2      *      1  *
 *  *        -1         *
 *  *         *         *
 *  ****-2*********-4****
 *  *         *         *
 *  *        -3         *
 *  * 3       *       4 *
 *  *********************
 */

import java.awt.*;

public class ClientGUI extends javax.swing.JFrame
{
    int x = 0, y = 0;
    int quadrant = 2;
    ClientVariableStruct clientVar;
    Client comm;
    Timer count;
    ClientDriver run;
    static String address;
    static int port;
    MIDIPlayer music = new MIDIPlayer();

    /** Creates new form ClientGUI */
    public ClientGUI()
    {
        initComponents();
        clientVar = new ClientVariableStruct();
        comm = new Client(address,port);
        while(!comm.isConnected())
        {
            comm = new Client(address,port);
            try
            {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {}
        }
        clientVar.connected = true;
        count = new Timer(Panel,timeField,comm);
        run = new ClientDriver(clientVar,comm,Panel);
        music.play();
    }


    private void initComponents() {

        Panel = new javax.swing.JPanel()
        {
            public void paint(Graphics g)
            {
                super.paint(g);
                ourCustomPaintingMethod(g);
            }
        };
        this.setFocusable(true);
        energyField = new javax.swing.JTextField();
        timeField = new javax.swing.JTextField();
        pointsField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel California - THE GAME");
        setAlwaysOnTop(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setBorder(new javax.swing.border.MatteBorder(null));
        Panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel.setEnabled(false);
        Panel.setMaximumSize(new java.awt.Dimension(440, 440));
        Panel.setMinimumSize(new java.awt.Dimension(440, 440));
        Panel.setPreferredSize(new java.awt.Dimension(440, 440));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        energyField.setEditable(false);
        energyField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        energyField.setText("Energy Level: 25");

        timeField.setEditable(false);
        timeField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timeField.setText("Time: 0");

        pointsField.setEditable(false);
        pointsField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pointsField.setText("Points: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(energyField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pointsField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(energyField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pointsField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        /*  left =  37
         *  up =    38
         *  right = 39
         *  down = 40
         */
        int c = evt.getKeyCode();
        if(clientVar.connected && ! clientVar.waiting)
        {
        System.out.println("Key Pressed = "+c);
        switch(c)
        {
            case(37): left(); break;
            case(38): up(); break;
            case(39): right(); break;
            case(40): down(); break;
        }
        if(c == 68)//D key pressed
        {
            if(quadrant > 0 && quadrant != 2)
            comm.send("unlockOccupied:"+quadrant);
        }
        run.changeEnergy(x,y);
        run.changePoints(x,y);
        comm.send("x:"+x);
        comm.send("y:"+y);
        comm.send("quadrant:"+quadrant);
        comm.send("energy:"+clientVar.energy);
        comm.send("points:"+clientVar.points);
        }
        else
        {
            count.stopCount();
        }
        repaint();
    }//GEN-LAST:event_formKeyPressed

  public void ourCustomPaintingMethod(Graphics g)
  {
      if(clientVar.energy < 0)
      {
          clientVar.connected = false;
          count.stopCount();
      }
      energyField.setText("Energy Level: "+clientVar.energy);
      pointsField.setText("Points: "+clientVar.points);

      int w = Panel.getWidth();
      int h = Panel.getHeight();

      int colW = w/11;
      int rowH = h/11;

       g.setColor(Color.gray);
       g.fillRect(0, rowH*5, colW*2, rowH);
       g.fillRect(colW*3, rowH*5, colW*5, rowH);
       g.fillRect(colW*9, rowH*5, colW*2, rowH);
       g.fillRect(colW*5, 0, colW, rowH*2);
       g.fillRect(colW*5, rowH*3, colW, rowH*5);
       g.fillRect(colW*5, rowH*9, colW, rowH*2);

       g.setColor(Color.black);
       g.fillRect(colW*0, rowH*0, colW*1, rowH*2);

      g.setColor(Color.red);
      if(!clientVar.doorN3)
      {
          g.fillRect(colW*5, rowH*8, colW, rowH);
      }
      if(!clientVar.doorN2)
      {
          g.fillRect(colW*2, rowH*5, colW, rowH);
      }
      if(!clientVar.doorN1)
      {
          g.fillRect(colW*5, rowH*2, colW, rowH);
      }
      if(!clientVar.doorN4)
      {
          g.fillRect(colW*8, rowH*5, colW, rowH);
      }
      g.setColor(Color.BLACK);
      for (int i = 0; i < 10; i++)
      {
        g.drawLine(colW+(colW*i),0,colW+(colW*i),h);
        g.drawLine(0, rowH+(rowH*i), w, rowH+(rowH*i));
      }
      //System.out.println("X = "+x+" Y = "+y);

      //set Food Stuffs
      Toolkit tool = Toolkit.getDefaultToolkit();
      Image pic = tool.getImage("pizza.png");
      g.drawImage(pic,clientVar.px*colW+(int)(colW*0),clientVar.py*rowH+(int)(rowH*0),(int)(colW*1),(int)(rowH*1),this);
      pic = tool.getImage("eggplant.png");
      g.drawImage(pic,clientVar.vx*colW+(int)(colW*.1),clientVar.vy*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("noodle.png");
      g.drawImage(pic,clientVar.nx*colW+(int)(colW*.1),clientVar.ny*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("coffee.png");
      g.drawImage(pic,clientVar.cx*colW+(int)(colW*.1),clientVar.cy*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("book.png");
      g.drawImage(pic,clientVar.bx*colW+(int)(colW*.1),clientVar.by*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("journal.png");
      g.drawImage(pic,clientVar.jx*colW+(int)(colW*.1),clientVar.jy*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("techArticle.png");
      g.drawImage(pic,clientVar.tx*colW+(int)(colW*.1),clientVar.ty*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);

      //draw character marker
      pic = tool.getImage("person1.png");
      g.drawImage(pic,x*colW+(int)(colW*.1),y*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);

      //prints GAME OVER
      if(!clientVar.connected)
      {
          g.setColor(Color.BLACK);
          g.setFont(new Font ("Garamond", Font.BOLD , 60));
          g.drawString("GAME OVER", 2*colW, 3*rowH);
      }

      //prints WAITING
      if(clientVar.waiting)
      {
          g.setColor(Color.BLACK);
          g.setFont(new Font ("Garamond", Font.BOLD , 60));
          g.drawString("WAITING", 2*colW, 3*rowH);
      }
  }


    private void left()
    {
        x--;
        if(clientVar.doorN1 && x == 5 && y == 2)
        {
           quadrant = -1;
        }
        if(clientVar.doorN3 && x == 5 && y == 8)
        {
           quadrant = -3;
        }
        checkBounds();
    }

    private void up()
    {
        y--;
        if(clientVar.doorN2 && x == 2 && y == 5)
        {
           quadrant = -2;
        }
        if(clientVar.doorN4 && x == 8 && y == 5)
        {
           quadrant = -4;
        }
        checkBounds();
    }

    private void right()
    {
        x++;
        if(clientVar.doorN1 && x == 5 && y == 2)
        {
           quadrant = -1;
        }
        if(clientVar.doorN3 && x == 5 && y == 8)
        {
           quadrant = -3;
        }
        checkBounds();
    }

    private void down()
    {
        y++;
        if(clientVar.doorN2 && x == 2 && y == 5)
        {
           quadrant = -2;
        }
        if(clientVar.doorN4 && x == 8 && y == 5)
        {
           quadrant = -4;
        }
        checkBounds();
    }

    private void checkBounds()
    {
        System.out.println("Check Bounds Case = "+quadrant);
        switch(quadrant)
        {
          case(-1):
              if(y == 2) clientVar.energy--;
              y = 2;
              if(x == 4)
              {
                  quadrant = 2;
                  count.stopCount();
              }
              if(x == 6)
              {
                 quadrant = 1;
                 count.stopCount();
                 count = new Timer(Panel,timeField,comm);
                 count.startCount();
              }
              break;

          case(-2):
              if(x == 2) clientVar.energy--;
              x = 2;
              if(y == 4)
              {
                  quadrant = 2;
                  count.stopCount();
              }
              if(y == 6)
              {
                  quadrant = 3;
                  count.stopCount();
                  count = new Timer(Panel,timeField,comm);
                  count.startCount();
              }
              break;

          case(-3):
              if(y == 8) clientVar.energy--;
              y = 8;
              if(x == 4)
              {
                  quadrant = 3;
                  count.stopCount();
                  count = new Timer(Panel,timeField,comm);
                  count.startCount();
              }
              if(x == 6)
              {
                  quadrant = 4;
                  count.stopCount();
                  count = new Timer(Panel,timeField,comm);
                  count.startCount();
              }
              break;

          case(-4):
              if(y == 8) clientVar.energy--;
              x = 8;
              if(y == 4)
              {
                  quadrant = 1;
                  count.stopCount();
                  count = new Timer(Panel,timeField,comm);
                  count.startCount();
              }
              if(y == 6)
              {
                  quadrant = 4;
                  count.stopCount();
                  count = new Timer(Panel,timeField,comm);
                  count.startCount();
              }
              break;

          case(1):  if(x >= 6 && x <= 10 && y >= 0 && y <= 4) clientVar.energy--;
                    if(x < 6) x = 6;
                    if(y < 0) y = 0;
                    if(x > 10) x = 10;
                    if(y > 4) y = 4;
                    break;

          case(2):  if(x >= 0 && x <= 4 && y >= 0 && y <= 4) clientVar.energy--;
                    if(x < 0) x = 0;
                    if(y < 0) y = 0;
                    if(x > 4) x = 4;
                    if(y > 4) y = 4;
                    break;

          case(3):  if(x >= 0 && x <= 4 && y >= 6 && y <= 10) clientVar.energy--;
                    if(x < 0) x = 0;
                    if(y < 6) y = 6;
                    if(x > 4) x = 4;
                    if(y > 10) y = 10;
                    break;

          case(4):  if(x >= 6 && x <= 10 && y >= 6 && y <= 10) clientVar.energy--;
                    if(x < 6) x = 6;
                    if(y < 6) y = 6;
                    if(x > 10) x = 10;
                    if(y > 10) y = 10;
                    break;
        }
    }


    public static void main(String args[])
    {
		try
		{
			address = args[0];
			port = Integer.valueOf(args[1]);
			java.awt.EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					new ClientGUI().setVisible(true);
            	}
			});
    	}
    	catch(Exception e)
    	{
			System.out.println("\nError: Malformed input, Requires an IP Address and a Port Number");
		}
	}

    	// Variables declaration - do not modify//
    	private javax.swing.JPanel Panel;
    	private javax.swing.JTextField energyField;
    	private javax.swing.JTextField pointsField;
    	private javax.swing.JTextField timeField;
    	// End of variables declaration//


}
