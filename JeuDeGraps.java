import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class JeuDeGraps {

	private JFrame frmJeuDeCraps;
	private final JLabel lblTitlePL = new JLabel("Premier lancer");
	private final JSeparator separator = new JSeparator();
	private final JLabel lblDe1 = new JLabel("");
	private final JLabel lblDe2 = new JLabel("");
	private final JLabel lblDe3 = new JLabel("");
	private final JLabel lblDe4 = new JLabel("");
	private final JLabel lblRelancer = new JLabel("Relancer");
	private final JSeparator separator_1 = new JSeparator();
	private final JLabel lblTitleMessage = new JLabel("Message");
	private final JLabel lblMessage = new JLabel("");
	private final JSeparator separator_2 = new JSeparator();
	private final JButton btnJouer = new JButton("Jouer");
	private final JButton btnRelancer = new JButton("Relancer");

	JeuCraps maJeuDes = new JeuCraps();
	private final JLabel Backgroud = new JLabel("");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JeuDeGraps window = new JeuDeGraps();
					window.frmJeuDeCraps.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JeuDeGraps() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJeuDeCraps = new JFrame();
		frmJeuDeCraps.setBackground(Color.LIGHT_GRAY);
		frmJeuDeCraps.setIconImage(Toolkit.getDefaultToolkit().getImage(JeuDeGraps.class.getResource("/ImagesDes/dado.png")));
		frmJeuDeCraps.setTitle("Jeu de CRAPS");
		frmJeuDeCraps.setBounds(100, 100, 450, 497);
		frmJeuDeCraps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJeuDeCraps.getContentPane().setLayout(null);
		lblTitlePL.setForeground(Color.WHITE);
		lblTitlePL.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTitlePL.setBounds(10, 11, 158, 22);
		
		frmJeuDeCraps.getContentPane().add(lblTitlePL);
		lblRelancer.setForeground(Color.WHITE);
		lblRelancer.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblRelancer.setBounds(10, 196, 158, 22);
		
		frmJeuDeCraps.getContentPane().add(lblRelancer);
		lblTitleMessage.setForeground(Color.WHITE);
		lblTitleMessage.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblTitleMessage.setBounds(10, 365, 158, 22);
		
		frmJeuDeCraps.getContentPane().add(lblTitleMessage);
		separator.setBounds(10, 44, 283, 2);
		
		frmJeuDeCraps.getContentPane().add(separator);
		separator_1.setBounds(10, 229, 283, 2);
		
		frmJeuDeCraps.getContentPane().add(separator_1);
		separator_2.setBounds(10, 398, 283, 2);
		
		frmJeuDeCraps.getContentPane().add(separator_2);
		lblDe1.setBackground(UIManager.getColor("Button.shadow"));
		lblDe1.setBounds(10, 57, 112, 112);
		
		frmJeuDeCraps.getContentPane().add(lblDe1);
		lblDe2.setBounds(151, 57, 112, 112);
		
		frmJeuDeCraps.getContentPane().add(lblDe2);
		lblDe3.setBounds(10, 242, 112, 112);
		
		frmJeuDeCraps.getContentPane().add(lblDe3);
		lblDe4.setBounds(151, 242, 112, 112);
		
		frmJeuDeCraps.getContentPane().add(lblDe4);
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMessage.setBounds(10, 411, 283, 29);
		
		frmJeuDeCraps.getContentPane().add(lblMessage);
		btnJouer.addActionListener(new BtnJouerActionListener());
		btnJouer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnJouer.setBounds(304, 116, 120, 25);
		
		frmJeuDeCraps.getContentPane().add(btnJouer);
		btnRelancer.setEnabled(false);
		btnRelancer.addActionListener(new BtnRelancerActionListener());
		btnRelancer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRelancer.setBounds(304, 297, 120, 25);
		
		frmJeuDeCraps.getContentPane().add(btnRelancer);
		Backgroud.setIcon(new ImageIcon(JeuDeGraps.class.getResource("/ImagesDes/craps.jpg")));
		Backgroud.setBounds(0, 0, 434, 458);
		
		frmJeuDeCraps.getContentPane().add(Backgroud);
	}
	private class BtnJouerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			maJeuDes.setPremLancer(true);
			maJeuDes.jouer();
			lblDe1.setIcon(new ImageIcon(JeuDeGraps.class.getResource("/ImagesDes/Alea_" + maJeuDes.getDeLancer1() + ".png")));
			lblDe2.setIcon(new ImageIcon(JeuDeGraps.class.getResource("/ImagesDes/Alea_" + maJeuDes.getDeLancer2() + ".png")));
			
			if (maJeuDes.aGagner()) {
				btnJouer.setEnabled(false);
				lblMessage.setText("Bravo! Vous avez gagner");
			} else if (maJeuDes.estRelance()) {
				lblMessage.setText("Relancer les dés");
				btnRelancer.setEnabled(true);
				btnJouer.setEnabled(false);
			} else {
				btnJouer.setEnabled(false);
				lblMessage.setForeground(Color.RED);
				lblMessage.setText("Désolé, vous avez perdu");
			}
		}
	}
	private class BtnRelancerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblMessage.setText("");
			int somme1 = maJeuDes.getDeLancer1() + maJeuDes.getDeLancer2();
			maJeuDes.setPremLancer(false);
			maJeuDes.jouer();
			lblDe3.setIcon(new ImageIcon(JeuDeGraps.class.getResource("/ImagesDes/Alea_" + maJeuDes.getDeLancer3() + ".png")));
			lblDe4.setIcon(new ImageIcon(JeuDeGraps.class.getResource("/ImagesDes/Alea_" + maJeuDes.getDeLancer4() + ".png")));			
			int somme2 = maJeuDes.getDeLancer3() + maJeuDes.getDeLancer4();
			
			if (somme2 == 7) {
				lblMessage.setText("Désolé, vous avez perdu");
				btnRelancer.setEnabled(false);
				lblMessage.setForeground(Color.RED);
			}
			if (somme1 == somme2) {
				lblMessage.setText("Bravo! Vous avez gagner");
				btnRelancer.setEnabled(false);
			}
		}
	}
}
