package com.dysoco.donnati.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.*;

public class EditScreen extends Screen {
    Image fondo;

    RopaButton[] leftButton;
    Button[] rightButton;

    public EditScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.FONDO_TEXTURE);
        stage.addActor(fondo);

        player.setPosition(328, 5);
        stage.addActor(player);

        leftButton = new RopaButton[4];
        rightButton = new Button[4];

        leftButton[0] = new RopaButton(false, player.zapatos, 20);
        leftButton[1] = new RopaButton(false, player.piernas, 130);
        leftButton[2] = new RopaButton(false, player.torso, 256);
        leftButton[3] = new RopaButton(false, player.pelos, 372);

        rightButton[0] = new RopaButton(true, player.zapatos, 20);
        rightButton[1] = new RopaButton(true, player.piernas, 130);
        rightButton[2] = new RopaButton(true, player.torso, 256);
        rightButton[3] = new RopaButton(true, player.pelos, 372);

        for(Button b : leftButton) {
            stage.addActor(b);
        }

        for(Button b : rightButton) {
            stage.addActor(b);
        }

        stage.addActor(volver);
    }

    @Override
    public void show() {
        if(juego.music) {
            Assets.MUSIC_EDITAR.setLooping(true);
            Assets.MUSIC_EDITAR.play();
        }

        super.show();
    }

}
