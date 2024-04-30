package ATV;
import javax.swing.JOptionPane;
/**
 *
 * @author 00254699
 */
public class Atividade1Paulinho {

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade de números:"));
        int[] numeros = new int[n];
        JOptionPane.showMessageDialog(null, "Insira os números:");
        for (int i = 0; i < n; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Número " + (i + 1) + ":"));
        }
        
        StringBuilder numerosOrdenados = new StringBuilder("Números ordenados:\n");
        for (int num : numeros) {
            numerosOrdenados.append(num).append(" ");
        }
        JOptionPane.showMessageDialog(null, numerosOrdenados.toString());
        int numeroBusca = Integer.parseInt(JOptionPane.showInputDialog("Insira o número a ser pesquisado:"));
        int posicao = buscaLinear(numeros, numeroBusca);
        if (posicao != -1) {
            JOptionPane.showMessageDialog(null, "O número " + numeroBusca + "\n foi encontrado na posição [" + (posicao + 1) + "].");
        } else {
            JOptionPane.showMessageDialog(null, "O número  " + numeroBusca + "\n não foi encontrado na lista.");
        }
    }

    public static void ordenacaoBolha(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static int buscaLinear(int[] arr, int alvo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == alvo) {
                return i;
            }
        }
        return -1;
    }
}