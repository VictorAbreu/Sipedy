package br.com.vitt.sipedy.tests;

import br.com.vitt.sipedy.dto.ClienteDTO;
import br.com.vitt.sipedy.dto.EmpresaDTO;
import br.com.vitt.sipedy.dto.FornecedorDTO;
import br.com.vitt.sipedy.entities.Cliente;
import br.com.vitt.sipedy.entities.Empresa;
import br.com.vitt.sipedy.entities.Fornecedor;

public class Factory {

	public static Empresa createEmpresa() {

		Empresa empresa = new Empresa(1L, "Vende Tudo Ltda", "Bill", "17.702.376/0001-40", "058.576.151/8733",
				"35610-000", "Av. Francisco Campos, 82", "Dores do Indaiá", "MG", "37-3551-3551", "37-99191-9191",
				"contato@vendetudo.com");
		return empresa;
	}

	public static EmpresaDTO createEmpresaDto() {
		Empresa empresa = createEmpresa();
		return new EmpresaDTO(empresa);
	}

	public static Cliente createCliente() {

		Cliente cliente = new Cliente(1L, "Vende Tudo Ltda", "Bill", "17.702.376/0001-40", "058.576.151/8733",
				"35610-000", "Av. Francisco Campos, 82", "Dores do Indaiá", "MG", "37-3551-3551", "37-99191-9191",
				"contato@vendetudo.com");
		return cliente;
	}

	public static ClienteDTO createClienteDto() {
		Cliente cliente = createCliente();
		return new ClienteDTO(cliente);
	}
	
	public static Fornecedor createFornecedor() {

		Fornecedor fornecedor = new Fornecedor(1L, "Vende Tudo Ltda", "Bill", "17.702.376/0001-40", "058.576.151/8733",
				"35610-000", "Av. Francisco Campos, 82", "Dores do Indaiá", "MG", "37-3551-3551", "37-99191-9191",
				"contato@vendetudo.com");
		return fornecedor;
	}

	public static FornecedorDTO createFornecedorDto() {
		Fornecedor fornecedor = createFornecedor();
		return new FornecedorDTO(fornecedor);
	}

}
