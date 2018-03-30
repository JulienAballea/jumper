package fr.iutlens.mmi.jumper;

import android.graphics.Canvas;

import fr.iutlens.mmi.jumper.utils.SpriteSheet;

/**
 * Created by clement.vitrant on 19/03/18.
 */

class Life {

    private final SpriteSheet sprite;

    public Life(int heart) {
        sprite = SpriteSheet.get(heart);
    }

    public void paint(Canvas canvas, int height) {
        canvas.save();
        float scale = (1f*height)/sprite.h;
        canvas.scale(scale,scale);
        int x = Hero.lifes;
        for (int i = 0; i < x; i++) {
            sprite.paint(canvas,0,i*sprite.w,0);
        }
        canvas.restore();
    }
}
