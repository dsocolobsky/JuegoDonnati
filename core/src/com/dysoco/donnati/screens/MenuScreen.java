package com.dysoco.donnati.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.Assets;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.Screen;
import com.dysoco.donnati.ScreenButton;

public class MenuScreen extends Screen {
    Image fondo;

    ScreenButton gameOne;
    ScreenButton gameTwo;
    ScreenButton gameThree;
    ScreenButton gameFour;

    public MenuScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.FONDO_TEXTURE);
        stage.addActor(fondo);

        player.setPosition(40, 5);

        player.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Assets.MUSIC_MENU.stop();
                Assets.MUSIC_MENU.setLooping(false);
                juego.setScreen(new EditScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        stage.addActor(player);

        gameOne = new ScreenButton(juego, new JuguetesScreen(juego), Assets.GAME_ONE, 300, 320, 200, 128);
        stage.addActor(gameOne);

        gameTwo = new ScreenButton(juego, new MemoScreen(juego), Assets.GAME_TWO, 560, 320, 200, 128);
        stage.addActor(gameTwo);

        gameThree = new ScreenButton(juego, new CocinaScreen(juego), Assets.GAME_THREE, 300, 140, 200, 128);
        stage.addActor(gameThree);

        gameFour = new ScreenButton(juego, new TrajesScreen(juego), Assets.GAME_FOUR, 560, 140, 200, 128);
        stage.addActor(gameFour);
    }

    @Override
    public void show(){
        super.show();

        Assets.MUSIC_MENU.setLooping(true);
        Assets.MUSIC_MENU.play();
    }

}
