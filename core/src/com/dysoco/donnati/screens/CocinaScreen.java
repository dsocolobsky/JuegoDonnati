package com.dysoco.donnati.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.Assets;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.Screen;
import com.dysoco.donnati.VolverButton;

public class CocinaScreen extends Screen {

    VolverButton volver;
    Image fondo;

    public CocinaScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.BACKGROUND_COCINA);
        fondo.setScale(0.45f);
        stage.addActor(fondo);

        volver = new VolverButton(juego, 10, 420);
        stage.addActor(volver);
    }
}
