package br.com.local.myappviacepapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnBuscarCep;
    EditText txtCep;
    EditText Cep;
    EditText Logradouro;
    EditText Complemento;
    EditText Bairro;
    EditText Cidade;
    EditText Estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCep = findViewById(R.id.txtCep);
        Cep = findViewById(R.id.Cep);
        Logradouro = findViewById(R.id.Logradouro);
        Complemento = findViewById(R.id.Complemento);
        Bairro = findViewById(R.id.Bairro);
        Cidade = findViewById(R.id.Cidade);
        Estado = findViewById(R.id.Uf);
        btnBuscarCep = findViewById(R.id.btnBuscaCep);


        btnBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String endereco = txtCep.getText().toString().trim();

                try {
                    //preencher o cep no lblResposta do layout
                    CEP retorno = new HttpService(txtCep.getText().toString().trim()).execute().get();
                    Cep.setText(retorno.getCep());
                    Logradouro.setText(retorno.getLogradouro());
                    Complemento.setText(retorno.getComplemento());
                    Bairro.setText(retorno.getBairro());
                    Cidade.setText(retorno.getLocalidade());
                    Estado.setText(retorno.getUf());

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}