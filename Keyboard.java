package a3;

import java.awt.*;
import javax.swing.*;


@SuppressWarnings("serial")
public class Keyboard extends JFrame{
	//=======Components and Containers==============//
	private JPanel Contain = new JPanel();
	private JPanel Padding = new JPanel();
	private JPanel Lbl  = new JPanel();
	private JPanel Keys = new JPanel();
	private JTextArea TextArea = new JTextArea();
	private JScrollPane TxtArea_ = new JScrollPane(TextArea);
	private JPanel Hold = new JPanel();
	private JPanel Kb = new JPanel();
	private JLabel Lbl_txt = new JLabel();
	//===============================//
	
	private static String [] KeysText = {"~","1","2","3","4","5","6","7","8","9","0","-","+","BackSpace"};
	
	
	public Keyboard() {
		
		this.setTitle("Typing Tutor");
		this.setLayout(new FlowLayout(FlowLayout.LEFT,10,5));		
		this.setSize(850, 630);  
		
		//Global Container 
		Contain.setLayout(new BoxLayout(Contain,BoxLayout.Y_AXIS));
		//Label Container
		Lbl.setLayout(new FlowLayout(FlowLayout.LEADING));
		//Holds Both the Lbl and Text area as required by assignment dimensions
		Hold.setLayout(new BoxLayout(Hold,BoxLayout.Y_AXIS));	//Make Hold place components
		//Eat 100% of available panel space
		Keys.setLayout(new GridLayout(1,1));
		
		Kb.setLayout(new FlowLayout(FlowLayout.LEADING,0,0));
		SetKeys(Kb);
		
		//==============TextArea=============//
		//Prevents shaking component and makes sure text wraps.
		//Wrapping via Javadocs style
		TextArea.setLineWrap(true);
		TextArea.setWrapStyleWord(true);
		//=============================//
	
	
		//Display text, note HTML since JLabel supports it and means less Panels.
		Lbl_txt.setText("<html><body><p>Type some text using your keyboard. The keys you press will be highlighted and the text"
				+ " will be displayed.</p><p>Note: Clicking the buttons with your mouse will not perform any action </p></body> </html>");

		//Lbl.setBackground(new Color(150,100,100));
		Keys.setBackground(new Color(100,200,200));
		Kb.setBackground(new Color(100,100,100));
		
		//Make space as specified by the assignment.
		Lbl.setPreferredSize(new Dimension(820,50));
		Keys.setPreferredSize(new Dimension(420,200));
		Kb.setPreferredSize(new Dimension(820,300));
		//Make an invisible divider while keeping the components vertically stacked
		Padding.setPreferredSize(new Dimension(25,20));
			
		//=======Add all components to the Frame and Panel(s)====//
		Lbl.add(Lbl_txt);
		Keys.add(TxtArea_);
		Hold.add(Lbl);
		Hold.add(Keys);
		Contain.add(Hold);
		Contain.add(Padding);
		Contain.add(Kb);
		add(Contain); //Add to frame
		//============================================//
		
		//Set behaviour
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(true);
		
	}
	//Write some buttons using the array lines.
	public static void SetKeys(Container kb) {
		for(int i = 0; i < KeysText.length; i++) {
		
			switch(i) {
				case 13: 
					JButton button_Ext = new JButton(GetNextKey(i));
					button_Ext.setAlignmentX(Component.CENTER_ALIGNMENT);
					button_Ext.setPreferredSize(new Dimension(105,50));
					button_Ext.setFont(new Font("Arial",Font.BOLD,12));
					kb.add(button_Ext);
					break;
			
			
				default:
					JButton button = new JButton(GetNextKey(i));
					button.setAlignmentX(Component.CENTER_ALIGNMENT);
					button.setPreferredSize(new Dimension(55,50));
					button.setFont(new Font("Arial",Font.BOLD,12));
					kb.add(button);
					break;
			}
	
		}
		
		
	}

	public static String GetNextKey(int arrAt) {
	
		return KeysText[arrAt];
	}
	public static void main (String [] args) {
		new Keyboard();
	}

}