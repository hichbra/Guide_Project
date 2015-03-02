package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import metier.Terrain;
import metier.objet.Ligne;
import metier.objet.Objet;
import metier.objet.Plateforme;

@SuppressWarnings("serial")
public class Visu extends JPanel
{
	private Terrain terrain ;
	
	// dessin du guide en cours
	private boolean preview ;
	private int debutX 	;
	private int debutY 	;
	private int finX 	;
	private int finY	;
	
	public Visu(Terrain t)
	{
		this.terrain = t ;
		
		this.addMouseListener(new ControleurMouseListener());
		this.addMouseMotionListener(new ControleurMouseListener());
		
		this.setPreferredSize(new Dimension(this.terrain.getLargeur(), this.terrain.getHauteur()));
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);

		dessineJoueur(g);
		dessineObjet(g);
		dessinDuGuide(g);
		
		
		/*
		try {
			Thread.sleep(20);
		} 
		catch (InterruptedException e) {e.printStackTrace();}
		*/
	}

	private void dessinDuGuide(Graphics g)
	{
		if(preview)
		{
			g.setColor(Color.GRAY);
			g.drawLine(debutX, debutY, finX, finY);
			g.setColor(Color.RED);
			g.drawLine(debutX, debutY, finX, debutY);
			g.setColor(Color.BLACK);
		}
	}

	private void dessineObjet(Graphics g)
	{
		for( Objet o : terrain.getObjets() )
		{
			if ( o instanceof Plateforme )
			{
				ArrayList<Ligne> r = (ArrayList<Ligne>)o.getRepresentation();
				g.drawLine(r.get(0).getP1().x, r.get(0).getP1().y, r.get(0).getP2().x, r.get(0).getP2().y);
			}
		}
	}

	private void dessineJoueur(Graphics g)
	{
		g.drawRect(	(int)this.terrain.getJoueur().getPosition().getX(),
					(int)this.terrain.getJoueur().getPosition().getY(),
					this.terrain.getJoueur().getLargeur(), 
					this.terrain.getJoueur().getHauteur());
		
	}
	
	
	class ControleurMouseListener implements MouseListener, MouseMotionListener
	{		
		public ControleurMouseListener() 
		{
			preview = false ;
			init();
		}
		
		public void init()
		{
			debutX 	= -1 ;
			debutY 	= -1 ;
			finX	= -1 ;
			finY	= -1 ;
		}
		
		@Override
		public void mouseDragged(MouseEvent e) 
		{
			finX	= e.getX() ;
			finY	= e.getY() ;
			
			preview = true ;
			repaint();
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		//------------------------------------------------
		//------------------------------------------------
		
		@Override
		public void mouseClicked(MouseEvent e) 
		{
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) 
		{
			debutX	= e.getX();
			debutY 	= e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) 
		{
			terrain.getObjets().add(new Plateforme(new Point(debutX, debutY), new Point(finX, debutY))) ;

			preview = false ;
			init();
		}
		
	}
}
