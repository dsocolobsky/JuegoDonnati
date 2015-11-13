package com.dysoco.donnati.screens;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.*;

public class EditScreen extends Screen {

    Player player;
    Image fondo;

    Button editButton;

    Button[] leftButton;
    Button[] rightButton;

    public EditScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.FONDO_TEXTURE);
        stage.addActor(fondo);

        player = new Player(new TextureRegion(Assets.PLAYER_TEXTURE), 328, 5);
        stage.addActor(player);

        // BOTONES
        TextureRegion leftRegion = new TextureRegion(Assets.LEFT_BUTTON);
        TextureRegion rightRegion = new TextureRegion(Assets.RIGHT_BUTTON);

        leftButton = new Button[5];
        rightButton = new Button[5];

        leftButton[0] = new Button(leftRegion, 500, 20, 35, 64); // Pies
        leftButton[1] = new Button(leftRegion, 500, 100, 35, 64); // Pantalon
        leftButton[2] = new Button(leftRegion, 500, 196, 35, 64); // Torso
        leftButton[3] = new Button(leftRegion, 500, 296, 35, 64); // Cara
        leftButton[4] = new Button(leftRegion, 500, 372, 35, 64); // Pelo

        rightButton[0] = new Button(rightRegion, 236, 20, 35, 64);
        rightButton[1] = new Button(rightRegion, 236, 100, 35, 64);
        rightButton[2] = new Button(rightRegion, 236, 196, 35, 64);
        rightButton[3] = new Button(rightRegion, 236, 296, 35, 64);
        rightButton[4] = new Button(rightRegion, 236, 372, 35, 64);

        for(Button b : leftButton) {
            stage.addActor(b);
        }

        for(Button b : rightButton) {
            stage.addActor(b);
        }
    }

}
