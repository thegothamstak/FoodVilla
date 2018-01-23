package com.example.stak.foodvilla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String food[] = new String[5];
    int top = -1;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.status_tview);
        editText = findViewById(R.id.enter_etext);
    }

    public void push(View view){
        //Storing the edit text value in a string
        String food_item = editText.getText().toString();
        //Condition, so that it does not accept a blank value
        if(food_item.trim().equals("")){
            Toast.makeText(this, food_item + "Enter a food item !", Toast.LENGTH_SHORT).show();
        }
        else {
            if (top == food.length - 1) {
                Toast.makeText(this, "Stash is full !!!", Toast.LENGTH_LONG).show();
            }//editText = findViewById(R.id.enter_etext);
            else{
                    //Incrementing the top first and then adding the food to the food stack.
                    ++top;
                    food[top] = food_item;
                    //food[top] = editText.getText().toString();

                    Toast.makeText(this, food_item + " entered in your stash...", Toast.LENGTH_SHORT).show();
                }
            //To clear the textview when Push operation is to be performed
            textView.setText("");
        }
        //After pushing a food item, it clears the edit text. Easier for the user.
        editText.setText("");
    }

    public void pop(View view){
        if(top == -1){
            Toast.makeText(this, "Stash is empty !!!", Toast.LENGTH_SHORT).show();
        }
        else{
            String popped_item = food[top];
            //textView = findViewById(R.id.status_tview);
            textView.setText("You ate "+popped_item);
            --top;
        }
        //Clears the edit text on pop operation. Easier for user.
        editText.setText("");
    }
}

/*
    res->values->strings.xml (to change the name of my project)
*/
