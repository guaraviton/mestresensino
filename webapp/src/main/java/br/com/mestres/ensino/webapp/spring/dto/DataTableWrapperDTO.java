package br.com.mestres.ensino.webapp.spring.dto;

import java.util.List;

public class DataTableWrapperDTO {

	private List<?> data;

	public DataTableWrapperDTO(List<?> dados) {
		this.data = dados;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
