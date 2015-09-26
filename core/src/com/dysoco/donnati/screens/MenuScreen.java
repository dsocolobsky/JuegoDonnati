package com.dysoco.donnati.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.dysoco.donnati.Assets;
import com.dysoco.donnati.Button;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.Player;

public class MenuScreen extends ScreenAdapter {

    final Juego juego;
    Stage stage;
    Player player;
    Button editButton;
    Image fondo;

    Button gameOne;
    Button gameTwo;
    Button gameThree;
    Button gameFour;

    public MenuScreen(final Juego juego) {
        this.juego = juego;

        stage = new Stage(new FitViewport(juego.WINDOW_WIDTH, juego.WINDOW_HEIGHT), juego.batch);

        fondo = new Image(Assets.FONDO_TEXTURE);
        stage.addActor(fondo);

        player = new Player(new TextureRegion(Assets.PLAYER_TEXTURE), 60, 20);
        stage.addActor(player);

        editButton = new Button(new TextureRegion(Assets.EDIT_BUTTON), 20, 400, 64, 64);

        editButton.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new EditScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        stage.addActor(editButton);

        gameOne = new Button(new TextureRegion(Assets.GAME_ONE), 300, 320, 200, 128);

        gameOne.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new JuguetesScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        stage.addActor(gameOne);

        gameTwo = new Button(new TextureRegion(Assets.GAME_TWO), 560, 320, 200, 128);
        stage.addActor(gameTwo);

        gameThree = new Button(new TextureRegion(Assets.GAME_THREE), 300, 140, 200, 128);
        stage.addActor(gameThree);

        gameFour = new Button(new TextureRegion(Assets.GAME_FOUR), 560, 140, 200, 128);
        stage.addActor(gameFour);
    }

    @Override
    public void show(){
        super.show();

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);

        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

}
