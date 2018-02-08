package com.terribleclickergame.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Zombie
{
    Animation<TextureRegion> walkRightAnimation;
    TextureRegion[] walkRightAnimationTextures;
    float timeElapsed;
    float FRAMES_PER_SECOND = 12;

    public Zombie()
    {
        TextureRegion walkRightAnimationSingleTexture = new TextureRegion(new Texture(Gdx.files.internal("Monster-zombie.png")));
        walkRightAnimationSingleTexture.setRegionY(walkRightAnimationSingleTexture.getRegionHeight()/8);
        walkRightAnimationSingleTexture.setRegionHeight(walkRightAnimationSingleTexture.getRegionHeight()/8);
        TextureRegion[][]walkRightAnimationTexturesTemp = walkRightAnimationSingleTexture.split(walkRightAnimationSingleTexture.getRegionWidth()/7, walkRightAnimationSingleTexture.getRegionHeight());

        TextureRegion[]  walkRightAnimationTextures = new TextureRegion[7];

        for (int x = 0; x < 7; x++) {
            walkRightAnimationTextures[x] = walkRightAnimationTexturesTemp[0][x];
        }

        walkRightAnimation = new Animation<TextureRegion>(1/FRAMES_PER_SECOND, walkRightAnimationTextures);

        timeElapsed = 0;

    }

    public void render(float deltaTime, SpriteBatch batch)
    {
        timeElapsed += deltaTime;

        batch.draw(walkRightAnimation.getKeyFrame(timeElapsed, true), 100, 100);
    }

}