package seguridad.otpg.main;

import seguridad.otpg.gui.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OTPmaker extends TimerTask {

	private boolean isTimedOut = false;
	private static boolean conectadoServerClient = true;


	private static int otp = 0;

	private static long time1;
	private static long time2;
	private static long diferencia;

	public static void main(String[] args) {

	/*	String cad;
		Scanner teclado = new Scanner(System.in);

		// Se toma la hora en el inicio del programa
		
		System.out.print("Pulsa Intro para terminar.");

		// Se espera a que el usuario pulse intro
		cad = teclado.nextLine();

		// Se vuelve a tomar la hora una vez que ha pulsado Intro
		Calendar ahora2 = Calendar.getInstance();
		time2 = ahora2.getTimeInMillis();

		// Se calcula la diferencia de tiempo
		diferencia = time2 - time1;

		// Se muestra en pantalla la diferencia de tiempo obtenido
		System.out.println("Has tardado: " + diferencia + " milisegundos");
		System.out.printf("Equivale a: %.3f segundos", (double) diferencia / 1000);*/
		
		if (conectadoServerClient) {
			otp = geneterateOTPTime(9999);
			System.out.println(otp);
			otp = geneterateOTPPassword(9999, "fuckermaister");
			System.out.println(otp);

		}

		

	}

	public void run() {

		if (conectadoServerClient) {

		}
		isTimedOut = true;
	}

	public static int geneterateOTPTime(int userID) {
		System.out.println("--->Generando OTP en funcion de la hora actual<--");
		System.out.println("    ------------------------------------------");
		System.out.println(" ");
	
		
		int semilla = 0, otp = 0;
		Random random;
		int horaActual = (LocalDateTime.now().getHour() * 100) + LocalDateTime.now().getMinute();
		// suma hora mas mins de forma que quede HHMM
		System.out.println("La hora actual 'HHmm' es: " + horaActual);
		System.out.println("El Id de este usuario es: " + userID);
		semilla = horaActual + userID;
		System.out
				.println("Sumando la hora actual con el Id del usuario: " + horaActual + "+" + userID + "=" + semilla);
		System.out.println("Generando numero random (de 4 digitos) OTP con semilla del random " + semilla);
		random = new Random(semilla);
		// Numero entero entre 0 y 9999, esto es, int de 4 digitos
		otp = random.nextInt(9999 - 0 + 1) + 0;

		System.out.println("Gerenando random.... OTP=" + otp);
		return otp;

	}

	public static int geneterateOTPPassword(int userID, String passwrod) {
		System.out.println("--->Generando OTP en funcion de la password<--");
		System.out.println("    ---------------------------------------");
		byte[] passByte = passwrod.getBytes();
		int passInt = 0, semilla = 0;
		Random random;

		System.out.println("Convertimos la password de String a entero");
		System.out.println("Primero de String--> byte[] y despues de byte[]-->int");
		System.out.println("Password en String: " + passwrod + " --> en byte[]: " + passByte.toString());
		for (int i = 0; i < passByte.length; i++) {
			passInt += passByte[i];
		}
		System.out.println("Password en en byte[]: " + passByte.toString() + " --> en int  " + passInt);
		System.out.println("El Id de este usuario es: " + userID);
		semilla = passInt + userID;
		System.out
				.println("Sumando la passworn en int con el Id del usuario: " + passInt + "+" + userID + "=" + semilla);
		System.out.println("Generando numero random (de 4 digitos) OTP con semilla del random " + semilla);
		random = new Random(semilla);
		// Numero entero entre 0 y 9999, esto es, int de 4 digitos
		otp = random.nextInt(9999 - 0 + 1) + 0;

		System.out.println("Gerenando random.... OTP=" + otp);

		return passInt;
	}
}
