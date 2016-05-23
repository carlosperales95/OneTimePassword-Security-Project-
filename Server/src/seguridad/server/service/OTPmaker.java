package seguridad.server.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class OTPmaker {

	
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
		
		/**System.out.println("Convertimos el nick + la password de String a entero:");
		System.out.println("User con nick '" + userNick + "' y password '" + userPasswrod + "'");
		System.out.println("Lo concatenamos '" + nombre + "' y lo convertimos en byte[]");
		System.out.println("En String: " + nombre + " --> en byte[]: " + passByte.toString());**/
		
		for (int i = 0; i < passByte.length; i++) {
			nickPassInt += passByte[i];
		}

		// paso 2.
		int min = LocalDateTime.now().getMinute();
		for (int i = 0; i < 4; i++) {

			fechas.add(((LocalDateTime.now().getMonthValue() * 1000000)
					+ (LocalDateTime.now().getDayOfMonth() * 10000) + (LocalDateTime.now().getHour() * 100) + min));

			if (min == 0) {
				min = 59;
			} else
				min--;
		}
		
		for (int i = 0; i < 4; i++) {

			fechas.add(((LocalDateTime.now().getMonthValue() * 1000000)
					+ (LocalDateTime.now().getDayOfMonth() * 10000) + (LocalDateTime.now().getHour() * 100) + min));

			if (min == 59) {
				min = 0;
			} else
				min++;
		}

		fechas.add(((LocalDateTime.now().getMonthValue() * 1000000)
					+ (LocalDateTime.now().getDayOfMonth() * 10000) + (LocalDateTime.now().getHour() * 100) + (LocalDateTime.now().getMinute())));

		for (int j = 0; j < 9; j++) {

			// paso 3.
			semilla = nickPassInt + fechas.get(j);

			// paso 4.
			random = new Random(semilla);
			numRandom = random.nextInt(999999 - 0 + 1) + 0;

			// paso 5.
			alfabetoa[0] = 'a';
			for (int i = 1; i < 26; i++) {
				alfabetoa[i] = (char) ('a' + i);
			}

			alfabetoA[0] = 'A';
			for (int i = 1; i < 26; i++) {
				alfabetoA[i] = (char) ('A' + i);
			}

			for (int i = 0; i < 52; i++) {
				if (i < 26) {
					alfabeto[i] = alfabetoa[i];
				} else
					alfabeto[i] = alfabetoA[i - 26];
			}

			// 3 digitos aleatorios y distintos 1-6
			do {
				digito1 = random.nextInt(5 - 0 + 1) + 0;
				digito2 = random.nextInt(5 - 0 + 1) + 0;
				digito3 = random.nextInt(5 - 0 + 1) + 0;

			} while (digito1 == digito2 || digito2 == digito3 || digito1 == digito3);

			// paso el numero random a string
			otp = Integer.toString(numRandom);

			// cambio esos 3 digitos por e letras minus o mayus
			digitos1 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
			digitos2 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
			digitos3 = alfabeto[random.nextInt(51 - 0 + 1) + 0];
			
			// sustituyo en el string otp estas chars en su digito correspondiente 
			char[] otpTemp = otp.toCharArray();
			otpTemp[digito1] = digitos1;
			otpTemp[digito2] = digitos2;
			otpTemp[digito3] = digitos3;
			otp = "";
			
			for (int i = 0; i < otpTemp.length; i++) {
				otp += otpTemp[i];
			}

			otps.add(otp);
		}
		return otps;
	}

	public boolean checkOTP(String username, String password, String otp) {
		System.out.println("Checking otp");
		boolean ok = false;
		ArrayList<String> otps = new ArrayList<String>();
		new OTPmaker();
		otps = OTPmaker.geneterateOTP2(username, password);
		for (int i = 0; i < otps.size(); i++) {
			System.out.println(otp + "=" + otps.get(i) + " ?");
			if (otp.equals(otps.get(i)))
				ok = true;
		}
		return ok;
	}
}