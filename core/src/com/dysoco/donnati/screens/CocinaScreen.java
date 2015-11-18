package com.dysoco.donnati.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Timer;
import com.dysoco.donnati.*;

import java.util.ArrayList;
import java.util.Collections;

import static com.badlogic.gdx.utils.Timer.schedule;

public class CocinaScreen extends Screen {

    VolverButton volver;
    Image fondo;

    ArrayList<Comida> comidas;
    Comida currentComida;
    int currentIndex = 0;

    Image plato;
    Image platos[];

    Image instruccion;

    public CocinaScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.BACKGROUND_COCINA);
        fondo.setScale(0.45f);
        stage.addActor(fondo);

        volver = new VolverButton(juego, 10, 420);
        stage.addActor(volver);

        platos = new Image[6];
        for(int i = 0; i < 6; i++) {
            platos[i] = new Image(Assets.COC_PLATO);
            if(i != 0) {
                platos[i].setScale(0.50f);
            }
        }

        platos[0].setPosition(370, 75);
        platos[1].setPosition(610, 220);
        platos[2].setPosition(240, 220);
        platos[3].setPosition(200, 120);
        platos[4].setPosition(650, 120);
        platos[5].setPosition(420, 240);

        for(Image plato : platos) {
            stage.addActor(plato);
        }

        comidas = new ArrayList<Comida>();

        comidas.add(new Comida("hamburguesa"));
        currentComida = comidas.get(currentIndex);
        currentComida.setPosition(370+28, 75+20);
        stage.addActor(currentComida);

        for(final Ingrediente ingrediente : currentComida.ingredientes) {
            ingrediente.addListener(new DragListener() {
                public void drag(InputEvent event, float x, float y, int pointer) {
                    event.getTarget().moveBy(x - event.getTarget().getWidth() / 2, y - event.getTarget().getHeight() / 2);
                }

                public void dragStop(InputEvent event, float x, float y, int pointer) {
                    if (ingrediente.getBounds().overlaps(new Rectangle((int) platos[0].getX(), (int) platos[0].getY(), (int) platos[0].getWidth(), (int) platos[0].getHeight()))) {
                        if (ingrediente.key == currentComida.currentSprite + 1) {
                            currentComida.currentSprite++;
                            ingrediente.remove();

                            if (ingrediente.key == 4) {
                                currentIndex++;
                            }
                        } else {
                            ingrediente.goBack();
                        }
                    }
                }

            });


            stage.addActor(ingrediente);
        }

        instruccion = new Image(currentComida.sprites.get(currentComida.sprites.size()-1));
        instruccion.setScale(0.65f);
        instruccion.setPosition(20, 200);
        stage.addActor(instruccion);
    }
}
