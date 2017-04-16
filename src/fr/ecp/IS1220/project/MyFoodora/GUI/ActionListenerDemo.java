package fr.ecp.IS1220.project.MyFoodora.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ActionListenerDemo extends JFrame {
	JTextField username = new JTextField(20);
	JTextField password = new JTextField(20);
	JButton b = new JButton("Connect");
	JButton c = new JButton("Suscribe");

	public ActionListenerDemo(String title) {
		super(title);
		setLayout(new FlowLayout(3)); // place added components on a row
		add(b); // add the button
		b.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent ae) {
				connect();
			}
		}); // listen to the added button
		add(username);
		username.setText("Username");
		add(password);
		password.setText("Password");
		password.setOpaque(true);
		add(c);
		c.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent ae) {
				suscribe();
			}
		}); // listen to the added button
		pack();
		setVisible(true);
	}

	private void connect() {
		username.setText("");
		password.setText("");
	}

	private void suscribe() {
		JTextField email = new JTextField(20);
		add(email);
		email.setText("Email");
		pack();
		setVisible(true);
	}
}
