package corso.WelcomToEsports.model;

public class Game extends Entity {
	
	private String titolo;

	@Override
	public String toString() {
		return "Game [" + super.toString() + ", titolo=" + titolo + "]";
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
}
