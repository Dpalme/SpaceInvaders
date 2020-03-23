package mx.dpalme.spaceinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;

public class Juego extends Game {

	@Override
	public void create () {
		setScreen(new PantallaMenu(this));
	}
}
