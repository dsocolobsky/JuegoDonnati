package com.dysoco.donnati.screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Timer;
import com.dysoco.donnati.*;

import java.util.ArrayList;
import java.util.Collections;

import static com.badlogic.gdx.utils.Timer.schedule;

public class MemoScreen extends Screen {

    Image fondo;

    ArrayList<MemoCard> cards;
    MemoCard previousCard;

    boolean secondFlip = false;

    VolverButton volver;

    int pares = 0;

    boolean canTouch = true;

    public MemoScreen(final Juego juego) {
        super(juego);

        fondo = new Image(Assets.FONDO_MEMO);
        stage.addActor(fondo);

        volver = new VolverButton(juego, 10, 420);
        stage.addActor(volver);

        previousCard = null;
        pares = 0;

        cards = new ArrayList<MemoCard>();
        cards.add(new MemoCard(0));
        cards.add(new MemoCard(0));
        cards.add(new MemoCard(1));
        cards.add(new MemoCard(1));
        cards.add(new MemoCard(2));
        cards.add(new MemoCard(2));
        cards.add(new MemoCard(3));
        cards.add(new MemoCard(3));

        Collections.shuffle(cards);

        for(int i = 0; i < 8; i++) {
            MemoCard c = cards.get(i);

            if(c != null) {
                c.setOrder(i);

                final MemoCard card = (MemoCard)c;
                c.addListener(new DragListener() {
                    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                        if(!secondFlip && previousCard == null && canTouch) {
                            card.flip();
                            Assets.SOUND_CARD.play();
                            previousCard = card;
                        } else if(previousCard != null && !(previousCard.getBounds().overlaps(card.getBounds())) && canTouch) {
                            canTouch = false;
                            card.flip();
                            Assets.SOUND_CARD.play();
                            if(card.getIndex() == previousCard.getIndex()) {
                                Assets.SOUND_CORRECT.play();
                                previousCard = null;
                                secondFlip = false;
                                canTouch = true;
                                pares++;
                                if(pares == 4) {
                                    ganar();
                                    canTouch = false;
                                }
                            } else {
                                schedule(new Timer.Task() {
                                    @Override
                                    public void run() {
                                        card.flip();
                                        Assets.SOUND_CARD.play();
                                        Assets.SOUND_WRONG.play(1.5f);
                                        previousCard.flip();
                                        Assets.SOUND_CARD.play();
                                        previousCard = null;
                                        secondFlip = false;
                                        canTouch = true;
                                    }
                                }, 1.50f);
                            }
                        }

                        return false;
                    }
                    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {}
                });

                stage.addActor(c);
            }
        }

    }

}
