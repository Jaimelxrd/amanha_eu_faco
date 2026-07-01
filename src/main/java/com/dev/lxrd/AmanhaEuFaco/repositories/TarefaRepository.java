package com.dev.lxrd.AmanhaEuFaco.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.lxrd.AmanhaEuFaco.models.TarefaModel;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, UUID> {

}
