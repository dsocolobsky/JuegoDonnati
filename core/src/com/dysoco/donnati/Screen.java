package com.dysoco.donnati;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Screen extends ScreenAdapter {

    protected final Juego juego;
    protected Stage stage;

    public Screen(final Juego juego) {
        this.juego = juego;
        this.stage = new Stage(new FitViewport(juego.WINDOW_WIDTH, juego.WINDOW_HEIGHT), juego.batch);
    }

}
