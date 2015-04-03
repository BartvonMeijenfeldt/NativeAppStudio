package bartvonmeijenfeldt.week1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;
import java.lang.String;



public class MainActivity extends Activity {

    private EditText billEditText;
    private TextView totalTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        billEditText = (EditText) findViewById(R.id.billEditText);
        totalTextView = (TextView) findViewById(R.id.totalTextView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    double amount;
    String output;
    DecimalFormat outputformat = new DecimalFormat("#.00");

    // Button that adds 2.5% to the bill amount and sets it in totalTextView.
    public void on_cheapButtonClick(View view) {

        // Check if user wrote a value, if not tell user to put in a amount.
        if (billEditText.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a amount to pay", Toast.LENGTH_SHORT).show();
            return;
        }

        amount = 1.025 * Double.parseDouble((billEditText.getText().toString()));

        // Check if the amount is not too big for a bill, if so tell user his bill is not that big.
        if (amount > java.lang.Math.pow(10, 15)) {
            Toast.makeText(this, "Your bill is not that high", Toast.LENGTH_SHORT).show();
            return;
        }

        output = '€' + outputformat.format(amount);
        totalTextView.setText(output);
    }

    // Button that adds 5% to the bill amount and sets it in totalTextView.
    public void on_standardButtonClick(View view) {

        // Check if user wrote a value, if not tell user to put in a amount.
        if (billEditText.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a amount to pay", Toast.LENGTH_SHORT).show();
            return;
        }

        amount = 1.05 * Double.valueOf(String.valueOf(billEditText.getText()));

        // Check if the amount is not too big for a bill, if so tell user his bill is not that big.
        if (amount > java.lang.Math.pow(10,15)) {
            Toast.makeText(this, "Your bill is not that high", Toast.LENGTH_SHORT).show();
            return;
        }
        output = '€' + outputformat.format(amount);
        totalTextView.setText(output);
    }

    // Button that adds 10% to the bill amount and sets it in totalTextView.
    public void on_expensiveButtonClick(View view) {

        // Check if user wrote a value, if not tell user to put in a amount.
        if (billEditText.getText().toString().matches("")) {
            Toast.makeText(this, "You did not enter a amount to pay", Toast.LENGTH_SHORT).show();
            return;
        }

        amount = 1.1 * Double.valueOf(String.valueOf(billEditText.getText()));

        // Check if the amount is not too big for a bill, if so tell user his bill is not that big.
        if (amount > java.lang.Math.pow(10,15)) {
            Toast.makeText(this, "Your bill is not that high", Toast.LENGTH_SHORT).show();
            return;
        }

        output = '€' + outputformat.format(amount);
        totalTextView.setText(output);
    }


}
