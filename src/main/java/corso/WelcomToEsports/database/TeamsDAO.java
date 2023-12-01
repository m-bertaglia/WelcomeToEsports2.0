package corso.WelcomToEsports.database;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import corso.WelcomToEsports.model.Game;
import corso.WelcomToEsports.model.Team;

public class TeamsDAO {
	
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	private HashMap<Integer, Team> eseguiQuery(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = db.eseguiQuery(query, params);
		Team n = null;
		HashMap<Integer, Team> ris = new HashMap<Integer, Team>();
		for (HashMap<String, Object> record : listaMappe) {
			n = context.getBean(Team.class);
			n.setId((int) record.get("id"));
			n.setNome((String) record.get("nome"));
			n.setNazione((String) record.get("nazione"));
			n.setGame(context.getBean(Game.class));
			n.getGame().setId((int) record.get("id_game"));
			n.getGame().setTitolo((String) record.get("titolo"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean eseguiUpdate(String query, String... params) {
		return db.eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Team> read() {
		String query = "select * from TEAMS";
		return eseguiQuery(query);
	}
	public HashMap<Integer, Team> read(int idTeam) {
		String query = "select * from TEAMS where id = ?";
		return eseguiQuery(query, idTeam+"");
	}
	public HashMap<Integer, Team> readFromGame(int idGames) {
		String query = "select TEAMS.id, nome, nazione, idGames as id_game, titolo from GAMES join TEAMS on GAMES.id = TEAMS.idGames where idGames = ?";
		return eseguiQuery(query, idGames+"");
	}
	
	public boolean create(Team team) {
		String query = "insert into TEAMS(nome, nazione, idGames) values(?, ?, ?)";
		return eseguiUpdate(query, team.getNome(), team.getNazione(), team.getGame().getId()+"");
	}
	
	public boolean update(Team team) {
		String query = "update TEAMS set nome = ?, nazione = ?, idGames = ? where = ?";
		return eseguiUpdate(query, team.getNome(), team.getNazione(), team.getGame().getId()+"", team.getId()+"");
	}
	
	public boolean delete(int id) {
		String query = "delete from TEAMS where id = ?";
		return eseguiUpdate(query, id+"");
	}
	

}
