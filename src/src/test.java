package src;

import java.util.Collection;
import java.util.Iterator;

public class test {
	public static void main(String[] args) {
		DossierPharmacie d = new DossierPharmacie("pharmacie1");

		String[] ord = { "vitamineE", "panadol", "vitamineA" };
		d.nouveauPatient("p1", ord);
		String[] ord1 = { "efferalgan", "vitamineD" };
		d.nouveauPatient("p2", ord1);
		d.nouveauPatient("p3", ord);

		System.out.println("afff tous:");
		d.affiche();

		Collection<patient> l = d.PatientAvecMedicament("vitamineE");
		System.out.println("patient qui prennent vitamineE:");
		Iterator<patient> it = l.iterator();
		while (it.hasNext())
			it.next().affiche();

		d.ajoutMedicament("p3", "doliprane");


		String[] ordVide = new String[2];
		d.nouveauPatient("pv", ordVide);
		System.out.println("avant suppp");
		d.affiche();
		d.enleverPatientOrdonnanceVide2();
		System.out.println("après suppp");
		d.affiche();
	}
}