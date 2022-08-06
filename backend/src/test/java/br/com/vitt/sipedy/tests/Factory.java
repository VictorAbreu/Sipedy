package br.com.vitt.sipedy.tests;

import br.com.vitt.sipedy.dto.EmpresaDTO;
import br.com.vitt.sipedy.entities.Empresa;

public class Factory {

	public static Empresa createEmpresa() {
		
		Empresa empresa = new Empresa (1L, "Vende Tudo Ltda", "Bill", "17.702.376/0001-40", "058.576.151/8733",
				"35610-000", "Av. Francisco Campos, 82", "Dores do Indaiá", "MG", "37-3551-3551", "37-99191-9191", 
				"contato@vendetudo.com");
		return empresa;
	}
	
	public static EmpresaDTO createEmpresaDto() {
		Empresa empresa = createEmpresa();
		return new EmpresaDTO(empresa);
	}
	
}
