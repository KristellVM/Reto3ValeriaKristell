package main;

import java.util.Scanner;

import clases.PedidoProducto;
import dao.PedidosDAO;
import util.Funciones;

public class Main3 {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);

	
	int opcion;

	do {
		opcion = Funciones.dimeEntero("Elige una opcion:", sc);
		System.out.println("0-Salir");
		System.out.println(" 1-Crear pedido");
		System.out.println(" 2-Ver pedidos");

		switch (opcion) {
		case 1:
		PedidosDAO.crearPedido();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		
		default:
			System.out.println("Opcion inválida. Seleccionar otra vez");
			break;
		}
	} while (opcion != 0);

	
	
	}

}
