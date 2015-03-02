package metier.objet;

import java.util.ArrayList;

public class Balise implements Objet 
{

	public Balise() 
	{
		//super(20, 20);
	}

	@Override
	public void initialisationObjet() 
	{
		
	}

	@Override
	public boolean collision(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Ligne> getRepresentation() {
		// TODO Auto-generated method stub
		return null;
	}

}
