package nivell1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
		// Fase 1
		// 1
		List<String> nomsPropis = Arrays.asList("Anna", "Olga", "Ada", "Andreu", "Albert", "Pau");
		System.out.println("1.");
		System.out.println(filtraNoms(nomsPropis));
		
		// 2
		List<Integer> numeros = Arrays.asList(1, 33, 223, 2, 95, 45, 545, 46, 26);
		System.out.println("2.");
		System.out.println(parellsImparells(numeros));
		
		// 3
		List<String> paraules = Arrays.asList("hola", "amics", "meus", "com", "us", "trobeu");
		System.out.println("3.");
		System.out.println(paraulesO(paraules));
		
		// 4
		System.out.println("4.");
		System.out.println(paraules5(paraules));
		
		// 5
		List<String> mesos = Arrays.asList("Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre");
		System.out.println("5.");
		mesos.forEach(s -> System.out.println(s));
		
		// 6
		System.out.println("6.");
		mesos.forEach(System.out::println);
		
		// Fase 2
		System.out.println("Fase 2");
		FunInter pi = () -> 3.1415;
		System.out.println(pi.getPiValue());	
		
		// Fase 3
		System.out.println("Fase 3");
		Rev rev = s -> new StringBuilder(s).reverse().toString();
		System.out.println(rev.reverse("String"));
	}
	// Retorna els noms que comencen per "A" i tenen 3 lletres
	public static List<String> filtraNoms(List<String> llistaNoms) {
		List<String> llista =
				llistaNoms.stream()
					.filter(x -> x.startsWith("A") & x.length() == 3)
					.collect(Collectors.toList());		
		return llista;
	}
	// Retorna un String amb els números parells precedits de "e" i els imparells de "o"
	public static String parellsImparells(List<Integer> numeros) {
		List<String> llistas = new ArrayList<>();		
		numeros.stream()
			.forEach(i -> {
				if(i % 2 == 0) {
					llistas.add("e" + i.toString());
				}else {
					llistas.add("o" + i.toString());
				}
			});		
		String cadena =
				llistas.stream()
				.collect(Collectors.joining(", "));		
		return cadena;
	}
	// Retorna les paraules que contenen la lletra "o" en una llista
	public static List<String> paraulesO(List<String> paraules) {
		List<String> paraulesO =
				paraules.stream()
					.filter(x -> x.contains("o"))
					.collect(Collectors.toList());		
		return paraulesO;
	}
	// Retorna les paraules de més de 5 lletres en una llista
	public static List<String> paraules5(List<String> paraules) {
		List<String> paraules5 =
				paraules.stream()
					.filter(x -> x.length() > 5)
					.collect(Collectors.toList());
		return paraules5;
	}
	
}
// Functional Interface amb el mètode abstracte getPiValue()
@FunctionalInterface
interface FunInter {
	public double getPiValue();
}
// Functional Interface amb el mètode abstracte reverse()
@FunctionalInterface
interface Rev {
	public String reverse(String string);
}
