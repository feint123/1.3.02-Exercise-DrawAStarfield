package com.udacity.gamedev.starfield;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.udacity.gamedev.starfield.game.WorldController;
import com.udacity.gamedev.starfield.game.WorldRenderer;

/**
 * Created by root on 7/13/16.
 */
public class CanyonBunnyMain implements ApplicationListener{

    private static final String TAG=
            CanyonBunnyMain.class.getName();

    private WorldController worldController;
    private WorldRenderer worldRenderer;

    private boolean paused;
    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        worldController=new WorldController();
        worldRenderer=new WorldRenderer(worldController);
        paused=false;
    }

    @Override
    public void resize(int width, int height) {
        worldRenderer.resize(width,height);
    }

    @Override
    public void render() {
        if(!paused) {
            worldController.update(Gdx.graphics.getDeltaTime());
        }
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        worldRenderer.render();
    }

    @Override
    public void pause() {
        paused=true;
    }

    @Override
    public void resume() {
        paused=false;
    }

    @Override
    public void dispose() {
        worldRenderer.dispose();
    }
}
