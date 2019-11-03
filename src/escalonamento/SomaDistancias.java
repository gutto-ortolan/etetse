package escalonamento;

/**
 *
 * @author augusto.ortolan
 */
public class SomaDistancias {
    
    private static Integer numeroInteiroPositivo(Integer n1, Integer n2){
        Integer numeroInteiro = Math.abs(n1 - n2);
        return numeroInteiro;
    }
    
    public static Integer soma(Integer inicial, Integer numeros[]){
        Integer verificador = numeros.length - 1;
        Integer total = numeroInteiroPositivo(inicial, numeros[0]);
        
        for(int i = 0; i < verificador; i++){
            total += Math.abs(numeros[i] - numeros[i+1]);
        }
        
        System.out.println("\n\n=========================================================\nNúmero inicial: "+inicial+"\n");
        System.out.print("Elementos: | ");
        for (Integer numero : numeros) { System.out.print(numero+" | "); }
        System.out.println("\n");
        System.out.println("Soma das distâncias: "+total+"\n=========================================================\n");
        
        return total;
    }
    
}
