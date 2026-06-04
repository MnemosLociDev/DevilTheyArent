package com.ciel.deviltheyarent.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Platform {

    public float x, y, width, height;

    public Platform(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean collidesWith(float px, float py, float pw, float ph) {
        return px + pw > x && px < x + width && py + ph > y && py < y + height;
    }

    public void render(ShapeRenderer sr) {
        sr.setColor(Color.GRAY);
        sr.rect(x, y, width, height);
    }
}
