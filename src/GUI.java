import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class GUI
{
    JFrame window = new JFrame();
    JPanel panel = new JPanel(null);

    JButton close = new JButton();

    JTabbedPane theTabs = new JTabbedPane();

    int x = 0;
    int y = 0;

    boolean value = false;

    public void init()
    {
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
            public void windowConfined(WindowEvent windowEvent)
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
        }
        window.add(panel);
        window.setVisible(true);
    }

    public void closed()
    {
        value = true;
    }

    public void makeNew()
    {
        window.setLocation(random());
        window.add(panel);
        window.setVisible(true);
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
        x = rand.nextInt(1920);
        y = rand.nextInt(1080);
        p.setLocation(x,y);
        return p;
    }
}