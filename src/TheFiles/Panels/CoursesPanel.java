package TheFiles.Panels;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import TheFiles.DataBaseRetrieval;
import TheFiles.Methods;

public class CoursesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static CoursesPanel coursesPanel;
	static JPanel table = DataBaseRetrieval.Retrieve("*", "COURSE", "*", "*");

	CoursesPanel() {
		try {
			setLayout(new BorderLayout());
			JButton button = Methods.homeBackButton();
			button.setText("Back");
			/* subpanel1. */add(button, BorderLayout.PAGE_START);
			// add(subpanel1, BorderLayout.PAGE_START);

			JPanel subpanel2 = new JPanel();
			JButton[] buttons = new JButton[5];
			for (int i = 0; i < 5; i++) {
				buttons[i] = new JButton();
				subpanel2.add(buttons[i]);
			}
			buttons[0].setText("Insert");
			buttons[0].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Methods.courseInsert();
				}
			});
			buttons[1].setText("Update");
			buttons[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Methods.update("COURSE");
				}
			});
			buttons[2].setText("Delete");
			buttons[2].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Methods.delete("COURSE");
				}
			});
			buttons[3].setText("Refresh");
			buttons[3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(table);
					table = DataBaseRetrieval.Retrieve("*", "COURSE", "*", "*");
					add(table, BorderLayout.CENTER);
					revalidate();
					repaint();
				}
			});
			buttons[4].setText("Find");
			buttons[4].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] find = Methods.find();
					remove(table);
					table = DataBaseRetrieval.Retrieve(find[0].toUpperCase(),"COURSE",find[1].toUpperCase(),find[2].toUpperCase());
					add(table, BorderLayout.CENTER);
					revalidate();
					repaint();
				}				
			});
			
			add(table, BorderLayout.CENTER);
			add(subpanel2, BorderLayout.SOUTH);
		} finally {
		}

	}
}