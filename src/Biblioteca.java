import java.sql.Date;

public class Biblioteca {
	
	private int id;
	private String nome;
	private String sobreNome;
	private Date dataNascimento;
   // private String matricula;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Empregado [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", dataNascimento="
				+ dataNascimento + "]";
	}
}
