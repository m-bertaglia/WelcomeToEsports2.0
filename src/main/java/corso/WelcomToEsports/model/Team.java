package corso.WelcomToEsports.model;

public class Team extends Entity {
	
	private Game game;
	private String nome;
	private String nazione;
	@Override
	public String toString() {
		return "Team [" + super.toString() + ", game=" + game + ", nome=" + nome + ", nazione=" + nazione
				+ "]";
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

}
