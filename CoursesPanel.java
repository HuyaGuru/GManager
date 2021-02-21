package gManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CoursesPanel extends JPanel{
	static CoursesPanel coursesPanel;
	CoursesPanel(){
		JButton button = Methods.homeBackButton();
		button.setText("Back");
		button.setBounds(50, 50, 110, 40);
		setLayout(null);
		add(button);
	}
}