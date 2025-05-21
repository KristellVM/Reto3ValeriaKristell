package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import clases.Cliente;
import clases.Pedido;
import dao.ClienteDAO;
import dao.PedidosDAO;
import util.Funciones;

public class otraPRUEBA {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int cod = Funciones.dimeEntero("Introduce el codigo de un cliente", sc);
		Cliente cliente = ClienteDAO.buscar(cod);
		if (cliente == null) {
			System.out.println("El cliente no existe");
		}
		//List<Pedido> listaPedidos = Main4.PedidosPorCliente(cliente);

	}
}
