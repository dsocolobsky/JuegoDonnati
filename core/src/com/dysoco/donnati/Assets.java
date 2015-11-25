package com.dysoco.donnati;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets {

    public static Texture FELICITACIONES;

    public static Texture CREDITOS_TEXTURE;
    public static Texture FONDO_TEXTURE;
    public static Texture CHESTS_BACKGROUND;

    public static Texture BACKGROUND_COCINA;

    public static Texture FONDO_MEMO;

    public static Texture FONDO_COCINA;
    public static Texture FONDO_POLICIA;
    public static Texture FONDO_BOMBERO;
    public static Texture FONDO_AGUA;
    public static Texture FONDO_FRIO;

    private static TextureAtlas atlas;

    public static AtlasRegion VACIO;

    public static AtlasRegion HOMBRE_BLANCO;
    public static AtlasRegion HOMBRE_CANELA;
    public static AtlasRegion HOMBRE_YOEL;

    public static AtlasRegion MUJER_BLANCO;
    public static AtlasRegion MUJER_CANELA;
    public static AtlasRegion MUJER_YOEL;

    public static AtlasRegion EDIT_BUTTON;
    public static AtlasRegion LEFT_BUTTON;
    public static AtlasRegion RIGHT_BUTTON;

    public static AtlasRegion INFO_BUTTON;
    public static AtlasRegion VOLOFF_BUTTON;
    public static AtlasRegion VOLON_BUTTON;
    public static AtlasRegion BACK_BUTTON;

    public static AtlasRegion MASCULINO_BUTTON;
    public static AtlasRegion FEMENINO_BUTTON;

    public static AtlasRegion BLANCO_BUTTON;
    public static AtlasRegion CANELA_BUTTON;
    public static AtlasRegion YOEL_BUTTON;

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

    public static AtlasRegion MEMOCARD_ONE;
    public static AtlasRegion MEMOCARD_TWO;
    public static AtlasRegion MEMOCARD_THREE;
    public static AtlasRegion MEMOCARD_FOUR;
    public static AtlasRegion MEMOCARD_FIVE;
    public static AtlasRegion MEMOCARD_SIX;

    public static AtlasRegion MEMOCARD_FRONT;

    public static AtlasRegion HAMB_PANABAJO;
    public static AtlasRegion HAMB_CARNE;
    public static AtlasRegion HAMB_LECHUGA;
    public static AtlasRegion HAMB_QUESO;
    public static AtlasRegion HAMB_TOMATES;
    public static AtlasRegion HAMB_PANARRIBA;

    public static AtlasRegion COC_PLATO;
    public static AtlasRegion COC_CARNE;
    public static AtlasRegion COC_LECHUGA;
    public static AtlasRegion COC_PAN;
    public static AtlasRegion COC_QUESO;
    public static AtlasRegion COC_TOMATES;

    public static AtlasRegion TACO_1;
    public static AtlasRegion TACO_2;
    public static AtlasRegion TACO_3;
    public static AtlasRegion TACO_4;
    public static AtlasRegion TACO_5;

    public static AtlasRegion TACO_BOWL;
    public static AtlasRegion TACO_PAPAS;
    public static AtlasRegion TACO_GUACAMOLE;
    public static AtlasRegion TACO_PICADA;
    public static AtlasRegion TACO_DADITOS;

    public static AtlasRegion PELO;
    public static AtlasRegion BUZO;
    public static AtlasRegion PANTALONES;
    public static AtlasRegion ZAPATOS;

    public static AtlasRegion PELO1;
    public static AtlasRegion PELO2;
    public static AtlasRegion PELO3;
    public static AtlasRegion PELO4;
    public static AtlasRegion PELO5;
    public static AtlasRegion PELO6;
    public static AtlasRegion PELO7;
    public static AtlasRegion PELO8;
    public static AtlasRegion PELO9;
    public static AtlasRegion PELO10;
    public static AtlasRegion PELO11;
    public static AtlasRegion PELO12;
    public static AtlasRegion PELO13;

    public static AtlasRegion COCINERO_GORRO;
    public static AtlasRegion COCINERO_TRAJE;
    public static AtlasRegion COCINERO_PANTALONES;
    public static AtlasRegion COCINERO_ZAPATOS;

    public static AtlasRegion TRAJE_BOMBERO;
    public static AtlasRegion TRAJE_POLICIA;
    public static AtlasRegion TRAJE_COCINERO;
    public static AtlasRegion TRAJE_FRIO;
    public static AtlasRegion TRAJE_BUZO;

    public static Sound SOUND_CORRECT;
    public static Sound SOUND_WRONG;
    public static Sound SOUND_APPLAUSE;

    public static Sound SOUND_CHEST_OPEN;
    public static Sound SOUND_CHEST_CLOSE;
    public static Sound SOUND_CARD;

    public static Music MUSIC_MENU;
    public static Music MUSIC_EDITAR;
    public static Music MUSIC_JUGUETES;
    public static Music MUSIC_MEMOTEST;
    public static Music MUSIC_COCINA;
    public static Music MUSIC_TRAJES;

    public static void load() {
        atlas = new TextureAtlas(Gdx.files.internal("textures/atlas.atlas"));

        VACIO = new AtlasRegion(atlas.findRegion("vacio"));

        FELICITACIONES = new Texture(Gdx.files.internal("textures/felicitaciones.png"));

        FONDO_TEXTURE = new Texture(Gdx.files.internal("textures/background.png"));
        CHESTS_BACKGROUND = new Texture(Gdx.files.internal("textures/chests_background.png"));

        CREDITOS_TEXTURE = new Texture(Gdx.files.internal("textures/creditos.png"));

        BACKGROUND_COCINA = new Texture(Gdx.files.internal("textures/cocina.jpg"));

        FONDO_MEMO = new Texture(Gdx.files.internal("textures/fondo_memo.jpg"));

        FONDO_COCINA = new Texture(Gdx.files.internal("textures/fondo_cocina.jpg"));
        FONDO_POLICIA = new Texture(Gdx.files.internal("textures/fondo_policia.jpg"));
        FONDO_BOMBERO = new Texture(Gdx.files.internal("textures/fondo_bombero.jpg"));
        FONDO_AGUA = new Texture(Gdx.files.internal("textures/fondo_agua.jpg"));
        FONDO_FRIO = new Texture(Gdx.files.internal("textures/fondo_frio.jpg"));

        HOMBRE_BLANCO = new AtlasRegion(atlas.findRegion("hombre_blanco"));
        HOMBRE_CANELA = new AtlasRegion(atlas.findRegion("hombre_canela"));
        HOMBRE_YOEL = new AtlasRegion(atlas.findRegion("hombre_yoel"));

        MUJER_BLANCO = new AtlasRegion(atlas.findRegion("mujer_blanco"));
        MUJER_CANELA = new AtlasRegion(atlas.findRegion("mujer_canela"));
        MUJER_YOEL = new AtlasRegion(atlas.findRegion("mujer_yoel"));

        EDIT_BUTTON = new AtlasRegion(atlas.findRegion("button_config"));
        LEFT_BUTTON = new AtlasRegion(atlas.findRegion("button_right"));
        RIGHT_BUTTON = new AtlasRegion(atlas.findRegion("button_left"));

        MASCULINO_BUTTON = new AtlasRegion(atlas.findRegion("masculino"));
        FEMENINO_BUTTON = new AtlasRegion(atlas.findRegion("femenino"));

        BLANCO_BUTTON = new AtlasRegion(atlas.findRegion("color_blanco"));
        CANELA_BUTTON = new AtlasRegion(atlas.findRegion("color_canela"));
        YOEL_BUTTON = new AtlasRegion(atlas.findRegion("color_yoel"));

        INFO_BUTTON = new AtlasRegion(atlas.findRegion("informacion"));
        VOLOFF_BUTTON = new AtlasRegion(atlas.findRegion("voloff"));
        VOLON_BUTTON = new AtlasRegion(atlas.findRegion("volon"));

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

        MEMOCARD_ONE = new AtlasRegion(atlas.findRegion("memocard_one"));
        MEMOCARD_TWO = new AtlasRegion(atlas.findRegion("memocard_two"));
        MEMOCARD_THREE = new AtlasRegion(atlas.findRegion("memocard_three"));
        MEMOCARD_FOUR = new AtlasRegion(atlas.findRegion("memocard_four"));
        MEMOCARD_FIVE = new AtlasRegion(atlas.findRegion("memocard_five"));
        MEMOCARD_SIX = new AtlasRegion(atlas.findRegion("memocard_six"));

        MEMOCARD_FRONT = new AtlasRegion(atlas.findRegion("memocard_front"));

        HAMB_PANABAJO = new AtlasRegion(atlas.findRegion("hamb_panabajo"));
        HAMB_CARNE = new AtlasRegion(atlas.findRegion("hamb_carne"));
        HAMB_LECHUGA = new AtlasRegion(atlas.findRegion("hamb_lechuga"));
        HAMB_QUESO = new AtlasRegion(atlas.findRegion("hamb_queso"));
        HAMB_TOMATES = new AtlasRegion(atlas.findRegion("hamb_tomate"));
        HAMB_PANARRIBA = new AtlasRegion(atlas.findRegion("hamb_panarriba"));

        COC_PLATO = new AtlasRegion(atlas.findRegion("plato"));
        COC_CARNE = new AtlasRegion(atlas.findRegion("coc_carne"));
        COC_LECHUGA = new AtlasRegion(atlas.findRegion("coc_lechuga"));
        COC_PAN = new AtlasRegion(atlas.findRegion("coc_pan"));
        COC_QUESO = new AtlasRegion(atlas.findRegion("coc_queso"));
        COC_TOMATES = new AtlasRegion(atlas.findRegion("coc_tomates"));

        TACO_1 = new AtlasRegion(atlas.findRegion("taco1"));
        TACO_2 = new AtlasRegion(atlas.findRegion("taco2"));
        TACO_3 = new AtlasRegion(atlas.findRegion("taco3"));
        TACO_4 = new AtlasRegion(atlas.findRegion("taco4"));
        TACO_5 = new AtlasRegion(atlas.findRegion("taco5"));

        TACO_BOWL = new AtlasRegion(atlas.findRegion("bowl"));
        TACO_PAPAS = new AtlasRegion(atlas.findRegion("papas"));
        TACO_DADITOS = new AtlasRegion(atlas.findRegion("daditos"));
        TACO_GUACAMOLE = new AtlasRegion(atlas.findRegion("guacamole"));
        TACO_PICADA = new AtlasRegion(atlas.findRegion("picada"));

        BUZO = new AtlasRegion(atlas.findRegion("buzo"));
        PANTALONES = new AtlasRegion(atlas.findRegion("pantalones"));
        ZAPATOS = new AtlasRegion(atlas.findRegion("zapatos"));

        PELO1 = new AtlasRegion(atlas.findRegion("pelo1"));
        PELO2 = new AtlasRegion(atlas.findRegion("pelo2"));
        PELO3 = new AtlasRegion(atlas.findRegion("pelo3"));
        PELO4 = new AtlasRegion(atlas.findRegion("pelo4"));
        PELO5 = new AtlasRegion(atlas.findRegion("pelo5"));
        PELO6 = new AtlasRegion(atlas.findRegion("pelo6"));
        PELO7 = new AtlasRegion(atlas.findRegion("pelo7"));
        PELO8 = new AtlasRegion(atlas.findRegion("pelo8"));
        PELO9 = new AtlasRegion(atlas.findRegion("pelo9"));
        PELO10 = new AtlasRegion(atlas.findRegion("pelo10"));
        PELO11 = new AtlasRegion(atlas.findRegion("pelo11"));
        PELO12 = new AtlasRegion(atlas.findRegion("pelo12"));
        PELO13 = new AtlasRegion(atlas.findRegion("pelo13"));

        COCINERO_GORRO = new AtlasRegion(atlas.findRegion("cocinero_gorro"));
        COCINERO_TRAJE = new AtlasRegion(atlas.findRegion("cocinero_traje"));
        COCINERO_PANTALONES = new AtlasRegion(atlas.findRegion("cocinero_pantalones"));
        COCINERO_ZAPATOS = new AtlasRegion(atlas.findRegion("cocinero_zapatos"));

        TRAJE_BOMBERO = new AtlasRegion(atlas.findRegion("traje_bombero"));
        TRAJE_POLICIA = new AtlasRegion(atlas.findRegion("traje_policia"));
        TRAJE_COCINERO = new AtlasRegion(atlas.findRegion("traje_cocinero"));
        TRAJE_FRIO = new AtlasRegion(atlas.findRegion("traje_frio"));
        TRAJE_BUZO = new AtlasRegion(atlas.findRegion("traje_buzo"));

        SOUND_CORRECT = Gdx.audio.newSound(Gdx.files.internal("sounds/correct.ogg"));
        SOUND_WRONG = Gdx.audio.newSound(Gdx.files.internal("sounds/wrong.ogg"));
        SOUND_APPLAUSE = Gdx.audio.newSound(Gdx.files.internal("sounds/applause.ogg"));

        SOUND_CHEST_OPEN = Gdx.audio.newSound(Gdx.files.internal("sounds/chest_open.ogg"));
        SOUND_CHEST_CLOSE = Gdx.audio.newSound(Gdx.files.internal("sounds/chest_close.ogg"));

        SOUND_CARD = Gdx.audio.newSound(Gdx.files.internal("sounds/card.ogg"));

        MUSIC_MENU = Gdx.audio.newMusic(Gdx.files.internal("music/menu.mp3"));
        MUSIC_EDITAR = Gdx.audio.newMusic(Gdx.files.internal("music/editar.mp3"));
        MUSIC_JUGUETES = Gdx.audio.newMusic(Gdx.files.internal("music/juguetes.mp3"));
        MUSIC_MEMOTEST = Gdx.audio.newMusic(Gdx.files.internal("music/memotest.mp3"));
        MUSIC_COCINA = Gdx.audio.newMusic(Gdx.files.internal("music/cocina.mp3"));
        MUSIC_TRAJES = Gdx.audio.newMusic(Gdx.files.internal("music/trajes.mp3"));

        MUSIC_MENU.setVolume(0.5f);
        MUSIC_EDITAR.setVolume(0.5f);
        MUSIC_JUGUETES.setVolume(0.5f);
        MUSIC_MEMOTEST.setVolume(0.5f);
        MUSIC_COCINA.setVolume(0.5f);
        MUSIC_TRAJES.setVolume(0.5f);
    }

}
