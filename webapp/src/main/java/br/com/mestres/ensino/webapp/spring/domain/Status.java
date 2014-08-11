package br.com.mestres.ensino.webapp.spring.domain;

public enum Status {
	
	ATIVO("A"), EXCLUIDO("E");
	
	String codigo;
    private Status(final String codigo) {
    	this.codigo = codigo;
    }
    
    public String getCodigo() {
    	return codigo;
    }
}
