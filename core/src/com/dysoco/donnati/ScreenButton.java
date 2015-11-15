package com.dysoco.donnati;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class ScreenButton extends Button {

    public ScreenButton(final Juego juego, final Screen screen, TextureRegion texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                juego.setScreen(screen);
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }

}
