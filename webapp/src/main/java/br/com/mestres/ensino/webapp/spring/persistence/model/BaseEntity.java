package br.com.mestres.ensino.webapp.spring.persistence.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class BaseEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao", nullable = false, length = 19)
	private Date dataInclusao;
	
	@Column(name = "usuario_inclusao", nullable = false, length = 10)
	private String usuarioInclusao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_atualizacao", nullable = false, length = 19)
	private Date dataUltimaAtualizacao;
	
	@Column(name = "usuario_ultima_atualizacao", nullable = false, length = 10)
	private String usuarioUltimaAtualizacao;
	
	@Column(name = "status", nullable = false, length = 1)
	private String status;

	public Date getDataInclusao(){
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao){
		this.dataInclusao = dataInclusao;
	}

	public String getUsuarioInclusao(){
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao){
		this.usuarioInclusao = usuarioInclusao;
	}

	public Date getDataUltimaAtualizacao(){
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao){
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public String getUsuarioUltimaAtualizacao(){
		return usuarioUltimaAtualizacao;
	}

	public void setUsuarioUltimaAtualizacao(String usuarioUltimaAtualizacao){
		this.usuarioUltimaAtualizacao = usuarioUltimaAtualizacao;
	}

	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
}
