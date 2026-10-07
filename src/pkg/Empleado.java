package pkg;

public class Empleado {

	public enum TipoEmpleado { Vendedor, Encargado, otro };

	public static float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float sueldo = 0;

		if (tipo == TipoEmpleado.Encargado) {
			sueldo = 2500;
		}
		else if (tipo == TipoEmpleado.Vendedor) {
			sueldo = 2000;
		}
		else return -1;

		if (ventasMes < 0) {
			return -1;
		}
		else if (ventasMes >= 1500) {
			sueldo += 200;
		}
		else if (ventasMes >= 1000) {
			sueldo += 100;
		}

		if (horasExtra >= 0)
			sueldo = sueldo + 30 * horasExtra;
		else return -1;

		return sueldo;
	}

	public static float calculoNominaNeta(float nominaBruta) {
		float retencion = 0f;

		if (nominaBruta >= 2500)
			retencion = 0.18f;
		else if (nominaBruta > 2100)
			retencion = 0.15f;
		else if (nominaBruta < 0)
			return -1;

		return nominaBruta * (1 - retencion);
	}
}