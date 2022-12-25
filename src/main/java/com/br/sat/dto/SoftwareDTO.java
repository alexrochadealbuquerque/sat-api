package com.br.sat.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SoftwareDTO implements Serializable {

	private Integer id;
	String softwareName;
	private static final long serialVersionUID = 1L;

}
