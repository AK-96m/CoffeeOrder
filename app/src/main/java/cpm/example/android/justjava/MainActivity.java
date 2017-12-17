/**
 * this project is done by Adeeb Khezam as a udacity's course example
 * and it is Not finished yet some updates will be applied!!
 **/
package cpm.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

import cpm.example.android.justjava.R;

//This app displays an order form to order coffee.

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    //used when creating some Logs!!
    //String tag = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int calculatePrice() {
        return quantity * 5;
    }

    // This method displays the given quantity value on the screen.
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    // This method displays the given price on the screen.
// the last line is to assign the dollar sign to the text displayed
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    // This method displays the given text on the screen.
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    //this method is to create the summary displayed
    private String createOrderSummery(int price, boolean addWC) {
        String name = "Adeeb kh";
        String priceMessage = name + "\n" +
                "Add whipped Cream? " + addWC + "\n" +
                "Quantity: " + quantity + "\n"
                + "The total is: " + price + "\nThank you!";
        return priceMessage;
    }

    // This method is called when the order button is clicked.
    public void submitOrder(View view) {
        int price = calculatePrice();
        CheckBox cb = findViewById(R.id.cb1);
        boolean whippedCreamIsChecked = cb.isChecked();
        String priceMessage = createOrderSummery(price, whippedCreamIsChecked);
        displayMessage(priceMessage);
    }
}