package seguridad.otpg.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.SliderUI;

import seguridad.otpg.main.OTPmaker;
import java.awt.event.MouseAdapter;

public class OtpGUI implements Runnable{

	private JFrame frame;
	private OTPmaker myotpmk;
	private boolean freeze;
	protected JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		Thread t = new Thread(new Runnable() {
			    public void run() {
					OtpGUI g=new OtpGUI();
			    	while(true){
			    		//System.out.println("hola");
			    		if(g.freeze==true){
			    			g.stopthr();
			    			System.out.println("Vuelve el hilo");
			    			g.freeze=false;
			    			g.btnNewButton.setEnabled(true);
			    			}
			    		}
			    }
			});

			t.start();
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
		this.freeze=false;
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
		
		JLabel lblotp = new JLabel();
		lblotp.setHorizontalAlignment(SwingConstants.CENTER);
		lblotp.setForeground(Color.WHITE);
		lblotp.setFont(new Font("Lucida Console", Font.BOLD, 24));
		lblotp.setBounds(105, 97, 240, 39);
		panel.add(lblotp);

		


	//	label.setText(myotpmk.geneterateOTP("astrain25", "astrain25"));

		
		 btnNewButton = new JButton("GENERATE KEY");
		 btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
					
					String otp=myotpmk.geneterateOTP("astrain25", "astrain25");
					
					lblotp.setText(otp);
					frame.repaint();
					
					System.out.println(lblotp.getText());
					
					btnNewButton.setEnabled(false);
				
					frame.repaint();
					
					freeze=true;
		
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 204, 102));
		btnNewButton.setFont(new Font("Narkisim", Font.BOLD, 16));
		
		btnNewButton.setBounds(130, 172, 158, 53);
		panel.add(btnNewButton);
		frame.setVisible(true);

	}

public void stopthr(){
	try {
		//180000
		Thread.sleep(180000);
		
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Override
public void run() {
	// TODO Auto-generated method stub

}
	
	  
}	
	


