package com.ciel.deviltheyarent.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ciel.deviltheyarent.DevilTheyArent;
import com.ciel.deviltheyarent.entities.Player;

public class GameScreen implements Screen {

    private final DevilTheyArent game;
    private ShapeRenderer sr;
    private Player player;

    public GameScreen(DevilTheyArent game) {
        this.game = game;
        sr = new ShapeRenderer();
        player = new Player(100, 50);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.DARK_GRAY);

        sr.begin(ShapeRenderer.ShapeType.Filled);
        player.render(sr);
        sr.end();

        player.update(delta);
    }

    @Override
    public void resize(int w, int h) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        sr.dispose();
    }
}
