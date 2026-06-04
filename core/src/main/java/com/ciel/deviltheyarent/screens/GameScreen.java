package com.ciel.deviltheyarent.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ciel.deviltheyarent.DevilTheyArent;
import com.ciel.deviltheyarent.entities.Guard;
import com.ciel.deviltheyarent.entities.Player;
import com.ciel.deviltheyarent.world.DayNightCycle;
import com.ciel.deviltheyarent.world.Platform;
import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {

    private final DevilTheyArent game;
    private ShapeRenderer sr;
    private Player player;
    private DayNightCycle cycle;
    private List<Platform> platforms;
    private List<Guard> guards;

    public GameScreen(DevilTheyArent game) {
        this.game = game;
        sr = new ShapeRenderer();
        player = new Player(100, 100);
        cycle = new DayNightCycle();
        platforms = new ArrayList<>();
        guards = new ArrayList<>();
        buildLevel();
    }

    private void buildLevel() {
        // Ground
        platforms.add(new Platform(0, 32, 800, 20));
        // Platforms
        platforms.add(new Platform(150, 150, 120, 16));
        platforms.add(new Platform(350, 220, 120, 16));
        platforms.add(new Platform(550, 180, 120, 16));
        platforms.add(new Platform(250, 300, 100, 16));

        // Guards startX, startY, patrolLeft, patrolRight
        guards.add(new Guard(300, 52, 200, 500));
        guards.add(new Guard(550, 52, 450, 700));
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        // Background
        if (cycle.isNight()) {
            ScreenUtils.clear(0.05f, 0.05f, 0.15f, 1f);
        } else {
            ScreenUtils.clear(0.9f, 0.7f, 0.3f, 1f);
        }

        // Day sunlight damage
        if (cycle.isDay()) {
            player.takeDamage();
        }

        // Guard flashlight damage, only at night
        if (cycle.isNight()) {
            for (Guard g : guards) {
                if (g.flashlightHits(player)) {
                    player.takeDamage();
                }
            }
        }

        cycle.update(delta);
        player.update(delta, platforms);
        for (Guard g : guards) g.update(delta);

        sr.begin(ShapeRenderer.ShapeType.Filled);
        for (Platform p : platforms) p.render(sr);
        for (Guard g : guards) g.render(sr);
        player.render(sr);
        sr.end();
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
