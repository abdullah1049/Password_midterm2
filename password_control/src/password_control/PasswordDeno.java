//AbdullaH AL-Sinaidi
package password_control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PasswordDeno extends JPanel implements ActionListener {

	private static String OK = "ok";
	private static String HELP = "help";
	    
	    
	private JFrame frame;
	private JPasswordField pass_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordDeno window = new PasswordDeno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasswordDeno() {
		initialize();
	}

	public PasswordDeno(JFrame frame2) {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		pass_field = new JPasswordField();
		pass_field.setBounds(188, 130, 74, 20);
		frame.getContentPane().add(pass_field);
		
        pass_field = new JPasswordField(10);
        pass_field.setActionCommand(OK);
        pass_field.addActionListener(this);
		
		
		
		JLabel lblNewLabel = new JLabel("Enter the password");
		lblNewLabel.setBounds(57, 133, 131, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(272, 117, 89, 23);
		frame.getContentPane().add(btnOk);
		btnOk.setActionCommand(OK);
		btnOk.addActionListener(this);

		
		JButton btnNewButton = new JButton("Help");
		btnNewButton.setBounds(272, 144, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		btnNewButton.setActionCommand(HELP);
		btnNewButton.addActionListener(this);

	}
	private static boolean isPasswordCorrect(char[] input) {
		boolean its_right = true;
		char[] correct_pass = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };

		if (input.length != correct_pass.length) {
			its_right = false;
		} else {
			for (int i = 0; i < input.length; i++) {
				if (input[i] != correct_pass[i]) {
					its_right = false;
				}
			}
		}

		int x =0;
		while (x<correct_pass.length){
			correct_pass[x] = 0;
			x++;}

		return its_right;
	}
	 protected void resetFocus() {
	        pass_field.requestFocusInWindow();
	    }
	 
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (OK.equals(command)) { 
			char[] input = pass_field.getPassword();
			if (isPasswordCorrect(input)) {
				JOptionPane.showMessageDialog(frame,"Success! You typed the right password.");
			} else {
				JOptionPane.showMessageDialog(frame,"Invalid password. Try again.", "Error Message",JOptionPane.ERROR_MESSAGE);
			}

			// security purposes
			int y=0;
			while (y<input.length){
				input[y] = 0;
				y++;
			}
			
			pass_field.selectAll();
		} else { // The user has asked for help.
			JOptionPane.showMessageDialog(frame,"You can get the password by searching this example's\n"
								+ "source code for the string \"correctPassword\".\n"
								+ "Or look at the section How to Use Password Fields in\n"
								+ "the components section of The Java Tutorial.");
		}
	}

	
	
	    }

