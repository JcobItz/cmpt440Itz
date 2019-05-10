import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GameBoard {
	public boolean isPlayer1;
	public StringBuilder gameString, xString, oString;
	private boolean isCPUgame;
	public gameCPU CPU;
	private JLabel gString;
	private JLabel winMsg;
	private JFrame frame;
	private JLabel slot0;
	private JLabel slot1;
	private JLabel slot2;
	private JLabel slot3;
	private JLabel slot4;
	private JLabel slot5;
	private JLabel slot6;
	private JLabel slot7;
	private JLabel slot8;
	public gameController controller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameBoard window = new GameBoard();
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
	public GameBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		isPlayer1 = true;
		gameString = new StringBuilder("000000000");
		xString = new StringBuilder("000000000");
		oString = new StringBuilder("000000000");
		controller = new gameController();
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		gString = new JLabel("");
		gString.setBounds(35, 29, 77, 14);
		frame.getContentPane().add(gString);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(154, 140, 299, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(154, 235, 299, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(246, 50, 1, 300);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(353, 50, 1, 300);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		frame.getContentPane().add(separator_3);
		slot0 = new JLabel("");
		winMsg = new JLabel("");
		winMsg.setHorizontalAlignment(SwingConstants.CENTER);
		winMsg.setFont(new Font("Stencil", Font.PLAIN, 57));
		winMsg.setBounds(64, 106, 496, 151);
		frame.getContentPane().add(winMsg);
		slot0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(slot0.getText() == "") {
					setSlot(slot0, 0);
				}
				
			}
		});
		slot0.setBounds(146, 50, 101, 92);
		frame.getContentPane().add(slot0);
		
		slot1 = new JLabel("");
		slot1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot1.getText() == "") {
					setSlot(slot1, 1);
				}
			}
		});
		slot1.setBounds(246, 50, 108, 92);
		frame.getContentPane().add(slot1);
		
		slot4 = new JLabel("");
		slot4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot4.getText() == "") {
					setSlot(slot4, 4);
				}
			}
		});
		slot4.setBounds(246, 140, 108, 97);
		frame.getContentPane().add(slot4);
		
		slot7 = new JLabel("");
		slot7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot7.getText() == "") {
					setSlot(slot7, 7);
				}
			}
		});
		slot7.setBounds(246, 235, 108, 99);
		frame.getContentPane().add(slot7);
		
		slot2 = new JLabel("");
		slot2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot2.getText() == "") {
					setSlot(slot2, 2);
				}
			}
		});
		slot2.setBounds(353, 50, 100, 92);
		frame.getContentPane().add(slot2);
		
		slot3 = new JLabel("");
		slot3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot3.getText() == "") {
					setSlot(slot3, 3);
				}
			}
		});
		slot3.setBounds(146, 140, 100, 97);
		frame.getContentPane().add(slot3);
		
		slot5 = new JLabel("");
		slot5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot5.getText() == "") {
					setSlot(slot5, 5);
				}
			}
		});
		slot5.setBounds(353, 139, 100, 98);
		frame.getContentPane().add(slot5);
		
		slot6 = new JLabel("");
		slot6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot6.getText() == "") {
					setSlot(slot6, 6);
				}
			}
		});
		slot6.setBounds(146, 235, 101, 99);
		frame.getContentPane().add(slot6);
		
		slot8 = new JLabel("");
		slot8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(slot8.getText() == "") {
					setSlot(slot8, 8);
				}
			}
		});
		slot8.setBounds(353, 235, 100, 99);
		frame.getContentPane().add(slot8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				isCPUgame = true;
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2 Player(Normal)", "1 Player vs. CPU"}));
		comboBox.setBounds(10, 268, 126, 20);
		frame.getContentPane().add(comboBox);
		
		
		
		
	}
	public void setSlot(JLabel label, int slot) {
		if(isPlayer1) {
			gameString.setCharAt(slot, '1');
			xString.setCharAt(slot, '1');
			isPlayer1 = false;
			label.setText("X");
			gString.setText(gameString.toString());
			if (controller.processX(gameString.toString())) {
				winMsg.setText("X Wins");
				int res = JOptionPane.showConfirmDialog(null, "X won! Would you like to play again?");
				switch(res) {
				 case 0:
					 restart();
					 break;
				 case 1:
					 frame.dispose();
					 break;
				 default:
					 return;
					 
				}
			}else if(!gameString.toString().contains("0")) {
				winMsg.setText("TIE");
				int resp = JOptionPane.showConfirmDialog(null, "No one won this time. Would you like to play again?");
				switch(resp) {
				 case 0:
					 restart();
					 break;
				 case 1:
					 frame.dispose();
					 break;
				 default:
					 return;
				}
			}else {
				if(isCPUgame) {
					isPlayer1 = true;  
					CPU = new gameCPU(gameString.toString());
					String[] move = CPU.makeMove();
					gameString = new StringBuilder(move[1]);
					gString.setText(gameString.toString());
					cpu(Integer.parseInt(move[0]));
					if (controller.processO(gameString.toString())) {
						winMsg.setText("O Wins");
						
						int res = JOptionPane.showConfirmDialog(null, "O won! Would you like to play again?");
						switch(res) {
						 case 0:
							 restart();
							 break;
						 case 1:
							 frame.dispose();
							 break;
						 default:
							 return;
							 
						}
					}else if(!gameString.toString().contains("0")) {
						winMsg.setText("TIE");
						int resp = JOptionPane.showConfirmDialog(null, "No one won this time. Would you like to play again?");
						switch(resp) {
						 case 0:
							 restart();
							 break;
						 case 1:
							 frame.dispose();
							 break;
						 default:
							 return;
						}
					}
				}
			}
			
		}else{
			gameString.setCharAt(slot , '2');
			oString.setCharAt(slot, '2');
			label.setText("O");
			gString.setText(gameString.toString());
			isPlayer1 = true;
			if (controller.processO(gameString.toString())) {
				winMsg.setText("O Wins");
				
				int res = JOptionPane.showConfirmDialog(null, "O won! Would you like to play again?");
				switch(res) {
				 case 0:
					 restart();
					 break;
				 case 1:
					 frame.dispose();
					 break;
				 default:
					 return;
					 
				}
			}else if(!gameString.toString().contains("0")) {
				winMsg.setText("TIE");
				int resp = JOptionPane.showConfirmDialog(null, "No one won this time. Would you like to play again?");
				switch(resp) {
				 case 0:
					 restart();
					 break;
				 case 1:
					 frame.dispose();
					 break;
				 default:
					 return;
				}
			}
		}
	}
	public void cpu(int slot) {
		switch(slot) {
		case 0:
			slot0.setText("O");
			break;
		case 1:
			slot1.setText("O");
			break;
		case 2:
			slot2.setText("O");
			break;
		case 3:
			slot3.setText("O");
			break;
		case 4:
			slot4.setText("O");
			break;
		case 5:
			slot5.setText("O");
			break;
		case 6:
			slot6.setText("O");
			break;
		case 7:
			slot7.setText("O");
			break;
		case 8:
			slot8.setText("O");
			break;
		}
	}
	public void restart() {
		slot0.setText("");
		slot1.setText("");
		slot2.setText("");
		slot3.setText("");
		slot4.setText("");
		slot5.setText("");
		slot6.setText("");
		slot7.setText("");
		slot8.setText("");
		
		gameString = new StringBuilder("000000000");
		xString = new StringBuilder("000000000");
		oString = new StringBuilder("000000000");
		gString.setText(gameString.toString());
		winMsg.setText("");
		controller = new gameController();
		isPlayer1 = true;
		
	}
	
}
