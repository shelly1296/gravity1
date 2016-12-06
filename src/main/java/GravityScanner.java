/**
 * 
 */


import java.util.Scanner;

/**
 * @author gamep_000
 *
 */
public class GravityScanner {

	public GravityScanner() {

	}

	public ScannerDto getFromScanner(boolean askZ) {
		ScannerDto scannerDto = new ScannerDto();
		Scanner scanner = new Scanner(System.in);
		try {
			scannerDto.setDeltaT(ask(scanner, "Enter value for t:"));
			scannerDto.setxComponent(ask(scanner, "Enter value for x:"));
			scannerDto.setyComponent(ask(scanner, "Enter value for y:"));
			if (askZ) {
				scannerDto.setzComponent(ask(scanner, "Enter value for z:"));
			}
			

		} finally {
			scanner.close();
		}
		return scannerDto;
	}

	private Double ask(Scanner scanner, String message) {
		System.out.println(message);
		System.out.println("");
		Double retDouble = scanner.nextDouble();

		return retDouble;
	}

}