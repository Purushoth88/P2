import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class TesteMouse {
	public static void main(String[] args) {
		JFrame frame = new JFrame("teste mouse");
		Cursor mouse = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
		JLabel label = new JLabel();
		frame.add(label);
		frame.setCursor(mouse);
		frame.setCursor(mouse);
		frame.setVisible(true);
		for(int i =0; i<10000*1000;i++){
			label.setText(i+"");
		}
		label.setText("ok");
		mouse = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
		frame.setCursor(mouse);
		
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
	}

}
