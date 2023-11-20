package prova;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		HashMap<String, Integer> ingredienti = new HashMap<>();
		ingredienti.put("Uova", 70);
		ingredienti.put("Latte", 200);
		ingredienti.put("Zucchero", 180);
		ingredienti.put("Farina", 80);
		ingredienti.put("Panna alla vaniglia", 100);
		ingredienti.put("Acqua", 0);
		ingredienti.put("Sale", 15);
		ingredienti.put("Pomodoro", 60);
		ingredienti.put("Pasta al grano Saraceno", 120);
		ingredienti.put("Carne di Wagyu", 300);
		ingredienti.put("Rosmarino", 20);

		HashMap<String, Integer> ricetta = new HashMap<>();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Benvenuto nel Pignatario: ");

		System.out.println("Nome della ricetta: ");
		String nomeRicetta = scanner.nextLine();

		boolean aggiungi = true;

		while (aggiungi) {
			System.out.println("\nGli ingredienti disponibili sono questi: ");

			for (String ingrediente : ingredienti.keySet()) {
				System.out.println(ingrediente);
			}

			System.out.println("\nInserisci l'ingrediente da aggiungere e la quantità (Gr/Ml): ");
			String nomeIngrediente = scanner.nextLine().replaceAll("\\s", "").toLowerCase();

			if (nomeIngrediente.equals("")) {
				System.out.println("Errore: nome ingrediente non valido.");
				continue;
			}

			int quantita = 0;
			boolean inputValido = false;

			while (!inputValido) {
				String input = scanner.nextLine();
				if (input.matches("\\d+")) {
					quantita = Integer.parseInt(input);
					inputValido = true;
				} else {
					System.out.println("Errore: inserire un numero intero per la quantità.");
				}
			}

			ricetta.put(nomeIngrediente, quantita);

			System.out.println("\nVuoi aggiungere altri ingredienti? (Si/No)");
			String risposta = scanner.nextLine();
			while (!risposta.equalsIgnoreCase("Si") && !risposta.equalsIgnoreCase("No")) {
				System.out.println("Errore: inserire 'Si' o 'No'.");
				risposta = scanner.nextLine();
			}

			if (risposta.equalsIgnoreCase("No")) {
				aggiungi = false;
			}
		}

		int calorieTot = 0;

		for (String ingr : ricetta.keySet()) {
			if (ingredienti.containsKey(ingr)) {
				int qta = ricetta.get(ingr);
				int tipoCalorie = ingredienti.get(ingr);
				int calorieSingole = tipoCalorie * qta;
				calorieTot += calorieSingole;
			} else {
				System.out.println("Ingredient not found: " + ingr);
			}
		}

		System.out.println("La tua ricetta è: ");
		for (String ingr : ricetta.keySet()) {
			int qta = ricetta.get(ingr);
			System.out.println(qta + " " + ingr);
		}
	}
}