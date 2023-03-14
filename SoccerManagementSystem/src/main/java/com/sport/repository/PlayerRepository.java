package com.sport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.sport.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
//	@Query("SELECT p FROM Player p where p.firstName like %?1% OR p.lastName like %?1%" )
	//@Query("SELECT p FROM Player p where CONCAT(p.id,'') like %?1%" )    For numbers use this
	//@Query("SELECT p FROM Player p where CONCAT(p.firstName ,p.id) like %?1%" )
	//@Query("SELECT p FROM Player p where CONCAT(p.firstName ,p.id) like ?1%" )
	
	
    //@Query("SELECT p FROM Player p where p.firstName like %?1%" )
     @Query("SELECT p FROM Player p where CONCAT(p.firstName ,p.id,p.team,p.country,p.jerseyNumber,p.footballLeague,p.position,p.birth_date) like %?1%" )
	 public <T> List<Player> search(T keyword);

}
