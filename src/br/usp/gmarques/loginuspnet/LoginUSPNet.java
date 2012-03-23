package br.usp.gmarques.loginuspnet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import br.usp.gmarques.loginuspnet.db.USPNetLoginDataSource;

public class LoginUSPNet extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final TextView username = (TextView) findViewById(R.id.login);
		final TextView password = (TextView) findViewById(R.id.password);
		
		USPNetLoginDataSource uspNetLoginDataSource = new USPNetLoginDataSource(LoginUSPNet.this);
		uspNetLoginDataSource.open();
		
		username.setText(uspNetLoginDataSource.getUsername());
		password.setText(uspNetLoginDataSource.getPassword());
		uspNetLoginDataSource.close();
		
	}
	
	public void saveData(View view){
		final TextView username = (TextView) findViewById(R.id.login);
		final TextView password = (TextView) findViewById(R.id.password);
		
		USPNetLoginDataSource uspNetLoginDataSource = new USPNetLoginDataSource(LoginUSPNet.this);
		uspNetLoginDataSource.open();
		
		if(uspNetLoginDataSource.setUsernameAndPassword(username.getText().toString(), password.getText().toString()) != -1)
			Toast.makeText(LoginUSPNet.this, "Email e senha salvos com sucesso!!", Toast.LENGTH_LONG).show();
		else
			Toast.makeText(LoginUSPNet.this, "Erro ao salvar!!", Toast.LENGTH_LONG).show();
		
		uspNetLoginDataSource.close();
		
	}

}
