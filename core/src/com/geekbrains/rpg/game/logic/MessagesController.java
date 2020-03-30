package com.geekbrains.rpg.game.logic;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.geekbrains.rpg.game.logic.utils.ObjectPool;
import com.geekbrains.rpg.game.screens.utils.Assets;

public class MessagesController extends ObjectPool<Message> {
    private GameController gc;

    @Override
    protected Message newObject() {
        return new Message(gc);
    }

    public MessagesController(GameController gc) {
        this.gc = gc;
    }

    public void setup(float x, float y, int amount) {
        getActiveElement().setup(x, y, amount);
    }

    public void update(float dt) {
        for (int i = 0; i < getActiveList().size(); i++) {
            getActiveList().get(i).update(dt);
        }
        checkPool();
    }

    public void render(SpriteBatch batch, BitmapFont font) {
        for (int i = 0; i < getActiveList().size(); i++) {
            getActiveList().get(i).render(batch, font);
        }
    }
}