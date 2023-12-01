package corso.WelcomToEsports.database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import corso.WelcomToEsports.model.Game;
import corso.WelcomToEsports.model.Match;
import corso.WelcomToEsports.model.Team;

public class MatchesDAO {
	
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	private HashMap<Integer, Match> eseguiQuery(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = db.eseguiQuery(query, params);
		Match n = null;
		HashMap<Integer, Match> ris = new HashMap<Integer, Match>();
		for (HashMap<String, Object> record : listaMappe) {
			n = context.getBean(Match.class);
			n.setId((int) record.get("id"));
			n.setDataMatch((Date) record.get("dataMatch"));
			n.setGame(context.getBean(Game.class));
			n.getGame().setId((int) record.get("idGames"));
			n.setTeamHome(context.getBean(Team.class));
			n.getTeamHome().setNome((String) record.get("team_home"));
			n.setTeamAway(context.getBean(Team.class));
			n.getTeamAway().setNome((String) record.get("team_away"));
			n.setPointsHome((int) record.get("pointsHome"));
			n.setPointsAway((int) record.get("pointsAway"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean eseguiUpdate(String query, String... params) {
		return db.eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Match> read() {
		String query = "select m.id, dataMatch, m.idGames, h.nome as team_home, a.nome as team_away, pointsHome, pointsAway from matches m join teams h on m.idteamhome = h.id join teams a on m.idteamaway = a.id";
		return eseguiQuery(query);
	}
	public HashMap<Integer, Match> read(int idMatch) {
		String query = "select m.id, dataMatch, m.idGames, h.nome as team_home, a.nome as team_away, pointsHome, pointsAway from matches m join teams h on m.idteamhome = h.id join teams a on m.idteamaway = a.id where m.id = ?";
		return eseguiQuery(query, idMatch+"");
	}
	
	public HashMap<Integer, Match> readFromGame(int idGame) {
		String query = "select m.id, dataMatch, m.idGames, h.nome as team_home, a.nome as team_away, pointsHome, pointsAway from matches m join teams h on m.idteamhome = h.id join teams a on m.idteamaway = a.id where m.idGames = ?";
		return eseguiQuery(query, idGame+"");
	}
	
	public boolean create(Match match) {
		String query = "insert into MATCHES(dataMatch, idGames, idTeamHome, idTeamAway, pointsHome, pointsAway) values(?, ?, ?, ?, ?, ?)";
		return eseguiUpdate(query, match.getDataMatch().toString(), match.getGame().getId()+"", match.getTeamHome().getId()+"", match.getTeamAway().getId()+"", match.getPointsHome()+"", match.getPointsAway()+"");
	}
	
	public boolean update(Match match) {
		String query = "update MATCHES set dataMatch = ?, idGames = ?, idTeamHome = ?, idTeamAway = ?, pointsHome = ?, pointsAway = ? where id = ?";
		return eseguiUpdate(query, match.getDataMatch().toString(), match.getGame().getId()+"", match.getTeamHome().getId()+"", match.getTeamAway().getId()+"", match.getPointsHome()+"", match.getPointsAway()+"", match.getId()+"");
	}
	
	public boolean delete(int id) {
		String query = "delete from MATCHES where id = ?";
		return eseguiUpdate(query, id+"");
	}
	

}
