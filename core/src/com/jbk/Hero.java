package com.jbk;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.oracle.jrockit.jfr.FlightRecorder.isActive;

/**
 * Created by kmelnik on 19.12.16.
 */
public class Hero {
    private Texture texture;
    private Vector2 position;
    private float speed;
    private int fireRate;
    private int fireCounter;

    public Hero() {
        texture = new Texture("tank.png");
        position = new Vector2(100, 100);
        speed = 6.0f;
        fireRate = 4;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void update() {

//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
//            fireCounter = fireRate;
//        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            fireCounter++;
            if (fireCounter > fireRate) {
                fireCounter = 0;
               fire(position.x + 70, position.y + 28);
                fire(position.x + 70, position.y + 19);
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
                position.y += speed;
                if (position.y > 670) {
                    position.y = 670;
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
                position.y -= speed;
                if (position.y < -10) {
                    position.y = -10;
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
                position.x -= speed;
                if (position.x < -10) {
                    position.x = -10;
                }
            }

            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
                position.x += speed;
                if (position.x > 1210) {
                    position.x = 1210;
                }
            }
        }

    public void fire(float x, float y) {
        for (int i = 0; i < JbsBugsKiller.bullets.length; i++) {
            if(!JbsBugsKiller.bullets[i].isActive()) {
                JbsBugsKiller.bullets[i].setup(x, y);
                break;
            }
        }
    }


}

//      For Android TOUCHEPAD
//        if(Gdx.input.isTouched()) {
//            if(Gdx.input.getX() > position.x){
//                position.x += speed;
//            }
//        }
//
//        if(Gdx.input.isTouched()) {
//            if(Gdx.input.getX() < position.x){
//                position.x -= speed;
//            }
//        }
//
//        if(Gdx.input.isTouched()) {
//            if(Gdx.input.getY() < position.y){
//                position.y -= speed;
//            }
//        }
//
//        if(Gdx.input.isTouched()) {
//            if(Gdx.input.getY() > position.y){
//                position.y += speed;
//            }
//        }