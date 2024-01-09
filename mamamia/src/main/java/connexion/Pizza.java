package connexion;

public class Pizza {
    private int IdPizza;
    private String NomPizza;
    private double prix;
    
 // Constructors, getters, setters
    
	public int getIdPizza() {
		return IdPizza;
	}
	public void setIdPizza(int IdPizza) {
		this.IdPizza = IdPizza;
	}
	public String getNomPizza() {
		return NomPizza;
	}
	public void setNomPizza(String nomPizza) {
		NomPizza = nomPizza;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}
