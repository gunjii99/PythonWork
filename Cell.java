import java.applet.*;
import java.awt.*;

/* <applet CODE = "Cell.class" Width = "700" Height = "500"></applet> */

public class Cell extends Applet implements Runnable
{
    private int x, flag; 
    Thread t;
    boolean running = true;
     public void update() 
    {
        x = x - 50 * flag; 
        if (x < 150) 
            flag = 0; 
        if (x > 150) 
            flag = 1; 
    } 
      public void init() 
    { 
        x = 440;
        flag = 1; 
       setSize(900,900);
        t = new Thread(this, "MyThread"); 
    } 


   public void start()
   {
   	t.start();
   }
    public void run() 
    { 
        while (running) 
       { 
            repaint(); 
            update(); 
            try 
	{ 
                Thread.sleep(1000);   // change these values
            } 
            catch (InterruptedException ie) 
	{ 
                System.out.println(ie); 
            } 
        } 
    } 
	public void paint(Graphics g)
	{
		g.drawString("Hello Juhi",25,25);
		g.drawRect(50,50,600,400);
		g.drawOval(100,150,190,190);
		g.drawOval(400,150,190,190);
		g.drawRect(475,180,30,30);
		g.drawRect(x+40,260,30,30);
		g.drawRect(520,260,30,30);
		g.drawString("A",485,195);
		g.drawString("B",x+50,275);
		g.drawString("C",530,275);

		g.setColor(Color.red);
		g.drawLine(530,260,500,210);
		if(x>150)
		{
			g.setColor(Color.red);
		}
		else
		{
			g.setColor(Color.green);
		}
		g.drawLine(x+50,260,490,210);
	}
	public void destroy()
	{
		running = false;
	}
	public void stop()
	{
		running = false;
	}
}
