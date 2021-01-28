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
		List<String> mesos = Arrays.asList("Gener", "Febrer", "Mar�", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre");
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
		
		// Nivell 3
		System.out.println("Nivell 3");
		// Crear la llista d'alumnes i omplir-la
		List<Alumne> alumnes = new ArrayList<Alumne>();
		alumnes.add(new Alumne("Joan", 34, "JAVA", 7));
		alumnes.add(new Alumne("Manel", 26, "JAVASCRIPT", 4));
		alumnes.add(new Alumne("Maria", 46, "PYTHON", 8));
		alumnes.add(new Alumne("Andrea", 21, "JAVA", 9));
		alumnes.add(new Alumne("Antoni", 29, "PHP", 7));
		alumnes.add(new Alumne("Silvia", 35, "PYTHON", 7));
		alumnes.add(new Alumne("Ernest", 58, "PHP", 3));
		alumnes.add(new Alumne("Marta", 34, "JAVA", 5));
		alumnes.add(new Alumne("Carles", 28, "JAVASCRIPT", 6));
		alumnes.add(new Alumne("Anna", 42, "JAVA", 4));
		
		// Mostrar nom i edat de cada alumne
		System.out.println("1.");
		alumnes.stream()
			.forEach(a -> System.out.println("Nom: " + a.getNom() + ", Edat: " + a.getEdat()));
		
		// Mostrar els alumnes que el nom comenci per "A" en una nova llista
		System.out.println("2.");
		List<Alumne> alumnesA = new ArrayList<Alumne>();
		alumnes.stream()
			.filter(a -> a.getNom().startsWith("A"))
			.peek(b -> alumnesA.add(b))
			.forEach(c -> System.out.println(c));
		
		// Mostra els alumnes que tinguin una nota m�s gran de 5
		System.out.println("3.");
		alumnes.stream()
			.filter(a -> a.getNota() >= 5)
			.forEach(System.out::println);
		
		// Mostra els alumnes que tinguin una nota m�s gran de 5 i no siguin "PHP"
		System.out.println("4.");
		alumnes.stream()
			.filter(a -> a.getNota() >= 5 & !a.getCurs().equals("PHP"))
			.forEach(System.out::println);
		
		// Mostra els alumnes que facin "JAVA" i siguin majors d'edat
		System.out.println("5.");
		alumnes.stream()
			.filter(a -> a.getCurs().equals("JAVA") & a.getEdat() > 18)
			.forEach(System.out::println);
	}
	// Retorna els noms que comencen per "A" i tenen 3 lletres
	public static List<String> filtraNoms(List<String> llistaNoms) {
		List<String> llista =
				llistaNoms.stream()
					.filter(x -> x.startsWith("A") & x.length() == 3)
					.collect(Collectors.toList());		
		return llista;
	}
	// Retorna un String amb els n�meros parells precedits de "e" i els imparells de "o"
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
	// Retorna les paraules de m�s de 5 lletres en una llista
	public static List<String> paraules5(List<String> paraules) {
		List<String> paraules5 =
				paraules.stream()
					.filter(x -> x.length() > 5)
					.collect(Collectors.toList());
		return paraules5;
	}
	
}
// Functional Interface amb el m�tode abstracte getPiValue()
@FunctionalInterface
interface FunInter {
	public double getPiValue();
}
// Functional Interface amb el m�tode abstracte reverse()
@FunctionalInterface
interface Rev {
	public String reverse(String string);
}
