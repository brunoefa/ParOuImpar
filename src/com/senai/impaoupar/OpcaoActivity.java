package com.senai.impaoupar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OpcaoActivity extends Activity {
	
	private static final String PAR = "par";
	private static final String IMPAR = "ímpar";
	String numero;
	String opcao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_opcao);
	}
	
	public void escolherImpar(View view) {
		opcao = IMPAR;
		obterNumero();
		exibeResultado();
	}
	
	public void escolherPar(View view) {
		opcao = PAR;
		obterNumero();
		exibeResultado();
	}
	
	private void obterNumero() {
		EditText etNumero = (EditText)findViewById(R.id.et_numero);
		numero = etNumero.getText().toString();
	}
	
	private void exibeResultado() {
		Intent intent = new Intent(this, ResultadoActivity.class);
		intent.putExtra("numero", numero);
		intent.putExtra("opcao", opcao);
		startActivity(intent);
	}

}
