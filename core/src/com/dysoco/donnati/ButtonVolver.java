package com.dysoco.donnati;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.dysoco.donnati.screens.MenuScreen;

public class ButtonVolver extends Button {

    public ButtonVolver(final Juego juego, float x, float y, float width, float height) {
        super(Assets.BACK_BUTTON, x, y, 56, 56);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(new MenuScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }

}
