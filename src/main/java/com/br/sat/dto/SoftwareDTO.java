package com.br.sat.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SoftwareDTO implements Serializable {

	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=2, max=100, message="O tamanho deve ser entre 5 e 100 caracteres")
	private String softwareName;
	private static final long serialVersionUID = 1L;

}
