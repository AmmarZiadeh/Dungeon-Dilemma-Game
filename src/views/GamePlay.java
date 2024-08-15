package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class GamePlay {
	
	private JPanel infoTabScreen;
	private JLabel infoTabTitle;
	private JLabel infoRule1;
	private JLabel infoRule2;
	private JLabel infoRule3;
	private JLabel infoRule4;
	private JLabel infoRule5;
	private JLabel infoRule6;
	private JButton bufferBtn;
	private JButton attackBtn;
	private JButton defendBtn;
	private JButton runBtn;
	private Timer timer1;
	private int timer1Counter;
	private Timer timer2;
	private int timer2Counter;
	private JLabel dungeonLevel;
	private int level;
	private int fights;
	private int monsterNum;
	private int monstersDefeated;
	private int monsterCounter;
	private JButton infoTab;
	private int stun;
	private JLabel stunned;
	private JLabel gameBackground;
	private boolean characterType;
	
	private DisplayCharacter player;
	private DisplayMonster currentMonster;
	private DisplayShop shop;
	
	private JLabel youWin;
	private JLabel youLose;
	
	private String hax;
	private KeyAdapter haxKey;
	
	public GamePlay(String cName, ImageIcon cIcon, int difficulty) {
		
		timer1 = new Timer(3000, timer1Listener);
		timer2 = new Timer(1500, timer2Listener);
		level = 1;
		fights = 5;
		monstersDefeated = 0;
		stun = 0;
		monsterNum = difficulty;
		hax = "";
		characterType = false;
		
		player = new DisplayCharacter(cName, cIcon);
		monsterCounter = 0;
		currentMonster = createMonster();
		shop = new DisplayShop();
		
		if(player.getPlayer().getHealth() == 120) {
			characterType = true;
		}
		
		infoTabScreen = new JPanel();
		infoTabScreen.setVisible(false);
		infoTabScreen.setLayout(null);
		
		infoTabTitle = new JLabel("Game Info");
		infoTabTitle.setHorizontalAlignment(SwingConstants.CENTER);
		infoTabTitle.setFont(new Font("Dialog", Font.PLAIN, 50));
		infoTabTitle.setBounds(0, 6, 624, 50);
		infoTabScreen.add(infoTabTitle);
		
		infoRule1 = new JLabel("Press \"a\" or click the Attack button to attack");
		infoRule1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		infoRule1.setBounds(10, 156 / 2, 624, 30);
		infoTabScreen.add(infoRule1);
		
		infoRule2 = new JLabel("Press \"d\" or click the Defend button to defend");
		infoRule2.setFont(new Font("SansSerif", Font.PLAIN, 25));
		infoRule2.setBounds(10, 276 / 2, 624, 30);
		infoTabScreen.add(infoRule2);
		
		infoRule3 = new JLabel("**There is a 25% chance of stunning the monster");
		infoRule3.setFont(new Font("SansSerif", Font.PLAIN, 25));
		infoRule3.setBounds(40, 346 / 2, 624, 30);
		infoTabScreen.add(infoRule3);
		
		infoRule4 = new JLabel("Press \"r\" or click the Run button to run");
		infoRule4.setFont(new Font("SansSerif", Font.PLAIN, 25));
		infoRule4.setBounds(10, 466 / 2, 624, 30);
		infoTabScreen.add(infoRule4);
		
		infoRule5 = new JLabel("**You will not gain Exp or Gold");
		infoRule5.setFont(new Font("SansSerif", Font.PLAIN, 25));
		infoRule5.setBounds(40, 536 / 2, 624, 30);
		infoTabScreen.add(infoRule5);
		
		infoRule6 = new JLabel("There are " + (level*fights-monsterCounter) + " monsters left in this level");
		infoRule6.setFont(new Font("SansSerif", Font.PLAIN, 25));
		infoRule6.setBounds(10, 656 / 2, 624, 30);
		infoTabScreen.add(infoRule6);
				
		bufferBtn = new JButton("");
		bufferBtn.setBounds(0, 0, 0, 0);
		bufferBtn.setVisible(false);
		
		attackBtn = new JButton("Attack");
		attackBtn.setBackground(Color.WHITE);
		attackBtn.setFont(new Font("Dialog", Font.PLAIN, (55)/2));
		attackBtn.setBounds((2498/2-250/2)/2, (450)/2, (250)/2, (150)/2);
		attackBtn.setVisible(false);
		
		defendBtn = new JButton("Defend");
		defendBtn.setBackground(Color.WHITE);
		defendBtn.setFont(new Font("Dialog", Font.PLAIN, (55)/2));
		defendBtn.setBounds((2498/2-250/2)/2, (750)/2, (250)/2, (150)/2);
		defendBtn.setVisible(false);
		
		runBtn = new JButton("Run");
		runBtn.setBackground(Color.WHITE);
		runBtn.setFont(new Font("Dialog", Font.PLAIN, (55)/2));
		runBtn.setBounds((2498/2-250/2)/2, (1050)/2, (250)/2, (150)/2);
		runBtn.setVisible(false);
		
		dungeonLevel = new JLabel("Dungeon Level " + level);
		dungeonLevel.setForeground(Color.WHITE);
		dungeonLevel.setFont(new Font("Dialog", Font.PLAIN, (134)/2));
		dungeonLevel.setHorizontalAlignment(SwingConstants.CENTER);
		dungeonLevel.setBounds((2498/2-1134/2)/2, (100)/2, (1134)/2, (170)/2);
		
		infoTab = new JButton("");
		infoTab.setBounds((2498/2-100/2)/2, (10)/2, (100)/2, (100)/2);
		infoTab.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Info Tab.png")).getImage().getScaledInstance(infoTab.getWidth(), infoTab.getHeight(), Image.SCALE_FAST)));
		
		stunned = new JLabel("Monster is stunned");
		stunned.setForeground(Color.DARK_GRAY);
		stunned.setFont(new Font("Dialog", Font.PLAIN, (50)/2));
		stunned.setBounds((1864)/2, (408)/2, (470)/2, (40)/2);
		stunned.setVisible(false);
		
		createEvents();
			
		youWin = new JLabel("You Win");
		youWin.setForeground(Color.GREEN);
		youWin.setFont(new Font("Dialog", Font.PLAIN, (650)/2));
		youWin.setBounds((2498/2-2480/2)/2, (350)/2, (2480)/2, (510)/2);
		youWin.setVisible(false);
		
		youLose = new JLabel("You Died");
		youLose.setForeground(Color.RED);
		youLose.setFont(new Font("Dialog", Font.PLAIN, (604)/2));
		youLose.setBounds((20)/2, (350)/2, (2498)/2, (510)/2);
		youLose.setVisible(false);
		
		gameBackground = new JLabel("");
		gameBackground.setBounds(0, 0, (2498)/2, (1562)/2);
		gameBackground.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Game Background.png")).getImage().getScaledInstance(gameBackground.getWidth(), gameBackground.getHeight(), Image.SCALE_FAST)));
		
		timer1.start();
		
		DungeonGame.addMonster(currentMonster, gameBackground);
		
	}
	
	private DisplayMonster createMonster() {
		
			return new DisplayMonster();
		
	}
	
	private void createEvents() {
		
		bufferBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A && attackBtn.isVisible() && !infoTabScreen.isVisible()) {
					attackMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_D && defendBtn.isVisible() && !infoTabScreen.isVisible()) {
					defendMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_R && runBtn.isVisible() && !infoTabScreen.isVisible()) {
					runMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(true);
					infoTab.setVisible(false);
					attackBtn.setVisible(false);
					defendBtn.setVisible(false);
					runBtn.setVisible(false);
					bufferBtn.requestFocusInWindow();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(false);
					infoTab.setVisible(true);
					if(!timer2.isRunning()) {
						attackBtn.setVisible(true);
						defendBtn.setVisible(true);
						runBtn.setVisible(true);
					}
					bufferBtn.requestFocusInWindow();
				}
			}
		});
		
		attackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				attackMove();
				bufferBtn.requestFocusInWindow();
			}
		});
		
		attackBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					attackMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					defendMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_R) {
					runMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(true);
					infoTab.setVisible(false);
					attackBtn.setVisible(false);
					defendBtn.setVisible(false);
					runBtn.setVisible(false);
					bufferBtn.requestFocusInWindow();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(false);
					infoTab.setVisible(true);
					if(!timer2.isRunning()) {
						attackBtn.setVisible(true);
						defendBtn.setVisible(true);
						runBtn.setVisible(true);
					}
					bufferBtn.requestFocusInWindow();
				}
			}
		});
		
		defendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				defendMove();
				bufferBtn.requestFocusInWindow();
			}
		});
		
		defendBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					attackMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					defendMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_R) {
					runMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(true);
					infoTab.setVisible(false);
					attackBtn.setVisible(false);
					defendBtn.setVisible(false);
					runBtn.setVisible(false);
					bufferBtn.requestFocusInWindow();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(false);
					infoTab.setVisible(true);
					if(!timer2.isRunning()) {
						attackBtn.setVisible(true);
						defendBtn.setVisible(true);
						runBtn.setVisible(true);
					}
					bufferBtn.requestFocusInWindow();
				}
			}
		});
		
		runBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				runMove();
				bufferBtn.requestFocusInWindow();
			}
		});
		
		runBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					attackMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					defendMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_R) {
					runMove();
					bufferBtn.requestFocusInWindow();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(true);
					infoTab.setVisible(false);
					attackBtn.setVisible(false);
					defendBtn.setVisible(false);
					runBtn.setVisible(false);
					bufferBtn.requestFocusInWindow();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(false);
					infoTab.setVisible(true);
					if(!timer2.isRunning()) {
						attackBtn.setVisible(true);
						defendBtn.setVisible(true);
						runBtn.setVisible(true);
					}
					bufferBtn.requestFocusInWindow();
				}
			}
		});
		
		shop.getShopContBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				disableShop();
				dungeonLevel.setVisible(true);
				infoTab.setVisible(true);
				timer1.start();
			}
		});
		
		infoTab.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				infoTabScreen.setVisible(true);
				infoTab.setVisible(false);
				attackBtn.setVisible(false);
				defendBtn.setVisible(false);
				runBtn.setVisible(false);
				bufferBtn.requestFocusInWindow();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				infoTabScreen.setVisible(false);
				infoTab.setVisible(true);
				if(!timer2.isRunning() && !timer1.isRunning()) {
					attackBtn.setVisible(true);
					defendBtn.setVisible(true);
					runBtn.setVisible(true);
				}
				bufferBtn.requestFocusInWindow();
			}
		});
		
		infoTab.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A && attackBtn.isVisible() && !infoTabScreen.isVisible()) {
					attackMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_D && defendBtn.isVisible() && !infoTabScreen.isVisible()) {
					defendMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_R && runBtn.isVisible() && !infoTabScreen.isVisible()) {
					runMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(true);
					infoTab.setVisible(false);
					attackBtn.setVisible(false);
					defendBtn.setVisible(false);
					runBtn.setVisible(false);
					bufferBtn.requestFocusInWindow();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(false);
					bufferBtn.requestFocusInWindow();
				}
			}
		});
		
		hax();
		
	}
	
	ActionListener timer1Listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			timer1Counter = 0;
			timer1Counter += 1;
			if (timer1Counter%2 == 0) {
				dungeonLevel.setVisible(true);
			} else {
				dungeonLevel.setVisible(false);
				bufferBtn.setVisible(true);
				if(!getCharacterIcon().hasFocus()) {
					bufferBtn.requestFocusInWindow();
				}
				attackBtn.setVisible(true);
				defendBtn.setVisible(true);
				runBtn.setVisible(true);
				timer1.stop();
			}
			
		}
	};
	
	ActionListener timer2Listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			timer2Counter = 0;
			timer2Counter += 1;
			if (timer2Counter%2 != 0) {
				currentMonster = createMonster();
				DungeonGame.addMonster(currentMonster, gameBackground);
				currentMonster.getMonsterIcon().setVisible(true);
				currentMonster.getMonsterStats().setVisible(true);
				if(monsterCounter == level*fights && monstersDefeated < 275) {
					enableShop();
					level += 1;
					monsterCounter = 0;
					infoRule6.setText("There are " + (level*fights-monsterCounter) + " monsters left in this level");
					dungeonLevel.setText("Dungeon Level " + level);
				} else {
					bufferBtn.setVisible(true);
					if(!getCharacterIcon().hasFocus()) {
						bufferBtn.requestFocusInWindow();
					}
					attackBtn.setVisible(true);
					defendBtn.setVisible(true);
					runBtn.setVisible(true);
				}
				timer2.stop();
			}
			
		}
	};
	
	public DisplayCharacter getPlayer() {
		
		return player;
		
	}
	
	public JButton getCharacterIcon() {
		
		return player.getCharacterIcon();
		
	}
	
	public JPanel getCharacterStats() {
		
		return player.getCharacterStats();
		
	}
	
	public DisplayMonster getMonster() {
		
		return currentMonster;
		
	}
	
	public JLabel getMonsterIcon() {
		
		return currentMonster.getMonsterIcon();
		
	}
	
	public JPanel getMonsterStats() {
		
		return currentMonster.getMonsterStats();
		
	}
	
	public JPanel getInfoTabScreen() {
		
		return infoTabScreen;
		
	}
	
	public JButton getBufferBtn() {
		
		return bufferBtn;
		
	}
	
	public JButton getAttackBtn() {
		
		return attackBtn;
		
	}
	
	public JButton getDefendBtn() {
		
		return defendBtn;
		
	}

	public JButton getRunBtn() {
	
		return runBtn;
	
	}
	
	public JLabel getDungeonLevel() {
		
		return dungeonLevel;
	
	}
	
	public JButton getInfoTab() {
		
		return infoTab;
		
	}
	
	public JLabel getStunned() {
		
		return stunned;
		
	}
	
	public JLabel getYouWin() {
		
		return youWin;
		
	}
	
	public JLabel getYouLose() {
		
		return youLose;
		
	}
	
	public JLabel getGameBackground(){
		
		return gameBackground;
		
	}
	
	public DisplayShop getShop() {
		
		return shop;
		
	}
	
	private void attackMove() {
		if(stun == 0) {
			if(player.getPlayer().getSpeed() >= currentMonster.getMonster().getSpeed()) {
				player.getPlayer().attack(currentMonster.getMonster());
			} else {
				player.getPlayer().hit(currentMonster.getMonster());
			}
			player.getHealth().setText("Health: " + player.getPlayer().getHealth());
			currentMonster.getHealth().setText("Health: " + currentMonster.getMonster().getHealth());
			if(player.getPlayer().getHealth() == 0) {
				loser();
			}
		} else if(stun == 1) {
			player.getPlayer().attack(currentMonster.getMonster());
			currentMonster.getHealth().setText("Health: " + currentMonster.getMonster().getHealth());
		}
		if(currentMonster.getMonster().getHealth() == 0) {
			currentMonster.getMonsterIcon().setVisible(false);
			currentMonster.getMonsterStats().setVisible(false);
			bufferBtn.setVisible(false);
			attackBtn.setVisible(false);
			defendBtn.setVisible(false);
			runBtn.setVisible(false);
			player.getPlayer().makeMoney(currentMonster.getMonster());
			player.getPlayer().gainExp(currentMonster.getMonster());
			player.getGold().setText("Gold: " + player.getPlayer().getGold());
			player.getExp().setText("Exp: " + player.getPlayer().getExp());
			player.getExpNeeded().setText("Exp to Lvl: " + player.getPlayer().getExpNeeded());
			stun = 0;
			stunned.setVisible(false);
			monstersDefeated += 1;
			monsterCounter += 1;
			infoRule6.setText("There are " + (level*fights-monsterCounter) + " monsters left in this level");
			if(monsterCounter == level*fights && monstersDefeated < monsterNum) {
				infoTab.setVisible(false);
			}
			if(monstersDefeated == monsterNum && player.getPlayer().getHealth() > 0) {
				winner();
			} else {
				timer2.start();
			}
		} else if((currentMonster.getMonster().getHealth() != 0) && (player.getPlayer().getHealth() != 0)){
			if(player.getPlayer().getSpeed() < currentMonster.getMonster().getSpeed()) {
				player.getPlayer().attack(currentMonster.getMonster());
				currentMonster.getHealth().setText("Health: " + currentMonster.getMonster().getHealth());
				if(currentMonster.getMonster().getHealth() == 0) {
					currentMonster.getMonsterIcon().setVisible(false);
					currentMonster.getMonsterStats().setVisible(false);
					bufferBtn.setVisible(false);
					attackBtn.setVisible(false);
					defendBtn.setVisible(false);
					runBtn.setVisible(false);
					player.getPlayer().makeMoney(currentMonster.getMonster());
					player.getPlayer().gainExp(currentMonster.getMonster());
					player.getGold().setText("Gold: " + player.getPlayer().getGold());
					player.getExp().setText("Exp: " + player.getPlayer().getExp());
					player.getExpNeeded().setText("Exp to Lvl: " + player.getPlayer().getExpNeeded());
					monstersDefeated += 1;
					monsterCounter += 1;
					infoRule6.setText("There are " + (level*fights-monsterCounter) + " monsters left in this level");
					if(monsterCounter == level*fights && monstersDefeated < monsterNum) {
						infoTab.setVisible(false);
					}
					if(monstersDefeated == monsterNum && player.getPlayer().getHealth() > 0) {
						winner();
					} else {
						timer2.start();
					}
				}
			} else if(stun != 1){
				player.getPlayer().hit(currentMonster.getMonster());
				player.getHealth().setText("Health: " + player.getPlayer().getHealth());
				if(player.getPlayer().getHealth() == 0) {
					loser();
				}
			}
			stun = 0;
			currentMonster.getMonsterIcon().setEnabled(true);
			stunned.setVisible(false);
			player.getHealth().setText("Health: " + player.getPlayer().getHealth());
			currentMonster.getHealth().setText("Health: " + currentMonster.getMonster().getHealth());
		}
		if(player.getPlayer().getExpNeeded() == 0) {
			if(characterType) {
				player.getPlayer().setHealth(120);
			} else {
				player.getPlayer().setHealth(100);
			}
			player.getPlayer().setExpNeeded(150);
			player.getHealth().setText("Health: " + player.getPlayer().getHealth());
			player.getExpNeeded().setText("Exp to Lvl: " + player.getPlayer().getExpNeeded());
		}
	}
	
	private void defendMove() {
		if(stun == 0) {
			player.getPlayer().defend(currentMonster.getMonster());
			player.getHealth().setText("Health: " + player.getPlayer().getHealth());
			currentMonster.getHealth().setText("Health: " + currentMonster.getMonster().getHealth());
			if(player.getPlayer().getHealth() == 0) {
				loser();
			}
		} else if(stun == 1){
			stun = 0;
			currentMonster.getMonsterIcon().setEnabled(true);
			stunned.setVisible(false);
		}
		if(player.getPlayer().getHealth() > 0) {
			stun = player.getPlayer().stun(currentMonster.getMonster());
			if(stun == 1) {
				currentMonster.getMonsterIcon().setEnabled(false);
				stunned.setVisible(true);
			}
		}
	}
	
	private void runMove() {
		if(stun == 0) {
			player.getPlayer().run(currentMonster.getMonster());
			player.getHealth().setText("Health: " + player.getPlayer().getHealth());
			if(player.getPlayer().getHealth() == 0) {
				loser();
			}
		} else if(stun == 1){
			stun = 0;
			currentMonster.getMonsterIcon().setEnabled(true);
			stunned.setVisible(false);
		}
		currentMonster.getMonsterIcon().setVisible(false);
		currentMonster.getMonsterStats().setVisible(false);
		bufferBtn.setVisible(false);
		attackBtn.setVisible(false);
		defendBtn.setVisible(false);
		runBtn.setVisible(false);
		monstersDefeated += 1;
		monsterCounter += 1;
		infoRule6.setText("There are " + (level*fights-monsterCounter) + " monsters left in this level");
		if(monsterCounter == level*fights && monstersDefeated < 275) {
			infoTab.setVisible(false);
		}
		if(monstersDefeated == 55 && player.getPlayer().getHealth() > 0) {
			winner();
		} else {
			timer2.start();
		}
	}
	
	private void enableShop() {
		
		bufferBtn.setVisible(false);
		attackBtn.setVisible(false);
		defendBtn.setVisible(false);
		runBtn.setVisible(false);
		player.getCharacterStats().setVisible(false);
		player.getCharacterIcon().setVisible(false);
		currentMonster.getMonsterStats().setVisible(false);
		currentMonster.getMonsterIcon().setVisible(false);
		infoTab.setVisible(false);
		gameBackground.setVisible(false);
		shop.getShopScreen().setVisible(true);
		
	}
	
	private void disableShop() {
		
		shop.getShopScreen().setVisible(false);
		player.getCharacterStats().setVisible(true);
		player.getCharacterIcon().setVisible(true);
		currentMonster.getMonsterStats().setVisible(true);
		currentMonster.getMonsterIcon().setVisible(true);
		infoTab.setVisible(true);
		gameBackground.setVisible(true);
		
	}
		
	private void winner() {
		
		getCharacterIcon().removeKeyListener(haxKey);
		bufferBtn.setVisible(false);
		attackBtn.setVisible(false);
		defendBtn.setVisible(false);
		runBtn.setVisible(false);
		infoTab.setVisible(false);
		youWin.setVisible(true);
		
	}
	
	private void loser() {
		
		timer2.stop();
		bufferBtn.setVisible(false);
		attackBtn.setVisible(false);
		defendBtn.setVisible(false);
		runBtn.setVisible(false);
		infoTab.setVisible(false);
		player.getCharacterIcon().setVisible(false);
		player.getCharacterStats().setVisible(false);
		youLose.setVisible(true);
		
	}
	
	private void hax() {
		
		getCharacterIcon().addKeyListener(haxKey = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_H && !infoTabScreen.isVisible()) {
					hax = "h";
				} else if(e.getKeyCode() == KeyEvent.VK_A && hax.equals("h")) {
					hax = "ha";
				} else if(e.getKeyCode() == KeyEvent.VK_X && hax.equals("ha")) {
					hax = "";
					player.getPlayer().setName("48H61H78H");
					player.getPlayer().setHealth(99999);
					player.getPlayer().setAttack(9999);
					player.getPlayer().setDefence(9999);
					player.getPlayer().setSpeed(999);
					player.getPlayer().setGold(9999);
					player.getPlayer().setExp(99999);
					player.getPlayer().setExpNeeded(9999999);
					player.getTitle(0).setText(player.getPlayer().getName() + "'s stats");
					player.getHealth().setText("Health: " + player.getPlayer().getHealth());
					player.getAttack().setText("Attack: " + player.getPlayer().getAttack());
					player.getDefence().setText("Defence: " + player.getPlayer().getDefence());
					player.getGold().setText("Gold: " + player.getPlayer().getGold());
					player.getSpeed().setText("Speed: " + player.getPlayer().getSpeed());
					player.getExp().setText("Exp: " + player.getPlayer().getExp());
					player.getExpNeeded().setText("Exp to Lvl: " + player.getPlayer().getExpNeeded());
					bufferBtn.requestFocusInWindow();
				} else {
					hax = "";
				}
				if(e.getKeyCode() == KeyEvent.VK_A && !hax.equals("ha") && attackBtn.isVisible() && !infoTabScreen.isVisible()) {
					attackMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_D  && defendBtn.isVisible() && !infoTabScreen.isVisible()) {
					defendMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_R  && runBtn.isVisible() && !infoTabScreen.isVisible()) {
					runMove();
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(true);
					infoTab.setVisible(false);
					attackBtn.setVisible(false);
					defendBtn.setVisible(false);
					runBtn.setVisible(false);
					bufferBtn.requestFocusInWindow();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					infoTabScreen.setVisible(false);
					infoTab.setVisible(true);
					if(!timer2.isRunning() && !timer1.isRunning()) {
						attackBtn.setVisible(true);
						defendBtn.setVisible(true);
						runBtn.setVisible(true);
					}
					infoTab.requestFocusInWindow();
				}
			}
		});
		
	}

}
