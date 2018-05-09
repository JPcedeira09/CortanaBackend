package br.com.zup.models.novo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="tb_futuro")
@Entity
public class Futuro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 

	@Enumerated(EnumType.STRING)
	private ClassML classe; 

	@Enumerated(EnumType.STRING)
	private TipoOp tipo;

	private BigDecimal valor;
	private BigDecimal previsao;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClassML getClasse() {
		return classe;
	}
	public void setClasse(ClassML classe) {
		this.classe = classe;
	}
	public TipoOp getTipo() {
		return tipo;
	}
	public void setTipo(TipoOp tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getPrevisao() {
		return previsao;
	}
	public void setPrevisao(BigDecimal previsao) {
		this.previsao = previsao;
	}

	public Futuro(int id, ClassML classe, TipoOp tipo, BigDecimal valor, BigDecimal previsao) {
		super();

		this.id = id;
		this.classe = classe;
		this.tipo = tipo;
		this.valor = valor;
		this.previsao = previsao;
	}

	public Futuro() {
		super();
	}
	
	@Override
	public String toString() {
		return "Futuro [id=" + id + ", classe=" + classe + ", tipo=" + tipo + ", valor=" + valor + ", previsao="
				+ previsao + "]";
	}




}