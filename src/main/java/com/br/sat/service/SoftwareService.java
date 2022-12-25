package com.br.sat.service;

import java.util.List;

import javax.validation.Valid;

import com.br.sat.dto.SoftwareDTO;

public abstract interface SoftwareService {

	public List<SoftwareDTO> findAll();

	public SoftwareDTO insert(@Valid SoftwareDTO obj);

	public SoftwareDTO findById(Integer id);

	public SoftwareDTO update(@Valid SoftwareDTO obj, Integer id);

	public void delete(Integer id);

}
