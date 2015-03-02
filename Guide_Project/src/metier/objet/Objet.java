package metier.objet;



public interface Objet 
{
	public void initialisationObjet() ;
	public boolean collision(int x, int y);
	public Object getRepresentation();
}
