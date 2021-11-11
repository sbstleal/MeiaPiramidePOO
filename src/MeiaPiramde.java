//Importação para usar Lista de Arrays.
import java.util.ArrayList;

public class MeiaPiramde {

	public static void main(String[] args) {

		// SEBASTIÃO LEAL ADS P1, RGM: 27596613
		
		// Declarando a variável string que será quebrada.
		String str = "95 61 40 62 75 83 51 97 111 32 56 12 400 331 11";
		
		// Declarando as variaveis inteiras que percorrem os loops.
		int contSpc = 0, size = 0, somaMenor = 0, qtNum = 0;
		
		// Declarando o vetor para os espaços que será usado.
		int[] spc = new int[100];

		// Lista dos numeros.
		ArrayList<Integer> lista = new ArrayList<>();
		// Lista dos menores.
		ArrayList<Integer> menores = new ArrayList<>();

		// Adicionando primeiro numero da string até o primeiro espaço da lista.
		lista.add(Integer.parseInt(str.substring(0, str.indexOf(" ")))); 
		
		// Criando Loop para adicionar espaçamento no vetor conforme tamanho da string (com contagem).
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				spc[contSpc] = i;
				contSpc++;
			}
		}

		// Criando Loop para percorrer todo vetor e adicionar os números na lista (verificando qual é o ultimo).
		for (int i = 0; i < spc.length; i++) {
			if (spc[i] != 0) {
				int index = spc[i] + 1;
				int num;// Adicionar os demais numeros.
				if (i == contSpc - 1) {
					num = Integer.parseInt(str.substring(index));
				} else {
					num = Integer.parseInt(str.substring(index, spc[i + 1]));
				}
				lista.add(num); // Identificar o ultimo número da lista.
			}

		}
		
		// Mostrando alguns resultados iniciais
		
		System.out.println("Dados iniciais: \n");
		System.out.println("Quantidade: " + (contSpc + 1));
		System.out.println("String: " + str);
		System.out.println("Lista da String quebrada: " + lista + "\n");
		System.out.println("===================\n");
		System.out.println("-- MEIA PIRAMIDE --\n");

		// Criando Loop para visualizar a piramide
		while (size < lista.size()) {
			int menor = 0;

			System.out.print("[");

			// Criando Loop para verificar o menor número além também de somar os menores.
			for (int i = 0; i <= qtNum; i++) {
				if (size < lista.size()) { // Validando tamanho para continuar piramide
					if (i == qtNum) { // Validando o ultimo número.
						if (size == 0) { // Primeiro número.
							menor = lista.get(size);
							System.out.print(lista.get(size));
						} else { // Ultimo número.
							System.out.print(lista.get(size));
							if (lista.get(size) < menor)
								menor = lista.get(size);
						}
					} else {
						if (i == 0) {
							menor = lista.get(size);
						} else {
							if (lista.get(size) < menor)
								menor = lista.get(size);
						}
						System.out.print(lista.get(size) + ", ");
					}
					size++;
				}
			}
			System.out.println("]");
			// Adicionando a lista de menores valores.
			menores.add(menor);
			// Soma de menores valores variavel externa.
			somaMenor += menor;
			qtNum++;
		}

		// Mostrando o resultado solicitado, menores valores e soma deles.
		System.out.println("\n===================\n");
		
		System.out.println("Dados solicitados: \n");
		System.out.println("Os menores valores: " + menores);
		System.out.print("A soma dos menores valores resultou em " + somaMenor + ".");
	}
}