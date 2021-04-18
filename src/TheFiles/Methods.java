package TheFiles;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import TheFiles.Panels.HomePanel2;

public class Methods {
	public static JButton templateButton() {
		JButton button = new JButton();
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setFocusPainted(false);
		return button;
	}

	public static JButton homeBackButton() {
		JButton button = templateButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loader.page.setContentPane(HomePanel2.homePanel);
				Loader.page.invalidate();
				Loader.page.validate();
			}
		});
		return button;

	}

	public static JPanel createtable(Object[][] rows, String[] columnNames) {
		JPanel panel = new JPanel(new GridLayout());

		JTable table = new JTable(rows, columnNames);
		@SuppressWarnings("serial")
		DefaultTableModel tableModel = new DefaultTableModel(rows, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(600, 200));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);

		return panel;
	}

	public static void departmentInsert() {
		JPanel subpanel = new JPanel();
		JTextField[] texts = new JTextField[4];
		JLabel[] labels = new JLabel[4];
		for (int i = 0; i < texts.length; i++) {
			texts[i] = new JTextField();
			labels[i] = new JLabel();
		}
		labels[0].setText("ID: ");
		labels[1].setText("Name : ");
		labels[2].setText("Department Head : ");
		labels[3].setText("Contact No. : ");
		for (int i = 0; i < texts.length; i++) {
			subpanel.add(labels[i]);
			subpanel.add(texts[i]);
		}
		subpanel.setLayout(new GridLayout(texts.length, 2));
		int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Insert",
				JOptionPane.OK_CANCEL_OPTION);
		if (submit == JOptionPane.OK_OPTION) {
			DataBaseInsert.Dept(texts[0].getText(), texts[1].getText(), texts[2].getText(),
					texts[3].getText());
		}
	}

	public static void studentInsert() {
		JPanel subpanel = new JPanel();
		JTextField[] texts = new JTextField[6];
		JLabel[] labels = new JLabel[6];
		for (int i = 0; i < texts.length; i++) {
			texts[i] = new JTextField();
			labels[i] = new JLabel();
		}
		labels[0].setText("ID : ");
		labels[1].setText("Name : ");
		labels[2].setText("Course : ");
		labels[3].setText("Total Fees : ");
		labels[4].setText("Pending Fees : ");
		labels[5].setText("Contact No. : ");
		for (int i = 0; i < texts.length; i++) {
			subpanel.add(labels[i]);
			subpanel.add(texts[i]);
		}
		subpanel.setLayout(new GridLayout(texts.length, 2));
		int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Insert",
				JOptionPane.OK_CANCEL_OPTION);
		if (submit == JOptionPane.OK_OPTION) {
			DataBaseInsert.Student(texts[0].getText(), texts[1].getText(), texts[2].getText(),
					texts[3].getText(), texts[4].getText(), texts[5].getText());
		}
	}

	public static void courseInsert() {
		JPanel subpanel = new JPanel();
		JTextField[] texts = new JTextField[3];
		JLabel[] labels = new JLabel[3];
		for (int i = 0; i < texts.length; i++) {
			texts[i] = new JTextField();
			labels[i] = new JLabel();
		}
		labels[0].setText("ID : ");
		labels[1].setText("Name : ");
		labels[2].setText("Department : ");
		for (int i = 0; i < texts.length; i++) {
			subpanel.add(labels[i]);
			subpanel.add(texts[i]);
		}
		subpanel.setLayout(new GridLayout(texts.length, 2));
		int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Insert",
				JOptionPane.OK_CANCEL_OPTION);
		if (submit == JOptionPane.OK_OPTION) {
			DataBaseInsert.Course(texts[0].getText(), texts[1].getText(), texts[2].getText());
		}
	}

	public static void facultyInsert() {
		JPanel subpanel = new JPanel();
		JTextField[] texts = new JTextField[6];
		JLabel[] labels = new JLabel[6];
		for (int i = 0; i < texts.length; i++) {
			texts[i] = new JTextField();
			labels[i] = new JLabel();
		}
		labels[0].setText("ID : ");
		labels[1].setText("Name : ");
		labels[2].setText("Department : ");
		labels[3].setText("Designation : ");
		labels[4].setText("Teaching : ");
		labels[5].setText("Contact No. : ");
		for (int i = 0; i < texts.length; i++) {
			subpanel.add(labels[i]);
			subpanel.add(texts[i]);
		}
		subpanel.setLayout(new GridLayout(texts.length, 2));
		int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Insert",
				JOptionPane.OK_CANCEL_OPTION);
		if (submit == JOptionPane.OK_OPTION) {
			DataBaseInsert.Faculty(texts[0].getText(), texts[1].getText(), texts[2].getText(),
					texts[3].getText(), texts[4].getText(), texts[5].getText());
		}
	}
	public static void semesterInsert() {
		JPanel subpanel = new JPanel();
		JTextField[] texts = new JTextField[4];
		JLabel[] labels = new JLabel[4];
		for (int i = 0; i < texts.length; i++) {
			texts[i] = new JTextField();
			labels[i] = new JLabel();
		}
		labels[0].setText("ID : ");
		labels[1].setText("Semester : ");
		labels[2].setText("Course : ");
		labels[3].setText("Status : ");
		for (int i = 0; i < texts.length; i++) {
			subpanel.add(labels[i]);
			subpanel.add(texts[i]);
		}
		subpanel.setLayout(new GridLayout(texts.length, 2));
		int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Insert",
				JOptionPane.OK_CANCEL_OPTION);
		if (submit == JOptionPane.OK_OPTION) {
			DataBaseInsert.Semester(texts[0].getText(), texts[1].getText(), texts[2].getText(), texts[1].getText());
		}
	}

	public static int update(String Table_Name) {
		int status = 0;
		JPanel subpanel = new JPanel();
		JTextField[] texts = new JTextField[3];
		JLabel[] labels = new JLabel[3];
		for (int i = 0; i < texts.length; i++) {
			texts[i] = new JTextField();
			labels[i] = new JLabel();
		}
		labels[0].setText("ID : ");
		labels[1].setText("Column Name (Case Sensitive) : ");
		labels[2].setText("New Data : ");
		for (int i = 0; i < texts.length; i++) {
			subpanel.add(labels[i]);
			subpanel.add(texts[i]);
		}
		subpanel.setLayout(new GridLayout(texts.length, 2));
		int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Update",
				JOptionPane.OK_CANCEL_OPTION);
		if (submit == JOptionPane.OK_OPTION) {
			status = DataBaseUpdate.update(Table_Name, texts[0].getText(), texts[1].getText(), texts[2].getText());
		}
		return status;
	}

	public static int delete(String Table_Name) {
		int status = 0;
		JPanel subpanel = new JPanel();
		JTextField texts = new JTextField();
		JLabel labels = new JLabel();
		labels.setText("ID : ");
		subpanel.add(labels);
		subpanel.add(texts);
		subpanel.setLayout(new GridLayout(1, 2));
		int submit = JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Delete",
				JOptionPane.OK_CANCEL_OPTION);
		if (submit == JOptionPane.OK_OPTION) {
			status = DataBaseDelete.Delete(Table_Name, texts.getText());
		}
		return status;
	}

	public static String[] find() {
		String[] status = new String[3];
		JPanel subpanel = new JPanel();

		JLabel[] labels = new JLabel[3];
		JTextField[] texts = new JTextField[3];
		for (int i = 0; i < texts.length; i++) {
			labels[i] = new JLabel();
			texts[i] = new JTextField();
			subpanel.add(labels[i]);
			subpanel.add(texts[i]);
		}

		labels[0].setText("Selected Columns (* for all, separator ',') : ");
		labels[1].setText("Search Column ('*' for all) : ");
		labels[2].setText("Matching Data (* for all) : ");

		texts[0].setText("*");
		texts[1].setText("'*'");
		texts[2].setText("*");

		subpanel.setLayout(new GridLayout(3, 2));
		JOptionPane.showConfirmDialog(Loader.page.getContentPane(), subpanel, "Find",
				JOptionPane.OK_CANCEL_OPTION);
		for (int i = 0; i < texts.length; i++) {
			status[i] = texts[i].getText();
		}
		return status;
	}
}
