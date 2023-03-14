package com.sport.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.model.Player;
import com.sport.repository.PlayerRepository;

@Repository
public class PlayerDao {
	
	@Autowired
	private PlayerRepository repo;
	
	public void AddEmployee(Player player) {


		repo.save(player);	
}
	
	public List<Player> getAllEmployeeList(){
		
		return repo.findAll();
	}
	
   public List<Player> getAllPlayersList(String keyword){
	
	if(keyword!=null) {
		return repo.search(keyword);
	}
		
		return repo.findAll();
	}
	
  public void deletePlayer(int id){
		
		repo.deleteById(id);
	}
  
  public Player getEmployee(Integer id){
		
		return repo.findById(id).get();
		
	}


}
