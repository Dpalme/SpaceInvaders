package mx.dpalme.spaceinvaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PantallaMenu extends Pantalla {

    private final Juego juego;

    private Texture texturaFondo;

    private Stage escenaMenu;

    public PantallaMenu(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void show() {
        texturaFondo = new Texture("fondo.jpg");

        crearMenu();
    }

    private void crearMenu() {
        escenaMenu = new Stage(vista);

        //Btn jugar
        Texture texturaBtnJugar = new Texture("BtnJugar.png");
        TextureRegionDrawable trdJugar = new TextureRegionDrawable(
                new TextureRegion(texturaBtnJugar));

        Texture texturaBtnJugarP = new Texture("BtnJugarPressed.png");
        TextureRegionDrawable trdJugarP = new TextureRegionDrawable(
                new TextureRegion(texturaBtnJugarP));

        ImageButton btnJugar = new ImageButton(trdJugar, trdJugarP);

        btnJugar.setPosition(ANCHO/2-btnJugar.getWidth()/2, ANCHO/3-btnJugar.getHeight()/2);

        btnJugar.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                juego.setScreen(new PantallaSpaceInvaders(juego));
            }
        });

        escenaMenu.addActor(btnJugar);

        Gdx.input.setInputProcessor(escenaMenu);
    }

    @Override
    public void render(float delta) {
        borrarPantalla();
        batch.setProjectionMatrix(camara.combined);

        batch.begin();
        batch.draw(texturaFondo, 0, 0);
        batch.end();

        escenaMenu.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        texturaFondo.dispose();
    }
}
