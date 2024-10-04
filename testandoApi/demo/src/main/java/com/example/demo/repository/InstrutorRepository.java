package com.example.demo.repository;
import  com.example.demo.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstrutorRepository extends JpaRepository <Instrutor, Integer>{
    @Query(value = "select a from Instrutor a where a.nome like %?1%")
    List<Instrutor> findByNome (String nome);

    @Query(value = "select * from instrutor where codigo > ?1", nativeQuery = true)
    List<Instrutor> findByCodigoEspecifico (int codigo);

    @Query(value = "select * from instrutor where codigo > ?1 and nome like %?2%", nativeQuery = true)
    List<Instrutor> findByCodigoandName (int codigo, String nome);
}
