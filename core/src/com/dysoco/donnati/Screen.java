package com.dysoco.donnati;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Screen extends ScreenAdapter {

    protected final Juego juego;
    protected Stage stage;
    protected Player player;
    protected Image felicitaciones;

    public Screen(final Juego juego) {
        this.juego = juego;
        this.stage = new Stage(new FitViewport(juego.WINDOW_WIDTH, juego.WINDOW_HEIGHT), juego.batch);
        this.player = juego.player;
        felicitaciones = new Image(Assets.FELICITACIONES);
        felicitaciones.setScale(0.40f);
    }

    public void ganar() {
        Assets.SOUND_APPLAUSE.play();
        stage.addActor(felicitaciones);
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
