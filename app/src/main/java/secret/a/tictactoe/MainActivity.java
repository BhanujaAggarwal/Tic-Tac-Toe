package secret.a.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] gamestate={2,2,2,2,2,2,2,2,2};
    boolean state=true;
    int [][] winningPositions={
            {0,1,2},
            {3,4,5},
            {6,7,8},
            {0,3,6},
            {1,4,7},
            {6,7,8},
            {2,4,6},
            {0,4,8}
    };

    int player=1;

    public void dropin(View view) {
        ImageView counter = (ImageView) view;

        int tappedCounter=Integer.parseInt(counter.getTag().toString());



        if(gamestate[tappedCounter]==2 && state) {
            gamestate[tappedCounter]=player;
            counter.setTranslationY(-1500);
            if (player == 0) {
                counter.setImageResource(R.drawable.r);
                player = 1;
            } else {
                counter.setImageResource(R.drawable.y);
                player = 0;
            }
            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            String winner;
                for (int[] winningPosition : winningPositions) {
                    if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[0]] == gamestate[winningPosition[2]] && gamestate[winningPosition[2]] != 2) {
                        state=false;
                        if (player == 0) {
                            winner = "Yellow has won!!";
                        } else {
                            winner = "Red has won!!";
                        }
                        Button btn=(Button)findViewById(R.id.btn);
                        TextView txt=(TextView)findViewById(R.id.textView);
                        txt.setText(winner);
                        btn.setVisibility(view.VISIBLE);
                        txt.setVisibility(view.VISIBLE);

                    }
                }
        }
    }

    public void playAgain(View view)
    {
        Button btn=(Button)findViewById(R.id.btn);
        TextView txt=(TextView)findViewById(R.id.textView);
        btn.setVisibility(view.INVISIBLE);
        txt.setVisibility(view.INVISIBLE);


        GridLayout grid=(GridLayout)findViewById(R.id.grid);

        for(int i=0;i<grid.getChildCount();i++)
        {
            ImageView counter=(ImageView)grid.getChildAt(i);
            counter.setImageDrawable(null);
        }

        for(int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }

        state=true;
        player=1;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
