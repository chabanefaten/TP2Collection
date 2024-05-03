package src;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class patient {
	private String nom;
	private Set<String> ordonnance;

	public patient(String n) {
		nom = n;
		ordonnance = new HashSet<String>();
	}

	public String getNom() {
		return nom;
	}

	public boolean ordonnanceVide() {
		return (ordonnance.isEmpty());
	}

	public void ajoutMedicament(String m) {
		ordonnance.add(m);
	}

	public void affiche() {
		System.out.println("nom patient: " + this.nom);
		System.out.println("ordonnance: ");
		Iterator<String> it = ordonnance.iterator();
		while (it.hasNext())
			System.out.println(it.next());

	}

	public boolean contientMedicament(String m) {
		return (ordonnance.contains(m));
	}
}

