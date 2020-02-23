import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.TypeVariable;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator {

	private JFrame frame;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculator() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		frame.setBounds(100, 100, 338, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JLabel displayLabel = new JLabel("0");
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displayLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 40));
		displayLabel.setBounds(26, 72, 267, 70);
		frame.getContentPane().add(displayLabel);
		
		JLabel beforeLabel = new JLabel("0");
		beforeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		beforeLabel.setFont(new Font("나눔고딕", Font.PLAIN, 20));
		beforeLabel.setBounds(27, 23, 266, 48);
		frame.getContentPane().add(beforeLabel);
		
		
		
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn7.setBackground(Color.lightGray);
		btn7.setBounds(14, 234, 70, 70);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn8.setBackground(Color.lightGray);
		btn8.setBounds(89, 234, 70, 70);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn9.setBackground(Color.lightGray);
		btn9.setBounds(163, 234, 70, 70);
		frame.getContentPane().add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn4.setBackground(Color.lightGray);
		btn4.setBounds(14, 308, 70, 70);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn5.setBackground(Color.lightGray);
		btn5.setBounds(89, 308, 70, 70);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn6.setBackground(Color.lightGray);
		btn6.setBounds(163, 308, 70, 70);
		frame.getContentPane().add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn1.setBackground(Color.lightGray);
		btn1.setBounds(14, 382, 70, 70);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn2.setBackground(Color.lightGray);
		btn2.setBounds(89, 382, 70, 70);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn3.setBackground(Color.lightGray);
		btn3.setBounds(163, 382, 70, 70);
		frame.getContentPane().add(btn3);
		
		
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String displayStr = displayLabel.getText();
				displayLabel.setText(displayStr+".");
			}
		});
		btnDot.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnDot.setBackground(Color.lightGray);
		btnDot.setBounds(14, 456, 70, 70);
		frame.getContentPane().add(btnDot);
		
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btn0.setBackground(Color.lightGray);
		btn0.setBounds(89, 456, 70, 70);
		frame.getContentPane().add(btn0);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayLabel.setText("0");
				beforeLabel.setText("0");
			}
		});
		btnC.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnC.setBackground(Color.lightGray);
		btnC.setBounds(163, 456, 70, 70);
		frame.getContentPane().add(btnC);
		
		
		
		JButton btnAng = new JButton("( )");
		btnAng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String beforeStr = beforeLabel.getText();
				String displayStr = displayLabel.getText();
				
				if(beforeStr=="0")	beforeLabel.setText("(");
				
				for(int i = beforeStr.length()-1; i>=0; i--) {
					if(beforeStr.charAt(i) == '(') {
						beforeLabel.setText(beforeStr + displayStr + ")");
						displayLabel.setText("");
						break;
					} else if(beforeStr.charAt(i) == ')') {
						beforeLabel.setText(beforeStr+"(");
						break;
					}
				}
			}
		});
		btnAng.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnAng.setBackground(Color.gray);
		btnAng.setBounds(14, 159, 70, 70);
		frame.getContentPane().add(btnAng);
				
		
		
		JButton btnPer = new JButton("%");
		btnPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String displayStr = displayLabel.getText();
				String beforeStr = beforeLabel.getText();
				
				double result = Double.parseDouble(displayStr)/100;
				displayLabel.setText(result+"");
			}
		});
		btnPer.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnPer.setBackground(Color.gray);
		btnPer.setBounds(89, 159, 70, 70);
		frame.getContentPane().add(btnPer);
				
				
	
		JButton btnDel = new JButton("\u2190");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String displayStr = displayLabel.getText();
				
				if(displayStr.length()==1)	displayLabel.setText("0");
				else {
					String displaySubStr = displayStr.substring(0,displayStr.length()-1);
					displayLabel.setText(displaySubStr);
				}
			}
		});
		btnDel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnDel.setBackground(Color.gray);
		btnDel.setBounds(163, 159, 70, 70);
		frame.getContentPane().add(btnDel);	
		
		
		
		JButton btnAdd = new JButton("+");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String beforeStr = beforeLabel.getText();
				String displayStr = displayLabel.getText();
				
				if(displayStr!="0") {
					if(beforeStr != "0") {
						beforeLabel.setText(beforeStr+displayStr+"+");
						displayLabel.setText("0");
					} else {
						beforeLabel.setText(displayStr+"+");
						displayLabel.setText("0");
					}			
				}
			}
		});
		btnAdd.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnAdd.setBackground(Color.gray);
		btnAdd.setBounds(236, 159, 70, 70);
		frame.getContentPane().add(btnAdd);
		
		
		
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String beforeStr = beforeLabel.getText();
				String displayStr = displayLabel.getText();
				
				if(displayStr!="0") {
					if(beforeStr != "0") {
						beforeLabel.setText(beforeStr+displayStr+"-");
						displayLabel.setText("0");
					} else {
						beforeLabel.setText(displayStr+"-");
						displayLabel.setText("0");
					}			
				}
			}
		});
		btnSub.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnSub.setBackground(Color.gray);
		btnSub.setBounds(236, 234, 70, 70);
		frame.getContentPane().add(btnSub);
		
		
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String beforeStr = beforeLabel.getText();
				String displayStr = displayLabel.getText();
				
				if(displayStr!="0") {
					if(beforeStr != "0") {
						beforeLabel.setText(beforeStr+displayStr+"*");
						displayLabel.setText("0");
					} else {
						beforeLabel.setText(displayStr+"*");
						displayLabel.setText("0");
					}			
				}
			}
		});
		btnMul.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnMul.setBackground(Color.gray);
		btnMul.setBounds(236, 308, 70, 70);
		frame.getContentPane().add(btnMul);
		
		
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String beforeStr = beforeLabel.getText();
				String displayStr = displayLabel.getText();
				
				if(displayStr!="0") {
					if(beforeStr != "0") {
						beforeLabel.setText(beforeStr+displayStr+"/");
						displayLabel.setText("0");
					} else {
						beforeLabel.setText(displayStr+"/");
						displayLabel.setText("0");
					}			
				}
			}
		});
		btnDiv.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnDiv.setBackground(Color.gray);
		btnDiv.setBounds(236, 382, 70, 70);
		frame.getContentPane().add(btnDiv);
		
		
		
		JButton btnResult = new JButton("=");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				beforeLabel.setText(beforeLabel.getText()+displayLabel.getText());
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("js");
				
				try {
					Object result = engine.eval(beforeLabel.getText());
					String resultStr = result.toString();
					
					if(resultStr.substring(resultStr.length()-2).equals(".0")) {
						displayLabel.setText(resultStr.substring(0, resultStr.length()-2));
					}
					else displayLabel.setText(result+"");
					if(resultStr.equals("Infinity"))	displayLabel.setText("0");
				} catch (ScriptException e1) {
					e1.printStackTrace();
				}
				beforeLabel.setText("0");
			}
		});
		btnResult.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		btnResult.setBackground(Color.pink);
		btnResult.setBounds(236, 456, 70, 70);
		frame.getContentPane().add(btnResult);	
		
		
		
		btn0.addActionListener(new NumberAction(displayLabel, beforeLabel, "0"));
		btn1.addActionListener(new NumberAction(displayLabel, beforeLabel, "1"));
		btn2.addActionListener(new NumberAction(displayLabel, beforeLabel, "2"));
		btn3.addActionListener(new NumberAction(displayLabel, beforeLabel, "3"));
		btn4.addActionListener(new NumberAction(displayLabel, beforeLabel, "4"));
		btn5.addActionListener(new NumberAction(displayLabel, beforeLabel, "5"));
		btn6.addActionListener(new NumberAction(displayLabel, beforeLabel, "6"));
		btn7.addActionListener(new NumberAction(displayLabel, beforeLabel, "7"));
		btn8.addActionListener(new NumberAction(displayLabel, beforeLabel, "8"));
		btn9.addActionListener(new NumberAction(displayLabel, beforeLabel, "9"));
	}
}


class NumberAction implements ActionListener{

	private JLabel displayLabel;
	private JLabel beforeLabel;
	private String num;
	
	public NumberAction(JLabel displayLabel, JLabel beforeLabel, String num) {
		this.displayLabel = displayLabel;
		this.beforeLabel = beforeLabel;
		this.num = num;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String displayStr = displayLabel.getText();
		if(displayStr.equals("0"))	displayLabel.setText(num);
		else	displayLabel.setText(displayStr+num);		
	}
}
