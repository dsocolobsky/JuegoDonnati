package com.dysoco.donnati.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.dysoco.donnati.Assets;
import com.dysoco.donnati.Button;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.Player;

public class EditScreen extends ScreenAdapter {

    final Juego juego;
    Stage stage;

    Player player;
    Image fondo;

    Button editButton;

    Button[] leftButton;
    Button[] rightButton;

    public EditScreen(final Juego juego) {
        this.juego = juego;
        stage = new Stage(new FitViewport(juego.WINDOW_WIDTH, juego.WINDOW_HEIGHT), juego.batch);

        fondo = new Image(Assets.FONDO_TEXTURE);
        stage.addActor(fondo);

        player = new Player(new TextureRegion(Assets.PLAYER_TEXTURE), 328, 20);
        stage.addActor(player);

        editButton = new Button(new TextureRegion(Assets.EDIT_BUTTON), 20, 400, 64, 64);

        editButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new MenuScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        stage.addActor(editButton);

        // BOTONES
        TextureRegion leftRegion = new TextureRegion(Assets.LEFT_BUTTON);
        TextureRegion rightRegion = new TextureRegion(Assets.RIGHT_BUTTON);

        leftButton = new Button[5];
        rightButton = new Button[5];

        leftButton[0] = new Button(leftRegion, 500, 20, 64, 64); // Pies
        leftButton[1] = new Button(leftRegion, 500, 100, 64, 64); // Pantalon
        leftButton[2] = new Button(leftRegion, 500, 196, 64, 64); // Torso
        leftButton[3] = new Button(leftRegion, 500, 296, 64, 64); // Cara
        leftButton[4] = new Button(leftRegion, 500, 372, 64, 64); // Pelo

        rightButton[0] = new Button(rightRegion, 236, 20, 64, 64);
        rightButton[1] = new Button(rightRegion, 236, 100, 64, 64);
        rightButton[2] = new Button(rightRegion, 236, 196, 64, 64);
        rightButton[3] = new Button(rightRegion, 236, 296, 64, 64);
        rightButton[4] = new Button(rightRegion, 236, 372, 64, 64);

        for(Button b : leftButton) {
            stage.addActor(b);
        }

        for(Button b : rightButton) {
            stage.addActor(b);
        }
    }

    @Override
    public void show(){
        super.show();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        System.out.println(Gdx.input.getY());
    }
}
