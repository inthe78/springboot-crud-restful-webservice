package com.sport.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import com.sport.dao.PlayerDao;
import com.sport.model.Player;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerDao dao;
	
	@GetMapping("/register")
	public String registerPlayerForm(Model model,Player player) {
		model.addAttribute("player",player);
		return "registration";
	}
	

	@PostMapping("/registering")
	public String saveEmployee(@ModelAttribute(name = "player") Player player,@RequestParam("file") MultipartFile file) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		System.out.println(fileName);
		
		if(fileName.contains("..")) {
			System.out.println("not valid");
		}
		try {
			player.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dao.AddEmployee(player);
		return "redirect:/";
		
	}
	
//	@GetMapping("/")
//	public String getAllEmployee(Model model,Player player) {
//		List<Player> playerList = dao.getAllEmployeeList();
//		model.addAttribute("player", player);
//		model.addAttribute("playerList", playerList);
//		return "playerlist";
//	}
	
	@GetMapping("/")
	public String getAllEmployee(Model model,Player player,@Param("keyword") String keyword) {
		//List<Player> playerList = dao.getAllEmployeeList();
		List<Player> playerList = dao.getAllPlayersList(keyword);
		model.addAttribute("keyword", keyword);
		model.addAttribute("playerList", playerList);
		return "playerlist";
	}
	
	@GetMapping("/editPlayer/{id}")
	public String editEmployee(@PathVariable int id , Model model) {
		
		Player existPlayer = dao.getEmployee(id);

		model.addAttribute("existPlayer", existPlayer);
		
		return "editplayer";	
	}
	
	@GetMapping("/deletePlayer/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		dao.deletePlayer(id);
		return "redirect:/";
	}

}
