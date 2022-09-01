package magasin;


public class Article {

	private long codeBarre;
	private String reference;
	private String libelle;
	private int prixHT; //en centimes
	private int tva;
	private final static int[] tauxTVA = {550, 2000};
	
	public Article(long codeBarre, String reference, String libelle, int prixHT, int tva) {
		super();
		this.codeBarre = codeBarre;
		this.reference = reference;
		this.libelle = libelle;
		this.prixHT = prixHT;
		this.tva = tauxTVA[tva];
	}

	public long getCodeBarre() {
		return codeBarre;
	}

	public void setCodeBarre(long codeBarre) {
		this.codeBarre = codeBarre;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(int prixHT) {
		this.prixHT = prixHT;
	}

	public static int[] getTauxtva() {
		return tauxTVA;
	}
	
	public int getTVA() {
		return this.tva;
	}
	
	public void setTVA(int tva) {
		this.tva = tauxTVA[tva];
	}

}