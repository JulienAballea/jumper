package fr.iutlens.mmi.robotjumper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import fr.iutlens.mmi.robotjumper.utils.AccelerationProxy;

/***
 * Crédits image : https://pixabay.com/fr/lapin-dessin-animé-jeu-élément-1582176/
 *
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    private AccelerationProxy proxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // On récupère la vue du jeu
        GameView game = findViewById(R.id.gameView);

        game.setTextViewScore((TextView) findViewById(R.id.textView));
        game.setLostView(findViewById(R.id.linearLayout));
        game.setLostView(findViewById(R.id.textView2));

        // On configure le jeu pour recevoir les changements d'orientation
        proxy = new AccelerationProxy(this, game);
    }


    @Override
    protected void onResume() {
        super.onResume();
        proxy.resume(); // On relance l'accéléromètre
    }

    @Override
    protected void onPause() {
        super.onPause();
        proxy.pause(); // On mets en pause l'accéléromètre
    }
}
