package com.dysoco.donnati.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.Assets;
import com.dysoco.donnati.Button;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TrajesScreen extends Screen {

    Button volver;
    int currentFondo;
    ArrayList<Texture> fondos;
    Image fondo;

    public TrajesScreen(final Juego juego) {
        super(juego);

        currentFondo = 0;
        fondos = new ArrayList<Texture>();
        fondos.add(Assets.FONDO_AGUA);
        fondos.add(Assets.FONDO_BOMBERO);
        fondos.add(Assets.FONDO_COCINA);
        fondos.add(Assets.FONDO_FRIO);
        fondos.add(Assets.FONDO_POLICIA);
        Collections.shuffle(fondos);

        fondo = new Image(fondos.get(currentFondo));
        fondo.setScale(0.5f);
        stage.addActor(fondo);

        volver = new Button(new TextureRegion(Assets.BACK_BUTTON), 10, 420, 56, 56);

        volver.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new MenuScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        stage.addActor(volver);
    }

}
