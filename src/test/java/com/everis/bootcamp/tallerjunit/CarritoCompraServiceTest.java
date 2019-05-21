package com.everis.bootcamp.tallerjunit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CarritoCompraServiceTest {

	private CarritoCompraService service;

	//Si alguien me modifica el numero de los articulos en la lista las pruebas darian fallo
	@Before
	public void inicializar() {
		service = new CarritoCompraService();
		service.articulos.add(new Articulo("Articulo1", 5d));
		service.articulos.add(new Articulo("Articulo2", 1d));
	}

	@Test
	public void limpiarCesta() {
		service.limpiarCesta();
		assertTrue(service.articulos.size() == 0);
	}

	@Test
	public void addArticulo() {
		Articulo nuevo = new Articulo("Articulo3", 10d);
		int sizeAntes = service.articulos.size();
		service.addArticulo(nuevo);
		int sizeDespues = service.articulos.size();

		assertTrue(sizeAntes < sizeDespues);
		assertTrue(sizeDespues - sizeAntes == 1);
		assertTrue(service.articulos.contains(nuevo));

	}

	@Test
	public void getNumArticulo() {
		assertTrue(service.getNumArticulo() == 2);
	}

	@Test
	public void getArticulos() {
		assertTrue(service.getArticulos() == service.articulos);
	}

	@Test
	public void totalPrice() {
		assertTrue(service.totalPrice() == 6d);
	}

	@Test
	public void calculadorDescuento() {
		assertTrue(service.calculadorDescuento(5d, 20d) == 4d);
	}

}
