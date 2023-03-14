package com.sport.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sport.dao.PlayerDao;
import com.sport.model.Player;

@Controller
public class SortPlayersController {
	

	@Autowired
	private PlayerDao dao;
	
	@GetMapping("/sortByName")
	public String sortByName(Model model,Player player) {
	List<Player> list = dao.getAllEmployeeList();
	List<Player> li = list.stream().sorted((x,y)->x.getFirstName().compareTo(y.getFirstName())).toList();
	model.addAttribute("playerList", li);
	return "playerlist";
		
	}

}
