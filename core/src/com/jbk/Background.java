package com.jbk;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by kmelnik on 19.12.16.
 */
public class Background {

//    class Star {
//        Vector2 position; //position.x position.y
//        private float speed;
//
//        public Star() {
//            position = new Vector2((float)Math.random() * 1280, (float)Math.random() * 720);
//            speed = 2.0f + (float)Math.random() * 7.0f ;
//
//        }
//
//        public void update() {
//
//            position.x -= speed;
//            if(position.x < -20) {
//                position.x = 1280;
//                position.y = (float)Math.random() * 720;
//                speed = 2.0f + (float)Math.random() * 7.0f ;
//            }
//        }
//
//    }

    private Texture texture;
//    private Texture textureStar;
//    private final int STARS_COUNT = 250;
//    private Star[] stars;

    public Background(){
//        textureStar = new Texture("star12.tga");
        texture = new Texture("bg.jpg");
//        stars = new Star[STARS_COUNT];
//        for(int i = 0; i < STARS_COUNT; i++) {
//            stars[i] = new Star();
//        }
    }

    public void render (SpriteBatch batch) {
        batch.draw(texture, 0, 0);

//        for(int i = 0; i < STARS_COUNT; i++) {
//            batch.draw(textureStar, stars[i].position.x, stars[i].position.y);file:///home/kmelnik/Pictures/projekt/JbsBugs/tank.png
//        }
    }

    public void update() {

//        for(int i = 0; i < STARS_COUNT; i++) {
//        stars[i].update();
//        }


    }
}
