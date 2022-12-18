package com.br.sat.service;

import java.util.List;

import javax.validation.Valid;

import com.br.sat.entity.Software;

public interface SoftwareService {

	public List<Software> findAll();

	public Software insert(@Valid Software obj);

	public Software findById(Integer id);

	public Software update(@Valid Software obj);

	public void delete(Integer id);

}
