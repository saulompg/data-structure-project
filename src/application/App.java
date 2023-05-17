package application;

// CLASSE PRINCIPAL
public class App {
	
//	MÉTODO PRINCIPAL
	public static void main(String[] args) {
				
//		DEFININDO O CAMINHO DO ARQUIVO DE ENTRADA
		String sourceFile = "src/data/lista_original.csv";
		
//		DEFININDO O CAMINHO DO ARQUIVO DE SAÍDA
		String targetFile = "src/data/lista_ordenada.csv";
		
//		CRIANDO LISTA PARA ARMAZENAR OS DADOS
		Lista list = new Lista();

		
//		CHAMA A FUNÇÃO PARA LEITURA DO ARQUIVO CSV
		ArquivoCSV.read(sourceFile, list);
		
		try {
		
//			DEFINE A VARIÁVEL AUXILIAR
			int aux = Integer.parseInt(args[0]);
			
//			REGISTRA O TEMPO DO INÍCIO
			long start = System.currentTimeMillis();
			
			switch(aux) {
			
			case 1:
				
//				ORDENA A LISTA PELO MÉTODO BUBBLE SORT
				list.bubbleSort();
				System.out.println("LISTA ORDENADA PELO MÉTODO BUBBLE SORT");
				break;
			
			case 2:
				
//				ORDENA A LISTA PELO MÉTODO INSERTION SORT
				list.insertionSort();
				System.out.println("LISTA ORDENADA PELO MÉTODO INSERTION SORT");
				break;
				
			case 3:
				
//				ORDENA A LISTA PELO MÉTODO SELECTION SORT
				list.selectionSort();
				System.out.println("LISTA ORDENADA PELO MÉTODO SELECTION SORT");
				break;

			case 4:
				
//				ORDENA A LISTA PELO MÉTODO QUICK SORT
				list.quickSort();
				System.out.println("LISTA ORDENADA PELO MÉTODO QUICK SORT");
				break;
				
			case 5:
				
//				ORDENA A LISTA PELO MÉTODO MERGE SORT
				list.mergeSort();
				System.out.println("LISTA ORDENADA PELO MÉTODO MERGE SORT");
				break;

			default:
				
//				EXIBE MENSAGEM DO ERRO DE PARÂMETRO 
				System.err.println("O PARÂMETRO PASSADO PARA O PROGRAMA É INVÁLIDO!");
				return;
			
			}
			
//			REGISTRA O TEMPO DO TERMINO
	        long finish = System.currentTimeMillis();
	        
//			EXPORTA A LISTA ORDENADA PARA UM ARQUIVO CSV
	        ArquivoCSV.write(targetFile, list);
			
//			EXIBE A DURAÇÃO EM SEGUNDOS
			System.out.printf("O programa levou %.3f segundos para ordenar o arquivo.\n", (finish - start) / 1000.0);
			
//		O MENU COM AS OPÇÕES É EXIBIDO CASO NÃO SEJA PASSADO NENHUM PARÂMETRO PARA A FUNÇÃO
		} catch (ArrayIndexOutOfBoundsException ex) {
						
			System.out.println("PASSE UM PARÂMETRO NA CHAMADA DA FUNÇÃO PARA SELECIONAR O MÉTODO DE ORDENAÇÃO");
			System.out.println("> 1: Bubble Sort");
			System.out.println("> 2: Insertion Sort");
			System.out.println("> 3: Selection Sort");
			System.out.println("> 4: Quick Sort");
			System.out.println("> 5: Merge Sort");
		
//		CASO O PARÂMETRO PASSADO SEJA UM CARACTERE, É EXIBIDA A SEGUINTE MENSAGEM
		} catch (NumberFormatException e) {
			
			System.err.println("O PARÂMETRO PASSADO PARA O PROGRAMA É INVÁLIDO!");
			System.err.println("Tente passar como parâmetro um valor numérico!");			
			
		}
	
	}

}
