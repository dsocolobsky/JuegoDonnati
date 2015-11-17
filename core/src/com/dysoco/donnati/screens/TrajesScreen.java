package com.dysoco.donnati.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.dysoco.donnati.*;

import java.util.ArrayList;
import java.util.Collections;

public class TrajesScreen extends Screen {

    VolverButton volver;
    int currentFondo;
    ArrayList<Texture> fondos;
    Image fondo;
    Image player;

    ArrayList<Traje> trajes;

    public TrajesScreen(final Juego juego) {
        super(juego);

        currentFondo = 0;
        fondos = new ArrayList<Texture>();
        fondos.add(Assets.FONDO_AGUA);
        fondos.add(Assets.FONDO_BOMBERO);
        fondos.add(Assets.FONDO_COCINA);
        fondos.add(Assets.FONDO_FRIO);
        fondos.add(Assets.FONDO_POLICIA);
        Collections.shuffle(fondos);

        fondo = new Image(fondos.get(currentFondo));
        fondo.setScale(0.5f);
        stage.addActor(fondo);

        player = new Image(Assets.PLAYER_TEXTURE);
        player.setPosition(60, 5);
        stage.addActor(player);

        volver = new VolverButton(juego, 10, 420);
        stage.addActor(volver);

        trajes = new ArrayList<Traje>();
        trajes.add(new Traje("bombero", Assets.TRAJE_BOMBERO));
        trajes.add(new Traje("policia", Assets.TRAJE_POLICIA));
        trajes.add(new Traje("cocinero", Assets.TRAJE_COCINERO));
        trajes.add(new Traje("frio", Assets.TRAJE_FRIO));

        Collections.shuffle(trajes);
        for(int i = 0; i <= 3; i++) {
            trajes.get(i).setOrder(i);
        }

        for(final Traje t : trajes) {

            t.addListener(new DragListener() {
                final Traje traje = (Traje)t;
                public void drag(InputEvent event, float x, float y, int pointer) {
                    event.getTarget().moveBy(x - event.getTarget().getWidth() / 2, y - event.getTarget().getHeight() / 2);
                }

                public void dragStop(InputEvent event, float x, float y, int pointer) {
                    if(traje.getBounds().overlaps( new Rectangle((int)player.getX(), (int)player.getY(), (int)player.getWidth(), (int)player.getHeight()))) {
                        traje.finish(player.getX(), player.getY()-7);
                    }
                }
            });

            stage.addActor(t);
        }
    }

}
