package com.dysoco.donnati;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.dysoco.donnati.screens.MenuScreen;

public class VolverButton extends Button {

    private Color color = Color.WHITE;
    public boolean grande = false;

    public VolverButton(final Juego juego, float x, float y) {
        super(Assets.BACK_BUTTON, x, y, 56, 56);

        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Assets.SOUND_WRONG.stop();
                Assets.SOUND_CORRECT.stop();
                Assets.SOUND_APPLAUSE.stop();

                Assets.MUSIC_MENU.stop();
                Assets.MUSIC_MENU.setLooping(false);

                Assets.MUSIC_EDITAR.stop();
                Assets.MUSIC_EDITAR.setLooping(false);

                Assets.MUSIC_JUGUETES.stop();
                Assets.MUSIC_JUGUETES.setLooping(false);

                Assets.MUSIC_MEMOTEST.stop();
                Assets.MUSIC_MEMOTEST.setLooping(false);

                Assets.MUSIC_COCINA.stop();
                Assets.MUSIC_COCINA.setLooping(false);

                Assets.MUSIC_TRAJES.stop();
                Assets.MUSIC_TRAJES.setLooping(false);

                juego.setScreen(new MenuScreen(juego));
                return false;
            }
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            }
        });
    }

    public void grande() {
        this.grande = true;
        setSize(this.getWidth()*1.65f, this.getHeight()*1.65f);
    }

    @Override
    public void draw(final Batch batch, float parentAlpha) {
        if(!grande) {
            batch.draw(texture, this.getX(), this.getY());
        } else {
            batch.draw(texture, this.getX(), this.getY()-35, this.texture.getRegionWidth()*1.65f, this.texture.getRegionHeight()*1.65f);
        }
    }
}
