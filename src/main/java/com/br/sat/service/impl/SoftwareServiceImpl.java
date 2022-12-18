package com.br.sat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sat.entity.Software;
import com.br.sat.repository.SoftwareRepository;
import com.br.sat.service.SoftwareService;

@Service
public class SoftwareServiceImpl implements SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;

	public List<Software> findAll() {
		return softwareRepository.findAll();
	}

	public Software findById(Integer id) {
		Software ResultObj = findByIdSoftware(id).get();
		return ResultObj;
	}

	public Software insert(Software obj) {
		obj.setId(null);
		return softwareRepository.save(obj);
	}

	public Software update(Software obj) {
		Software newObj = findByIdSoftware(obj.getId()).get();
		updateData(newObj, obj);
		return softwareRepository.save(newObj);
	}

	public void delete(Integer id) {
		softwareRepository.deleteById(id);
	}

	// GLOBAL
	public Optional<Software> findByIdSoftware(Integer id) {
		return softwareRepository.findById(id);
	}

	private void updateData(Software newObj, Software obj) {
		newObj.setSoftwareName(obj.getSoftwareName());
	}

}
