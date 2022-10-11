package kz.talipovsn.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity {

    // Локальные переменные для доступа к компонентам окна
    private EditText editText;
    private EditText editText2;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton selectRadioButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Инициализация переменных доступа к компонентам окна
        editText =   findViewById(R.id.editText);
        editText2 =   findViewById(R.id.editText2);
        checkBox =   findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        spinner =    findViewById(R.id.spinner);
    }

    // МЕТОД ДЛЯ КНОПКИ НАЗАД
    public void onBack1(View v) {
        setResult(RESULT_OK);
        finish();
    }

    // МЕТОД ДЛЯ КНОПКИ
    public void onInfo(View v) {
        // Создание второго окна
        Intent intent2 = new Intent(Main2Activity.this, ResultActivity.class);

        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        // Подготовка параметров для второго окна
        intent2.putExtra("fio", editText.getText().toString());
        intent2.putExtra("age", editText2.getText().toString());
        intent2.putExtra("gender", checkBox.isChecked() ? getString(R.string.Мужчина) : getString(R.string.Женщина));
        intent2.putExtra("edu", selectRadioButton.getText());
        intent2.putExtra("country", spinner.getSelectedItem().toString());

        // Запуск третьего окна
        startActivity(intent2);
    }

}
