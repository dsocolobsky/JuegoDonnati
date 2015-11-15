package com.dysoco.donnati;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class RopaButton extends Button {

    public RopaButton(final boolean rightSide, final ChangableCollection collection, float y) {
        super(Assets.LEFT_BUTTON, 500, y, 35, 64);

        if (rightSide) {
            setX(236);
            texture = Assets.RIGHT_BUTTON;
        }

        addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (rightSide) {
                    collection.forward();
                } else {
                    collection.backwards();
                }
                return false;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }
}
