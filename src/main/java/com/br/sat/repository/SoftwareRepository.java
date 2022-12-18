package com.br.sat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.sat.entity.Software;

@Repository
public interface SoftwareRepository extends JpaRepository<Software, Integer> {

}
