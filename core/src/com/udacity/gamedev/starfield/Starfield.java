package com.udacity.gamedev.starfield;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * TODO: Start here!
 *
 * In this exercise we'll draw a star field of white points on a black background. The number of
 * points will be defined by a density parameter that states what proportion of the pixels should be
 * white.
 *
 * TODO: Run what you've got before making any changes
 *
 * One thing to note is we're using two new LibGDX classes, Array, and Vector2. We're using a custom
 * Array type so LibGDX can control the memory, and avoid unfortunate garbage collection events.
 * Vector2 is a super simple class for holding a 2D position. You can find more information in the
 * LibGDX Javadocs, or just by right clicking on the class name, and selecting Go To > Declaration.
 *
 * One new utility class we'll be using in this exercise is com.badlogic.gdx.math.Vector2. You can
 * find more information in the LibGDX Javadocs.
 *
 * Remember you can set up a Desktop run configuration using the dropdown in the toolbar, or you can
 * open the terminal at the bottom of the screen and run
 *
 * $ ./gradlew desktop:run
 */


public class Starfield extends ApplicationAdapter {

//    private static final float STAR_DENSITY = 0.01f;
//    ShapeRenderer shapeRenderer;
//    Array<Vector2> stars;
//
//    @Override
//    public void create() {
//        // TODO: Initialize a shapeRenderer
//
//        // TODO: Call initStars
//
//    }
//
//    public void initStars(float density) {
//        // TODO: Figure out how many stars to draw. You'll need the screen dimensions, which you can get using Gdx.graphics.getWidth() and Gdx.graphics.getHeight().
//
//        // TODO: Create a new array of Vector2's to hold the star positions
//
//        // TODO: Use java.util.Random to fill the array of star positions
//
//    }
//
//    @Override
//    public void render() {
//        // TODO: Make the night sky black
//        Gdx.gl.glClearColor(1, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        // TODO: Begin a shapeRenderer batch using ShapeType.Point
//
//        // TODO: Loop through the star positions and use shapeRenderer to draw points
//
//        // TODO: End the shapeRenderer batch
//
//    }
//
//    @Override
//    public void dispose() {
//        // TODO: Dispose of our ShapeRenderer
//
//        super.dispose();
//    }
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture texture;
    private Sprite sprite;

    @Override
    public void create() {

        float w=Gdx.graphics.getWidth();
        float h=Gdx.graphics.getHeight();

        camera=new OrthographicCamera(1,h/w);
        batch=new SpriteBatch();

        texture=new Texture(Gdx.files.internal("badlogic.jpg"));
        TextureRegion region=new TextureRegion(texture,0,0,texture.getWidth(),texture.getHeight());
        sprite=new Sprite(region);
        sprite.setSize(h,h);
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        sprite.rotate(90);
        sprite.setPosition(w/2,h/2);
//        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
//
//        TextureRegion region=
//                new TextureRegion(texture,0,0,400,300);
//
//        sprite=new Sprite(region);
//
//        sprite.setSize(0.9f,0.9f);
//        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
//        sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        batch.draw(texture,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        sprite.draw(batch);
        batch.end();
    }
}
