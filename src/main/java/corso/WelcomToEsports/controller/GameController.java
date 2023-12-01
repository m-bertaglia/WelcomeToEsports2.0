package corso.WelcomToEsports.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import corso.WelcomToEsports.database.DAOFacade;
import corso.WelcomToEsports.model.Game;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private DAOFacade daoFacade;

	// Apriamo la pagina del gioco scelto, avendo quindi un parametro in
	// input che dalla pagina home che ci dice quale gioco aprire e con quali
	@PostMapping("/")
	public String openGame(@RequestParam("idGames") String idGames, Model model) {
		
		model.addAttribute("game", daoFacade.getGame(idGames));
		model.addAttribute("listaTeams", daoFacade.getTeamFromGames(idGames));
		model.addAttribute("listaMatches", daoFacade.getMatchFromGames(idGames));
		
		return "game.html";
	}

	// modale per inserire un nuovo team 
	@PostMapping("/newTeam")
	public String addNewTeam(@RequestParam HashMap<String, String> params) {
		
		daoFacade.createTeam(params);

		return "redirect:/game/";
	}

	// modale per inserire un nuovo match 
	@PostMapping("/newMatch")
	public String addNewMatch(@RequestParam HashMap<String, String> params) {

		daoFacade.createMatch(params);
		
		return "redirect:/game/";
	}




}
