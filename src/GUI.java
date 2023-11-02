import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.Toolkit;

public class GUI
{
    JFrame window = new JFrame();
    JPanel panel = new JPanel(null);

    int x = 0;
    int y = 0;
    int boundX = 0;
    int boundY = 0;

    public void init()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        boundX = (int)screenSize.getWidth();
        boundY = (int)screenSize.getHeight();
        window.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                makeNew();
            }
            public void windowClosed(WindowEvent windowEvent)
            {
                makeNew();
            }
        });
        window.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                makeNew();
            }
        });
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        window.setSize(300, 160);
        window.setLocation(random());
        panel.setSize(500, 250);
        window.setUndecorated(true);
        window.setAlwaysOnTop(true);
        try
        {
            ImageIcon image = new ImageIcon("picture.jpg");
            JLabel labelImage = new JLabel();
            labelImage.setIcon(image);
            labelImage.setLocation(0,-40);
            labelImage.setSize(500,250);
            panel.add(labelImage);
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong :(");
        }
        window.add(panel);
        window.setVisible(true);
    }

    public void makeNew()
    {
        MultiThread thread = new MultiThread();
        thread.start();
        /*
        window.setLocation(random());
        window.add(panel);
        window.setVisible(true);
         */
    }

    public void run()
    {
        GUI guiObj = new GUI();
        guiObj.init();
    }

    public Point random()
    {
        Random rand = new Random();
        Point p = new Point();
        x = rand.nextInt(boundX-300);
        y = rand.nextInt(boundY-160);
        p.setLocation(x,y);
        return p;
    }
}