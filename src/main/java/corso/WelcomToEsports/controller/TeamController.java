package corso.WelcomToEsports.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/team")
public class TeamController {
	
	@GetMapping("/")
	public String openTeam(@RequestParam HashMap<String, String> params, Model model) {
		model.addAttribute("nomeGame", params.get("idGames"));
		model.addAttribute("nomeTeam", params.get("idTeam"));
		return "team.html";
	}
	
	@PostMapping("/updateTeam")
	public String updateTeam() {
		System.out.println("TEAM AGGIORNATO NEL DB");
		return "redirect:/team/";
	}
	
	@PostMapping("/deleteTeam")
	public String deleteTeam() {
		System.out.println("TEAM ELIMINATO NEL DB");
		return "redirect:/team/";
	}
	
	@PostMapping("/addPlayer")
	public String addPlayer() {
		System.out.println("PLAYER INSERITO NEL DB");
		return "redirect:/team/";
	}
	@PostMapping("/updatePlayer")
	public String updatePlayer() {
		System.out.println("PLAYER AGGIORNATO NEL DB");
		return "redirect:/team/";
	}
	@PostMapping("/deletePlayers")
	public String deletePlayers() {
		System.out.println("PLAYER ELIMINATO NEL DB");
		return "redirect:/team/";
	}
	
}
