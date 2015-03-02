package metier.objet;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Plateforme implements Objet
{
	private Point p1 ;
	private Point p2 ;
	
	private Rectangle hitbox ;
	
	
	public Plateforme(Point p1, Point p2)
	{
		this.p1 = p1 ;
		this.p2 = p2 ;
		
		initialisationObjet();
	}

	public void initialisationObjet() 
	{
		// this.angle = Math.atan2(p2.getX() - p1.getX(), p2.getY() - p1.getY()) ;
		
		this.hitbox = new Rectangle(this.p1.x, this.p1.y, this.p2.x-this.p1.x, 1);
	
	}

	@Override
	public boolean collision(int x, int y) 
	{
		return hitbox.contains(x, y);
	}
	
	
	/*
	private double triangleArea(Point a, Point b, Point c)
	{
		return (c.x*b.y-b.x*c.y)-(c.x*a.y-a.x*c.y)+(b.x*a.y-a.x*b.y);
	}
		
	private boolean isInsideSquare(Point a, Point b, Point c, Point d, Point p) 
	{
		if (triangleArea(a,b,p)>0 || triangleArea(b,c,p)>0 || triangleArea(c,d,p)>0 || triangleArea(d,a,p)>0) 
			return false;
		else
			return true;
	}
*/
	@Override
	public ArrayList<Ligne> getRepresentation() 
	{
		ArrayList<Ligne> l = new ArrayList<Ligne>();
		
		l.add(new Ligne(p1, p2));
		return l ;
	}
	
	public Object getHitbox() 
	{
		return hitbox;
	}

	
}
