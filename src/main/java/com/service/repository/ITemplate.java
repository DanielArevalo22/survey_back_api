package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.models.Templates;

@Repository
public interface ITemplate extends JpaRepository<Templates, Integer>{

}
