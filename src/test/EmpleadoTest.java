package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Inicio de todo");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Fin de todo");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Inicio de uno");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("Fin de todo");
	}

	// 1. Vendedor
	@Test
	void testVendedor() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1000;
		float horas = 0;
		
		float resultado = 2000 + 100;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 2. Encargado
	@Test
	void testEncargado() {
		TipoEmpleado tipo = TipoEmpleado.Encargado;
		float ventas = 1000;
		float horas = 0;
		
		float resultado = 2500 + 100;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 3. Otro
	@Test
	void testOtro() {
		TipoEmpleado tipo = TipoEmpleado.otro;
		float ventas = 1000;
		float horas = 0;
		
		float resultado = -1;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 4. VentasMes < 1000
	@Test
	void testVentasMenor1000() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 500;
		float horas = 0;
		
		float resultado = 2000;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 5. VentasMes entre 1000 y 1500
	@Test
	void testVentasEntre1000y1500() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1200;
		float horas = 0;
		
		float resultado = 2000 + 100;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 6. VentasMes >= 1500
	@Test
	void testVentasMayor1500() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1600;
		float horas = 0;
		
		float resultado = 2000 + 200;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 7. VentasMes Negativas
	@Test
	void testVentasNegativas() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = -100;
		float horas = 0;
		
		float resultado = -1;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 8. HorasExtra Si
	@Test
	void testHorasExtraPositivas() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1000;
		float horas = 2;
		
		float resultado = 2000 + 100 + (30 * 2);
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 9. HorasExtra No (Negativas)
	@Test
	void testHorasExtraNegativas() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1000;
		float horas = -1;
		
		float resultado = -1;
		float resEmpleado = Empleado.CalculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 10. Nómina neta < 2100
	@Test
	void testNominaNetaMenor2100() {
		float nomina = 2000;
		
		float resultado = 2000;
		float resEmpleado = Empleado.CalculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}

	// 11. Nómina neta entre 2100 y 2500
	@Test
	void testNominaNetaEntre2100y2500() {
		float nomina = 2200;
		
		float resultado = 2200 * (1 - 0.15f);
		float resEmpleado = Empleado.CalculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}

	// 12. Nómina neta > 2500
	@Test
	void testNominaNetaMayor2500() {
		float nomina = 2600;
		
		float resultado = 2600 * (1 - 0.18f);
		float resEmpleado = Empleado.CalculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}

	// 13. Nómina neta negativa
	@Test
	void testNominaNetaNegativa() {
		float nomina = -100;
		
		float resultado = -1;
		float resEmpleado = Empleado.CalculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}
}