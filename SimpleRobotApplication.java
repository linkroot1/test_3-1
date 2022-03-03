import View.GameFrame;

import javax.swing.*;

// master 1
public class SimpleRobotApplication {
	
	// serpinin branch 1
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
			// master 2
            public void run() {
                GameFrame mainW = new GameFrame();
                mainW.setVisible(true);
            }
			// serpinin branch 2
        });
    }
}