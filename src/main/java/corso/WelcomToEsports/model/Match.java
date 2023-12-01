package corso.WelcomToEsports.model;

import java.sql.Date;

public class Match extends Entity {
	
	private Date dataMatch;
	private Game game;
	private Team teamHome;
	private Team teamAway;
	private int pointsHome;
	private int pointsAway;
	@Override
	public String toString() {
		return "Match [" + super.toString() + ", dataMatch=" + dataMatch + ", game=" + game + ", teamHome="
				+ teamHome + ", teamAway=" + teamAway + ", pointsHome=" + pointsHome + ", pointsAway=" + pointsAway
				+ "]";
	}
	public Date getDataMatch() {
		return dataMatch;
	}
	public void setDataMatch(Date dataMatch) {
		this.dataMatch = dataMatch;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Team getTeamHome() {
		return teamHome;
	}
	public void setTeamHome(Team teamHome) {
		this.teamHome = teamHome;
	}
	public Team getTeamAway() {
		return teamAway;
	}
	public void setTeamAway(Team teamAway) {
		this.teamAway = teamAway;
	}
	public int getPointsHome() {
		return pointsHome;
	}
	public void setPointsHome(int pointsHome) {
		this.pointsHome = pointsHome;
	}
	public int getPointsAway() {
		return pointsAway;
	}
	public void setPointsAway(int pointsAway) {
		this.pointsAway = pointsAway;
	}
	
}
