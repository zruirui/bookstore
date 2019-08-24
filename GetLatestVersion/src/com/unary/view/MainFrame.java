package com.unary.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.unary.control.Execute;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	String m_sourcePath = null; //源路径
	String m_destPath = null; //目标路径
	private static Logger logger = Logger.getLogger(MainFrame.class);
	private JTextField source_textField;
	private JTextField dest_textField;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 306);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		//源目录 "浏览" 按钮
		JButton sourceBtn = new JButton("浏览");
		sourceBtn.setFont(new Font("宋体", Font.PLAIN, 16));
		sourceBtn.setBounds(356, 40, 75, 37);
		contentPanel.add(sourceBtn);
		sourceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnVal = jFileChooser.showOpenDialog(jFileChooser);
				if(returnVal == JFileChooser.APPROVE_OPTION){
					m_sourcePath = jFileChooser.getSelectedFile().getAbsolutePath();
					source_textField.setText(m_sourcePath);
					logger.info("源目录路径为：" + m_sourcePath);						
				}	
	 		}
		});
			
		//目标目录 "浏览" 按钮
		JButton destBtn = new JButton("浏览");
		destBtn.setFont(new Font("宋体", Font.PLAIN, 16));
		destBtn.setBounds(356, 100, 75, 37);
		contentPanel.add(destBtn);
		destBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int i = jFileChooser.showOpenDialog(jFileChooser);
		        if(i== JFileChooser.APPROVE_OPTION){ //打开文件
		        	m_destPath = jFileChooser.getSelectedFile().getAbsolutePath();//目标路径
		        	dest_textField.setText(m_destPath);
		            logger.info("目标路径："+m_destPath);
		        }else{
		        	logger.error("没有选择目标路径");
		        }
			}
		});
			
		//"执行" 按钮
		JButton getBtn = new JButton("执 行");
		getBtn.setFont(new Font("宋体", Font.PLAIN, 16));
		getBtn.setBounds(231, 187, 101, 45);
		contentPanel.add(getBtn);
		getBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == getBtn) {
					m_sourcePath = source_textField.getText();
					m_destPath = dest_textField.getText();
					System.out.println(m_sourcePath);
					if(m_sourcePath == null || m_sourcePath.equals("")) {		
						JOptionPane.showMessageDialog(null, "未选择源路径！ ", "出错 ", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(m_destPath == null || m_destPath.equals("")) {
						JOptionPane.showMessageDialog(null, "未选择目标路径！ ", "出错 ", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Execute exe = new Execute(m_sourcePath,m_destPath);
					String result = exe.operate();
					JOptionPane.showMessageDialog(null, result, "拷贝结果", JOptionPane.INFORMATION_MESSAGE);		
				}				
			}
		});
		
		//输入"源路径" 的文本框
		source_textField = new JTextField();
		source_textField.setBounds(185, 44, 147, 32);
		contentPanel.add(source_textField);
		source_textField.setColumns(10);
		
		//输入 "目标路径" 的文本框
		dest_textField = new JTextField();
		dest_textField.setBounds(185, 104, 147, 32);
		contentPanel.add(dest_textField);
		dest_textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("源目录：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(112, 46, 63, 26);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("目标目录：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 106, 75, 26);
		contentPanel.add(lblNewLabel_1);
	}

}
