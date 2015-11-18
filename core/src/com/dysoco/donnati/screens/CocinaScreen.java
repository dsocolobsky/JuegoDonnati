package com.dysoco.donnati.screens;

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

    Image plato;
    Image platos[];

    Ingrediente ingredientes[];

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

        ingredientes = new Ingrediente[5];
        ingredientes[0] = new Ingrediente(4, Assets.COC_LECHUGA);
        ingredientes[1] = new Ingrediente(5, Assets.COC_PAN);
        ingredientes[2] = new Ingrediente(3, Assets.COC_TOMATES);
        ingredientes[3] = new Ingrediente(2, Assets.COC_QUESO);
        ingredientes[4] = new Ingrediente(1, Assets.COC_CARNE);

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
        currentComida = comidas.get(0);
        currentComida.setPosition(370+28, 75+20);
        stage.addActor(currentComida);

        ingredientes[0].setPosition(630, 220); // LECHUGA
        ingredientes[1].setPosition(255, 230); // PAN
        ingredientes[2].setPosition(210, 130); // TOMATE
        ingredientes[3].setPosition(656, 120); // QUESO
        ingredientes[4].setPosition(435, 250); // CARNE

        for(final Ingrediente ingrediente : ingredientes) {
            ingrediente.addListener(new DragListener() {
                public void drag(InputEvent event, float x, float y, int pointer) {
                    event.getTarget().moveBy(x - event.getTarget().getWidth() / 2, y - event.getTarget().getHeight() / 2);
                }

                public void dragStop(InputEvent event, float x, float y, int pointer) {
                    if(ingrediente.getBounds().overlaps(new Rectangle((int)platos[0].getX(), (int)platos[0].getY(), (int)platos[0].getWidth(), (int)platos[0].getHeight()))) {
                        if(ingrediente.key == currentComida.currentSprite+1) {
                            currentComida.currentSprite++;
                            ingrediente.remove();
                        } else {
                            ingrediente.goBack();
                        }
                    }
                }

            });


            stage.addActor(ingrediente);
        }

        instruccion = new Image(Assets.HAMB_PANARRIBA);
        instruccion.setScale(0.65f);
        instruccion.setPosition(20, 200);
        stage.addActor(instruccion);
    }
}
