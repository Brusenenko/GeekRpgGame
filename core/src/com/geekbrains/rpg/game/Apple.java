package com.geekbrains.rpg.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Apple {
    private TextureRegion textureRegion;
    private Vector2 position;
    private int radius;
    private Projectile projectile;

    public Apple (TextureAtlas atlas, Projectile projectile) {
        this.textureRegion = atlas.findRegion("apple");
        this.position = new Vector2(0, 0);
        this.radius = 32;
        this.projectile = projectile;
    }

    public void render (SpriteBatch batch) {
        batch.draw(textureRegion, position.x - 32, position.y - 32, 32, 32, 64, 64, 1, 1, 0);
    }

    public void setup() {
        int min = radius;
        int maxX = 1280 - radius;
        int maxY = 720 - radius;
        float x = (float) (Math.random() * (maxX - min + 1) + min);
        float y = (float) (Math.random() * (maxY - min + 1) + min);
        position.set(x, y);
    }

    public void update() {
        if ((projectile.getPosition().x >= position.x - radius) && (projectile.getPosition().x <= position.x + radius) &&
                (projectile.getPosition().y >= position.y - radius) && (projectile.getPosition().y <= position.y + radius)) {
            this.setup();
            projectile.deactivate();
        }
    }
}
