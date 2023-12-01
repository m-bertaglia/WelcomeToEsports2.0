package corso.WelcomToEsports.model;

import java.sql.Date;

public class Player extends Entity {
	
	private Team team;
	private String nickname;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private String gameRole;
	@Override
	public String toString() {
		return "Player [" + super.toString() + ", team=" + team + ", nickname=" + nickname + ", nome=" + nome
				+ ", cognome=" + cognome + ", dataNascita=" + dataNascita + ", gameRole=" + gameRole + "]";
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getGameRole() {
		return gameRole;
	}
	public void setGameRole(String gameRole) {
		this.gameRole = gameRole;
	}

}
