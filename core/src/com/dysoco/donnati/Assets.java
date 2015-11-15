package com.dysoco.donnati;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets {

    public static Texture FONDO_TEXTURE;
    public static Texture CHESTS_BACKGROUND;

    public static Texture FONDO_COCINA;
    public static Texture FONDO_POLICIA;
    public static Texture FONDO_BOMBERO;
    public static Texture FONDO_AGUA;
    public static Texture FONDO_FRIO;

    private static TextureAtlas atlas;

    public static AtlasRegion VACIO;

    public static AtlasRegion PLAYER_TEXTURE;
    public static AtlasRegion EDIT_BUTTON;
    public static AtlasRegion LEFT_BUTTON;
    public static AtlasRegion RIGHT_BUTTON;

    public static AtlasRegion BACK_BUTTON;

    public static AtlasRegion GAME_ONE;
    public static AtlasRegion GAME_TWO;
    public static AtlasRegion GAME_THREE;
    public static AtlasRegion GAME_FOUR;

    public static AtlasRegion CHEST_RED_CLOSED;
    public static AtlasRegion CHEST_RED_OPEN;
    public static AtlasRegion SHADOW_LEFT_CLOSED;
    public static AtlasRegion SHADOW_LEFT_OPEN;

    public static AtlasRegion CHEST_GREEN_CLOSED;
    public static AtlasRegion CHEST_GREEN_OPEN;
    public static AtlasRegion SHADOW_MIDDLE_CLOSED;
    public static AtlasRegion SHADOW_MIDDLE_OPEN;

    public static AtlasRegion CHEST_BLUE_CLOSED;
    public static AtlasRegion CHEST_BLUE_OPEN;
    public static AtlasRegion SHADOW_RIGHT_CLOSED;
    public static AtlasRegion SHADOW_RIGHT_OPEN;

    public static AtlasRegion OSO;
    public static AtlasRegion AUTO;
    public static AtlasRegion DOLL;
    public static AtlasRegion PELOTA;
    public static AtlasRegion AVION;
    public static AtlasRegion BARCO;

    public static AtlasRegion MEMOCARD_BACK;

    public static AtlasRegion PELO;
    public static AtlasRegion BUZO;
    public static AtlasRegion PANTALONES;
    public static AtlasRegion ZAPATOS;

    public static AtlasRegion COCINERO_GORRO;
    public static AtlasRegion COCINERO_TRAJE;
    public static AtlasRegion COCINERO_PANTALONES;
    public static AtlasRegion COCINERO_ZAPATOS;

    public static Sound SOUND_CORRECT;
    public static Sound SOUND_WRONG;
    public static Sound SOUND_APPLAUSE;

    public static Sound SOUND_CHEST_OPEN;
    public static Sound SOUND_CHEST_CLOSE;

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("textures/atlas.atlas"));

        VACIO = new AtlasRegion(atlas.findRegion("vacio"));

        FONDO_TEXTURE = new Texture(Gdx.files.internal("textures/background.png"));
        CHESTS_BACKGROUND = new Texture(Gdx.files.internal("textures/chests_background.png"));

        FONDO_COCINA = new Texture(Gdx.files.internal("textures/fondo_cocina.jpg"));
        FONDO_POLICIA = new Texture(Gdx.files.internal("textures/fondo_policia.jpg"));
        FONDO_BOMBERO = new Texture(Gdx.files.internal("textures/fondo_bombero.jpg"));
        FONDO_AGUA = new Texture(Gdx.files.internal("textures/fondo_agua.jpg"));
        FONDO_FRIO = new Texture(Gdx.files.internal("textures/fondo_frio.jpg"));

        PLAYER_TEXTURE = new AtlasRegion(atlas.findRegion("hombre"));
        EDIT_BUTTON = new AtlasRegion(atlas.findRegion("button_config"));
        LEFT_BUTTON = new AtlasRegion(atlas.findRegion("button_right"));
        RIGHT_BUTTON = new AtlasRegion(atlas.findRegion("button_left"));

        BACK_BUTTON = new AtlasRegion(atlas.findRegion("button_back"));

        GAME_ONE = new AtlasRegion(atlas.findRegion("game_one"));
        GAME_TWO = new AtlasRegion(atlas.findRegion("game_two"));
        GAME_THREE = new AtlasRegion(atlas.findRegion("game_three"));
        GAME_FOUR = new AtlasRegion(atlas.findRegion("game_four"));

        CHEST_RED_CLOSED = new AtlasRegion(atlas.findRegion("chest_red_closed"));
        CHEST_RED_OPEN = new AtlasRegion(atlas.findRegion("chest_red_open"));
        SHADOW_LEFT_CLOSED = new AtlasRegion(atlas.findRegion("shadow_left_closed"));
        SHADOW_LEFT_OPEN = new AtlasRegion(atlas.findRegion("shadow_left_open"));

        CHEST_GREEN_CLOSED = new AtlasRegion(atlas.findRegion("chest_green_closed"));
        CHEST_GREEN_OPEN = new AtlasRegion(atlas.findRegion("chest_green_open"));
        SHADOW_MIDDLE_CLOSED = new AtlasRegion(atlas.findRegion("shadow_middle_closed"));
        SHADOW_MIDDLE_OPEN = new AtlasRegion(atlas.findRegion("shadow_middle_open"));

        CHEST_BLUE_CLOSED = new AtlasRegion(atlas.findRegion("chest_blue_closed"));
        CHEST_BLUE_OPEN = new AtlasRegion(atlas.findRegion("chest_blue_open"));
        SHADOW_RIGHT_CLOSED = new AtlasRegion(atlas.findRegion("shadow_right_closed"));
        SHADOW_RIGHT_OPEN = new AtlasRegion(atlas.findRegion("shadow_right_open"));

        OSO = new AtlasRegion(atlas.findRegion("oso"));
        AUTO = new AtlasRegion(atlas.findRegion("auto"));
        DOLL = new AtlasRegion(atlas.findRegion("doll"));
        PELOTA = new AtlasRegion(atlas.findRegion("pelota"));
        AVION = new AtlasRegion(atlas.findRegion("avion"));
        BARCO = new AtlasRegion(atlas.findRegion("barco"));

        MEMOCARD_BACK = new AtlasRegion(atlas.findRegion("memocard_back"));

        PELO = new AtlasRegion(atlas.findRegion("pelo"));
        BUZO = new AtlasRegion(atlas.findRegion("buzo"));
        PANTALONES = new AtlasRegion(atlas.findRegion("pantalones"));
        ZAPATOS = new AtlasRegion(atlas.findRegion("zapatos"));

        COCINERO_GORRO = new AtlasRegion(atlas.findRegion("cocinero_gorro"));
        COCINERO_TRAJE = new AtlasRegion(atlas.findRegion("cocinero_traje"));
        COCINERO_PANTALONES = new AtlasRegion(atlas.findRegion("cocinero_pantalones"));
        COCINERO_ZAPATOS = new AtlasRegion(atlas.findRegion("cocinero_zapatos"));

        SOUND_CORRECT = Gdx.audio.newSound(Gdx.files.internal("sounds/correct.ogg"));
        SOUND_WRONG = Gdx.audio.newSound(Gdx.files.internal("sounds/wrong.ogg"));
        SOUND_APPLAUSE = Gdx.audio.newSound(Gdx.files.internal("sounds/applause.ogg"));

        SOUND_CHEST_OPEN = Gdx.audio.newSound(Gdx.files.internal("sounds/chest_open.ogg"));
        SOUND_CHEST_CLOSE = Gdx.audio.newSound(Gdx.files.internal("sounds/chest_close.ogg"));
    }

}
