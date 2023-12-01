package corso.WelcomToEsports.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import corso.WelcomToEsports.database.DAOFacade;

@Controller
public class HomeController {
	
	@Autowired
	private DAOFacade daoFacade;
	
	// ./
	// apre la pagina con la lista dei giochi
	@GetMapping("/")
	public String home(Model model) {
		
		model.addAttribute("listaGames", daoFacade.getAllGames());
		
		return "home.html";
	}
	
	// Opzionale mapping per aprire una pagina con 
	// form di inserimento nuovo games
	
	// ./newGames
	// che aggiunge il nuovo gioco al DB(insert into GAMES)
	// 1opzione: aprire una pagina di conferma inserimento
	// 2opzione: redirect:/
	@PostMapping("/newGame")
	public String newGame(@RequestParam("titolo") String titolo) {
		
		daoFacade.createGame(titolo);
		
		return "redirect:/";
	}
	
	@PostMapping("/delGame")
	public String delGame(@RequestParam("id") int id) {
	
		daoFacade.deleteGames(id);
		
		return "redirect:/";
	}
	
	
	

}
