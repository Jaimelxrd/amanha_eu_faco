package com.dev.lxrd.AmanhaEuFaco.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dev.lxrd.AmanhaEuFaco.dtos.TarefaDto;
import com.dev.lxrd.AmanhaEuFaco.models.TarefaModel;
import com.dev.lxrd.AmanhaEuFaco.repositories.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository=tarefaRepository;
    }
    
    //metodo para listar todas as tarefas cadastradas:
    public List<TarefaModel> listarTodas(){
        return tarefaRepository.findAll();
    }

    //metodo para buscar por id
    public TarefaModel buscarPorId(UUID id){
        return tarefaRepository.findById(id).orElseThrow(()->new RuntimeException("Tarefa nao encontrada!"));
    }

    //metodo para criar tarefa
    public TarefaModel criarTarefa(TarefaDto tarefaDto){
            var tarefaModel = new TarefaModel();
            BeanUtils.copyProperties(tarefaDto, tarefaModel);
            TarefaModel tarefa = tarefaRepository.save(tarefaModel);
            return tarefa;
    }

    //atualizar tarefa
    public TarefaModel atualizarTarefa(UUID id, TarefaDto tarefaDto){
        TarefaModel tarefaModel = tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa nao encontrada"));
        BeanUtils.copyProperties(tarefaDto, tarefaModel);
        return tarefaRepository.save(tarefaModel);
    }

    //deletar tarefa
    public void deletarTarefa(UUID id){
        TarefaModel tarefaModel = tarefaRepository.findById(id).orElseThrow(()-> new RuntimeException("Tarefa nao encontrada"));
        tarefaRepository.delete(tarefaModel);
    }
}
