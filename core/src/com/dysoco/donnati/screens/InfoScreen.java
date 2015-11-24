package com.dysoco.donnati.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.Assets;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.Screen;

public class InfoScreen extends Screen {

    Image fondo;
    Image creditos;

    public InfoScreen(Juego juego) {
        super(juego);

        fondo = new Image(Assets.FONDO_TEXTURE);
        fondo.setPosition(-30, -40);
        stage.addActor(fondo);

        creditos = new Image(Assets.CREDITOS_TEXTURE);
        creditos.setScale(0.65f);
        creditos.setPosition(75, -14);
        stage.addActor(creditos);

        stage.addActor(volver);
    }

    @Override
    public void show(){
        Assets.MUSIC_EDITAR.setLooping(true);
        Assets.MUSIC_EDITAR.play();

        super.show();
    }


}
