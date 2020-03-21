package com.geekbrains.rpg.game.logic;

import com.badlogic.gdx.math.MathUtils;

public class Weapon {
    public enum Type {
        MELEE, RANGED
    }

    private Type type;
    private String title;
    private int minDamage;
    private int maxDamage;
    private float speed;
    private float range;

    public Weapon(Type type, String title, int minDamage, int maxDamage, float speed, float range) {
        this.type = type;
        this.title = title;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.speed = speed;
        this.range = range;
    }

    public Type getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public float getSpeed() {
        return speed;
    }

    public float getRange() {
        return range;
    }

    public static Weapon createSimpleRangedWeapon() {
        return new Weapon(
                Type.RANGED,
                "Bow",
                MathUtils.random(1, 2),
                MathUtils.random(3, 5),
                0.5f,
                150f
        );
    }

    public static Weapon createSimpleMeleeWeapon() {
        return new Weapon(
                Type.MELEE,
                "Sword",
                MathUtils.random(1, 2),
                MathUtils.random(3, 4),
                0.4f,
                60f
        );
    }
}
