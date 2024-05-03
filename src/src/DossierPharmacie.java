package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DossierPharmacie {
	private String nom;
	private HashMap<String, patient> patients;

	public DossierPharmacie(String n) {
		nom = n;
		patients = new HashMap<String, patient>();
	}

	public void nouveauPatient(String nom, String[] ord) {
		patient p = new patient(nom);
		for (int i = 0; i < ord.length; i++) {
			if (ord[i] != null)
				p.ajoutMedicament(ord[i]);
		}

		patients.put(nom.toLowerCase(), p);
	}

	public boolean ajoutMedicament(String nom, String m) {
		patient p = patients.get(nom.toLowerCase());
		if (p == null) {
			return false;
		}
		p.ajoutMedicament(m);
		return true;
	}

	public void affichePatient(String m) {
		patient p = patients.get(m.toLowerCase());
		if (p != null)
			p.affiche();
		else
			System.out.println("patient non existant");

	}

	public void affiche() {
		System.out.println("Nom pharmacie: " + this.nom);
		System.out.println("liste patients: ");
		Collection<patient> c = patients.values();
		Iterator<patient> it = c.iterator();
		while (it.hasNext())

			it.next().affiche();

	}

     public Collection<patient> PatientAvecMedicament(String m)
           {
            Collection<patient> c= new ArrayList<>(patients.values());
             Iterator<patient> it=c.iterator();
            while(it.hasNext())
            {
                patient p=it.next();
                 if(! (p.contientMedicament(m)))
                            it.remove();
             }
               return c;
}
     
     public Collection<patient> enleverPatientOrdonnanceVide2()
     {
     Collection<patient> c= patients.values();
     Iterator<patient> it=c.iterator();
     while(it.hasNext())
     {
     patient p=it.next();
     if(p.ordonnanceVide())
     it.remove();
     }
     return c;
     }




}