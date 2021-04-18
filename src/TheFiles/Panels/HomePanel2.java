package TheFiles.Panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import TheFiles.Loader;

public class HomePanel2 extends JPanel {
	private static final long serialVersionUID = 1L;
	public static HomePanel2 homePanel = new HomePanel2();

	HomePanel2() {

		// Panels
		JPanel departmentsPanel = new DepartmentsPanel();
		JPanel facultyPanel = new FacultyPanel();
		JPanel studentsPanel = new StudentsPanel();
		JPanel coursesPanel = new CoursesPanel();
		JPanel semesterPanel = new SemesterPanel();

		JPanel subPanel = new JPanel();
		subPanel.setPreferredSize(new Dimension(140, 300));
		subPanel.setLayout(new GridBagLayout());

		// Buttons
		GridBagConstraints c = new GridBagConstraints();

		JButton buttonArray[] = new JButton[6];
		for (int i = 0; i < buttonArray.length; i++) {
			buttonArray[i] = new JButton();
			buttonArray[i].setFocusPainted(false);
		}
		buttonArray[0].setText("Departments");
		buttonArray[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader.page.setContentPane(departmentsPanel);
				Loader.page.invalidate();
				Loader.page.validate();
			}
		});
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		subPanel.add(buttonArray[0], c);

		buttonArray[1].setText("Faculty");
		buttonArray[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader.page.setContentPane(facultyPanel);
				Loader.page.invalidate();
				Loader.page.validate();
			}
		});
		c.gridx = 0;
		c.gridy = 1;
		subPanel.add(buttonArray[1], c);

		buttonArray[2].setText("Students");
		buttonArray[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader.page.setContentPane(studentsPanel);
				Loader.page.invalidate();
				Loader.page.validate();
			}
		});
		c.gridx = 0;
		c.gridy = 2;
		subPanel.add(buttonArray[2], c);

		buttonArray[3].setText("Courses");
		buttonArray[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader.page.setContentPane(coursesPanel);
				Loader.page.invalidate();
				Loader.page.validate();
			}
		});
		c.gridx = 0;
		c.gridy = 3;
		subPanel.add(buttonArray[3], c);
		
		buttonArray[4].setText("Semester");
		buttonArray[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader.page.setContentPane(semesterPanel);
				Loader.page.invalidate();
				Loader.page.validate();
			}
		});
		c.gridx = 0;
		c.gridy = 4;
		subPanel.add(buttonArray[4], c);

		buttonArray[5].setText("Change Password");
		buttonArray[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel subpanel = new JPanel();
				
				JLabel[] labelArray = new JLabel[2];
				JPasswordField[] passwordFieldArray = new JPasswordField[2];
				for (int i = 0; i < passwordFieldArray.length; i++) {
					labelArray[i] = new JLabel();
					passwordFieldArray[i] = new JPasswordField();
					subpanel.add(labelArray[i]);
					subpanel.add(passwordFieldArray[i]);
				}
				labelArray[0].setText("Old Password : ");
				labelArray[1].setText("New Password : ");
				
				subpanel.setLayout(new GridLayout(passwordFieldArray.length, 2));
				int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Confirm",
						JOptionPane.OK_CANCEL_OPTION);
				if (submit == JOptionPane.OK_OPTION) {
					String oldpassword = String.valueOf(passwordFieldArray[0].getPassword());
					String newpassword = String.valueOf(passwordFieldArray[1].getPassword());
					TheFiles.Admin.Update(oldpassword, newpassword);
				}
			}
		});
		c.gridy = 5;
		subPanel.add(buttonArray[5], c);

		add(subPanel);
	}
}
