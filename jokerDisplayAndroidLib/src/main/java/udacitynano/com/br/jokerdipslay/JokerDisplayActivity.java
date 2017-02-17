package udacitynano.com.br.jokerdipslay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokerDisplayActivity extends AppCompatActivity {

    TextView jokerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker_display);

        String jokerContent = this.getIntent().getStringExtra(Constant.JOKER_CONTENT);
        jokerText = (TextView) findViewById(R.id.jokerText);
        jokerText.setText(jokerContent);

    }
}
