package com.mgmoura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mgmoura.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	
	
	@Query("select c from Contato c where c.email = :email")
	Contato findByEmail(@Param("email") String email);	
	
    @Query("select c from Contato c where c.idContato = :idContato")
    Contato findByIdContato(@Param("idContato") Integer idContato);
    
    @Query("select c from Contato c order by c.nome asc")
    List<Contato> findAll();

}

