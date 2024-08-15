package views;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.Shop;

public class DisplayShop {
	
	private Shop shop;
	private JPanel shopScreen;
	private JLabel shopWeapon;
	private JLabel shopArmor;
	private JLabel shopShield;
	private JLabel shopBoots;
	private JLabel shopItemTitle;
	private JLabel shopItemDescription;
	private JButton shopBuyBtn;
	private JButton shopContBtn;
	private JLabel shopBackground;

	public DisplayShop() {
		
		shop = new Shop(1);
		
		shopScreen = new JPanel();
		shopScreen.setBounds(0, 0, (2498)/2, (1562)/2);
		shopScreen.setVisible(false);
		shopScreen.setLayout(null);
		
		shopWeapon = new JLabel();
		//shopWeapon.setBounds();
		shopScreen.add(shopWeapon);
		
		shopArmor = new JLabel();
		//shopArmor.setBounds();
		shopScreen.add(shopArmor);
		
		shopShield = new JLabel();
		//shopShield.setBounds();
		shopScreen.add(shopShield);
		
		shopBoots = new JLabel();
		//shopBoots.setBounds();
		shopScreen.add(shopBoots);
		
		shopItemTitle = new JLabel();
		shopItemTitle.setBounds((988)/2, (277)/2, (839)/2, (140)/2);
		shopScreen.add(shopItemTitle);
		
		shopItemDescription = new JLabel();
		shopItemDescription.setBounds((986)/2, (472)/2, (842)/2, (693)/2);
		shopScreen.add(shopItemDescription);
		
		shopBuyBtn = new JButton();
		//shopBuyBtn.setBounds();
		shopScreen.add(shopBuyBtn);
		
		shopContBtn = new JButton("Continue");
		shopContBtn.setBounds((2162)/2, (1360)/2, (300)/2, (120)/2);
		shopScreen.add(shopContBtn);
		
		shopBackground = new JLabel();
		shopBackground.setBounds(0, 0, (2498)/2, (1562)/2);
		shopBackground.setIcon(new ImageIcon(new ImageIcon(DungeonGame.class.getResource("/resources/Shop Background.png")).getImage().getScaledInstance(shopBackground.getWidth(), shopBackground.getHeight(), Image.SCALE_FAST)));
		shopScreen.add(shopBackground);
		
	}
	
	public Shop getShop() {
		
		return shop;
		
	}
	
	public JPanel getShopScreen() {
		
		return shopScreen;
		
	}
	
	public JLabel getShopWeapon() {
		
		return shopWeapon;
		
	}

	public JLabel getShopArmor() {
	
		return shopArmor;
	
	}

	public JLabel getShopShield() {
	
		return shopShield;
	
	}

	public JLabel getShopBoots() {
	
		return shopBoots;
	
	}
	
	public JLabel getShopItemTitle() {
		
		return shopItemTitle;
	
	}
	
	public JLabel getShopItemDescription() {
		
		return shopItemDescription;
	
	}
	
	public JButton getShopBuyBtn() {
		
		return shopBuyBtn;
	
	}
	
	public JButton getShopContBtn() {
		
		return shopContBtn;
	
	}
	
	public JLabel getShopBackground() {
		
		return shopBackground;
	
	}

}
