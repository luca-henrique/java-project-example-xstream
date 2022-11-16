package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class HandleEventConfirmClickUser implements ActionListener {

	private final JTextField field;

	public HandleEventConfirmClickUser(JTextField field) {
		this.field = field;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JOptionPane.showMessageDialog(null, field.getText());
	}
}
