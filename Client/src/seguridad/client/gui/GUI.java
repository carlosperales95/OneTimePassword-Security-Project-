package seguridad.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;

import seguridad.client.controller.ClientController;

import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JInternalFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTextPane;

public class GUI {

	private ClientController myClientController;
	
	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField textField_1;



	/**
	 * Create the application.
	 */
	public GUI(ClientController tc) {
		this.registerClientController(tc);
		initialize();
	}

	private void registerClientController(ClientController tc) {
		this.myClientController = tc;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 700, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(desktopPane);
		frame.setVisible(true);
		
		loginFrame();

		
		

	}
	public void loginFrame(){
		JInternalFrame LoginFrame = new JInternalFrame("Log In");
		LoginFrame.setBounds(163, 70, 381, 231);
		frame.getContentPane().add(LoginFrame);
		LoginFrame.setBackground(new Color(204, 204, 255));
		LoginFrame.setResizable(false);
		LoginFrame.getContentPane().setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Verdana", Font.BOLD, 14));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(22, 29, 77, 35);
		LoginFrame.getContentPane().add(lblUser);
		
		userField = new JTextField();
		userField.setBounds(109, 38, 196, 20);
		LoginFrame.getContentPane().add(userField);
		userField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Verdana", Font.BOLD, 14));
		lblPassword.setBounds(22, 75, 77, 35);
		LoginFrame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 84, 196, 20);
		LoginFrame.getContentPane().add(passwordField);
		
		JButton btnDone = new JButton("Done");
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					String pass="";
					for(int i=0;i<passwordField.getPassword().length;i++){
						pass=pass+passwordField.getPassword()[i];
					}	
					System.out.println("pass");
				myClientController.SignIn(userField.getText(),pass);
				System.out.println(userField.getText());
				System.out.println("Bien logeado");
				adminPanel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				LoginFrame.dispose();

				frame.repaint();
			}
		});
		btnDone.setBounds(146, 167, 89, 23);
		LoginFrame.getContentPane().add(btnDone);
		
		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtp.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOtp.setBounds(22, 121, 77, 35);
		LoginFrame.getContentPane().add(lblOtp);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 130, 196, 20);
		LoginFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		LoginFrame.setVisible(true);
		
		frame.repaint();
	}
	public void adminPanel(){
		
		JPanel listspanel = new JPanel();
		listspanel.setBackground(new Color(176, 224, 230));
		listspanel.setBounds(6, 6, 658, 417);
		frame.getContentPane().add(listspanel);
		GridBagLayout gbl_listspanel = new GridBagLayout();
		gbl_listspanel.columnWidths = new int[]{40, 149, 51, 43, 151, 71, 135, 0};
		gbl_listspanel.rowHeights = new int[]{0, 358, 0};
		gbl_listspanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_listspanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		listspanel.setLayout(gbl_listspanel);
		
		JLabel lblUserList = new JLabel("USER LIST");
		lblUserList.setFont(new Font("SansSerif", Font.BOLD, 18));
		GridBagConstraints gbc_lblUserList = new GridBagConstraints();
		gbc_lblUserList.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserList.gridx = 1;
		gbc_lblUserList.gridy = 0;
		listspanel.add(lblUserList, gbc_lblUserList);
		
		JLabel lblAdminList = new JLabel("ADMIN LIST");
		lblAdminList.setFont(new Font("SansSerif", Font.BOLD, 18));
		GridBagConstraints gbc_lblAdminList = new GridBagConstraints();
		gbc_lblAdminList.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdminList.gridx = 4;
		gbc_lblAdminList.gridy = 0;
		listspanel.add(lblAdminList, gbc_lblAdminList);
		
		@SuppressWarnings("rawtypes")
		JList userList = new JList();
		userList.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_userList = new GridBagConstraints();
		gbc_userList.insets = new Insets(0, 0, 0, 5);
		gbc_userList.fill = GridBagConstraints.BOTH;
		gbc_userList.gridx = 1;
		gbc_userList.gridy = 1;
		listspanel.add(userList, gbc_userList);
		
		@SuppressWarnings("rawtypes")
		JList adminList = new JList();
		adminList.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_adminList = new GridBagConstraints();
		gbc_adminList.insets = new Insets(0, 0, 0, 5);
		gbc_adminList.fill = GridBagConstraints.BOTH;
		gbc_adminList.gridx = 4;
		gbc_adminList.gridy = 1;
		listspanel.add(adminList, gbc_adminList);
		
		JPanel utilitiesPanel = new JPanel();
		utilitiesPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_utilitiesPanel = new GridBagConstraints();
		gbc_utilitiesPanel.fill = GridBagConstraints.BOTH;
		gbc_utilitiesPanel.gridx = 6;
		gbc_utilitiesPanel.gridy = 1;
		listspanel.add(utilitiesPanel, gbc_utilitiesPanel);
		
		frame.repaint();
		
		
	}
	
	public void userData(){
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(6, 6, 672, 499);
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{19, 618, 0, 0};
		gbl_panel.rowHeights = new int[]{79, 397, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel headpanel = new JPanel();
		headpanel.setBackground(new Color(176, 224, 230));
		headpanel.setLayout(null);
		GridBagConstraints gbc_headpanel = new GridBagConstraints();
		gbc_headpanel.insets = new Insets(0, 0, 5, 5);
		gbc_headpanel.fill = GridBagConstraints.BOTH;
		gbc_headpanel.gridx = 1;
		gbc_headpanel.gridy = 0;
		panel.add(headpanel, gbc_headpanel);
		
		JLabel lblNewLabel = new JLabel("USER'S ACCOUNT DATA");
		lblNewLabel.setBounds(28, 6, 579, 59);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headpanel.add(lblNewLabel);
		
		JPanel datapanel = new JPanel();
		datapanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		datapanel.setBackground(new Color(211, 211, 211));
		GridBagConstraints gbc_datapanel = new GridBagConstraints();
		gbc_datapanel.insets = new Insets(0, 0, 5, 5);
		gbc_datapanel.fill = GridBagConstraints.BOTH;
		gbc_datapanel.gridx = 1;
		gbc_datapanel.gridy = 1;
		panel.add(datapanel, gbc_datapanel);
		GridBagLayout gbl_datapanel = new GridBagLayout();
		gbl_datapanel.columnWidths = new int[]{24, 77, 15, 327, 40, 0};
		gbl_datapanel.rowHeights = new int[]{25, 47, 43, 46, 46, 44, 42, 48, 15, 0};
		gbl_datapanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_datapanel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		datapanel.setLayout(gbl_datapanel);
		
		JLabel lblUsername = new JLabel("Username: ");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		datapanel.add(lblUsername, gbc_lblUsername);
		lblUsername.setBackground(new Color(211, 211, 211));
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JPanel valuespanel = new JPanel();
		valuespanel.setBackground(new Color(211, 211, 211));
		valuespanel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GridBagConstraints gbc_valuespanel = new GridBagConstraints();
		gbc_valuespanel.gridheight = 7;
		gbc_valuespanel.insets = new Insets(0, 0, 5, 5);
		gbc_valuespanel.fill = GridBagConstraints.BOTH;
		gbc_valuespanel.gridx = 3;
		gbc_valuespanel.gridy = 1;
		datapanel.add(valuespanel, gbc_valuespanel);
		GridBagLayout gbl_valuespanel = new GridBagLayout();
		gbl_valuespanel.columnWidths = new int[]{32, 364, 0, 0};
		gbl_valuespanel.rowHeights = new int[]{43, 47, 47, 48, 45, 44, 36, 0};
		gbl_valuespanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_valuespanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		valuespanel.setLayout(gbl_valuespanel);
		
		JLabel usernameValue = new JLabel();
		GridBagConstraints gbc_usernameValue = new GridBagConstraints();
		gbc_usernameValue.insets = new Insets(0, 0, 5, 5);
		gbc_usernameValue.gridx = 1;
		gbc_usernameValue.gridy = 0;
		valuespanel.add(usernameValue, gbc_usernameValue);
		usernameValue.setBackground(new Color(211, 211, 211));
		
		JLabel nameValue = new JLabel();
		GridBagConstraints gbc_nameValue = new GridBagConstraints();
		gbc_nameValue.insets = new Insets(0, 0, 5, 5);
		gbc_nameValue.gridx = 1;
		gbc_nameValue.gridy = 1;
		valuespanel.add(nameValue, gbc_nameValue);
		nameValue.setBackground(new Color(211, 211, 211));
		
		JLabel mailValue = new JLabel();
		GridBagConstraints gbc_mailValue = new GridBagConstraints();
		gbc_mailValue.insets = new Insets(0, 0, 5, 5);
		gbc_mailValue.gridx = 1;
		gbc_mailValue.gridy = 2;
		valuespanel.add(mailValue, gbc_mailValue);
		mailValue.setBackground(new Color(211, 211, 211));
		
		JLabel passValue = new JLabel();
		GridBagConstraints gbc_passValue = new GridBagConstraints();
		gbc_passValue.insets = new Insets(0, 0, 5, 5);
		gbc_passValue.gridx = 1;
		gbc_passValue.gridy = 3;
		valuespanel.add(passValue, gbc_passValue);
		passValue.setBackground(new Color(211, 211, 211));
		
		JLabel bdayValue = new JLabel();
		GridBagConstraints gbc_bdayValue = new GridBagConstraints();
		gbc_bdayValue.insets = new Insets(0, 0, 5, 5);
		gbc_bdayValue.gridx = 1;
		gbc_bdayValue.gridy = 4;
		valuespanel.add(bdayValue, gbc_bdayValue);
		bdayValue.setBackground(new Color(211, 211, 211));
		
		JLabel countryValue = new JLabel();
		GridBagConstraints gbc_countryValue = new GridBagConstraints();
		gbc_countryValue.insets = new Insets(0, 0, 5, 5);
		gbc_countryValue.gridx = 1;
		gbc_countryValue.gridy = 5;
		valuespanel.add(countryValue, gbc_countryValue);
		countryValue.setBackground(new Color(211, 211, 211));
		
		JLabel addressValue = new JLabel();
		GridBagConstraints gbc_addressValue = new GridBagConstraints();
		gbc_addressValue.insets = new Insets(0, 0, 0, 5);
		gbc_addressValue.gridx = 1;
		gbc_addressValue.gridy = 6;
		valuespanel.add(addressValue, gbc_addressValue);
		addressValue.setBackground(new Color(211, 211, 211));
		
		JLabel lblName = new JLabel("Real name: ");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		datapanel.add(lblName, gbc_lblName);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblMail = new JLabel("Email: ");
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.WEST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 1;
		gbc_lblMail.gridy = 3;
		datapanel.add(lblMail, gbc_lblMail);
		lblMail.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblPass = new JLabel("Password: ");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.WEST;
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.gridx = 1;
		gbc_lblPass.gridy = 4;
		datapanel.add(lblPass, gbc_lblPass);
		lblPass.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblBday = new JLabel("Birthdate: ");
		GridBagConstraints gbc_lblBday = new GridBagConstraints();
		gbc_lblBday.anchor = GridBagConstraints.WEST;
		gbc_lblBday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBday.gridx = 1;
		gbc_lblBday.gridy = 5;
		datapanel.add(lblBday, gbc_lblBday);
		lblBday.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblCountry = new JLabel("Country: ");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.anchor = GridBagConstraints.WEST;
		gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
		gbc_lblCountry.gridx = 1;
		gbc_lblCountry.gridy = 6;
		datapanel.add(lblCountry, gbc_lblCountry);
		lblCountry.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblAddress = new JLabel("Address: ");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 7;
		datapanel.add(lblAddress, gbc_lblAddress);
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 13));
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	GUI window = new GUI(myClientController);
				//		window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
