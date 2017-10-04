import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Main {
	private JFrame mFrame;

	private JButton button1;
	private JButton button2;
	private JTextField[] tfs;
	
	Font headerFont = new Font("Serif", Font.PLAIN, 22);
	
	String[] navnPaaOevelser = {"Knebøy", "Markløft", "Benkpress", "Chins", "Militærpress"};
	boolean[] oevelserSatt = new boolean[navnPaaOevelser.length];
	Program program;
	
	final int SCREENWITH = 400;
	final int SCREENHEIGHT = 500;
	
	final int BUTTONWITH = 80;
	final int BUTTONHEIGHT = 50;
	
	

	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            //UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
		new Main().run();
	}
	
	private void run(){
		mFrame = new JFrame("Program generator");
		mFrame.setSize(SCREENWITH, SCREENHEIGHT);
		button1 = new JButton("Nytt program");
		button1.setBounds(SCREENWITH/2-150/2, SCREENHEIGHT*1/3, 150, 50);
		mFrame.add(button1);
		button2 = new JButton("Åpne fil");
		button2.setBounds(SCREENWITH/2-150/2, SCREENHEIGHT/2, 150, 50);
		mFrame.add(button2);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				velgOevelser();	
			}
		});
		mFrame.setLayout(null);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setVisible(true);
	}
	
	private void velgOevelser(){
		toemFrame();
		
		JLabel label = new JLabel("Velg øvelsene du ønsker:");
		label.setBounds(50, 10, 300, 100);
		label.setFont(headerFont);
		mFrame.add(label);
		
		JButton neste = new JButton("Neste");
		neste.setBounds(SCREENWITH/3, SCREENHEIGHT-100, 80, 50);
		neste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fyllInnSkjerm();	
			}
		});
		mFrame.add(neste);
		
		
		
		for(int i = 0; i < 5; i++){
			JCheckBox temp = new JCheckBox(navnPaaOevelser[i]);
			temp.setBounds(SCREENWITH/3, i*SCREENHEIGHT/8 + 80, 140, 30);
			temp.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i < navnPaaOevelser.length; i++){
						if(navnPaaOevelser[i].equals(temp.getText())){
							oevelserSatt[i] = !oevelserSatt[i];
							return;
						}
					}
				}
			});
			mFrame.add(temp);
		}
		
	}
	
	private void fyllInnSkjerm(){
		toemFrame();
		
		JLabel  label = new JLabel("Fyll inn 1RM for hver øvelse:");
		label.setBounds(SCREENWITH/7, 50, 400, 30);
		label.setFont(headerFont);
		mFrame.add(label);
		
		tfs = new JTextField[oevelserSatt.length];
		
		int c = 0;
		int x, y;
		for(int i = 0; i < oevelserSatt.length; i++){
			if(oevelserSatt[i]){
				x = SCREENWITH/8;
				y = c++*SCREENHEIGHT/8+100;
				JLabel tj = new JLabel(navnPaaOevelser[i]);
				tj.setBounds(x, y, 100, 30);
				JTextField tf = new JTextField();
				tf.setBounds(x+80, y, 150, 30);
				tfs[i] = tf;
				mFrame.add(tj);
				mFrame.add(tf);
			}
		}
		
		JButton neste = new JButton("Neste");
		neste.setBounds(SCREENWITH/3, SCREENHEIGHT-100, 80, 50);
		neste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				opprettProgram();	
			}
		});
		mFrame.add(neste);
	}
	
	void opprettProgram(){
		program = new Program(9); //TODO: Endre uker til inputbasert
		toemFrame();
		
		for(int i = 0; i < oevelserSatt.length; i++){
			if(oevelserSatt[i]){
				program.leggTilOevelse(navnPaaOevelser[i], Double.parseDouble(tfs[i].getText()));
			}
		}
		program.leggTilUker();
		
		JFrame pFrame = new JFrame("Program");
		pFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pFrame.setSize(1200, 800);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
		JScrollPane scrollpane = new JScrollPane(mainPanel);
		
		JPanel panelUkedager = new JPanel();
		panelUkedager.setLayout(new BoxLayout(panelUkedager, BoxLayout.X_AXIS));
		JLabel[] labelDager = new JLabel[3];
		
		labelDager[0] = new JLabel("Mandag");
		labelDager[1] = new JLabel("Onsdag");
		labelDager[2] = new JLabel("Fredag");
		
		for(int i = 0 ; i < labelDager.length; i++){
			labelDager[i].setFont(new Font("Serif", Font.BOLD, 28));
			labelDager[i].setBorder(BorderFactory.createEmptyBorder(10, 70, 5, 110));
			panelUkedager.add(labelDager[i]);
		}
		mainPanel.add(panelUkedager);
		
		for(int i = 0; i < program.nUker; i++){
			JPanel ukePanel = new JPanel();
			ukePanel.setLayout(new BoxLayout(ukePanel, BoxLayout.X_AXIS));
			JLabel ukeLabel = new JLabel("Uke " + i);
			ukeLabel.setFont(new Font("Serif", Font.BOLD, 28));
			ukeLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0 ,10));
			ukePanel.add(ukeLabel);
			for(int j = 0; j < program.uker[j].dager.size();j++){
				JTextArea dagArea = new JTextArea(program.uker[i].dager.get(j).toString());
				dagArea.setEditable(false);
				Border marg = BorderFactory.createLineBorder(Color.BLACK);
				dagArea.setBorder(BorderFactory.createCompoundBorder(marg, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
				ukePanel.add(dagArea);
			}
			mainPanel.add(ukePanel);
		}
		
		pFrame.add(scrollpane);
		//pFrame.pack();
		pFrame.setVisible(true);
		
	}
	
	void toemFrame(){
		mFrame.getContentPane().removeAll();
		mFrame.revalidate();
		mFrame.repaint();
	}

}
