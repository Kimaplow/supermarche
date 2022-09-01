package magasin;

import java.util.HashMap;

public class Supermarche {
	
	private HashMap<String, Article> articles;

	public Supermarche() {
		super();
		this.articles = new HashMap<String, Article>();
	}

	public HashMap<String, Article> getArticles() {
		return articles;
	}
	
	public Article getOneArticle(String ref) {
		return this.articles.get(ref);
	}
	
	public void addArticle(Article art) {
		this.articles.put(art.getReference(), art);
	}
	
	public void replaceArticle(String ref, Article art) {
		this.articles.remove(ref);
		this.articles.put(art.getReference(), art);
	}
	
	public void deleteArticles(String ref) {
		this.articles.remove(ref);
	}
	
	public void updateArticle(String ref, Article art) {
		this.articles.put(ref, art);
	}
	
	public Boolean isEmpty() {
		return this.articles.size() == 0;
	}
}