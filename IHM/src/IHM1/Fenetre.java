package IHM1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{

	
	public Fenetre(){

		this.setTitle("Animation?");

		this.setSize(300, 150);

		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//GridLayout (nbLignes, nbColonnes, espaceColonnes, espaceLignes)
	    this.setLayout(new GridLayout(3,2,5,10));

	    this.getContentPane().add(new JButton("1"));
	    this.getContentPane().add(new JButton("2"));
	    this.getContentPane().add(new JButton("3"));
	    this.getContentPane().add(new JButton("4"));
	    this.getContentPane().add(new JButton("5"));

		this.setVisible(true);
		
	}
	
}
