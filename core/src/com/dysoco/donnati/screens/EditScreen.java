package com.dysoco.donnati.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.dysoco.donnati.*;

public class EditScreen extends Screen {
    Image fondo;

    RopaButton[] leftButton;
    Button[] rightButton;

    Button colorBlanco;
    Button colorCanela;
    Button colorYoel;

    Button masculino;
    Button femenino;

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

        colorBlanco = new Button(Assets.BLANCO_BUTTON, 105, 330, 50, 50);
        colorBlanco.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                player.change(player.hombre, 1);
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        stage.addActor(colorBlanco);

        colorCanela = new Button(Assets.CANELA_BUTTON, 105, 250, 50, 50);
        colorCanela.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                player.change(player.hombre, 2);
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        stage.addActor(colorCanela);

        colorYoel = new Button(Assets.YOEL_BUTTON, 105, 170, 50, 50);
        colorYoel.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                player.change(player.hombre, 3);
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        stage.addActor(colorYoel);

        masculino = new Button(Assets.MASCULINO_BUTTON, 630, 290, 50, 50);
        masculino.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                player.change(true, player.color);
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        stage.addActor(masculino);

        femenino = new Button(Assets.FEMENINO_BUTTON, 630, 210, 50, 50);
        femenino.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                player.change(false, player.color);
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
        stage.addActor(femenino);

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
