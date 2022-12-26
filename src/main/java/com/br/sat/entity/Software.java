package com.br.sat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Software implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String softwareName;
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "softwares")
	private List<Shortcut> shortcut = new ArrayList<>();

}
