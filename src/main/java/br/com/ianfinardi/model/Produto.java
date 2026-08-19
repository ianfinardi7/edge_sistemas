package br.com.ianfinardi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "TB_PRODUTO")
		
public class Produto {
	 @Id
	 private Integer codigo;

	 @NotBlank
	 private String nome;
	 
	 @PositiveOrZero(message = "O preço não pode ser negativo.")
	 private Double preco;
	 
	 private String marca;
	 
	 public Produto() {
		 
	 }
	 
	 public Produto(String nome, Double preco, String marca, int codigo) {
		 this.nome = nome;
		 this.preco = preco;
		 this.marca = marca;
		 this.codigo = codigo;
	 }
	
	 public int getCodigo() {
		 return codigo;
	 }
	 
	 public void setCodigo(int codigo) {
		 this.codigo = codigo;
	 }
	 
	 public String getNome() {
		 return nome;
	 }
	 
	 public void setNome(String nome) {
		 this.nome = nome;
	 }
	 
	 public Double getPreco() {
		 return preco;
	 }
	 
	 public void setPreco(Double preco) {
		 this.preco = preco;
	 }
	 
	 public String getMarca() {
		 return marca;
	 }
		 
	 public void setMarca(String marca) {
		 this.marca = marca;
	 }
	 
	 
};
