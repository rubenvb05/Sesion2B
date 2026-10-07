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

	// 1: Vendedor
	@Test
	void testVendedor() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1000;
		float horas = 0;
		
		float resultado = 2000 + 100;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 2: Encargado
	@Test
	void testEncargado() {
		TipoEmpleado tipo = TipoEmpleado.Encargado;
		float ventas = 1000;
		float horas = 0;
		
		float resultado = 2500 + 100;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 3: Otro
	@Test
	void testOtro() {
		TipoEmpleado tipo = TipoEmpleado.otro;
		float ventas = 1000;
		float horas = 0;
		
		float resultado = -1;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 4: VentasMes < 1000
	@Test
	void testVentasMenor1000() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 999;
		float horas = 0;
		
		float resultado = 2000;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 5: VentasMes entre 1000 y 1500
	@Test
	void testVentasEntre1000y1500() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1499;
		float horas = 0;
		
		float resultado = 2000 + 100;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 6: VentasMes >= 1500
	@Test
	void testVentasMayor1500() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1500;
		
		float horas = 0;
		
		float resultado = 2000 + 200;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 7: VentasMes Negativas
	@Test
	void testVentasNegativas() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = -1;
		float horas = 0;
		
		float resultado = -1;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 8: Sí hay horas extra
	@Test
	void testHorasExtraPositivas() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1000;
		float horas = 1;
		
		float resultado = 2000 + 100 + (30 * 1);
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 9: No hay horas extra (Negativas)
	@Test
	void testHorasExtraNegativas() {
		TipoEmpleado tipo = TipoEmpleado.Vendedor;
		float ventas = 1000;
		float horas = -1;
		
		float resultado = -1;
		float resEmpleado = Empleado.calculoNominaBruta(tipo, ventas, horas);
		
		assertEquals(resultado, resEmpleado);
	}

	// 10: Nómina neta < 2100
	@Test
	void testNominaNetaMenor2100() {
		float nomina = 2099;
		
		float resultado = 2099;
		float resEmpleado = Empleado.calculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}

	// 11: Nómina neta entre 2100 y 2500
	@Test
	void testNominaNetaEntre2100y2500() {
		float nomina = 2101;
		
		float resultado = 2101 * (1 - 0.15f);
		float resEmpleado = Empleado.calculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}

	// 12: Nómina neta >= 2500
	@Test
	void testNominaNetaMayor2500() {
		float nomina = 2500;
		
		float resultado = 2500 * (1 - 0.18f);
		float resEmpleado = Empleado.calculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}

	// 13: Nómina neta negativa
	@Test
	void testNominaNetaNegativa() {
		float nomina = -1;
		
		float resultado = -1;
		float resEmpleado = Empleado.calculoNominaNeta(nomina);
		
		assertEquals(resultado, resEmpleado);
	}
}