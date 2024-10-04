package com.example.demo.controller;

import com.example.demo.model.Instrutor;
import com.example.demo.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/apiInstrutor")
public class InstrutorController {
    @Autowired
    InstrutorRepository instrutorRepository;

    @GetMapping(value="/instrutores")
    public List<Instrutor> listarAlunos(){
        return instrutorRepository.findAll();
    }

    @GetMapping(value="/instrutores/{codigo}")
    public Optional<Instrutor> listaInstrutoresporCodigo(@PathVariable(value = "codigo")int codigo){
        return instrutorRepository.findById(codigo);
    }

    @PostMapping("/inserirInstrutor")
    public void inserirInstrutores (@RequestBody Instrutor instrutor){
        instrutorRepository.save(instrutor);
    }

    @DeleteMapping("/removerInstrutor")
    public void removeInstrutor (@RequestBody Instrutor instrutor){
        instrutorRepository.delete(instrutor);
    }

    @PutMapping("/atualizarInstrutor")
    public void atualizarInstrutor (@RequestBody Instrutor instrutor){
        instrutorRepository.save(instrutor);
    }

    @GetMapping(value="/instrutoresNome/{nome}")
    public List<Instrutor> buscarPorNome(@PathVariable(value="nome")String nome){
        return instrutorRepository.findByNome(nome);
    }

    @GetMapping(value="/instrutoresCodigoMaior/{codigo}")
    public List<Instrutor> buscarPorCodigoEspecifico(@PathVariable(value="codigo")int codigo){
        return instrutorRepository.findByCodigoEspecifico(codigo);
    }

    @GetMapping(value="/instrutoresCodigoNome/{codigo}/{nome}")
    public List<Instrutor> buscarPorCodigoeNome(@PathVariable(value="codigo")int codigo, @PathVariable(value="nome") String nome){
        return instrutorRepository.findByCodigoandName(codigo, nome);
    }
}
