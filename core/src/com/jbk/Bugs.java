package com.jbk;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by kmelnik on 19.12.16.
 */
public class Bugs {
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private Rectangle rect;

    public Vector2 getPosition() {
        return position;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Bugs() {
        position = new Vector2(1280+(float)Math.random() * 1280, (float)Math.random() * 720);
        speed = 4.0f + (float)Math.random() * 8.0f ;
        rect = new Rectangle(position.x, position.y, 80, 60);
        if(texture == null) {
            texture = new Texture("bugs_1.png");
        }

    }

    public void recreate(){
        position.x = 1280 + (float)Math.random() * 1280;
        position.x =  720 + (float)Math.random() * 720;
        speed = 4.0f + (float)Math.random() * 8.0f;

    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);

    }

    public void update() {

        position.x -= speed;
        if(position.x < -80) {
            recreate();
        }
        rect.x = position.x;
        rect.y = position.y;
    }


}
