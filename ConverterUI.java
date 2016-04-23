package lab9;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.nio.file.attribute.GroupPrincipal;
/**
 * 
 * @author Nuttapatprom CHongamorkulprapa
 * 
 *
 */
public class ConverterUI extends JFrame {
	/**
	 * All attribute
	 */
	private JPanel contentPane;
	private JButton convertButton;
	private UnitConverter unitconverter;
	private JTextField inputField;
	private JTextField outputField;
	private JComboBox<Unit> fromUnitBox = new JComboBox<>();
	private JComboBox<Unit> toUnitBox = new JComboBox<>();
	private JRadioButton rdbtnRightToLeft;
	private JRadioButton rdbtnLeftToRight;

	/**
	 * Launch the application.
	 */
	public ConverterUI(UnitConverter uc) {
		this.unitconverter = uc;
		this.setTitle("Length Converter");
		initComponents();
	}
	/**
	 * Initialize compinents GUI
	 */
	private void initComponents() {
		//all of part about GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Unit[] lengths = unitconverter.getUnits();

		inputField = new JTextField();
		inputField.setBounds(10, 11, 150, 23);
		contentPane.add(inputField);
		inputField.setColumns(10);

		fromUnitBox = new JComboBox<Unit>(lengths);
		fromUnitBox.setBounds(163, 11, 89, 23);
		contentPane.add(fromUnitBox);
		
		JLabel labeleq = new JLabel("=");
		labeleq.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labeleq.setBounds(260, 16, 16, 12);
		contentPane.add(labeleq);
		
		outputField = new JTextField();
		outputField.setBounds(284, 11, 150, 23);
		outputField.setEditable(false);
		contentPane.add(outputField);
		outputField.setColumns(10);

		toUnitBox = new JComboBox<Unit>(lengths);
		toUnitBox.setBounds(437, 11, 89, 23);
		contentPane.add(toUnitBox);

		JButton convertButton = new JButton("Convert!");
		convertButton.setBounds(536, 11, 89, 23);
		contentPane.add(convertButton);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnClear.setBounds(635, 11, 89, 23);
		contentPane.add(btnClear);
		
		rdbtnLeftToRight = new JRadioButton("Left -> Right");
		rdbtnLeftToRight.setBounds(209, 41, 109, 23);
		contentPane.add(rdbtnLeftToRight);

		rdbtnRightToLeft = new JRadioButton("Right -> Left");
		rdbtnRightToLeft.setBounds(370, 41, 109, 23);
		contentPane.add(rdbtnRightToLeft);
		
		ButtonGroup groupRadio = new ButtonGroup();
		groupRadio.add(rdbtnRightToLeft);
		groupRadio.add(rdbtnLeftToRight);
		
		this.setVisible(true);

		
		
		
		
		//all of part about listener
		ActionListener convertLst = new ConvertButtonListener();
		convertButton.addActionListener(convertLst);
		KeyListener keyboardLst = new ConvertButtonListener();
		inputField.addKeyListener(keyboardLst);
		outputField.addKeyListener(keyboardLst);

		ActionListener claerLst = new ClearButtonListener();
		btnClear.addActionListener(claerLst);

		ActionListener rightToLeft = new RightToLeftListener();
		rdbtnRightToLeft.addActionListener(rightToLeft);

		ActionListener leftToRight = new LeftToRightListener();
		rdbtnLeftToRight.addActionListener(leftToRight);
		rdbtnLeftToRight.setSelected(true);
	}
	/**
	 * 
	 * @author ntpch
	 *	Convert method invoke this method by action listener and key listener
	 */
	class ConvertButtonListener implements ActionListener, KeyListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (rdbtnLeftToRight.isSelected()) {
				String s = inputField.getText().trim();
				if (s.length() > 0) {
					try {
						double value = Double.valueOf(s);
						Unit fromUnit = (Unit) fromUnitBox.getSelectedItem();
						Unit toUnit = (Unit) toUnitBox.getSelectedItem();
						double valueOut = unitconverter.convert(value, fromUnit, toUnit);
						outputField.setText(String.valueOf(valueOut));
					} catch (NumberFormatException exception) {
						System.out.println("Not a number");
					} catch (NullPointerException exception) {
						System.out.println("Null");
					}
				}
			} else {
				String s = outputField.getText().trim();
				if (s.length() > 0) {
					try {
						double value = Double.valueOf(s);
						Unit toUnit = (Unit) fromUnitBox.getSelectedItem();
						Unit fromUnit = (Unit) toUnitBox.getSelectedItem();
						double valueOut = unitconverter.convert(value, fromUnit, toUnit);
						inputField.setText(String.valueOf(valueOut));
					} catch (NumberFormatException exception) {
						System.out.println("Not a number");
					} catch (NullPointerException exception) {
						System.out.println("Null");
					}
				}
			}

		}

		public void keyTyped(KeyEvent e) {
			

		}

		public void keyPressed(KeyEvent e) {

		}

		public void keyReleased(KeyEvent e) {
			if (rdbtnLeftToRight.isSelected()) {
				String s = inputField.getText().trim();
				if (s.length() > 0) {
					try {
						double value = Double.parseDouble(s);
						Unit fromUnit = (Unit) fromUnitBox.getSelectedItem();
						Unit toUnit = (Unit) toUnitBox.getSelectedItem();
						double valueOut = unitconverter.convert(value, fromUnit, toUnit);
						outputField.setText(String.valueOf(valueOut));
					} catch (NumberFormatException exception) {
						System.out.println("Not a number");
					} catch (NullPointerException exception) {
						System.out.println("Null");
					}
				}
			} else {
				String s = outputField.getText().trim();
				if (s.length() > 0) {
					try {
						double value = Double.valueOf(s);
						Unit toUnit = (Unit) fromUnitBox.getSelectedItem();
						Unit fromUnit = (Unit) toUnitBox.getSelectedItem();
						double valueOut = unitconverter.convert(value, fromUnit, toUnit);
						inputField.setText(String.valueOf(valueOut));
					} catch (NumberFormatException exception) {
						System.out.println("Not a number");
					} catch (NullPointerException exception) {
						System.out.println("Null");
					}
				}
			}
		}
	}
	/**
	 * 
	 * @author ntpch
	 *	this method clear text field by invoke from action listener
	 */
	class ClearButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			inputField.setText("");
			outputField.setText("");
		}
	}
	/**
	 * 
	 * @author ntpch
	 *	this method select side to convert Right to Left by invoke from action listener
	 */
	class RightToLeftListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			inputField.setText("");
			inputField.setEditable(false);
			outputField.setText("");
			outputField.setEditable(true);
		}
	}
	/**
	 * 
	 * @author ntpch
	 *	this method select side to convert Left to Right by invoke from action listener
	 */
	class LeftToRightListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			inputField.setText("");
			inputField.setEditable(true);
			outputField.setText("");
			outputField.setEditable(false);
		}

	}
	/*
	 * Method main
	 */
	public static void main(String[] args) {
		ConverterUI run = new ConverterUI(new UnitConverter());
	}
}
