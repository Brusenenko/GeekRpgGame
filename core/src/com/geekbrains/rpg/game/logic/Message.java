package com.geekbrains.rpg.game.logic;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.rpg.game.logic.utils.Consumable;
import com.geekbrains.rpg.game.logic.utils.MapElement;
import com.geekbrains.rpg.game.logic.utils.Poolable;

public class Message implements Poolable {

    private GameController gc;
    private Vector2 position;
    private Vector2 velocity;
    private float time;
    private boolean active;

//    не уверен, что использовать String в качестве буффера в данном случае эффективно
//    скорее всего, лучше использовать StringBuilder, чтобы не плодить кучу объектов
    private String message;

    public Vector2 getPosition() {
        return position;
    }

    public Message(GameController gc) {
        this.gc = gc;
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
    }

    public void setup(float x, float y, int amount) {
        position.set(x, y);
        velocity.set(30.0f, 30.0f);
        time = 0.0f;
        active = true;
        message = String.valueOf(amount);
    }

    public void update(float dt) {
        time += dt;
        position.mulAdd(velocity, dt);
        if (time > 1.0f) {
            active = false;
        }
    }

    public void render(SpriteBatch batch, BitmapFont font) {
        font.draw(batch, message, position.x, position.y);
    }

    @Override
    public boolean isActive() {
        return active;
    }
}