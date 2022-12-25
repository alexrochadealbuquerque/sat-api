package com.br.sat.service.impl;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sat.dto.SoftwareDTO;
import com.br.sat.entity.Software;
import com.br.sat.repository.SoftwareRepository;
import com.br.sat.service.SoftwareService;

@Service
public class SoftwareServiceImpl implements SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<SoftwareDTO> findAll() {
		List<Software> listSoftware = softwareRepository.findAll();
		Type listType = new TypeToken<List<SoftwareDTO>>() {
		}.getType();
		List<SoftwareDTO> listSoftwareDTO = modelMapper.map(listSoftware, listType);
		return listSoftwareDTO;
	}

	public SoftwareDTO findById(Integer id) {
		Software software = findByIdSoftware(id).get();
		SoftwareDTO softwareDTO = modelMapper.map(software, SoftwareDTO.class);
		return softwareDTO;
	}

	public SoftwareDTO insert(SoftwareDTO newSoftwareDTO) {
		Software software = softwareRepository.save(modelMapper.map(newSoftwareDTO, Software.class));
		SoftwareDTO softwareDTO = modelMapper.map(software, SoftwareDTO.class);
		return softwareDTO;
	}

	public SoftwareDTO update(SoftwareDTO softwareDTO, Integer id) {
		Software newSoftware = findByIdSoftware(id).get();
		updateData(newSoftware, softwareDTO);
		return modelMapper.map(softwareRepository.save(newSoftware), SoftwareDTO.class);
	}

	public void delete(Integer id) {
		softwareRepository.deleteById(id);
	}

	// # GLOBAL #
	public Optional<Software> findByIdSoftware(Integer id) {
		return softwareRepository.findById(id);
	}

	private void updateData(Software newSoftware, SoftwareDTO softwareDTO) {
		newSoftware.setSoftwareName(softwareDTO.getSoftwareName());
	}

}
