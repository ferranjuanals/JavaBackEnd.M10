package nivell1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
		
		// Nivell 2
		System.out.println("Nivell 2");
		String[] lletresNumeros = {"efectivament", "aquest", "2021", "no", "serà", "diferent", "al", "2020"};

		// Ordenar per el número de lletres en ordre ascendent
		System.out.println("1.");
		Arrays.stream(lletresNumeros)
			.sorted(Comparator.comparingInt(String::length))
			.forEach(System.out::println);

		// Ordenar per el número de lletres en ordre descendent
		System.out.println("2.");
		Arrays.stream(lletresNumeros)
			.sorted(Comparator.comparingInt(String::length).reversed())
			.forEach(System.out::println);

		// Ordenar pel primer caràcter
		System.out.println("3.");
		Arrays.stream(lletresNumeros)
			.sorted(Comparator.comparing(s -> s.charAt(0)))
			.forEach(System.out::println);

		// Ordenar les cadenes que contenen 'e' primer
		System.out.println("4.");
		Arrays.stream(lletresNumeros)
			.sorted(Comparator.comparingInt(s -> (s.contains("E") | s.contains("e") ? 0:1)))
			.forEach(System.out::println);

		// Modificar les cadenes canviant el caràcter "a" per "4"
		System.out.println("5.");
		Arrays.stream(lletresNumeros)
			.forEach(s -> System.out.println(s.replaceAll("a", "4")));

		// Mostra les cadenes que siguin numèriques
		System.out.println("6.");
		Arrays.stream(lletresNumeros)
			.filter(s -> s.chars().allMatch(Character::isDigit))
			.forEach(System.out::println);
		
		// Injecta a la interfície amb una lambda el cos del mètode per poder transformar la operació en suma, resta, multiplicació i divisió
		System.out.println("7.");
		Ope ope = (s, i1, i2) -> {
			if(s.equals("suma")) {
				return i1 + i2;
			}else if(s.equals("resta")) {
				return i1 - i2;
			}else if(s.equals("multiplicacio")) {
				return i1 * i2;
			}else if(s.equals("divisio")) {
				return i1 / i2;
			}else {
				System.out.println("La operació no s'ha dut a terme");
				return 0;
			}
		};
		System.out.println(ope.operacio("suma", 3, 8));
    
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
		
		// Mostra els alumnes que tinguin una nota més gran de 5
		System.out.println("3.");
		alumnes.stream()
			.filter(a -> a.getNota() >= 5)
			.forEach(System.out::println);
		
		// Mostra els alumnes que tinguin una nota més gran de 5 i no siguin "PHP"
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
// Functional Interface amb el mètode abstracte operacio()
@FunctionalInterface
interface Ope {
	public float operacio(String string, float int1, float int2);
}
