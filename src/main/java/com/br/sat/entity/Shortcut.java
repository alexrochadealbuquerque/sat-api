package com.br.sat.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Shortcut implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String appliedSystem;
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToMany
	@JoinTable(	name = "SHORTCUT_SOFTWARE", 
				joinColumns = @JoinColumn(name = "shortcut_id"), 
				inverseJoinColumns = @JoinColumn(name = "software_id"))
	private List<Software> softwares = new ArrayList<>();

}
