import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        //escreva aqui o seu código

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int q = input.nextInt();

        int operacao = 0;
        int r = 0;
        int valor = 0;

        Integer [][] tabuleiro = new Integer[n][n];

        for(int k=0; k<n; k++){
            for(int j=0; j<n; j++){
                tabuleiro[k][j]=0;
            }
        }

        for (int k = 0; k < q; k++){

            operacao = input.nextInt();
            r = input.nextInt()-1;

            if(operacao == 1 || operacao == 2){
                valor = input.nextInt();
                if (operacao == 1){
                    for(int j=0; j<n; j++){
                        tabuleiro[r][j]=valor;
                    }
                }
                else {
                    for(int j=0; j<n; j++){
                        tabuleiro[j][r]=valor;
                    }
                }
            }
            else if(operacao == 3){


                List<Integer> list = Arrays.asList(tabuleiro[r]);

                Map<Integer, Long> frequencies = list.stream()
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

                long maxCount = frequencies.values().stream().mapToLong(Long::longValue).max().orElse(0);

                List<Integer> all = frequencies.entrySet().stream()
                        .filter(e -> e.getValue() == maxCount)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

                System.out.println(all.get(all.size()-1));
            }
            else if(operacao == 4){

                int coluna = r;

                List<Integer> list = Arrays.stream(tabuleiro).mapToInt(integers -> integers[coluna]).boxed().collect(Collectors.toList());

                Map<Integer, Long> frequencies = list.stream()
                        .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

                long maxCount = frequencies.values().stream().mapToLong(Long::longValue).max().orElse(0);

                List<Integer> all = frequencies.entrySet().stream()
                        .filter(e -> e.getValue() == maxCount)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

                System.out.println(all.get(all.size()-1));
            }

        }

    }
}