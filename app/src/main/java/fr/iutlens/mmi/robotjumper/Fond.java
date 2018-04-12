package fr.iutlens.mmi.robotjumper;

import android.graphics.Canvas;

import fr.iutlens.mmi.robotjumper.utils.SpriteSheet;

/**
 * Created by clement.vitrant on 16/03/18.
 */

class Fond {
    private final SpriteSheet sprite;

    public Fond(int sprite_id) {
        sprite = SpriteSheet.get(sprite_id);
    }

    public void paint(Canvas canvas, int height, float d) {
        canvas.save();
        float scale = (1f*height)/sprite.h;
        canvas.scale(scale,scale);

        d = d - ((int) d);
        int ndx = (int) (d*2);
        int ndx2 = 1- ndx;
        float offs = - (2*d-ndx)*sprite.w;


        sprite.paint(canvas,ndx,offs,0);
        sprite.paint(canvas,ndx2,sprite.w+offs,0);
        sprite.paint(canvas,ndx,(sprite.w)*2+offs,0);
        sprite.paint(canvas,ndx2,(sprite.w)*3+offs,0);
        canvas.restore();
    }
}
