package gManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StudentsPanel extends JPanel{
	static StudentsPanel studentsPanel;
	StudentsPanel(){
		JButton button = Methods.homeBackButton();
		button.setText("Back");
		button.setBounds(50, 50, 110, 40);
		setLayout(null);
		add(button);
	}
}
