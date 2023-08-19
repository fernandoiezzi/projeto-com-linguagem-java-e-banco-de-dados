package br.com.cursosja.controlecursoja.model.entidade;

public class Professor {
	private long id;
	private String nome;
	private String celular;
	private double valorHora;
	
	public Professor() {
		this.id = 0;
		this.nome = "";
		this.celular = "";
		this.valorHora = 0.00;
	}
	
	public void setId(long i) {
		this.id = i;
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCelular(String cel) {
		this.celular = cel;
	}
	
	public String getCelular() {
		return this.celular;
	}
	
	public void setValorHora(double valor) {
		this.valorHora = valor;
	}
	
	public double getValorHora() {
		return this.valorHora;
	}

}
