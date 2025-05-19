package main;

import java.util.ArrayList;
import java.util.List;

import clases.Pedido;
import dao.PedidosDAO;

public class otraPRUEBA {

	public static void main(String[] args) {
		System.out.println(PedidosDAO.verPedidos());

		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		for (Pedido pedido : listaPedidos) {
			System.out.println(pedido);
		}

	}
}
