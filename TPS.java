import java.io.*;
import java.awt.Image;
import java.util.*;
import java.text.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TPS extends JFrame{
	public static JList list;
	public static JList list2;
	
	public static JFrame frame=new JFrame();
	public static JFrame loginFrame=new JFrame();
	public static JFrame fMenu;
	public static JFrame fInventory;
	public static JFrame fPurchase;
	
	
	public static JPanel pane1;
	public static JPanel pane11=new JPanel();
	public static JPanel pane2;
	public static JPanel pane3;
	public static JPanel pane4=new JPanel();
	
	public static JButton buy=new JButton();
	public static JButton clear=new JButton();
	public static JButton delete=new JButton();
	public static JButton back1=new JButton();
	public static JButton additem;
	public static JButton bInventory;
	public static JButton bPurchase;
	public static JButton back;
	public static JButton back2;
	public static JButton login=new JButton();
	public static JButton changes=new JButton(); 	
	public static JButton logout=new JButton();
	public static JButton exit=new JButton();
	
	
	public static JLabel itemPrice;
	public static JLabel itemName;
	public static JLabel itemStock;
	public static JLabel itemProduct=new JLabel();
	public static JLabel itemProduct1=new JLabel();
	public static JLabel lproductName=new JLabel();
	public static JLabel lAmount=new JLabel();
	public static JLabel lstock=new JLabel();
	public static JLabel lstock2=new JLabel();
	public static JLabel lprice=new JLabel();
	public static JLabel lmoney=new JLabel();
	public static JLabel lchange=new JLabel();
	public static JLabel lusername=new JLabel();
	public static JLabel lpassword=new JLabel();
	public static JLabel version=new JLabel();
	public static JLabel welcome=new JLabel();
	
	public static DecimalFormat df=new DecimalFormat("#0.00");
	

	public static JTextField addItem;
	public static JTextField addPrice;
	public static JTextField amount=new JTextField();
	public static JTextField money=new JTextField();
	public static JTextField change=new JTextField();
	public static JTextField stocks=new JTextField();
	public static JTextField stocks2=new JTextField();
	public static JTextField price2=new JTextField();
	public static JTextField productName=new JTextField();
	
	public static JTextField username=new JTextField();
	public static JPasswordField password=new JPasswordField();
	
	
	public static String stocksDir="C:\\Users\\DaryllJoshua\\Downloads\\TPS-2\\TPS\\TPS\\db_stocks.db";
	public static String adminDir="C:\\Users\\DaryllJoshua\\Downloads\\TPS-2\\TPS\\TPS\\db_admin.db";
	public static String productsDir="C:\\Users\\DaryllJoshua\\Downloads\\TPS-2\\TPS\\TPS\\db_products.db";
	
	public static int x;
	
	

	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[]) throws IOException{
		
		try {
			
		//backgounds
		BufferedImage img1 = ImageIO.read(new File("C:\\Users\\DaryllJoshua\\Downloads\\TPS-2\\TPS\\TPS\\bg.jpg"));
		JLabel bg2=new JLabel(new ImageIcon(img1));
		BufferedImage img2 = ImageIO.read(new File("C:\\Users\\DaryllJoshua\\Downloads\\TPS-2\\TPS\\TPS\\login.jpg"));
		JLabel bg1=new JLabel(new ImageIcon(img2));
		BufferedImage img3 = ImageIO.read(new File("C:\\Users\\DaryllJoshua\\Downloads\\TPS-2\\TPS\\TPS\\inventory.jpg"));
		JLabel bg3=new JLabel(new ImageIcon(img3));
		
		//beta test in db and try
		
		
		
		
		FileInputStream db = new FileInputStream(productsDir);
		BufferedReader getData = new BufferedReader(new InputStreamReader(db));
		FileInputStream db1 = new FileInputStream(adminDir);
		final BufferedReader logintxt = new BufferedReader(new InputStreamReader(db1));
		FileInputStream db2 = new FileInputStream(stocksDir);
		final BufferedReader mStocks = new BufferedReader(new InputStreamReader(db2));

			
			do {
				String ct = getData.readLine(); 
	            String ct2= logintxt.readLine();
	            String ct3= mStocks.readLine();
	            

				if(ct==null) {
                      break; 
                }
               if(ct.trim().charAt(0) != '#') { 
            	   final String as[] = ct.split(" ");
                   final String as1[]= new String[as.length];
                   final String[] txt1= ct2.split(" ");
                   final String[] mStocks1= ct3.split(" ");
                   
             //interchanging of data in an array       
            for (x=0; x<as.length; x++) 
                  {
               if(x%2 == 0) 
               	{
			   as1[x]=as[x]; // splited price of product
               	}
			
                }
              
            final String loginUcheck[]= new String [txt1.length];
            final String loginPcheck[]= new String [txt1.length];
            
            for (x=0; x<txt1.length; x++) 
            {
         if(x%2 == 0) 
         	{
		   loginUcheck[x]=txt1[x];
         	}
            }
         for (x=0; x<loginUcheck.length; x++) 
         {  
           if(x%2 != 0) 
         	{
		   loginPcheck[x]=txt1[x];
         	}
		
          }	

	
		//Buttons for frame MENU
		bInventory = new JButton("INVENTORY");
		bPurchase = new JButton("PURCHASE");	
		logout.setText("Logout");
		bInventory.setBounds(10,30,223,75);
		bPurchase.setBounds(10,115,223,75);
		welcome.setBounds(3,8,155,20);
		logout.setBounds(143,200,90,20);
		
	
	
		//Elements for frame INVENTORY

		list2 = new JList(as1);
		JScrollPane scrollPane = new JScrollPane(list2);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(new Rectangle(110, 40,13,80));
		
		
		list2.setBounds(10,50,100,150);
		list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list2.setBackground(Color.lightGray);
		
		back2 = new JButton("Back");
		back2.setBounds(60,250,85,25);
		
		lproductName.setText("Product name:");
		lstock2.setText("Stocks:");
		lprice.setText("Price:");
		itemProduct1.setText("Product List:");
		
		
		lstock2.setBounds(130,85,150,20); 
		stocks2.setBounds(130,105,150,20);
		lprice.setBounds(130,135,80,20);
		price2.setBounds(130,155,150,20);
		lproductName.setBounds(130,40,150,20);
		productName.setBounds(130,60,150,20);
		itemProduct1.setBounds(11,30,150,10);
		
		changes.setText("Change");
		changes.setBounds(60, 215, 85, 25);

		additem = new JButton();
		additem.setText("Add Item");
		additem.setBounds(157,215,85,25);
		
		
		bg3.setBounds(150,1,400,300);
		
		delete.setText("Delete");
		delete.setBounds(157,250,85,25);
		
		
		
		//Elements for frame PURCHASE
		list = new JList(as1);
		list.setBounds(10,50,100,150);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		itemPrice = new JLabel();
		itemPrice.setBounds(120,60,150,30);
		
		
		
		//ActionsMenu
		bInventory.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			fMenu.setVisible(false);
			fInventory.setVisible(true);
			
		}
		});
		
		bPurchase.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			fMenu.setVisible(false);
			fPurchase.setVisible(true);	
			
		}
		});
		//clear button
		clear.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			money.setText("");
			stocks.setText("");
			
		}
		});
		
		delete.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				PrintWriter productNpricePR=new PrintWriter(new FileWriter(productsDir),true);
				PrintWriter stocksPR=new PrintWriter(new FileWriter(stocksDir),true);	
				int reply = JOptionPane.showConfirmDialog(null, "Do you want to remove " + productName.getText() + "?", "Inventory", JOptionPane.YES_NO_OPTION);
		        if (reply == JOptionPane.YES_OPTION) {
		        	
			productNpricePR.print("#products");
			productNpricePR.print("\r\n");
			stocksPR.print("#stocks");
			stocksPR.print("\r\n");
			
			as[list2.getSelectedIndex()]=null;
			as[list2.getSelectedIndex()+1]=null;
			mStocks1[list2.getSelectedIndex()]=null;
			mStocks1[list2.getSelectedIndex()+1]=null;
			
			for(x=0; x<as.length; x++)
			{
				if (as[x]!=null)
				{
					productNpricePR.print(as[x]+ " ");
				}
				
			}
			for (x=0; x<mStocks1.length; x++)
			{
				if (mStocks1[x]!=null)
				{
					stocksPR.print(mStocks1[x]+ " ");
				}
			}
			productNpricePR.close();
			stocksPR.close();
			int reply1 = JOptionPane.showConfirmDialog(null, "Product deleted. Do you want to restart app to take effect? This is a MUST! " , "Inventory", JOptionPane.YES_NO_OPTION);
	        if (reply1 == JOptionPane.YES_OPTION) {
	        	System.exit(0);
	        }
		        }
		        else
		        {
		        	productNpricePR.print("#products");
					productNpricePR.print("\r\n");
					
					stocksPR.print("#stocks");
					stocksPR.print("\r\n");
					
		        	for(x=0; x<as.length; x++)
					{
						if (as[x]!=null)
						{
							productNpricePR.print(as[x]+ " ");
						}
						
					}
					for (x=0; x<mStocks1.length; x++)
					{
						if (mStocks1[x]!=null)
						{
							stocksPR.print(mStocks1[x]+ " ");
						}
					}
					productNpricePR.close();
					stocksPR.close();
		        }
		}
			catch(Exception ex)
			{
				//
			}
		}
		
		});
		
		//back1 button
		back1.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			fMenu.setVisible(true);
			fPurchase.setVisible(false);
			
		}
		});
		//back2 button
			back2.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			fMenu.setVisible(true);
			fInventory.setVisible(false);
			
		}
		});
		//additem button
		additem.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			try
			{
			PrintWriter productNpricePR=new PrintWriter(new FileWriter(productsDir),true);
			PrintWriter stocksPR=new PrintWriter(new FileWriter(stocksDir),true);
			
			String product=JOptionPane.showInputDialog(null, "Add product \nProduct name:");
			String stock=JOptionPane.showInputDialog(null, "Stock:");
			String prices=JOptionPane.showInputDialog(null, "Price (in Pesos):");
			
			if (product!=null || stock!=null || prices!=null)
			{
				Integer.parseInt(stock);
				Double.parseDouble(prices);
				
			productNpricePR.print("#products");
			productNpricePR.print("\r\n");

			for(x=0; x<as.length; x++)
			{
				
				productNpricePR.print(as[x]+ " ");
			}
			
			stocksPR.print("#products");
			stocksPR.print("\r\n");
			for(x=0; x<mStocks1.length; x++)
			{
				stocksPR.print(mStocks1[x]+ " ");
			}
			
			productNpricePR.print(product+ " " +prices+ " ");
			stocksPR.print(stock+" |");
			
			productNpricePR.flush();
			stocksPR.flush();
			productNpricePR.close();
			stocksPR.close();
			
			int reply = JOptionPane.showConfirmDialog(null, "Product added. Do you want to restart the app to take effect? This is a MUST!", "Inventory", JOptionPane.YES_NO_OPTION);
	        if (reply == JOptionPane.YES_OPTION) {
	        	System.exit(0);
	        }
			}
			
		}
			catch (Exception ex)
			{
				try{
				PrintWriter productNpricePR=new PrintWriter(new FileWriter(productsDir),true);
				PrintWriter stocksPR=new PrintWriter(new FileWriter(stocksDir),true);	
				JOptionPane.showMessageDialog(null, "Must be number!","Add item",
						 JOptionPane.WARNING_MESSAGE);
				productNpricePR.print("#products");
				productNpricePR.print("\r\n");

				for(x=0; x<as.length; x++)
				{
					
					productNpricePR.print(as[x]+ " ");
				}
				
				stocksPR.print("#products");
				stocksPR.print("\r\n");
				for(x=0; x<mStocks1.length; x++)
				{
					stocksPR.print(mStocks1[x]+ " ");
				}
				productNpricePR.flush();
				stocksPR.flush();
				productNpricePR.close();
				stocksPR.close();
				}
				catch(Exception ex1)
				{
					JOptionPane.showMessageDialog(null, "ERORR" + ex1,"Add item",
							 JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
		});
		
		//ActionsForPURCHASEWindow
		list.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{
				
				
				String a = String.valueOf(list.getSelectedValue());
				itemPrice.setText(a);
				try {
					if(as1[list.getSelectedIndex()]==(null))
					{
						amount.setText("");
					}
					else {
						amount.setText("₱ " +as[list.getSelectedIndex()+1]);
					}
				}
				catch (Exception exception)
				{
					//just to remove errors
				}
			}
		}); 
		
		
		list2.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{
				
				
				//String a = String.valueOf(list2.getSelectedValue());
				//price2.setText(a);
				try {
					if(as1[list2.getSelectedIndex()]==(null))
					{
						stocks2.setText("");
						price2.setText("");
						productName.setText("");
					}
					else {
						productName.setText(String.valueOf(as[list2.getSelectedIndex()]));
						price2.setText(String.valueOf(as[list2.getSelectedIndex()+1]));
						stocks2.setText(String.valueOf(mStocks1[list2.getSelectedIndex()]));
					}
				}
				catch (Exception exception)
				{
					//just to remove errors
				}
			}
		}); 
		
			
		
		buy.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			try{
			PrintWriter stocksPR = new PrintWriter(new FileWriter(stocksDir),true);
			
			Double parsedMoney=Double.valueOf(money.getText());
			Double parsedPrice=Double.valueOf(as[list.getSelectedIndex()+1]);
			int parsedQuantity=Integer.parseInt(stocks.getText());
			int parsedStocks=Integer.parseInt(mStocks1[list.getSelectedIndex()]);
			
			double amount1=parsedPrice*parsedQuantity;
			double change1=parsedMoney-amount1;
			int fStocks=parsedStocks-parsedQuantity;
			
			
				if(0>change1)
				{
					JOptionPane.showMessageDialog(null, "Insufficient money!","Purchase",
							 JOptionPane.WARNING_MESSAGE);
				}	

				else if(parsedQuantity==0)
				{
					JOptionPane.showMessageDialog(null,"Quantity should not be 0!","Purchase",JOptionPane.WARNING_MESSAGE);
				}
				else if (fStocks<0)
				{
					JOptionPane.showMessageDialog(null,"No Stocks Available!","Purchase",JOptionPane.WARNING_MESSAGE);
				
				}
				
				
				else
				{
				mStocks1[list.getSelectedIndex()]=String.valueOf(fStocks);	
				change.setText("₱ "+ String.valueOf(change1));
				JOptionPane.showMessageDialog(null, stocks.getText()+" "+list.getSelectedValue()+ " Bought!"
						+"\n---------------------------------------\n"+"Amount: ₱"+ df.format(amount1)+"   Money: ₱"+df.format(parsedMoney)+"\nChange: ₱"+df.format(change1),"Purchase",
						JOptionPane.INFORMATION_MESSAGE);
				
				
				stocksPR.print("#stocks");
				stocksPR.print("\r\n");
				
				for (x=0; x<mStocks1.length; x++)
				{
					stocksPR.print(mStocks1[x]+" ");
				}
				change.setText("");
				money.setText("");
				stocks.setText("");
				

				
				}
				stocksPR.flush();
				stocksPR.close();
			}
		
		catch(Exception exception)
		{
			
				
			
			if (list.isSelectionEmpty()||as1[list.getSelectedIndex()]==null)
			{
			JOptionPane.showMessageDialog(null, "No selected product!","Purchase",
					 JOptionPane.WARNING_MESSAGE);
				money.setText("");
				stocks.setText("");
			}
			else if(money.getText().equals("")||stocks.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Money and quantity must be filled!","Purchase",
						 JOptionPane.WARNING_MESSAGE);
				money.setText("");
				stocks.setText("");
			}
			else if(money.getText() instanceof String||stocks.getText() instanceof String)
			{
				JOptionPane.showMessageDialog(null, "Must be number!","Purchase",
						 JOptionPane.WARNING_MESSAGE);
				money.setText("");
				stocks.setText("");
			}
			
			
		}
			

		
		}
		});
		
		login.addActionListener(new ActionListener () 
		{
		public void actionPerformed(ActionEvent e) 
		{
			String un=username.getText();
			String pw=String.valueOf(password.getPassword());

			
			if(un.equals("")&&pw.equals(""))
			{
				JOptionPane.showMessageDialog(null, "All fields must be fill up!"
						,"Login",JOptionPane.WARNING_MESSAGE);
					password.setText("");
					
			}
		
					for (x=0; x<txt1.length; x++)
		        	{
			
			
			 if(un.equalsIgnoreCase(loginUcheck[x])&&pw.equals(loginPcheck[x+1]))
			{
				fMenu.setVisible(true);
				loginFrame.setVisible(false); 
				welcome.setText("Welcome "+username.getText()+"!");
			
				
			}
		        	}
			 if (fMenu.isVisible()!=true)
			 
			 {
				 
				 JOptionPane.showMessageDialog(null, "Incorrect username or password! Try again!"
							,"Login",JOptionPane.ERROR_MESSAGE);
						password.setText("");
				 
			 }
			 
		
					
		}	
		
		
	
		});
		changes.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			
				try
			{
					PrintWriter productNpricePR=new PrintWriter(new FileWriter(productsDir),true);
					PrintWriter stocksPR=new PrintWriter(new FileWriter(stocksDir),true);
				if (list2.isSelectionEmpty() ||as1[list2.getSelectedIndex()]==null)
				{
					JOptionPane.showMessageDialog(null, "No Selected Products!","Inventory",
							 JOptionPane.WARNING_MESSAGE);
					
					productNpricePR.print("#products");
					productNpricePR.print("\r\n");
					stocksPR.print("#stocks");
					stocksPR.print("\r\n");
					for(x=0; x<as.length; x++)
					{
						productNpricePR.print(as[x]+ " ");					
					}
					for (x=0; x<mStocks1.length; x++)
					{
						stocksPR.print(mStocks1[x]+" ");
					}
					
					
				}
				else if(productName.getText().equals("")|| price2.getText().equals("") || stocks2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "All fields should be filled!","Inventory",
							 JOptionPane.WARNING_MESSAGE);
					
					productNpricePR.print("#products");
					productNpricePR.print("\r\n");
					stocksPR.print("#stocks");
					stocksPR.print("\r\n");
					for(x=0; x<as.length; x++)
					{
						productNpricePR.print(as[x]+ " ");					
					}
					for (x=0; x<mStocks1.length; x++)
					{
						stocksPR.print(mStocks1[x]+" ");
					}
				}
				
			
				else
				{
				Double.parseDouble(price2.getText());
				Integer.parseInt(stocks2.getText());
					int reply = JOptionPane.showConfirmDialog(null, "Do you want to confirm?", "Inventory", JOptionPane.YES_NO_OPTION);
			        if (reply == JOptionPane.YES_OPTION) {
						as[list2.getSelectedIndex()]=productName.getText();
						as[list2.getSelectedIndex()+1]=price2.getText();
						mStocks1[list2.getSelectedIndex()]=stocks2.getText();
						
						productNpricePR.print("#products");
						productNpricePR.print("\r\n");

						for(x=0; x<as.length; x++)
						{
							productNpricePR.print(as[x]+ " ");
						}
						
						stocksPR.print("#products");
						stocksPR.print("\r\n");
						for(x=0; x<mStocks1.length; x++)
						{
							stocksPR.print(mStocks1[x]+ " ");
						}
						
						int reply1 = JOptionPane.showConfirmDialog(null, "Product updated. Do you want to restart app to take effect? This is a MUST! " , "Inventory", JOptionPane.YES_NO_OPTION);
						if (reply1 == JOptionPane.YES_OPTION) {
							productNpricePR.flush();
							stocksPR.flush();
							productNpricePR.close();
							stocksPR.close();
				        	System.exit(0);

				        	
						}
			        }
			        else
			        {
			        	productNpricePR.print("#products");
						productNpricePR.print("\r\n");

						for(x=0; x<as.length; x++)
						{
							productNpricePR.print(as[x]+ " ");
						}
						
						stocksPR.print("#products");
						stocksPR.print("\r\n");
						for(x=0; x<mStocks1.length; x++)
						{
							stocksPR.print(mStocks1[x]+ " ");
						}
			        }
			        
			       
				}
				
				productNpricePR.flush();
				stocksPR.flush();
				productNpricePR.close();
				stocksPR.close();
				
			        
			}
			catch(Exception exp) 
			{
				try
				{
				PrintWriter productNpricePR=new PrintWriter(new FileWriter(productsDir),true);
				PrintWriter stocksPR=new PrintWriter(new FileWriter(stocksDir),true);
				JOptionPane.showMessageDialog(null, "Must be a number!","Inventory",
						 JOptionPane.WARNING_MESSAGE);
				productNpricePR.print("#products");
				productNpricePR.print("\r\n");
				stocksPR.print("#stocks");
				stocksPR.print("\r\n");
				for(x=0; x<as.length; x++)
				{
					productNpricePR.print(as[x]+ " ");
				}
				
				stocksPR.print("#products");
				stocksPR.print("\r\n");
				for(x=0; x<mStocks1.length; x++)
				{
					stocksPR.print(mStocks1[x]+ " ");
				}
				productNpricePR.flush();
				stocksPR.flush();
				productNpricePR.close();
				stocksPR.close();
				}
				catch (Exception ep)
				{
					JOptionPane.showMessageDialog(null, "Something is wrong with database.","Inventory",
							 JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		});
		exit.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
		});
		
		logout.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "You've successfully logout "+username.getText()+"!"
					,"Login",JOptionPane.INFORMATION_MESSAGE);
			fMenu.setVisible(false);
			loginFrame.setVisible(true);
			username.setText("");
			password.setText("");
		}
		});
		

		
		//Panels
		
		pane11.setLayout(null);
		pane11.add(lusername);
		pane11.add(lpassword);
		pane11.add(username);
		pane11.add(password);
		pane11.add(version);
		pane11.add(login);
		pane11.add(exit);
		pane11.add(bg1);
		
				
		
		pane1 = new JPanel();
		pane1.setLayout(null);
		pane1.add(welcome);
		pane1.add(logout);
		pane1.add(bInventory);
		pane1.add(bPurchase);
		
		
		
		pane2 = new JPanel();
		pane2.setLayout(null);
		pane2.add(list2);
		pane2.add(back2);
		pane2.add(lprice);
		pane2.add(price2);
		pane2.add(stocks2);
		pane2.add(additem);
		pane2.add(itemProduct1);
		pane2.add(lstock2);
		pane2.add(lproductName);
		pane2.add(productName);
		pane2.add(changes);
		pane2.add(delete);
		pane2.add(scrollPane);
		pane2.add(bg3);
		
		
		pane3 = new JPanel();
		pane3.setLayout(null);
		pane3.add(buy);
		pane3.add(amount);
		pane3.add(money);
		pane3.add(change);
		pane3.add(list);
		pane3.add(itemProduct);
		pane3.add(lAmount);
		pane3.add(lmoney);
		pane3.add(lchange);
		pane3.add(lstock);
		pane3.add(stocks);
		pane3.add(clear);
		pane3.add(back1);
		pane3.add(bg2);


		pane4.setLayout(null);
		

		

		
		itemProduct.setText("Products:");
		lAmount.setText("Price:");
		lmoney.setText("Money:");
		lstock.setText("Quantity");
		lchange.setText("Change:");
		buy.setText("Buy");
		clear.setText("Clear");
		back1.setText("Back");
		login.setText("Login");
		exit.setText("Exit");
		
		lusername.setText("Username: ");
		lpassword.setText("Password :");
		version.setText("Ver 0.1 beta");
		
		
		
		money.setBounds(100,85,167,25);
		lmoney.setBounds(100,60,150,25);
		amount.setBounds(100, 35, 167, 25);
		lAmount.setBounds(100,10,100,20);
		change.setBounds(100, 185, 167, 25);
		lchange.setBounds(100, 160, 167, 25);
		buy.setBounds(100, 225, 75, 25);
		list.setBounds(15, 35, 70, 150);
		itemProduct.setBounds(10,10,80,23);
		lstock.setBounds(100, 110, 150, 25);
		stocks.setBounds(100, 135, 35, 25);
		clear.setBounds(190, 225, 76, 25);
		back1.setBounds(145, 260, 76, 25);
		bg2.setBounds(0,0, 450, 350);
		
		lusername.setBounds(20, 75, 100, 23);
		username.setBounds(105,75,150,23);
		lpassword.setBounds(20, 123, 100, 23);
		password.setBounds(105, 123, 150, 23);
		bg1.setBounds(220, 40, 310, 300);
		version.setBounds(9,301,100,25);
		login.setBounds(20, 183, 100, 30);
		exit.setBounds(155, 183, 100, 30);
		
		list.setSelectionForeground(Color.blue);
		pane11.setBackground(Color.white);
		pane2.setBackground(Color.white);
		
		
		
		amount.setEditable(false);
		change.setEditable(false);
		
		//Frames
		fMenu = new JFrame("Menu");
		fMenu.setSize(250,250);
		fMenu.setContentPane(pane1);
		fMenu.setVisible(false);
		fMenu.setResizable(false);
		fMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fInventory = new JFrame("Inventory");
		fInventory.setSize(450,350);
		fInventory.setContentPane(pane2);
		fInventory.setVisible(false);
		fInventory.setResizable(false);
		fInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		fPurchase = new JFrame("Purchase");
		fPurchase.setSize(450,350);
		fPurchase.setContentPane(pane3);
		fPurchase.setVisible(false);
		fPurchase.setResizable(false);
		fPurchase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginFrame = new JFrame("Log-in to POS");
		loginFrame.setSize(450,350);
		loginFrame.setContentPane(pane11);
		loginFrame.setVisible(true);
		loginFrame.setResizable(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setContentPane(pane4); //add item window
		
		
	}
			}
			while(true);
			db.close();
			db1.close();
			mStocks.close();
			
		}
	
		//catching any errors
		catch(Exception exception) {
            JOptionPane.showMessageDialog(null, "ERROR: "+exception +"\nPlease report to the"
            		+" administrator","Error",
					 JOptionPane.ERROR_MESSAGE);
		}     
       
	
	
}
}