package gManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HomePanel extends JPanel{
	static HomePanel homePanel;
	HomePanel(){
		//Panels
		JPanel departmentsPanel = new DepartmentsPanel();
		JPanel facultyPanel = new FacultyPanel();
		JPanel studentsPanel = new StudentsPanel();
		JPanel coursesPanel = new CoursesPanel();
		
		//Buttons
		JButton buttonArray[] = new JButton[4];
		int y = 50;
		for(int i = 0;i < buttonArray.length;i++) {
			buttonArray[i] = Methods.templateButton();
			buttonArray[i].setBounds(50, y, 110, 40);
			y += 50;
			if(i==0) {
				buttonArray[i].setText("Departments");
				buttonArray[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Loader.page.setContentPane(departmentsPanel);
						Loader.page.invalidate();
						Loader.page.validate();
					}
				});
			}
			if(i==1) {
				buttonArray[i].setText("Faculty");
				buttonArray[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Loader.page.setContentPane(facultyPanel);
						Loader.page.invalidate();
						Loader.page.validate();
					}
				});
			}
			if(i==2) {
				buttonArray[i].setText("Students");
				buttonArray[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Loader.page.setContentPane(studentsPanel);
						Loader.page.invalidate();
						Loader.page.validate();
					}
				});
			}
			if(i==3) {
				buttonArray[i].setText("Courses");
				buttonArray[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Loader.page.setContentPane(coursesPanel);
						Loader.page.invalidate();
						Loader.page.validate();
					}
				});
			}
			add(buttonArray[i]);
		}
	}
}
