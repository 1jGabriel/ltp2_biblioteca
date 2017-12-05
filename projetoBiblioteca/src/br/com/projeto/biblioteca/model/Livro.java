package br.com.projeto.biblioteca.model;

public class Livro {

	private int id;
	private String nome;
	private String editora;
	private String edicao;
	private String area;

	public Livro() {
		super();
	}

	public Livro(int id, String nome, String editora, String edicao, String area) {
		super();
		this.id = id;
		this.nome = nome;
		this.editora = editora;
		this.edicao = edicao;
		this.area = area;
	}

	public Livro(String nome, String editora, String edicao, String area) {
		super();
		this.nome = nome;
		this.editora = editora;
		this.edicao = edicao;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
