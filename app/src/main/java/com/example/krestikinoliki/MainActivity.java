package com.example.krestikinoliki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Paint;


public class MainActivity extends AppCompatActivity {
Button button, button2, button3, button4, button5, button6, button7, button8, button9;
TextView textView;
    String krest[][] = {{"","",""},{"","",""},{"","",""}};
    String znak, znak1;
    int r1, r2;

    Button restartButton; // Добавляем переменную для кнопки перезапуска


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restartButton = findViewById(R.id.restartButton);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame(v);
            }
        });


        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        textView = findViewById(R.id.textView);
        button.setTextColor(getResources().getColor(android.R.color.black));
        button2.setTextColor(getResources().getColor(android.R.color.black));
        button3.setTextColor(getResources().getColor(android.R.color.black));
        button4.setTextColor(getResources().getColor(android.R.color.black));
        button5.setTextColor(getResources().getColor(android.R.color.black));
        button6.setTextColor(getResources().getColor(android.R.color.black));
        button7.setTextColor(getResources().getColor(android.R.color.black));
        button8.setTextColor(getResources().getColor(android.R.color.black));
        button9.setTextColor(getResources().getColor(android.R.color.black));

        znak="X";
        znak1="O";
    }

    ///Ходы человека
    public void k1(View v){
        krest[0][0]=znak;
        button.setText(znak);
        button.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k2(View v){
        krest[0][1]=znak;
        button2.setText(znak);
        button2.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k3(View v){
        krest[0][2]=znak;
        button3.setText(znak);
        button3.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k4(View v){
        krest[1][0]=znak;
        button4.setText(znak);
        button4.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k5(View v){
        krest[1][1]=znak;
        button5.setText(znak);
        button5.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k6(View v){
        krest[1][2]=znak;
        button6.setText(znak);
        button6.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k7(View v){
        krest[2][0]=znak;
        button7.setText(znak);
        button7.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k8(View v){
        krest[2][1]=znak;
        button8.setText(znak);
        button8.setEnabled(false);
        proverka();
        obrat_hod();
    }

    public void k9(View v){
        krest[2][2]=znak;
        button9.setText(znak);
        button9.setEnabled(false);
        proverka();
        obrat_hod();

    }

    ///Ходы компа
    public void random_comp(){
        r1 = (int) (Math.random()*3);
        r2 = (int) (Math.random()*3);
    }
    public void obrat_hod(){
        random_comp();
        while (!krest[r1][r2].equals("")) {
            random_comp();
        }

        krest[r1][r2] = znak1;
        smotr();
        proverka();

        // Находим кнопку, соответствующую ходу компьютера и делаем её неактивной
        Button compButton = findButtonByCoordinates(r1, r2);
        compButton.setEnabled(false);
    }

    private Button findButtonByCoordinates(int r1, int r2) {
        int id = getResources().getIdentifier("button" + (r1*3 + r2 + 1), "id", getPackageName());
        return findViewById(id);
    }


    private Button getButtonByCoords(int row, int col) {
        Button[][] buttons = {
                {button, button2, button3},
                {button4, button5, button6},
                {button7, button8, button9}
        };
        return buttons[row][col];
    }

    public void smotr(){
        button.setText(krest[0][0]);
        button2.setText(krest[0][1]);
        button3.setText(krest[0][2]);
        button4.setText(krest[1][0]);
        button5.setText(krest[1][1]);
        button6.setText(krest[1][2]);
        button7.setText(krest[2][0]);
        button8.setText(krest[2][1]);
        button9.setText(krest[2][2]);
    }
    public void proverka() {
        if ((button.getText().equals("X")) && (button2.getText().equals("X")) && (button3.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button2.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button3.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button.getText().equals("X")) && (button4.getText().equals("X")) && (button7.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button4.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button7.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button.getText().equals("X")) && (button5.getText().equals("X")) && (button9.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button9.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button2.getText().equals("X")) && (button5.getText().equals("X")) && (button8.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button2.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button8.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button3.getText().equals("X")) && (button5.getText().equals("X")) && (button7.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button3.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button7.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button3.getText().equals("X")) && (button6.getText().equals("X")) && (button9.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button3.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button6.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button9.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button4.getText().equals("X")) && (button5.getText().equals("X")) && (button6.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button4.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button6.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button7.getText().equals("X")) && (button8.getText().equals("X")) && (button9.getText().equals("X"))) {
            textView.setText("Игрок победил");
            button7.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button8.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button9.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }

        if ((button.getText().equals("O")) && (button2.getText().equals("O")) && (button3.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button2.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button3.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button.getText().equals("O")) && (button4.getText().equals("O")) && (button7.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button4.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button7.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button.getText().equals("O")) && (button5.getText().equals("O")) && (button9.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button9.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button2.getText().equals("O")) && (button5.getText().equals("O")) && (button8.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button2.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button8.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button3.getText().equals("O")) && (button5.getText().equals("O")) && (button7.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button3.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button7.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button3.getText().equals("O")) && (button6.getText().equals("O")) && (button9.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button3.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button6.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button9.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button4.getText().equals("O")) && (button5.getText().equals("O")) && (button6.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button4.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button5.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button6.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
        if ((button7.getText().equals("O")) && (button8.getText().equals("O")) && (button9.getText().equals("O"))) {
            textView.setText("Компьютер победил");
            button7.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button8.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            button9.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }

        boolean isDraw = true;

        // Проверяем, остались ли пустые клетки
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (krest[i][j].equals("")) {
                    isDraw = false;
                    break;
                }
            }
        }

        // Если не осталось пустых клеток и никто не победил, значит ничья
        if (isDraw) {
            textView.setText("Ничья");
        }
    }




    public void restartGame(View view) {
        Button[] buttons = {button, button2, button3, button4, button5, button6, button7, button8, button9};

        for (Button button : buttons) {
            button.setText("");
            button.setEnabled(true);
           // button.setBackgroundResource(android.R.drawable.btn_default); // Возвращаем стандартный фон кнопки
            button.setTextColor(getResources().getColor(R.color.black));
        }

        textView.setText("");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                krest[i][j] = "";
            }
        }
    }
}