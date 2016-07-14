package com.udacity.gamedev.starfield.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.udacity.gamedev.util.CameraHelper;

/**
 * Created by root on 7/13/16.
 */
public class WorldController {
    private static final String TAG=
            WorldController.class.getName();

    public Sprite[] testSprites;
    public int selectedSprite;
    public CameraHelper cameraHelper;

    public WorldController(){
        init();
    }
    private void init(){
        cameraHelper=new CameraHelper();
        initTestObject();
    }

    private void initTestObject(){
        testSprites=new Sprite[5];

        int width=32;
        int height=32;

        Pixmap pixmap=createProceduralPixmap(width,height);

        Texture texture=new Texture(pixmap);

        for(int i=0;i<testSprites.length;i++){
            Sprite sprite=new Sprite(texture);

            sprite.setSize(1,1);
            sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);

            float randomX= MathUtils.random(-2,2);
            float randomY=MathUtils.random(-2,2);
            sprite.setPosition(randomX,randomY);
            testSprites[i]=sprite;
        }
        selectedSprite=0;
    }

    private Pixmap createProceduralPixmap(int width,int height){
        Pixmap pixmap=new Pixmap(width,height, Pixmap.Format.RGB888);
        pixmap.setColor(1,0,0,0.5f);
        pixmap.fill();
        pixmap.setColor(1,1,0,1);
        pixmap.drawLine(0,0,width,height);
        pixmap.drawLine(width,0,0,height);
        pixmap.setColor(0,1,1,1);
        pixmap.drawRectangle(0,0,width,height);
        return pixmap;
    }


    public void update(float deltaTime){
        handleDebugInput(deltaTime);
        updateTestObjects(deltaTime);
        cameraHelper.update(deltaTime);
    }

    private void handleDebugInput(float deltaTime){
        if(Gdx.app.getType() != Application.ApplicationType.Android) return;

        float spriteMoveSpeed=5*deltaTime;
        if(Gdx.input.isTouched()) moveSelectedSprite(0,spriteMoveSpeed);
    }
    private void moveSelectedSprite(float x,float y){
        testSprites[selectedSprite].translate(x,y);
    }
    private void updateTestObjects(float deltaTime){
        float rotation=testSprites[selectedSprite].getRotation();
        rotation+=90*deltaTime;
        rotation%=360;
        testSprites[selectedSprite].setRotation(rotation);
    }
}
