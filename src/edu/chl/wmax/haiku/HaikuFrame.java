package edu.chl.wmax.haiku;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class HaikuFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField line1Field;
	private JTextField line2Field;
	private JTextField line3Field;
	private JLabel scoreLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HaikuFrame frame = new HaikuFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HaikuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 65, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel scoreText = new JLabel("Score:");
		GridBagConstraints gbc_scoreText = new GridBagConstraints();
		gbc_scoreText.insets = new Insets(0, 0, 5, 5);
		gbc_scoreText.gridx = 2;
		gbc_scoreText.gridy = 0;
		contentPane.add(scoreText, gbc_scoreText);
		
		this.scoreLabel = new JLabel("");
		GridBagConstraints gbc_scoreLabel = new GridBagConstraints();
		gbc_scoreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_scoreLabel.gridx = 3;
		gbc_scoreLabel.gridy = 0;
		contentPane.add(scoreLabel, gbc_scoreLabel);
		
		line1Field = new JTextField();
		GridBagConstraints gbc_line1Field = new GridBagConstraints();
		gbc_line1Field.gridwidth = 3;
		gbc_line1Field.insets = new Insets(0, 0, 5, 5);
		gbc_line1Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_line1Field.gridx = 2;
		gbc_line1Field.gridy = 2;
		contentPane.add(line1Field, gbc_line1Field);
		line1Field.setColumns(10);
		
		line2Field = new JTextField();
		line2Field.setColumns(10);
		GridBagConstraints gbc_line2Field = new GridBagConstraints();
		gbc_line2Field.gridwidth = 3;
		gbc_line2Field.insets = new Insets(0, 0, 5, 5);
		gbc_line2Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_line2Field.gridx = 2;
		gbc_line2Field.gridy = 3;
		contentPane.add(line2Field, gbc_line2Field);
		
		line3Field = new JTextField();
		line3Field.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 4;
		contentPane.add(line3Field, gbc_textField);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(this);
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.gridwidth = 2;
		gbc_btnCalculate.anchor = GridBagConstraints.WEST;
		gbc_btnCalculate.insets = new Insets(0, 0, 0, 5);
		gbc_btnCalculate.gridx = 2;
		gbc_btnCalculate.gridy = 5;
		contentPane.add(btnCalculate, gbc_btnCalculate);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int score = HaikuModel.haikuScore(line1Field.getText(), line2Field.getText(), line3Field.getText());
		
		this.scoreLabel.setText(score+"/20");
		this.repaint();
		this.validate();		
	}

}
