package com.senai.impaoupar;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ResultadoActivity extends Activity {

	private static final String PAR = "par";
	private static final String IMPAR = "ímpar";
	
	String opcao;
	String resultado;
	String stringResultado;
	
	int numero;
	int numeroMaquina;
	int soma;
	
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultado);
		intent = getIntent();
		obtemDados();
		gerarNumeroRandomico();
		verificaResultado();
		exibeResultado();
	}
	
	private void exibeResultado() {
		TextView tvVencedor = (TextView)findViewById(R.id.tv_vencedor);
		tvVencedor.setText(stringResultado);
		
		TextView tvVoce = (TextView)findViewById(R.id.tv_voce);
		tvVoce.setText(String.valueOf(numero));
		
		TextView tvMaquina = (TextView)findViewById(R.id.tv_maquina);
		tvMaquina.setText(String.valueOf(numeroMaquina));
		
		TextView tvResultado = (TextView)findViewById(R.id.tv_resultado);
		tvResultado.setText(String.valueOf(soma) + " é " + resultado);
	}

	private void verificaResultado() {
		soma = numero + numeroMaquina;
		if ((soma % 2) == 0) {
			resultado = PAR;
		} else {
			resultado = IMPAR;
		}
		stringResultado = (opcao.equals(resultado) ? "Você venceu =)" : "Você perdeu =(");
	}

	private void gerarNumeroRandomico() {
		numeroMaquina = (new Random()).nextInt((5) + 1) + 0;
	}

	private void obtemDados() {
		String stringNumero = intent.getStringExtra("numero");
		numero = Integer.parseInt(stringNumero);
		opcao = intent.getStringExtra("opcao");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.resultado, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.acao_voltar) {
			jogarNovamente();
		}
		return super.onOptionsItemSelected(item);
	}

	public void jogarNovamente() {
		Intent intent = new Intent(this, OpcaoActivity.class);
		startActivity(intent);
	}
	
	public void voltar(View view) {
		jogarNovamente();
	}
}
