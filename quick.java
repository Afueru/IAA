import java.util.Scanner;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;

public class quick {
	public static void main (String [] args) throws IOException {
		File mil  = new File("D:\\Faculdade\\EP IAA\\Arrays\\1K");
		File dez = new File ("D:\\Faculdade\\EP IAA\\Arrays\\10K");
		File cem = new File ("D:\\Faculdade\\EP IAA\\Arrays\\100K");
		File milhao = new File ("D:\\Faculdade\\EP IAA\\Arrays\\1M");
	    mexe(mil,1);
	    mexe(dez,251);
	    mexe(cem,501);
	    mexe(milhao,751);
}

	public static void mexe (File dir,int n) throws IOException {
		File [] files = dir.listFiles();
		long il = System.nanoTime();
		for (File file : files) {
		if (file.isFile()) {
        Scanner ler = new Scanner(file);
        int tipo = ler.nextInt();
  		int [] A = new int [tipo];
        for (int i = 0; i < A.length; i++) {
            A[i] = ler.nextInt();
        }
        long tempoleitura = System.nanoTime() - il;
		long comeco = System.nanoTime();				
		quicksort(A,0,A.length-1);
		long tempo = System.nanoTime() - comeco;
		System.out.println(file.getName() + " Tamanho: " + tipo + " elementos Tempo de leitura: " + tempoleitura  + " Tempo de processamento: " + tempo + " i7-4770-3.4GHz-SSD-120G-16G RAM-GDDR3 "+" Array " + n + " quick_sort " + "java 1.8.0_231 " + "WINDOWS10 64_bit nao_ordenado " + "Numero USP: 11208291 ");
		n++;
		ler.close();	
	    }
		}
	}
	
	public static void quicksort (int [] A,int esq, int dir) {
		if (esq < dir) {
			int j = ordenar(A,esq,dir);
			quicksort(A,esq,j-1);
			quicksort(A,j+1,dir);	
		}		
	}
	public static int ordenar (int [] A, int esq, int dir) {
		int i = esq + 1;
		int j = dir;
		int p = A[esq];
		while (i <= j) {
			if (A[i] <= p) i++;
			else if (A[j] > p) j--;
			else if (i <= j) {
				troca(A,i,j);
				i++;
				j--;
			}
		}
		troca(A,esq,j);
		return j;	
	}
	public static void troca (int [] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;	
	}
	public static void imprimeArray (int [] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println("A[" + (i + 1) + "] = " + A[i]);
		}
	}
}
