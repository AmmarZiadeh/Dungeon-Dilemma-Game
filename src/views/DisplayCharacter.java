package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.Character;

public class DisplayCharacter {

	private Character player;
	private JButton characterIcon;
	private JPanel statsBox;
	private JLabel statsTitle;
	private JLabel statsHealth;
	private JLabel statsAttack;
	private JLabel statsDefence;
	private JLabel statsSpeed;
	private JLabel statsGold;
	private JLabel statsExp;
	private JLabel statsExpNeeded;
	
	public DisplayCharacter(String n, ImageIcon i) {
		
		player = new Character(n);
		
		if(i.getDescription().equals("file:/C:/Users/ammar/eclipse-workspace/Java%20Game/bin/resources/Knight.png")) {
			player.setHealth(120);
			player.setDefence(3);
		} else if(i.getDescription().equals("file:/C:/Users/ammar/eclipse-workspace/Java%20Game/bin/resources/Archer.png")) {
			player.setSpeed(3);
		} else if(i.getDescription().equals("file:/C:/Users/ammar/eclipse-workspace/Java%20Game/bin/resources/Mage.png")) {
			player.setAttack(14);
		}
		
		characterIcon = new JButton("");
		characterIcon.setContentAreaFilled(false);
		characterIcon.setBorderPainted(false);
		characterIcon.setBounds((160)/2, (480)/2, (674)/2, (761)/2);
		characterIcon.setIcon(new ImageIcon(i.getImage().getScaledInstance(characterIcon.getWidth(), characterIcon.getHeight(), Image.SCALE_FAST)));
		
		statsBox = new JPanel();
		statsBox.setOpaque(true);
		statsBox.setLayout(null);
		statsBox.setBackground(Color.YELLOW);
		statsBox.setBounds((150)/2, (32)/2, (530)/2, (420)/2);
		
		statsTitle = new JLabel(player.getName() + "'s stats");
		statsTitle.setFont(new Font("Dialog", Font.PLAIN, (40)/2));
		statsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		statsTitle.setBounds(0, 0, (player.toString().length()*8)/2, (50)/2);
		statsBox.add(statsTitle);
		
		statsHealth = new JLabel("Health: " + player.getHealth());
		statsHealth.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsHealth.setBounds((10)/2, (62)/2, (player.toString().length()*8)/2, (40)/2);
		statsBox.add(statsHealth);
		
		statsAttack = new JLabel("Attack: " + player.getAttack());
		statsAttack.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsAttack.setBounds((10)/2, (114)/2, (player.toString().length()*8)/2, (40)/2);
		statsBox.add(statsAttack);
		
		statsDefence = new JLabel("Defence: " + player.getDefence());
		statsDefence.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsDefence.setBounds((10)/2, (166)/2, (player.toString().length()*8)/2, (40)/2);
		statsBox.add(statsDefence);
		
		statsSpeed = new JLabel("Speed: " + player.getSpeed());
		statsSpeed.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsSpeed.setBounds((10)/2, (218)/2, (player.toString().length()*8)/2, (40)/2);
		statsBox.add(statsSpeed);
		
		statsGold = new JLabel("Gold: " + player.getGold());
		statsGold.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsGold.setBounds((10)/2, (270)/2, (player.toString().length()*8)/2, (40)/2);
		statsBox.add(statsGold);
		
		statsExp = new JLabel("Exp: " + player.getExp());
		statsExp.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsExp.setBounds((10)/2, (322)/2, (player.toString().length()*8)/2, (40)/2);
		statsBox.add(statsExp);
		
		statsExpNeeded = new JLabel("Exp to Lvl: " + player.getExpNeeded());
		statsExpNeeded.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsExpNeeded.setBounds((10)/2, (374)/2, (player.toString().length()*8)/2, (40)/2);
		statsBox.add(statsExpNeeded);
		
	}
	
	public Character getPlayer() {
		
		return player;
		
	}
	
	public JButton getCharacterIcon() {
		
		return characterIcon;
		
	}
	
	public JPanel getCharacterStats() {
		
		return statsBox;
		
	}
	
	public JLabel getTitle(int a) {
		
		return statsTitle;
		
	}
	
	public JLabel getHealth() {
		
		return statsHealth;
		
	}
	
	public JLabel getAttack() {
		
		return statsAttack;
		
	}
	
	public JLabel getDefence() {
		
		return statsDefence;
	
	}

	public JLabel getSpeed() {
	
		return statsSpeed;
	
	}
	
	public JLabel getGold() {
		
		return statsGold;
	
	}
	
	public JLabel getExp() {
		
		return statsExp;
	
	}
	
	public JLabel getExpNeeded() {
		
		return statsExpNeeded;
	
	}
	
}
