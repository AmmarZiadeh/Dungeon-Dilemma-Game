package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import common.Monster;

public class DisplayMonster {
	
	private Monster monster;
	private JLabel monsterIcon;
	private JPanel statsBox;
	private JLabel statsTitle;
	private JLabel statsHealth;
	private JLabel statsAttack;
	private JLabel statsDefence;
	private JLabel statsSpeed;
	private JLabel statsGold;
	private JLabel statsExp;
	
	public DisplayMonster() {
		
		monster = new Monster();
		
		monsterIcon = new JLabel("");
		ImageIcon iconMonster;
		if(monster.getName() == "Goblin") {
			iconMonster = new ImageIcon(DungeonGame.class.getResource("/resources/Goblin.png"));
		} else {
			iconMonster = new ImageIcon(DungeonGame.class.getResource("/resources/Skeleton.png"));
		}
		monsterIcon.setBounds((1808)/2 - 28, (480)/2 + 10, (674)/2 - 30, (761)/2 - 10);
		monsterIcon.setIcon(new ImageIcon(iconMonster.getImage().getScaledInstance(monsterIcon.getWidth(), monsterIcon.getHeight(), Image.SCALE_FAST)));
		
		statsBox = new JPanel();
		statsBox.setOpaque(true);
		statsBox.setLayout(null);
		statsBox.setBackground(Color.YELLOW);
		statsBox.setBounds((1808)/2, (32)/2, (530)/2, (420)/2);
		
		statsTitle = new JLabel(monster.getName() + "'s stats");
		statsTitle.setFont(new Font("Dialog", Font.PLAIN, (40)/2));
		statsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		statsTitle.setBounds(0, 0, (530)/2, (50)/2);
		statsBox.add(statsTitle);
		
		statsHealth = new JLabel("Health: " + monster.getHealth());
		statsHealth.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsHealth.setBounds((10)/2, (62)/2, (monster.toString().length()*8)/2, (40)/2);
		statsBox.add(statsHealth);
		
		statsAttack = new JLabel("Attack: " + monster.getAttack());
		statsAttack.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsAttack.setBounds((10)/2, (114)/2, (monster.toString().length()*8)/2, (40)/2);
		statsBox.add(statsAttack);
		
		statsDefence = new JLabel("Defence: " + monster.getDefence());
		statsDefence.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsDefence.setBounds((10)/2, (166)/2, (monster.toString().length()*8)/2, (40)/2);
		statsBox.add(statsDefence);
		
		statsSpeed = new JLabel("Speed: " + monster.getSpeed());
		statsSpeed.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsSpeed.setBounds((10)/2, (218)/2, (monster.toString().length()*8)/2, (40)/2);
		statsBox.add(statsSpeed);
		
		statsGold = new JLabel("Gold: " + monster.getGold());
		statsGold.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsGold.setBounds((10)/2, (270)/2, (monster.toString().length()*8)/2, (40)/2);
		statsBox.add(statsGold);
		
		statsExp = new JLabel("Exp: " + monster.getExp());
		statsExp.setFont(new Font("Comic Sans MS", Font.BOLD, (30)/2));
		statsExp.setBounds((10)/2, (322)/2, (monster.toString().length()*8)/2, (40)/2);
		statsBox.add(statsExp);
		
	}
	
	public Monster getMonster() {
		
		return monster;
		
	}
	
	public JLabel getMonsterIcon() {
		
		return monsterIcon;
		
	}
	
	public JPanel getMonsterStats() {
		
		return statsBox;
		
	}
	
	public JLabel getSTitle() {
		
		return statsTitle;
		
	}
	
	public JLabel getHealth() {
		
		return statsHealth;
		
	}

}


