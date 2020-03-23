package mx.dpalme.spaceinvaders;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

class Marcador {
    private int puntos;

    private float x, y;

    private Texto texto;

    public Marcador(float x, float y) {
        this.x = x;
        this.y = y;
        puntos = 0;
        texto = new Texto("fuenteMarcador.fnt");        // Fuente
    }

    public void reset() {
        puntos = 0;
    }

    public void marcar(int puntos) {
        this.puntos += puntos;
    }
    public void render(SpriteBatch batch) {
        String mensaje = "Puntos: " + puntos;
        texto.render(batch, mensaje, x, y);
    }
}
