package corso.WelcomToEsports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import corso.WelcomToEsports.database.DAOFacade;
import corso.WelcomToEsports.database.Database;
import corso.WelcomToEsports.database.GamesDAO;
import corso.WelcomToEsports.database.MatchesDAO;
import corso.WelcomToEsports.database.PlayersDAO;
import corso.WelcomToEsports.database.TeamsDAO;
import corso.WelcomToEsports.model.Game;
import corso.WelcomToEsports.model.Match;
import corso.WelcomToEsports.model.Player;
import corso.WelcomToEsports.model.Team;

@Configuration
public class Context {

	@Bean
	public Database db() {
		System.out.println("init Database()");
		return new Database();
	}
	
	@Bean
	public DAOFacade daoFacade() {
		System.out.println("init DAOFacade()");
		return new DAOFacade();
	}
	
	@Bean
	public GamesDAO gamesDAO() {
		System.out.println("init GamesDAO()");
		return new GamesDAO();
	}
	
	@Bean
	public TeamsDAO teamsDAO() {
		System.out.println("init TeamsDAO()");
		return new TeamsDAO();
	}
	
	@Bean
	public PlayersDAO playersDAO() {
		System.out.println("init PlayersDAO()");
		return new PlayersDAO();
	}
	
	@Bean
	public MatchesDAO matchesDAO() {
		System.out.println("init MatchesDAO()");
		return new MatchesDAO();
	}
	
	
	@Bean
	@Scope("prototype")
	public Game game() {
		return new Game();
	}
	
	@Bean
	@Scope("prototype")
	public Team team() {
		return new Team();
	}
	
	@Bean
	@Scope("prototype")
	public Player player() {
		return new Player();
	}
	
	@Bean
	@Scope("prototype")
	public Match match() {
		return new Match();
	}
	
	
}
