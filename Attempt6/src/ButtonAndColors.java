//图形用户初探
//按钮改变颜色

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonAndColors{
    JFrame frame = new JFrame();
    Color color = Color.blue;
    MyDrawPanel drawPanel = new MyDrawPanel();
    int x=70;
    int y=70;

    public static void main(String[] args) {
        ButtonAndColors gui = new ButtonAndColors();
        gui.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton colorButton = new JButton("Change Crcle");
        colorButton.addActionListener(new ColorListener());

        JButton moveButton = new JButton("Move");
        moveButton.addActionListener(new MoveListener());

        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        frame.getContentPane().add(BorderLayout.CENTER,drawPanel);
        frame.getContentPane().add(BorderLayout.NORTH,moveButton);

        frame.setSize(400,300);
        frame.setVisible(true);

        for(int i=0;i<40;i++){
            x++;
            y++;
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            }catch (Exception ex){ }
        }
    }

    class ColorListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color randomColor = new Color(red,green,blue);
            color = randomColor;
            frame.repaint();
        }
    }

    class MoveListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            for(int i=0;i<40;i++){
                x++;
                y++;
                drawPanel.repaint();
                try {
                    Thread.sleep(50);
                }catch (Exception ex){ }
            }
        }
    }

    class MyDrawPanel extends JPanel
    {
        public void paintComponent(Graphics g)
        {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());
            g.setColor(color);
            g.fillOval(x,y,40,40);
        }
    }

}

