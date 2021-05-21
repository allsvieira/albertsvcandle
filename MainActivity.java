package Fi06.candles;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.durationResult).setFocusable(false);

        ViewBuilder viewBuilder = new ViewBuilder();
        viewBuilder.buildSpinner(this);

        initButtons();
    }

    private void initButtons(){
        Button calcBtn = (Button) findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.onClickCalculate(view);
            }
        });

        Button resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.onClickReset(view);
            }
        });

    }

    private void onClickCalculate(View view) {
        CandleCalculator candleCalculator = new CandleCalculator(getCandleDataInput());
        ((TextView) findViewById(R.id.durationResult)).setText(candleCalculator.getTimeLeft());
    }

    private void onClickReset(View view){
        ((EditText)findViewById(R.id.lengthInput)).getText().clear();
        ((EditText)findViewById(R.id.diameterInput)).getText().clear();
        ((EditText)findViewById(R.id.durationResult)).getText().clear();
    }

    private Candle getCandleDataInput() {
        Spinner spinner = (Spinner) findViewById(R.id.candleSpinner);
        Candle selectedItem = new Candle();
        selectedItem.setMaterial((Material) spinner.getSelectedItem());
        selectedItem.setLength(getInputFieldContent(R.id.lengthInput));
        selectedItem.setDiameter(getInputFieldContent(R.id.diameterInput));
        return selectedItem;
    }

    private double getInputFieldContent(int inputFieldId) {
        try {
            String number = ((EditText) findViewById(inputFieldId)).getText().toString();
            return Double.parseDouble(number);
        } catch (NumberFormatException ex) {
            Log.e("Error", "Bitte geben sie mir ein Zahl");
        }
        return 0;
    }
}
