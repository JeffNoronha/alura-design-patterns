package br.com.alura.loja;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.alura.loja.pedido.GeraPedido;
import br.com.alura.loja.pedido.GeraPedidoHandler;
import br.com.alura.loja.pedido.acao.AcaoAposGerarPedido;
import br.com.alura.loja.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.pedido.acao.LogDePedido;
import br.com.alura.loja.pedido.acao.SalvarPedidoNoBancoDeDados;

public class DemoPedido {

	public static void main(String[] args) {
	
		String cliente = "Rodrigo";
		BigDecimal valorOrcamento = new BigDecimal("300");
		int quantidadeItens = Integer.parseInt("2");
		
		List<AcaoAposGerarPedido> acoes = Arrays.asList(
				new SalvarPedidoNoBancoDeDados(), 
				new EnviarEmailPedido(),
				new LogDePedido());
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(acoes);
		handler.executar(gerador);
	}
}
