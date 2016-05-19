package seguridad.server.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class OTPmaker {

	private static boolean conectadoServerClient = true;

	public static void main(String[] args) {

		if (conectadoServerClient) {
			String otp = geneterateOTP("astrain25", "astrain25");
			System.out.println(otp);
			new ArrayList<>();
			// otps = geneterateOTP2("astrain25", "astrain25");
			conectadoServerClient = checkOTP("astrain25", "astrain25", otp);
			System.out.println(" ");
			System.out.println(otp);
			System.out.println(conectadoServerClient);
		}

	}

	public static String geneterateOTP(String userNick, String userPasswrod) {
		String otp;
		String nombre = userNick + userPasswrod;
		byte[] passByte = nombre.getBytes();
		int nickPassInt = 0, semilla = 0, numRandom = 0, fecha = 0;
		Random random;
		char[] alfabetoa = new char[26];
		char[] alfabetoA = new char[26];
		char[] alfabeto = new char[52];
		int digito1 = 0, digito2 = 0, digito3 = 0;
		char digitos1, digitos2, digitos3;

		// paso 1.
		System.out.println("--->Generando OTP<--");
		System.out.println("    -------------");
		System.out.println(" ");
		System.out.println("Convertimos el nick + la password de String a entero:");
		System.out.println("User con nick '" + userNick + "' y password '" + userPasswrod + "'");
		System.out.println("Lo concatenamos '" + nombre + "' y lo convertimos en byte[]");
		System.out.println("En String: " + nombre + " --> en byte[]: " + passByte.toString());
		for (int i = 0; i < passByte.length; i++) {
			nickPassInt += passByte[i];
		}
		System.out.println("En en byte[]: " + passByte.toString() + " --> en int  " + nickPassInt);
		System.out.println(" ");

		// paso 2.
		fecha = (LocalDateTime.now().getMonthValue() * 1000000) + (LocalDateTime.now().getDayOfMonth() * 10000)
				+ (LocalDateTime.now().getHour() * 100) + LocalDateTime.now().getMinute();
		System.out.println("Ahora, cogemos la fecha actual--> mes: " + (LocalDateTime.now().getMonthValue()) + ", dia: "
				+ (LocalDateTime.now().getDayOfMonth()) + ", hora: " + (LocalDateTime.now().getHour()) + ", mins: "
				+ LocalDateTime.now().getMinute());
		System.out.println("Y la concatenamos '" + fecha + "'");
		System.out.println(" ");

		// paso 3.
		semilla = nickPassInt + fecha;
		System.out.println("A continuacion, sumamos el int userNick-userPassword y el int fechasActual: " + nickPassInt
				+ "+" + fecha + "=" + (semilla));

		// paso 4.
		System.out.println("Generando numero random (de 6 digitos) con semilla del random " + semilla);
		random = new Random(semilla);
		// Numero entero entre 0 y 999999, esto es, int de 4 digitos
		numRandom = random.nextInt(999999 - 0 + 1) + 0;

		System.out.println("Gerenando random.... " + numRandom);

		// paso 5.
		// alfabeto
		alfabetoa[0] = 'a';
		for (int i = 1; i < 26; i++) {
			alfabetoa[i] = (char) ('a' + i);
		}
		System.out.println();

		alfabetoA[0] = 'A';
		for (int i = 1; i < 26; i++) {
			alfabetoA[i] = (char) ('A' + i);
		}
		System.out.println(" ");
		System.out.print("El alfabeto completo es: ");

		for (int i = 0; i < 52; i++) {
			if (i < 26) {
				alfabeto[i] = alfabetoa[i];
			} else
				alfabeto[i] = alfabetoA[i - 26];

			System.out.print(alfabeto[i] + ",");
		}
		System.out.println(" ");
		// 3 digitos aleatorios y distintos 1-6
		do {
			digito1 = random.nextInt(5 - 0 + 1) + 0;
			digito2 = random.nextInt(5 - 0 + 1) + 0;
			digito3 = random.nextInt(5 - 0 + 1) + 0;

		} while (digito1 == digito2 || digito2 == digito3 || digito1 == digito3);
		System.out.println("Digitos aleatorios entre el 1 y el 6: " + digito1 + ", " + digito2 + ", " + digito3);

		// paso el numero random a string
		otp = Integer.toString(numRandom);

		// cambio esos 3 digitos por e letras minus o mayus

		digitos1 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
		digitos2 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
		digitos3 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
		System.out
				.println("Las 3 chars nuevas a introducir en el otp: " + digitos1 + ", " + digitos2 + ", " + digitos3);
		// sustituyo en el string otp estas chars en su digito correspondiente
		char[] otpTemp = otp.toCharArray();
		otpTemp[digito1] = digitos1;
		otpTemp[digito2] = digitos2;
		otpTemp[digito3] = digitos3;
		otp = "";
		for (int i = 0; i < otpTemp.length; i++) {
			otp += otpTemp[i];
		}
		System.out.println("OTP FINAL--------->" + otp);
		return otp;

	}

	public static ArrayList<String> geneterateOTP2(String userNick, String userPasswrod) {
		String otp;
		String nombre = userNick + userPasswrod;
		byte[] passByte = nombre.getBytes();
		int nickPassInt = 0, semilla = 0, numRandom = 0;
		ArrayList<Integer> fechas = new ArrayList<>();
		ArrayList<String> otps = new ArrayList<>();
		Random random;
		char[] alfabetoa = new char[26];
		char[] alfabetoA = new char[26];
		char[] alfabeto = new char[52];
		int digito1 = 0, digito2 = 0, digito3 = 0;
		char digitos1, digitos2, digitos3;

		// paso 1.
		System.out.println("--->Generando OTPS<--");
		System.out.println("    -------------");
		System.out.println(" ");
		System.out.println("Convertimos el nick + la password de String a entero:");
		System.out.println("User con nick '" + userNick + "' y password '" + userPasswrod + "'");
		System.out.println("Lo concatenamos '" + nombre + "' y lo convertimos en byte[]");
		System.out.println("En String: " + nombre + " --> en byte[]: " + passByte.toString());
		for (int i = 0; i < passByte.length; i++) {
			nickPassInt += passByte[i];
		}
//		System.out.println("En en byte[]: " + passByte.toString() + " --> en int  " + nickPassInt);
//		System.out.println(" ");

		// paso 2.
		int min = LocalDateTime.now().getMinute();
		for (int i = 0; i < 10; i++) {

			fechas.add(i, ((LocalDateTime.now().getMonthValue() * 1000000)
					+ (LocalDateTime.now().getDayOfMonth() * 10000) + (LocalDateTime.now().getHour() * 100) + min));

//			System.out.println("fecha  " + i + ": " + fechas.get(i) + "'");
			if (min == 0) {
				min = 59;
			} else
				min--;
		}

//		System.out.println(" ");

		for (int j = 0; j < 10; j++) {

			// paso 3.
			semilla = nickPassInt + fechas.get(j);
//			System.out.println("A continuacion, sumamos el int userNick-userPassword y el int fechasActual: "
//					+ nickPassInt + "+" + fechas.get(j) + "=" + (semilla));

			// paso 4.
//			System.out.println("Generando numero random (de 6 digitos) con semilla del random " + semilla);
			random = new Random(semilla);
			// Numero entero entre 0 y 999999, esto es, int de 4 digitos
			numRandom = random.nextInt(999999 - 0 + 1) + 0;

//			System.out.println("Gerenando random.... " + numRandom);

			// paso 5.
			// alfabeto
			alfabetoa[0] = 'a';
			for (int i = 1; i < 26; i++) {
				alfabetoa[i] = (char) ('a' + i);
			}
			System.out.println();

			alfabetoA[0] = 'A';
			for (int i = 1; i < 26; i++) {
				alfabetoA[i] = (char) ('A' + i);
			}
//			System.out.println(" ");
//			System.out.print("El alfabeto completo es: ");

			for (int i = 0; i < 52; i++) {
				if (i < 26) {
					alfabeto[i] = alfabetoa[i];
				} else
					alfabeto[i] = alfabetoA[i - 26];

//				System.out.print(alfabeto[i] + ",");
			}
//			System.out.println(" ");
			// 3 digitos aleatorios y distintos 1-6
			do {
				digito1 = random.nextInt(5 - 0 + 1) + 0;
				digito2 = random.nextInt(5 - 0 + 1) + 0;
				digito3 = random.nextInt(5 - 0 + 1) + 0;

			} while (digito1 == digito2 || digito2 == digito3 || digito1 == digito3);
//			System.out.println("Digitos aleatorios entre el 1 y el 6: " + digito1 + ", " + digito2 + ", " + digito3);

			// paso el numero random a string
			otp = Integer.toString(numRandom);

			// cambio esos 3 digitos por e letras minus o mayus

			digitos1 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
			digitos2 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
			digitos3 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
//			System.out.println(
//					"Las 3 chars nuevas a introducir en el otp: " + digitos1 + ", " + digitos2 + ", " + digitos3);
			// sustituyo en el string otp estas chars en su digito
			// correspondiente
			char[] otpTemp = otp.toCharArray();
			otpTemp[digito1] = digitos1;
			otpTemp[digito2] = digitos2;
			otpTemp[digito3] = digitos3;
			otp = "";
//			System.out.println(otp);
			for (int i = 0; i < otpTemp.length; i++) {
				otp += otpTemp[i];
			}
//			System.out.println("OTP FINAL--------->" + otp);
//			System.out.println(" ..........." + j + "................");
			otps.add(otp);
		}
		System.out.println("otps: " + otps.toString());
		return otps;
	}

	public static boolean checkOTP(String username, String password, String otp) {
		System.out.println("checking otp");
		boolean ok = false;
		ArrayList<String> otps = new ArrayList<String>();
		new OTPmaker();
		otps = OTPmaker.geneterateOTP2(username, password);
		for (int i = 0; i < otps.size(); i++) {
			System.out.println(otp + "=" + otps.get(i) + "?");
			if (otp.equals(otps.get(i)))
				ok = true;
		}

		return ok;
	}
}