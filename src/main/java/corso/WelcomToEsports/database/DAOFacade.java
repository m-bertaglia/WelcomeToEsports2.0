package corso.WelcomToEsports.database;

import java.sql.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import corso.WelcomToEsports.model.Game;
import corso.WelcomToEsports.model.Match;
import corso.WelcomToEsports.model.Team;

public class DAOFacade {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private GamesDAO gamesDao;
	
	@Autowired
	private TeamsDAO teamsDao;
	
	@Autowired
	private PlayersDAO playersDao;
	
	@Autowired
	private MatchesDAO matchesDao;
	

	public HashMap<Integer, Game> getAllGames() {
		return gamesDao.read();
	}
	public Game getGame(String idGame) {
		return gamesDao.read(Integer.parseInt(idGame));
	}
	
	public boolean createGame(String titolo) {
		Game g = context.getBean(Game.class);
		g.setTitolo(titolo);
		return gamesDao.create(g);
	}
	
	public boolean createTeam(HashMap<String, String> params) {
		Team g = context.getBean(Team.class);
		g.setGame(context.getBean(Game.class));
		g.getGame().setId(Integer.parseInt(params.get("idGame")));
		g.setNome(params.get("nome"));
		g.setNazione(params.get("nazione"));
		return teamsDao.create(g);
	}
	
	public boolean createMatch(HashMap<String, String> params) {
		Match g = context.getBean(Match.class);
		g.setDataMatch(Date.valueOf(params.get("dataMatch")));
		g.setGame(context.getBean(Game.class));
		g.getGame().setId(Integer.parseInt(params.get("idGame")));
		g.setTeamHome(context.getBean(Team.class));
		g.getTeamHome().setId(Integer.parseInt(params.get("idTeamHome")));
		g.setTeamAway(context.getBean(Team.class));
		g.getTeamAway().setId(Integer.parseInt(params.get("idTeamAway")));
		g.setPointsHome(Integer.parseInt(params.get("pointsHome")));
		g.setPointsAway(Integer.parseInt(params.get("pointsAway")));
		return matchesDao.create(g);
	}
	
	public boolean updateGames(int id, String titolo) {
		Game g = context.getBean(Game.class);
		g.setId(id);
		g.setTitolo(titolo);
		return gamesDao.update(g);
	}
	
	public boolean deleteGames(int id) {
		return gamesDao.delete(id);
	}
	
	public HashMap<Integer, Team> getTeamFromGames(String idGame) {
		return teamsDao.readFromGame(Integer.parseInt(idGame));
	}
	public HashMap<Integer, Match> getMatchFromGames(String idGame) {
		return matchesDao.readFromGame(Integer.parseInt(idGame));
	}
	
}
