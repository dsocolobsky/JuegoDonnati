package com.dysoco.donnati.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.*;

public class MenuScreen extends Screen {

    Player player;
    Button editButton;
    Image fondo;

    Button gameOne;
    Button gameTwo;
    Button gameThree;
    Button gameFour;

    public MenuScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.FONDO_TEXTURE);
        stage.addActor(fondo);

        player = new Player(new TextureRegion(Assets.PLAYER_TEXTURE), 40, 5);

        player.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new EditScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });;

        stage.addActor(player);

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

        gameTwo.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new MemoScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        stage.addActor(gameTwo);

        gameThree = new Button(new TextureRegion(Assets.GAME_THREE), 300, 140, 200, 128);
        stage.addActor(gameThree);

        gameFour = new Button(new TextureRegion(Assets.GAME_FOUR), 560, 140, 200, 128);
        stage.addActor(gameFour);
    }

}
