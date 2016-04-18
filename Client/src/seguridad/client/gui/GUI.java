package seguridad.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
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

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
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
		
		textField = new JTextField();
		textField.setBounds(109, 38, 196, 20);
		LoginFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
				LoginFrame.dispose();
				adminPanel();
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(176, 224, 230));
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		
		JLabel lblNewLabel = new JLabel("USER'S ACCOUNT DATA");
		lblNewLabel.setBounds(28, 6, 579, 59);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{24, 77, 15, 327, 40, 0};
		gbl_panel_1.rowHeights = new int[]{25, 47, 43, 46, 46, 44, 42, 48, 15, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Username: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(211, 211, 211));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 7;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{32, 364, 0, 0};
		gbl_panel_2.rowHeights = new int[]{43, 47, 47, 48, 45, 44, 36, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel textPane = new JLabel();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 0;
		panel_2.add(textPane, gbc_textPane);
		textPane.setBackground(new Color(211, 211, 211));
		
		JLabel textPane_1 = new JLabel();
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 1;
		panel_2.add(textPane_1, gbc_textPane_1);
		textPane_1.setBackground(new Color(211, 211, 211));
		
		JLabel textPane_2 = new JLabel();
		GridBagConstraints gbc_textPane_2 = new GridBagConstraints();
		gbc_textPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_2.gridx = 1;
		gbc_textPane_2.gridy = 2;
		panel_2.add(textPane_2, gbc_textPane_2);
		textPane_2.setBackground(new Color(211, 211, 211));
		
		JLabel textPane_3 = new JLabel();
		GridBagConstraints gbc_textPane_3 = new GridBagConstraints();
		gbc_textPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_3.gridx = 1;
		gbc_textPane_3.gridy = 3;
		panel_2.add(textPane_3, gbc_textPane_3);
		textPane_3.setBackground(new Color(211, 211, 211));
		
		JLabel textPane_4 = new JLabel();
		GridBagConstraints gbc_textPane_4 = new GridBagConstraints();
		gbc_textPane_4.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_4.gridx = 1;
		gbc_textPane_4.gridy = 4;
		panel_2.add(textPane_4, gbc_textPane_4);
		textPane_4.setBackground(new Color(211, 211, 211));
		
		JLabel textPane_5 = new JLabel();
		GridBagConstraints gbc_textPane_5 = new GridBagConstraints();
		gbc_textPane_5.insets = new Insets(0, 0, 5, 5);
		gbc_textPane_5.gridx = 1;
		gbc_textPane_5.gridy = 5;
		panel_2.add(textPane_5, gbc_textPane_5);
		textPane_5.setBackground(new Color(211, 211, 211));
		
		JLabel textPane_6 = new JLabel();
		GridBagConstraints gbc_textPane_6 = new GridBagConstraints();
		gbc_textPane_6.insets = new Insets(0, 0, 0, 5);
		gbc_textPane_6.gridx = 1;
		gbc_textPane_6.gridy = 6;
		panel_2.add(textPane_6, gbc_textPane_6);
		textPane_6.setBackground(new Color(211, 211, 211));
		
		JLabel lblNewLabel_2 = new JLabel("Real name: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblNewLabel_3 = new JLabel("Email: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 3;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Password: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 4;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblNewLabel_5 = new JLabel("Birthdate: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 5;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblNewLabel_6 = new JLabel("Country: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 6;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JLabel lblNewLabel_7 = new JLabel("Address: ");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 7;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 13));
	}
}
