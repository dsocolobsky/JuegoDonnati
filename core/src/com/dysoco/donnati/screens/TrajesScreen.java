package com.dysoco.donnati.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.Assets;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.Screen;
import com.dysoco.donnati.VolverButton;

import java.util.ArrayList;
import java.util.Collections;

public class TrajesScreen extends Screen {

    VolverButton volver;
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

        volver = new VolverButton(juego, 10, 420);
        stage.addActor(volver);
    }

}
