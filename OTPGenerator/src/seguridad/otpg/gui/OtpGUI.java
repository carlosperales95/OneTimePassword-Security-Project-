package seguridad.otpg.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OtpGUI implements Runnable{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		OtpGUI g=new OtpGUI();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OtpGUI() {
		initialize();
		//(new Thread( new OtpGUI())).start();
		//enablebutton();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblOtpGenerator = new JLabel("OTP GENERATOR");
		lblOtpGenerator.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtpGenerator.setForeground(new Color(50, 205, 50));
		lblOtpGenerator.setFont(new Font("Lucida Console", Font.BOLD, 24));
		lblOtpGenerator.setBounds(105, 38, 218, 29);
		panel.add(lblOtpGenerator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(60, 91, 301, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(301, 36, -302, -38);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		panel_1.add(label);
		
		JButton btnNewButton = new JButton("GENERATE KEY");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setFont(new Font("Narkisim", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setEnabled(false);
				try {
					Thread.sleep(180000);
					System.out.println("Vuelve el hilo");
					btnNewButton.setEnabled(true);
					label.setText("");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//CODIGO PARA LA LLAMADA AL CODIGO OTP
				
			}
		});
		btnNewButton.setBounds(130, 172, 158, 53);
		panel.add(btnNewButton);
		frame.setVisible(true);
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


}
