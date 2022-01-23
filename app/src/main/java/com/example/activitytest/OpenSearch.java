package com.example.activitytest;

public class OpenSearch extends androidx.appcompat.app.AppCompatActivity {

    private android.widget.Button btnUpdate;
    private android.widget.EditText etUpdate;

    protected void onCreate(android.os.Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.search_open);
        btnUpdate = findViewById(com.example.activitytest.R.id.btnUpdate);
        etUpdate = findViewById(R.id.etUpdate);
        btnUpdate.setOnClickListener(this::returnData);
    }

    private void returnData(android.view.View view){
        android.content.Intent passDataBack = new android.content.Intent();
        passDataBack.putExtra("DataBack", etUpdate.getText().toString().isEmpty()
        ? "Not applicable" : etUpdate.getText().toString());

        setResult(RESULT_OK, passDataBack);

        finish();
    }


}
