package br.com.mestres.ensino.webapp.spring.domain;

public enum StatusRegistro {
	
	ATIVO("A"), EXCLUIDO("E");
	
	String codigo;
	
    private StatusRegistro(final String codigo) {
    	this.codigo = codigo;
    }
    
    public String getCodigo() {
    	return codigo;
    }
}
