package main;

import javax.swing.JFrame;

public class AppFrame extends JFrame {

	AppFrame(){
        this.add(new AppPanel());
        this.setTitle("Brick Game!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Better constant for exit behavior
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
	}
}
