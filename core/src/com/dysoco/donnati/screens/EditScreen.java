package com.dysoco.donnati.screens;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.*;

public class EditScreen extends Screen {
    Image fondo;

    Button volver;

    Button[] leftButton;
    Button[] rightButton;

    public EditScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.FONDO_TEXTURE);
        stage.addActor(fondo);

        player.setPosition(328, 5);
        stage.addActor(player);

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

        // BOTONES
        TextureRegion leftRegion = new TextureRegion(Assets.LEFT_BUTTON);
        TextureRegion rightRegion = new TextureRegion(Assets.RIGHT_BUTTON);

        leftButton = new Button[4];
        rightButton = new Button[4];

        leftButton[0] = new Button(leftRegion, 500, 20, 35, 64);
        leftButton[0].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverZapatos(-1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        leftButton[1] = new Button(leftRegion, 500, 130, 35, 64);
        leftButton[1].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverPiernas(-1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        leftButton[2] = new Button(leftRegion, 500, 256, 35, 64);
        leftButton[2].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverTorso(-1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        leftButton[3] = new Button(leftRegion, 500, 372, 35, 64); // Pelo
        leftButton[3].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverPelos(-1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        rightButton[0] = new Button(rightRegion, 236, 20, 35, 64);
        rightButton[0].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverZapatos(1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        rightButton[1] = new Button(rightRegion, 236, 130, 35, 64);
        rightButton[1].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverPiernas(1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        rightButton[2] = new Button(rightRegion, 236, 256, 35, 64);
        rightButton[2].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverTorso(1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        rightButton[3] = new Button(rightRegion, 236, 372, 35, 64);
        rightButton[3].addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                player.moverPelos(1);
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });

        for(Button b : leftButton) {
            stage.addActor(b);
        }

        for(Button b : rightButton) {
            stage.addActor(b);
        }
    }

}
