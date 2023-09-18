package br.unifaccamp.carrinho;

public class Livro {
	private String codigo;
	private String titulo;
	private Float valor;
	private Integer quantidade;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Livro() {
		super();
		this.codigo="";
		this.titulo="";
		this.valor=(float)0;
		this.quantidade=0;
	}
	
	
	
}
