import java.awt.*;

public class ServerGUI extends javax.swing.JFrame
{

   ServerDriver comm1,comm2;
   ServerVariableStruct serverVar;
   static int port1, port2;

    public ServerGUI()
    {
        initComponents();
        serverVar = new ServerVariableStruct();
        initFoodStuffs();
        comm1 = new ServerDriver(port1,Panel,p1Energy,p1Points,p1Time,serverVar);
        comm2 = new ServerDriver(port2,Panel,p2Energy,p2Points,p2Time,serverVar);
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
        p1Energy = new javax.swing.JTextField();
        p1Time = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p1Points = new javax.swing.JTextField();
        p2Energy = new javax.swing.JTextField();
        p2Points = new javax.swing.JTextField();
        p2Time = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Captain - Server View");

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
            .addGap(0, 472, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        p1Energy.setEditable(false);
        p1Energy.setText("Energy: 25");

        p1Time.setEditable(false);
        p1Time.setText("Time: 0");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jLabel1.setText("Player 1");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jLabel2.setText("Player 2");

        p1Points.setEditable(false);
        p1Points.setText("Points: 0");

        p2Energy.setEditable(false);
        p2Energy.setText("Energy: 25");

        p2Points.setEditable(false);
        p2Points.setText("Points: 0");

        p2Time.setEditable(false);
        p2Time.setText("Time: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(p1Points)
                        .addComponent(p1Time, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(p1Energy, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(p2Energy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(p2Points, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(p2Time, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1Energy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p1Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(p2Energy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p2Points, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(p2Time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  public void ourCustomPaintingMethod(Graphics g)
  {
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
      if(!serverVar.doorN3)
      {
          g.fillRect(colW*5, rowH*8, colW, rowH);
      }
      if(!serverVar.doorN2)
      {
          g.fillRect(colW*2, rowH*5, colW, rowH);
      }
      if(!serverVar.doorN1)
      {
          g.fillRect(colW*5, rowH*2, colW, rowH);
      }
      if(!serverVar.doorN4)
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
      g.drawImage(pic,serverVar.px*colW+(int)(colW*0),serverVar.py*rowH+(int)(rowH*0),(int)(colW*1),(int)(rowH*1),this);
      pic = tool.getImage("eggplant.png");
      g.drawImage(pic,serverVar.vx*colW+(int)(colW*.1),serverVar.vy*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("noodle.png");
      g.drawImage(pic,serverVar.nx*colW+(int)(colW*.1),serverVar.ny*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("coffee.png");
      g.drawImage(pic,serverVar.cx*colW+(int)(colW*.1),serverVar.cy*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("book.png");
      g.drawImage(pic,serverVar.bx*colW+(int)(colW*.1),serverVar.by*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("journal.png");
      g.drawImage(pic,serverVar.jx*colW+(int)(colW*.1),serverVar.jy*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("techArticle.png");
      g.drawImage(pic,serverVar.tx*colW+(int)(colW*.1),serverVar.ty*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);

      //draw character marker
      pic = tool.getImage("person1.png");
      g.drawImage(pic,comm1.getX()*colW+(int)(colW*.1),comm1.getY()*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);
      pic = tool.getImage("person2.png");
      g.drawImage(pic,comm2.getX()*colW+(int)(colW*.1),comm2.getY()*rowH+(int)(rowH*.1),(int)(colW*.9),(int)(rowH*.9),this);

      //change waiting status
      if(!serverVar.waitingSent)
      {
          if(comm2.getX()>0 || comm2.getY()>1)
          {
              comm1.send("waiting:"+0);
              System.out.println("Change Waiting 1");
              serverVar.waitingSent = true;
          }
          else
          {
              comm2.send("waiting:"+0);
              System.out.println("Change Waiting 2");
          }
      }
  }

    public static void main(String args[])
    {
        try
        {
			port1 = Integer.valueOf(args[0]);
        	port2 = Integer.valueOf(args[1]);
        	java.awt.EventQueue.invokeLater(new Runnable() {

            	public void run()
            	{
            	    new ServerGUI().setVisible(true);
            	}
        	});
		}
		catch(Exception e)
		{
			System.out.println("\nERROR: Malformed input. Requires 2 different port numbers");
		}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField p1Energy;
    private javax.swing.JTextField p1Points;
    private javax.swing.JTextField p1Time;
    private javax.swing.JTextField p2Energy;
    private javax.swing.JTextField p2Points;
    private javax.swing.JTextField p2Time;
    // End of variables declaration//GEN-END:variables

    private void initFoodStuffs()
    {
        int vx = 0, vy = 0, px = 0, py = 0, cx = 0, cy = 0, nx = 0, ny = 0;
        int bx =0, by = 0, jx = 0, jy = 0, tx = 0, ty = 0;

        vx = (int)(Math.random()*10); //place Vegetable
        vy = (int)(Math.random()*10);
        if(vx == 5)
        {
            vx++;
        }
        if(vy == 5)
        {
            vy++;
        }
        if(vx < 5 && vy < 5)
        {
            vy += 6;
        }
        System.out.println("vx = "+vx+"\nvy = "+vy);
        serverVar.vx = vx ;
        serverVar.vy = vy;

        do //randomly place pizza
        {
            px = (int)(Math.random()*10);
            py = (int)(Math.random()*10);
            if(px == 5)
            {
                px++;
            }
            if(py == 5)
            {
                py++;
            }
            if(px < 5 && py < 5)
            {
                py += 6;
            }
        }while(occupied(px,py));
        System.out.println("px = "+px+"\npy = "+py);
        serverVar.px = px ;
        serverVar.py = py;

        do  //randomly place coffee
        {
            cx = (int)(Math.random()*10);
            cy = (int)(Math.random()*10);
            if(cx == 5)
            {
                cx++;
            }
            if(cy == 5)
            {
                cy++;
            }
            if(cx < 5 && cy < 5)
            {
                cy += 6;
            }
        }while(occupied(cx,cy));
        System.out.println("cx = "+cx+"\ncy = "+cy);
        serverVar.cx = cx;
        serverVar.cy = cy;

        do  //randomly place noodle
        {
            nx = (int)(Math.random()*10);
            ny = (int)(Math.random()*10);
            if(nx == 5)
            {
                nx++;
            }
            if(ny == 5)
            {
                ny++;
            }
            if(nx < 5 && ny < 5)
            {
                ny += 6;
            }
        }while(occupied(nx,ny));
        System.out.println("nx = "+nx+"\nny = "+ny);
        serverVar.nx = nx;
        serverVar.ny = ny;

        do  //randomly place book
        {
            bx = (int)(Math.random()*10);
            by = (int)(Math.random()*10);
            if(bx == 5)
            {
                bx++;
            }
            if(by == 5)
            {
                by++;
            }
            if(bx < 5 && by < 5)
            {
                by += 6;
            }
        }while(occupied(bx,by));
        System.out.println("bx = "+bx+"\nby = "+by);
        serverVar.bx = bx;
        serverVar.by = by;

        do  //randomly place journal
        {
            jx = (int)(Math.random()*10);
            jy = (int)(Math.random()*10);
            if(jx == 5)
            {
                jx++;
            }
            if(jy == 5)
            {
                jy++;
            }
            if(jx < 5 && jy < 5)
            {
                jy += 6;
            }
        }while(occupied(jx,jy));
        System.out.println("jx = "+jx+"\njy = "+jy);
        serverVar.jx = jx;
        serverVar.jy = jy;


        do  //randomly place technical article
        {
            tx = (int)(Math.random()*10);
            ty = (int)(Math.random()*10);
            if(tx == 5)
            {
                tx++;
            }
            if(ty == 5)
            {
                ty++;
            }
            if(tx < 5 && ty < 5)
            {
                ty += 6;
            }
        }while(occupied(tx,ty));
        System.out.println("tx = "+tx+"\nty = "+ty);
        serverVar.tx = tx;
        serverVar.ty = ty;
    }

    private boolean occupied(int x, int y) //returns true if the cell is occupied
    {
        if((x == serverVar.vx && y == serverVar.vy) || (x == serverVar.px && y == serverVar.py) ||
           (x == serverVar.cx && y == serverVar.cy) || (x == serverVar.nx && y == serverVar.ny) ||
           (x == serverVar.bx && y == serverVar.by) || (x == serverVar.jx && y == serverVar.jy) ||
           (x == serverVar.tx && y == serverVar.ty))
        {
            System.out.println("collision");
            return true;
        }
        return false;
    }

}
