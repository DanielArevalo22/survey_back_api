package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.models.Participant;

@Repository
public interface IParticipant extends JpaRepository<Participant, Integer>{

}
