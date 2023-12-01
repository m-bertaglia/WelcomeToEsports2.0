package corso.WelcomToEsports.database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import corso.WelcomToEsports.model.Game;
import corso.WelcomToEsports.model.Player;
import corso.WelcomToEsports.model.Team;

public class PlayersDAO {
	
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	private HashMap<Integer, Player> eseguiQuery(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = db.eseguiQuery(query, params);
		Player n = null;
		HashMap<Integer, Player> ris = new HashMap<Integer, Player>();
		for (HashMap<String, Object> record : listaMappe) {
			n = context.getBean(Player.class);
			n.setId((int) record.get("id"));
			n.setNickname((String) record.get("nickname"));
			n.setNome((String) record.get("nome"));
			n.setCognome((String) record.get("cognome"));
			n.setDataNascita((Date) record.get("dataNascita"));
			n.setGameRole((String) record.get("gamesRole"));
			n.setTeam(context.getBean(Team.class));
			n.getTeam().setId((int) record.get("id_team"));
			n.getTeam().setNome((String) record.get("nome_team"));
			n.getTeam().setNazione((String) record.get("nazione"));
			n.getTeam().setGame(context.getBean(Game.class));
			n.getTeam().getGame().setId((int) record.get("id_game"));
			n.getTeam().getGame().setTitolo((String) record.get("titolo"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean eseguiUpdate(String query, String... params) {
		return db.eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Player> read() {
		String query = "select * from TEAMS";
		return eseguiQuery(query);
	}
	public HashMap<Integer, Player> read(int idTeam) {
		String query = "select * from PLAYERS where id = ?";
		return eseguiQuery(query, idTeam+"");
	}
	public HashMap<Integer, Player> readFromGames(int idGames) {
		String query = "select p.id, nickname, p.nome, cognome, dataNascita, gamesRole, idTeam as id_team, t.nome as nome_team, nazione, idGames as id_game, titolo from players p join teams t on p.idTeam = t.id join games g on t.idGames = g.id";
		return eseguiQuery(query, idGames+"");
	}
	
	public boolean create(Player player) {
		String query = "insert into PLAYERS(nickname, nome, cognome, dataNascita, gamesRole, idTeam) values(?, ?, ?, ?, ?, ?)";
		return eseguiUpdate(query, player.getNickname(), player.getNome(), player.getCognome(), player.getDataNascita().toString(), player.getGameRole(), player.getTeam().getId()+"");
	}
	
	public boolean update(Player player) {
		String query = "update PLAYERS set nickname = ?, nome = ?, cognome = ?, dataNascita = ?, gamesRole = ?, idTeam = ? where id = ?";
		return eseguiUpdate(query, player.getNickname(), player.getNome(), player.getCognome(), player.getDataNascita().toString(), player.getGameRole(), player.getTeam().getId()+"", player.getId()+"");
	}
	
	public boolean delete(int id) {
		String query = "delete from PLAYERS where id = ?";
		return eseguiUpdate(query, id+"");
	}
	

}
