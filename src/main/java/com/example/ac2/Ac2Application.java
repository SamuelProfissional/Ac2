package com.example.ac2;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac2.models.Diretor;
import com.example.ac2.models.Filme;
import com.example.ac2.repositories.DiretorRepository;
import com.example.ac2.repositories.FilmeRepository;

@SpringBootApplication

public class Ac2Application {


	
	@Bean
	public CommandLineRunner init(
			@Autowired FilmeRepository filmeRepository, @Autowired DiretorRepository diretorRepository ) {
		return args -> {
	
			Diretor c1 = diretorRepository.save(
				new Diretor(null, "Jonata", null));

			

			// Inserir cursos
			filmeRepository.save(
					new Filme(null,"Vingadores",220,null));
			filmeRepository.save(
					new Filme(null,"Homem-Aranha",120,null));
			filmeRepository.save(
					new Filme(null,"Vingadores - 2",300,null));
			
			List<Filme> listaFilme = filmeRepository.findAll();
			listaFilme.forEach(System.out::println);
			// Associar cursos à categoria
			listaFilme.forEach(filme -> {
				filme.setDiretor(c1);
				filmeRepository.save(filme);
			});

			// System.out.println("Cursos que começa com 'Jogos'");
			// cursoRepository.findByNomeLike("Jogos%")
			// 		.forEach(System.out::println);


			System.out.println(("Filmes como o mesmos nome"));
			filmeRepository.findBytituloStartingWith("Vingadores").forEach (System.out::println);

			System.out.println(("filmes com duração menor ou igual a um determinado valor."));
			filmeRepository.findByduracaoLessThanEqual(300).forEach (System.out::println);  
			//  terminar 
			System.out.println((" Filmes com duração maior que um determinado valor"));
			filmeRepository.findByduracaoGreaterThan(120).forEach (System.out::println);  

			System.out.println((" Filmes com duração maior que um determinado valor"));
			diretorRepository.findBynomeStartingWith("Jonata").forEach (System.out::println);  

			


		};
	}


	public static void main(String[] args) {
		SpringApplication.run(Ac2Application.class, args);
	}

}
