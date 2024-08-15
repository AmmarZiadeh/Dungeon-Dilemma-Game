package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class DungeonGame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static DungeonGame frame;
	private JPanel cptMain;
	private JPanel titleScreen;
	private JLabel titleName;
	private JButton startBtn;
	private JButton infoBtn;
	private JLabel titleBackground;
	private boolean infoTitleScreen;
	private boolean releasedBtn;
	private JButton infoBackBtn;
	private JLabel infoTitle;
	private JLabel infoRules1;
	private JLabel infoRules2;
	private JLabel infoRules3;
	private JLabel infoTitleBackground;
	private JPanel selectScreen;
	private JLabel selectHeroTitle;
	private JLabel selectHero1;
	private JLabel selectHero2;
	private JLabel selectHero3;
	private ImageIcon iconSBorder;
	private JLabel selectBorder;
	private JLabel selectDifficulty;
	private JLabel selectEasyBtn;
	private JLabel selectHardBtn;
	private int difficultyKey;
	private boolean difficultySelected;
	private JLabel selectEasyBorder;
	private JLabel selectHardBorder;
	private ImageIcon unselectedDifficulty;
	private ImageIcon selectedDifficulty;
	private ImageIcon selectedHero;
	private boolean heroSelected;
	private JTextField selectName;
	private JLabel selectNameTitle;
	private JLabel selectNext;
	private JLabel selectBackground;
	private static JPanel gameScreen;

	private static GamePlay battle;

	public Monitor screen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DungeonGame();
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
	public DungeonGame() {

		initComponents();
		createEvents();

	}

	private void initComponents() {

		screen = new Monitor();
		infoTitleScreen = false;
		releasedBtn = true;
		heroSelected = false;
		difficultySelected = false;

		setTitle("Dungeon Dilemma");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(DungeonGame.class.getResource("/resources/Dugeon Game Icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(screen.getMidX() - screen.getScreenWidth() / 5, screen.getMidY() - screen.getScreenHeight() / 4,
				(int) (screen.getScreenWidth() / 2.5), (int) (screen.getScreenHeight() / 2.5));
		cptMain = new JPanel();
		cptMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		cptMain.setLayout(null);
		setContentPane(cptMain);
		setResizable(false);

		titleScreen = new JPanel();
		titleScreen.setBounds(0, 0, getWidth(), getHeight());
		titleScreen.setLayout(null);
		cptMain.add(titleScreen);

		titleName = new JLabel("Dungeon Dilemma");
		titleName.setHorizontalAlignment(SwingConstants.CENTER);
		titleName.setForeground(new Color(255, 0, 0));
		titleName.setBounds(0, 0, titleScreen.getWidth(), (int) (titleScreen.getHeight() / 2.3));
		titleName.setBounds(titleScreen.getWidth() - titleName.getWidth() + titleName.getWidth() / titleName.getHeight(), 0, titleName.getWidth(), titleName.getHeight());
		titleName.setFont(new Font("Dialog", Font.PLAIN, (int) ((getWidth() - getHeight()) / 4)));
		titleScreen.add(titleName);

		startBtn = new JButton("Start");
		startBtn.setBackground(Color.WHITE);
		startBtn.setBounds(0, 0, titleScreen.getWidth() / 5, titleScreen.getHeight() / 6);
		startBtn.setBounds(titleScreen.getWidth() / 2 - startBtn.getWidth() / 2, (int) (titleScreen.getHeight() / 2.65), startBtn.getWidth(), startBtn.getHeight());
		startBtn.setFont(new Font("Dialog", Font.PLAIN, (titleScreen.getHeight() / startBtn.getWidth()) * 10));
		titleScreen.add(startBtn);

		infoBtn = new JButton("Info");
		infoBtn.setBackground(Color.WHITE);
		infoBtn.setFont(new Font("Dialog", Font.PLAIN, (titleScreen.getHeight() / startBtn.getWidth()) * 10));
		infoBtn.setBounds(0, 0, titleScreen.getWidth() / 5, titleScreen.getHeight() / 6);
		infoBtn.setBounds(titleScreen.getWidth() / 2 - infoBtn.getWidth() / 2, (int) (titleScreen.getHeight() / 1.6), infoBtn.getWidth(), infoBtn.getHeight());
		titleScreen.add(infoBtn);

		titleBackground = new JLabel("");
		titleBackground.setBounds(0, 0, titleScreen.getWidth(), titleScreen.getHeight());
		titleBackground.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/TitleScreen Background.png")).getImage().getScaledInstance(titleBackground.getWidth(), titleBackground.getHeight(), Image.SCALE_FAST)));
		titleScreen.add(titleBackground);

		infoBackBtn = new JButton("");
		infoBackBtn.setBounds(15, 15, titleScreen.getWidth() / 11, titleScreen.getWidth() / 11);
		infoBackBtn.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Info Back Arrow.png")).getImage().getScaledInstance(infoBackBtn.getWidth(), infoBackBtn.getHeight(), Image.SCALE_FAST)));
		titleScreen.add(infoBackBtn);

		infoTitle = new JLabel("Rules");
		infoTitle.setFont(new Font("Dialog", Font.PLAIN, (int) ((titleScreen.getWidth()-titleScreen.getHeight())/4*1.09)));
		infoTitle.setBounds((int) ((titleScreen.getWidth()-titleScreen.getHeight())*1.07), (titleScreen.getWidth()-titleScreen.getHeight())/8, (int) ((titleScreen.getWidth()-titleScreen.getHeight())/1.4), (int) ((titleScreen.getWidth()-titleScreen.getHeight())/4.5));
		infoTitle.setVisible(false);
		titleScreen.add(infoTitle);

		infoRules1 = new JLabel("  1.)  There are 10 levels in the dungeon.");
		infoRules1.setFont(new Font("SansSerif", Font.PLAIN, (int) ((titleScreen.getWidth()-titleScreen.getHeight())/16*1.09)));
		infoRules1.setBounds(0, (titleScreen.getWidth()-titleScreen.getHeight())/3, (int) (titleScreen.getWidth()), (int) ((titleScreen.getWidth()-titleScreen.getHeight())/4.5));
		infoRules1.setVisible(false);
		titleScreen.add(infoRules1);

		infoRules2 = new JLabel("  2.)  The monster count starts at 5 and increases by 5 each dungeon level.");
		infoRules2.setFont(new Font("SansSerif", Font.PLAIN, (int) ((titleScreen.getWidth()-titleScreen.getHeight())/16*1.09)));
		infoRules2.setBounds(0, (titleScreen.getWidth()-titleScreen.getHeight())/3 + 100, (int) (titleScreen.getWidth()), (int) ((titleScreen.getWidth()-titleScreen.getHeight())/4.5));
		infoRules2.setVisible(false);
		titleScreen.add(infoRules2);

		infoRules3 = new JLabel("  3.)  There are three move a player can perform: \"Attack\", \"Defend\", and \"Run\".");
		infoRules3.setFont(new Font("SansSerif", Font.PLAIN, (int) ((titleScreen.getWidth()-titleScreen.getHeight())/16*1.09)));
		infoRules3.setBounds(0, (titleScreen.getWidth()-titleScreen.getHeight())/3 + 200, (int) (titleScreen.getWidth()), (int) ((titleScreen.getWidth()-titleScreen.getHeight())/4.5));
		infoRules3.setVisible(false);
		titleScreen.add(infoRules3);

		infoTitleBackground = new JLabel("");
		infoTitleBackground.setBounds(0, 0, titleScreen.getWidth(), titleScreen.getHeight());
		infoTitleBackground.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/TitleScreen Background.png")).getImage().getScaledInstance(infoTitleBackground.getWidth(), infoTitleBackground.getHeight(), Image.SCALE_FAST)));
		infoTitleBackground.setEnabled(false);
		infoTitleBackground.setVisible(false);
		titleScreen.add(infoTitleBackground);

		selectScreen = new JPanel();
		selectScreen.setBounds(0, 0, (int) (titleScreen.getWidth()*2.285), (int) (titleScreen.getHeight()*2.148));
		selectScreen.setVisible(false);
		selectScreen.setLayout(null);
		cptMain.add(selectScreen);

		selectHeroTitle = new JLabel("Select Your Hero");
		selectHeroTitle.setFont(new Font("SansSerif", Font.PLAIN, (int) ((selectScreen.getWidth()-selectScreen.getHeight())/9.2)-1));
		selectHeroTitle.setBounds((int) ((selectScreen.getWidth()-selectScreen.getHeight())/1.063), (int) ((selectScreen.getWidth()-selectScreen.getHeight())/9.2), (int) ((selectScreen.getWidth()-selectScreen.getHeight())/1.17), (int) ((selectScreen.getWidth()-selectScreen.getHeight())/9.2));
		selectScreen.add(selectHeroTitle);
		
		iconSBorder = new ImageIcon(DungeonGame.class.getResource("/resources/Selection Border.png"));
		selectBorder = new JLabel("");
		selectBorder.setVisible(false);
		selectScreen.add(selectBorder);
		
		selectHero1 = new JLabel("");
		selectHero1.setBounds(200 / 2, 300 / 2, 674 / 2, 761 / 2);
		selectHero1.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Knight.png")).getImage().getScaledInstance(selectHero1.getWidth(), selectHero1.getHeight(), Image.SCALE_FAST)));
		selectScreen.add(selectHero1);
		
		selectHero2 = new JLabel("");
		selectHero2.setBounds(0, 0, 100, 100);
//		selectHero2.setBounds(0, 0, (int) ((selectScreen.getWidth()-selectScreen.getHeight())/1.44), (int) ((selectScreen.getWidth()-selectScreen.getHeight())/1.245));
//		selectHero2.setBounds((int) ((selectScreen.getWidth()-selectHero2.getWidth())/1.9), (int) ((selectScreen.getWidth()-selectScreen.getHeight())/3.11), selectHero2.getWidth(), selectHero2.getHeight());
		selectHero2.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Archer.png")).getImage().getScaledInstance(selectHero2.getWidth(), selectHero2.getHeight(), Image.SCALE_FAST)));
		selectScreen.add(selectHero2);

		selectHero3 = new JLabel("");
		selectHero3.setBounds(1750 / 2, 300 / 2, 668 / 2, 758 / 2);
		selectHero3.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Mage.png")).getImage().getScaledInstance(selectHero3.getWidth(), selectHero3.getHeight(), Image.SCALE_FAST)));
		selectScreen.add(selectHero3);

		selectDifficulty = new JLabel("Select A Difficulty");
		selectDifficulty.setFont(new Font("SansSerif", Font.PLAIN, 66/2));
		selectDifficulty.setBounds(1600 / 2, 1116 / 2, 520 / 2, 100 / 2);
		selectDifficulty.setVisible(false);
		selectScreen.add(selectDifficulty);

		selectEasyBtn = new JLabel("Easy");
		selectEasyBtn.setFont(new Font("Dialog", Font.PLAIN, 35));
		selectEasyBtn.setHorizontalAlignment(SwingConstants.CENTER);
		selectEasyBtn.setBackground(Color.WHITE);
		selectEasyBtn.setBounds(1470 / 2, 1250 / 2, 300 / 2, 150 / 2);
		selectEasyBtn.setVisible(false);
		selectScreen.add(selectEasyBtn);

		selectHardBtn = new JLabel("Hard");
		selectHardBtn.setFont(new Font("Dialog", Font.PLAIN, 35));
		selectHardBtn.setHorizontalAlignment(SwingConstants.CENTER);
		selectHardBtn.setBackground(Color.WHITE);
		selectHardBtn.setBounds(1920/2, 1250/2, 300/2, 150/2);
		selectHardBtn.setVisible(false);
		selectScreen.add(selectHardBtn);
		
		selectEasyBorder = new JLabel("");
		selectEasyBorder.setBounds(selectEasyBtn.getBounds());
		selectEasyBorder.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Difficulty Button.png")).getImage().getScaledInstance(selectEasyBorder.getWidth(), selectEasyBorder.getHeight(), Image.SCALE_FAST)));
		selectEasyBorder.setVisible(false);
		selectScreen.add(selectEasyBorder);

		selectHardBorder = new JLabel("");
		selectHardBorder.setBounds(selectHardBtn.getBounds());
		selectHardBorder.setIcon(selectEasyBorder.getIcon());
		selectHardBorder.setVisible(false);
		selectScreen.add(selectHardBorder);
		
		unselectedDifficulty = (ImageIcon) selectEasyBorder.getIcon();
		selectedDifficulty = new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Difficulty Border.png")).getImage().getScaledInstance(selectEasyBorder.getWidth(), selectEasyBorder.getHeight(), Image.SCALE_FAST));

		selectNameTitle = new JLabel("Enter Your Hero's Name:");
		selectNameTitle.setFont(new Font("SansSerif", Font.PLAIN, 50/2));
		selectNameTitle.setBounds(130/2, 1230/2, 570/2, 100/2);
		selectNameTitle.setVisible(false);
		selectScreen.add(selectNameTitle);

		selectName = new JTextField();
		selectName.setFont(new Font("SansSerif", Font.PLAIN, 45/2));
		selectName.setBounds(708/2, 1236/2, 500/2, 100/2);
		selectName.setVisible(false);
		selectScreen.add(selectName);
		
		selectNext = new JLabel("Press \"Enter\" to Continue");
		selectNext.setFont(new Font("SansSerif", Font.PLAIN, 18));
		selectNext.setBounds(0, 0, 230, 100);
//		selectNext.setBounds(selectScreen.getWidth() - selectNext.getWidth(), selectScreen.getHeight() - selectNext.getHeight(), selectNext.getWidth(), selectNext.getHeight());
		selectNext.setVisible(false);
		selectScreen.add(selectNext);

		selectBackground = new JLabel("");
		selectBackground.setBounds(0, 0, 2498/2, 1562/2);
		selectBackground.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Gray Background.png")).getImage().getScaledInstance(selectBackground.getWidth(), selectBackground.getHeight(), Image.SCALE_FAST)));
		selectScreen.add(selectBackground);

		gameScreen = new JPanel();
		gameScreen.setBounds(0, 0, 2498/2, 1562/2);
		gameScreen.setVisible(false);
		gameScreen.setLayout(null);
		cptMain.add(gameScreen);

	}

	private void createEvents() {

		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectScreen.setVisible(true);
				titleScreen.setVisible(false);
				setBounds(screen.getMidX()-selectScreen.getWidth()/2, screen.getMidY()-selectScreen.getHeight()/2, (2498) / 2, (1562) / 2);
			}
		});

		startBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					selectScreen.setVisible(true);
					titleScreen.setVisible(false);
					setBounds(screen.getMidX()-selectScreen.getWidth()/2, screen.getMidY()-selectScreen.getHeight()/2, (2498) / 2, (1562) / 2);
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE && releasedBtn) {
					titleBackground.setVisible(false);
					titleName.setVisible(false);
					startBtn.setVisible(false);
					infoBtn.setVisible(false);
					infoTitle.setVisible(true);
					infoRules1.setVisible(true);
					infoRules2.setVisible(true);
					infoRules3.setVisible(true);
					infoTitleBackground.setVisible(true);
					infoTitleScreen = true;
					releasedBtn = false;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					releasedBtn = true;
				}
			}
		});

		infoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				titleBackground.setVisible(false);
				titleName.setVisible(false);
				startBtn.setVisible(false);
				infoBtn.setVisible(false);
				infoTitle.setVisible(true);
				infoRules1.setVisible(true);
				infoRules2.setVisible(true);
				infoRules3.setVisible(true);
				infoTitleBackground.setVisible(true);
				infoTitleScreen = true;
			}
		});

		infoBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					selectScreen.setVisible(true);
					titleScreen.setVisible(false);
					setBounds(screen.getMidX()-selectScreen.getWidth()/2, screen.getMidY()-selectScreen.getHeight()/2, (2498) / 2, (1562) / 2);
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					titleBackground.setVisible(false);
					titleName.setVisible(false);
					startBtn.setVisible(false);
					infoBtn.setVisible(false);
					infoTitle.setVisible(true);
					infoRules1.setVisible(true);
					infoRules2.setVisible(true);
					infoRules3.setVisible(true);
					infoTitleBackground.setVisible(true);
					infoTitleScreen = true;
					releasedBtn = false;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					releasedBtn = true;
				}
			}
		});

		infoBackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (infoTitleScreen) {
					infoTitle.setVisible(false);
					infoRules1.setVisible(false);
					infoRules2.setVisible(false);
					infoRules3.setVisible(false);
					infoTitleBackground.setVisible(false);
					startBtn.setVisible(true);
					infoBtn.setVisible(true);
					titleName.setVisible(true);
					titleBackground.setVisible(true);
					infoTitleScreen = false;
				}
			}
		});

		infoBackBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && !infoTitleScreen) {
					selectScreen.setVisible(true);
					titleScreen.setVisible(false);
					setBounds(screen.getMidX()-selectScreen.getWidth()/2, screen.getMidY()-selectScreen.getHeight()/2, (2498) / 2, (1562) / 2);
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE && infoTitleScreen && releasedBtn) {
					infoTitle.setVisible(false);
					infoRules1.setVisible(false);
					infoRules2.setVisible(false);
					infoRules3.setVisible(false);
					infoTitleBackground.setVisible(false);
					startBtn.setVisible(true);
					infoBtn.setVisible(true);
					titleName.setVisible(true);
					titleBackground.setVisible(true);
					infoTitleScreen = false;
					releasedBtn = false;
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE && !infoTitleScreen && releasedBtn) {
					titleBackground.setVisible(false);
					titleName.setVisible(false);
					startBtn.setVisible(false);
					infoBtn.setVisible(false);
					infoTitle.setVisible(true);
					infoRules1.setVisible(true);
					infoRules2.setVisible(true);
					infoRules3.setVisible(true);
					infoTitleBackground.setVisible(true);
					infoTitleScreen = true;
					releasedBtn = false;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					releasedBtn = true;
				}
			}
		});

		selectHero1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectBorder.setBounds(selectHero1.getX(), 299/2, selectHero1.getWidth(), 763/2);
				Image scaledSBorder = iconSBorder.getImage().getScaledInstance(selectBorder.getWidth(), selectBorder.getHeight(), Image.SCALE_FAST);
				ImageIcon newIconSBorder = new ImageIcon(scaledSBorder);
				selectBorder.setIcon(newIconSBorder);
				selectBorder.setVisible(true);
				if(!heroSelected) {
					heroSelected = true;
					selectDifficulty.setVisible(true);
					selectEasyBtn.setVisible(true);
					selectHardBtn.setVisible(true);
					selectEasyBorder.setVisible(true);
					selectHardBorder.setVisible(true);
					selectNameTitle.setVisible(true);
					selectName.setVisible(true);
				}
				selectedHero = new ImageIcon(DungeonGame.class.getResource("/resources/Knight.png"));
			}
		});

		selectHero2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectBorder.setBounds(selectHero2.getX(), 299 / 2, selectHero2.getWidth(), 763 / 2);
				Image scaledSBorder = iconSBorder.getImage().getScaledInstance(selectBorder.getWidth(), selectBorder.getHeight(),
						Image.SCALE_FAST);
				ImageIcon newIconSBorder = new ImageIcon(scaledSBorder);
				selectBorder.setIcon(newIconSBorder);
				selectBorder.setVisible(true);
				if (!heroSelected) {
					heroSelected = true;
					selectDifficulty.setVisible(true);
					selectEasyBtn.setVisible(true);
					selectHardBtn.setVisible(true);
					selectEasyBorder.setVisible(true);
					selectHardBorder.setVisible(true);
					selectNameTitle.setVisible(true);
					selectName.setVisible(true);
				}
				selectName.requestFocusInWindow();
				selectedHero = new ImageIcon(DungeonGame.class.getResource("/resources/Archer.png"));
			}
		});

		selectHero3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectBorder.setBounds(selectHero3.getX(), 299/2, selectHero3.getWidth(), 763/2);
				Image scaledSBorder = iconSBorder.getImage().getScaledInstance(selectBorder.getWidth(), selectBorder.getHeight(),
						Image.SCALE_FAST);
				ImageIcon newIconSBorder = new ImageIcon(scaledSBorder);
				selectBorder.setIcon(newIconSBorder);
				selectBorder.setVisible(true);
				if (!heroSelected) {
					heroSelected = true;
					selectDifficulty.setVisible(true);
					selectEasyBtn.setVisible(true);
					selectHardBtn.setVisible(true);
					selectEasyBorder.setVisible(true);
					selectHardBorder.setVisible(true);
					selectNameTitle.setVisible(true);
					selectName.setVisible(true);
				}
				selectName.requestFocusInWindow();
				selectedHero = new ImageIcon(DungeonGame.class.getResource("/resources/Mage.png"));
			}
		});

		selectEasyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectHardBorder.setIcon(unselectedDifficulty);
				selectEasyBorder.setIcon(selectedDifficulty);
				selectName.requestFocusInWindow();
				selectNext.setVisible(true);
				difficultyKey = 75;
				difficultySelected = true;
			}
		});

		selectHardBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectEasyBorder.setIcon(unselectedDifficulty);
				selectHardBorder.setIcon(selectedDifficulty);
				selectName.requestFocusInWindow();
				selectNext.setVisible(true);
				difficultyKey = 275;
				difficultySelected = true;
			}
		});

		selectName.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && difficultySelected) {
					selectScreen.setVisible(false);
					gameScreen.setVisible(true);
					String n = selectName.getText();
					if (n.trim().isEmpty()) {
						n = "Hero";
					}
					battle = new GamePlay(n, selectedHero, difficultyKey);
					battleScene();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if (selectName.getText().length() >= 10)
					e.consume();
			}
		});

	}

	private void battleScene() {
		
		gameScreen.remove(battle.getMonsterStats());
		gameScreen.remove(battle.getMonsterIcon());
		battle.getInfoTabScreen().setBounds(0, 0, gameScreen.getWidth()/2, gameScreen.getHeight()/2);
		battle.getInfoTabScreen().setBounds((gameScreen.getWidth()-battle.getInfoTabScreen().getWidth())/2, (gameScreen.getHeight()-battle.getInfoTabScreen().getHeight())/2, battle.getInfoTabScreen().getWidth(), battle.getInfoTabScreen().getHeight());
		gameScreen.add(battle.getInfoTabScreen());
		gameScreen.add(battle.getYouLose());
		gameScreen.add(battle.getYouWin());
		gameScreen.add(battle.getStunned());
		gameScreen.add(battle.getInfoTab());
		gameScreen.add(battle.getCharacterIcon());
		gameScreen.add(battle.getCharacterStats());
		gameScreen.add(battle.getMonsterStats());
		gameScreen.add(battle.getMonsterIcon());
		gameScreen.add(battle.getBufferBtn());
		gameScreen.add(battle.getAttackBtn());
		gameScreen.add(battle.getDefendBtn());
		gameScreen.add(battle.getRunBtn());
		gameScreen.add(battle.getDungeonLevel());
		gameScreen.add(battle.getGameBackground());
		gameScreen.add(battle.getShop().getShopScreen());

	}
	
	public static void addMonster(DisplayMonster m, JLabel b) {
		
		gameScreen.remove(b);
		gameScreen.add(m.getMonsterIcon());
		gameScreen.add(m.getMonsterStats());
		m.getMonsterIcon().setVisible(true);
		m.getMonsterStats().setVisible(true);
		gameScreen.add(b);
		frame.repaint();
		
	}

}
