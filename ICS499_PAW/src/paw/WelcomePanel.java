package paw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class WelcomePanel extends JPanel {
	
	public ArrayList<String> tmpConfigSettings;
	PAWgui internalgui;
	private int gameLevel;
	private int userGameLevel;
	
	public WelcomePanel(Color color, PAWgui paw) {
		
		internalgui = paw;
		tmpConfigSettings = internalgui.tmpConfigSettings;
		
		setMinimumSize(new Dimension(640,480));
		setBackground(color);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(1, 2));
		
		JPanel pic = new JPanel();
		pic.setBackground(color);
		JLabel logoImage = new JLabel("", new ImageIcon("src/logo.jpg"), SwingConstants.CENTER);
		pic.add(logoImage);
		add(pic);
		
		JPanel text = new JPanel();
		text.setBackground(color);
		text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));
		text.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JTextPane title = new JTextPane();
		title.setBackground(color);
		title.setText(Config.WELCOME_TITLE);
		title.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		text.add(title);
		
		JTextPane body = new JTextPane();
		body.setBackground(color);
		if(Config.DEFAULTMODE.equals("admin")){
			body.setText(Config.ADMIN_WELCOME);
		}else{
			body.setText(Config.WELCOME_MSG);
		}
		body.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		text.add(body);
		
		
		JPanel button = new JPanel();
		button.setBackground(color);
		button.setLayout(new FlowLayout());
		gameLevel = getGameLevel();
		
		JButton setLevelOne = new JButton("Easy");
		setLevelOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Config.DEFAULTMODE.equals("admin")){
						tmpConfigSettings.clear();
						tmpConfigSettings.add("Any");
						tmpConfigSettings.add("1");
						tmpConfigSettings.add("4");
						tmpConfigSettings.add("4");
						tmpConfigSettings.add("true");
						tmpConfigSettings.add("true");
						tmpConfigSettings.add("false");
						tmpConfigSettings.add("5");
						internalgui.setTmpConfigSettings(tmpConfigSettings);
					}else{
						userGameLevel = 1;
						internalgui.tmpConfigSettings.set(1, "1");
						//TODO use this information to populate the user's play panel with a game
					}
					internalgui.initialize();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setLevelOne.setSize(100, 100);
		setLevelOne.setFont(new Font("Sitka Display", Font.BOLD, 16));
		setLevelOne.setBackground(Color.yellow);
		button.add(setLevelOne);
		
		JButton setLevelTwo = new JButton("Medium");
		setLevelTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Config.DEFAULTMODE.equals("admin")){
						tmpConfigSettings.clear();
						tmpConfigSettings.add("Any");
						tmpConfigSettings.add("2");
						tmpConfigSettings.add("6");
						tmpConfigSettings.add("6");
						tmpConfigSettings.add("true");
						tmpConfigSettings.add("true");
						tmpConfigSettings.add("false");
						tmpConfigSettings.add("5");
						internalgui.setTmpConfigSettings(tmpConfigSettings);
					}else{
						userGameLevel = 2;
						internalgui.tmpConfigSettings.set(1, "2");
						//TODO use this information to populate the user's play panel with a game
					}
					internalgui.initialize();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setLevelTwo.setSize(100, 50);
		setLevelTwo.setFont(new Font("Sitka Display", Font.BOLD, 16));
		setLevelTwo.setBackground(Color.yellow);
		button.add(setLevelTwo);

		JButton setLevelThree = new JButton("Hard");
		setLevelThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Config.DEFAULTMODE.equals("admin")){
						tmpConfigSettings.clear();
						tmpConfigSettings.add("Any");
						tmpConfigSettings.add("3");
						tmpConfigSettings.add("6");
						tmpConfigSettings.add("6");
						tmpConfigSettings.add("false");
						tmpConfigSettings.add("true");
						tmpConfigSettings.add("false");
						tmpConfigSettings.add("8");
						internalgui.setTmpConfigSettings(tmpConfigSettings);
					}else{
						userGameLevel = 3;
						internalgui.tmpConfigSettings.set(1, "3");
						//TODO use this information to populate the user's play panel with a game
					}
					internalgui.initialize();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setLevelThree.setSize(100, 50);
		setLevelThree.setFont(new Font("Sitka Display", Font.BOLD, 16));
		setLevelThree.setBackground(Color.yellow);
		button.add(setLevelThree);

		JButton setLevelFour = new JButton("Impossible");
		setLevelFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Config.DEFAULTMODE.equals("admin")){
						tmpConfigSettings.clear();
						tmpConfigSettings.add("Any");
						tmpConfigSettings.add("4");
						tmpConfigSettings.add("6");
						tmpConfigSettings.add("6");
						tmpConfigSettings.add("false");
						tmpConfigSettings.add("false");
						tmpConfigSettings.add("false");
						tmpConfigSettings.add("5");
						internalgui.setTmpConfigSettings(tmpConfigSettings);
					}else{
						userGameLevel = 4;
						internalgui.tmpConfigSettings.set(1, "4");
						//TODO use this information to populate the user's play panel with a game
					}
					internalgui.initialize();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setLevelFour.setSize(100, 50);
		setLevelFour.setFont(new Font("Sitka Display", Font.BOLD, 16));
		setLevelFour.setBackground(Color.yellow);
		button.add(setLevelFour);
		
		text.add(button);
		add(text);
	}

	public int getGameLevel(){
		if(tmpConfigSettings.size() > 0){
			return Integer.valueOf(tmpConfigSettings.get(1));
		}
		return Integer.valueOf(Config.level);
	}

}