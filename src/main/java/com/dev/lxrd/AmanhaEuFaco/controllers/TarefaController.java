package com.dev.lxrd.AmanhaEuFaco.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.lxrd.AmanhaEuFaco.dtos.TarefaDto;
import com.dev.lxrd.AmanhaEuFaco.models.TarefaModel;
import com.dev.lxrd.AmanhaEuFaco.services.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tareService){
        this.tarefaService=tareService;
    }

    //metodo para listar tarefas Get:api/tarefas
    @GetMapping("/tarefas")
    public ResponseEntity<List<TarefaModel>> listarTarefas(){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaService.listarTodas());
    }

    //metodo para visualizar uma tarefa:Get: api/tarefa/{id}
    @GetMapping("/tarefa/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable UUID id){
        try{
            var tarefa =  tarefaService.buscarPorId(id);
            return ResponseEntity.ok(tarefa);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //metodo para criar tarefa: POST: api/tarefas/create

    @PostMapping("/tarefas")
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody @Valid TarefaDto tarefaDto){
        var tarefa = tarefaService.criarTarefa(tarefaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa);
    }
    
    //atualizar tarefa api/tarefa+{}

    @PutMapping("/tarefa/{id}")
    public ResponseEntity<?> atualizarTarefa(@PathVariable (value = "id") UUID id, @RequestBody @Valid TarefaDto tarefaDto){
        try{
            return ResponseEntity.ok(tarefaService.atualizarTarefa(id, tarefaDto));
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    //deletar
    @DeleteMapping("/tarefa/{id}")
    public ResponseEntity<String> deletarTarefa(@PathVariable UUID id){
        try{
            tarefaService.deletarTarefa(id);
            return ResponseEntity.ok("deletado com sucesso");
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
