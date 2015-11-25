package com.dysoco.donnati;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.dysoco.donnati.screens.EditScreen;

public class Juego extends Game {
	public final int WINDOW_WIDTH = 800;
    public final int WINDOW_HEIGHT = 480;

	public AssetManager assetManager;
	public SpriteBatch batch;
	public Player player;

	public boolean music = true;

	@Override
	public void create () {
		assetManager = new AssetManager();
		batch = new SpriteBatch();

        Assets.load();

        player = new Player(true, 1);

        setScreen(new EditScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
