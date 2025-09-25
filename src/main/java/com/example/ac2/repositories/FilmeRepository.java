package com.example.ac2.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ac2.models.Filme;

public interface  FilmeRepository  extends  JpaRepository<Filme, Long> {
    
    //maior
    List<Filme>findByduracaoGreaterThan(Integer duracao);
    //menor =
    List<Filme>findByduracaoLessThanEqual(Integer duracao);

    List<Filme> findBytituloStartingWith(String titulo);
}
