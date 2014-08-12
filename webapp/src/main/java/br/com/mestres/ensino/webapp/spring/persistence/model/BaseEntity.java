package br.com.mestres.ensino.webapp.spring.persistence.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	private Integer id;
	
	private Date dataInclusao;
	
	private String usuarioInclusao;
	
	private Date dataUltimaAtualizacao;
	
	private String usuarioUltimaAtualizacao;
	
	private String statusRegistro;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao", nullable = false, length = 19)
	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	@Column(name = "usuario_inclusao", nullable = false, length = 10)
	public String getUsuarioInclusao() {
		return this.usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_atualizacao", nullable = false, length = 19)
	public Date getDataUltimaAtualizacao() {
		return this.dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	@Column(name = "usuario_ultima_atualizacao", nullable = false, length = 10)
	public String getUsuarioUltimaAtualizacao() {
		return this.usuarioUltimaAtualizacao;
	}

	public void setUsuarioUltimaAtualizacao(String usuarioUltimaAtualizacao) {
		this.usuarioUltimaAtualizacao = usuarioUltimaAtualizacao;
	}

	@Column(name = "status_registro", nullable = false, length = 1)
	public String getStatusRegistro() {
		return this.statusRegistro;
	}

	public void setStatusRegistro(String statusRegistro) {
		this.statusRegistro = statusRegistro;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
