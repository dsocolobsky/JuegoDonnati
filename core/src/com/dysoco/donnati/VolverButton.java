package com.dysoco.donnati;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.dysoco.donnati.screens.MenuScreen;

public class VolverButton extends Button {

    public VolverButton(final Juego juego, float x, float y) {
        super(Assets.BACK_BUTTON, x, y, 56, 56);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Assets.SOUND_APPLAUSE.stop();
                juego.setScreen(new MenuScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }

}
