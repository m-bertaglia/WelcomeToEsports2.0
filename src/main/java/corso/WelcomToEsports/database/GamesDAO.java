package corso.WelcomToEsports.database;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import corso.WelcomToEsports.model.Game;

public class GamesDAO {
	
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	private HashMap<Integer, Game> eseguiQuery(String query, String... params) {
		ArrayList<HashMap<String, Object>> listaMappe = db.eseguiQuery(query, params);
		Game n = null;
		HashMap<Integer, Game> ris = new HashMap<Integer, Game>();
		for (HashMap<String, Object> record : listaMappe) {
			n = context.getBean(Game.class);
			n.setId((int) record.get("id"));
			n.setTitolo((String) record.get("titolo"));
			ris.put(n.getId(), n);
		}
		return ris;
	}
	
	private boolean eseguiUpdate(String query, String... params) {
		return db.eseguiUpdate(query, params); 
	}
	
	public HashMap<Integer, Game> read() {
		String query = "select * from GAMES";
		return eseguiQuery(query);
	}
	public Game read(int idGame) {
		String query = "select * from GAMES where id = ?";
		return eseguiQuery(query, idGame+"").get(idGame);
	}
	
	public boolean create(Game game) {
		String query = "insert into GAMES(titolo) values(?)";
		return eseguiUpdate(query, game.getTitolo());
	}
	
	public boolean update(Game game) {
		String query = "update GAMES set titolo = ? where id = ?";
		return eseguiUpdate(query, game.getTitolo(), game.getId()+"");
	}
	
	public boolean delete(int id) {
		String query = "delete from GAMES where id = ?";
		return eseguiUpdate(query, id+"");
	}
	

}
