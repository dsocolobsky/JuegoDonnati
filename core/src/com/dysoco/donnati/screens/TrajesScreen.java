package com.dysoco.donnati.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.dysoco.donnati.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.badlogic.gdx.utils.Timer.Task;
import static com.badlogic.gdx.utils.Timer.schedule;

public class TrajesScreen extends Screen {

    VolverButton volver;
    int currentFondo;
    ArrayList<Texture> fondos;
    Image fondo;
    Image player;

    ArrayList<Traje> trajes;

    private Random random;

    public TrajesScreen(final Juego juego) {
        super(juego);

        random = new Random();

        fondos = new ArrayList<Texture>();
        fondos.add(0, Assets.FONDO_AGUA);
        fondos.add(1, Assets.FONDO_BOMBERO);
        fondos.add(2, Assets.FONDO_COCINA);
        fondos.add(3, Assets.FONDO_FRIO);
        fondos.add(4, Assets.FONDO_POLICIA);
        Collections.shuffle(fondos);

        currentFondo = 0;

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
        trajes.add(new Traje("buzo", Assets.TRAJE_BUZO));

        Collections.shuffle(trajes);
        for(int i = 0; i <= 4; i++) {
            trajes.get(i).setOrder(i);
        }

        for(final Traje t : trajes) {

            t.addListener(new DragListener() {
                final Traje traje = (Traje)t;
                public void drag(InputEvent event, float x, float y, int pointer) {
                    if(traje.movable) {
                        event.getTarget().moveBy(x - event.getTarget().getWidth() / 2, y - event.getTarget().getHeight() / 2);
                    }
                }

                public void dragStop(InputEvent event, float x, float y, int pointer) {
                    if(traje.getBounds().overlaps( new Rectangle((int)player.getX(), (int)player.getY(), (int)player.getWidth(), (int)player.getHeight()))) {
                        traje.finish(player.getX(), player.getY()-7);
                        if(traje.key.equals("bombero") && fondos.get(currentFondo) == Assets.FONDO_BOMBERO || (traje.key.equals("cocinero") && fondos.get(currentFondo) == Assets.FONDO_COCINA) ||
                                (traje.key.equals("frio") && fondos.get(currentFondo) == Assets.FONDO_FRIO) || (traje.key.equals("policia") && fondos.get(currentFondo) == Assets.FONDO_POLICIA) ||
                                (traje.key.equals("buzo") && fondos.get(currentFondo) == Assets.FONDO_AGUA)) {
                            Assets.SOUND_CORRECT.play(1.80f);

                            schedule(new Task() {
                                @Override
                                public void run() {
                                    if((currentFondo + 1) == fondos.size()) {
                                        ganar();
                                    } else {
                                        currentFondo++;
                                        reset();
                                        traje.goBack();
                                    }
                                }
                            }, 2);

                        } else {
                            Assets.SOUND_WRONG.play(1.5f);
                            traje.goBack();
                        }
                    }
                }
            });

            stage.addActor(t);
        }
    }

    private void reset() {
        fondo = new Image(fondos.get(currentFondo));
        fondo.setScale(0.5f);
        stage.addActor(fondo);

        stage.addActor(player);

        for(Traje t : trajes) {
            stage.addActor(t);
        }

        stage.addActor(volver);
    }

}
