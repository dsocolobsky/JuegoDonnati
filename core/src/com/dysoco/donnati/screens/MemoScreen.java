package com.dysoco.donnati.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.dysoco.donnati.Juego;
import com.dysoco.donnati.MemoCard;
import com.dysoco.donnati.Screen;

import java.util.ArrayList;
import java.util.Collections;

public class MemoScreen extends Screen {

    ArrayList<MemoCard> cards;
    boolean secondFlip;
    MemoCard previousCard;

    public MemoScreen(final Juego juego) {
        super(juego);

        secondFlip = false;
        previousCard = null;

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
                        if(!card.isFlipped()) {

                            if (previousCard == null) {
                                card.flip();
                                previousCard = card;
                            } else {
                                card.flip();

                                if(card.getIndex() != previousCard.getIndex()) {
                                    card.flip();
                                    previousCard.flip();
                                }

                                previousCard = null;
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
