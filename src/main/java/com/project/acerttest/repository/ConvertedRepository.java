package com.project.acerttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.acerttest.model.Converted;

@Repository
public interface ConvertedRepository extends JpaRepository<Converted, Long>{

}
