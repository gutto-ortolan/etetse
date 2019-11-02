package escalonamento;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augusto.ortolan
 */
public class Principal {

    private List<Integer> listaElementos = new ArrayList();
    private Integer elementos[];
    private Integer nrInicial;
    private final Integer limiteDisco = 200;
    private final Integer verificador = limiteDisco - 1;
    private Thread t;

    public void pedeNumeros() throws InterruptedException, IOException {
        /*
         * • Método em que o programa pede ao usuário a lista de números(separadas por ponto e vírgula)
         * e o número incial.
         * • É o início de todo o processo e captação dos dados para serem postos nas variáveis.
         */

        Scanner scan = new Scanner(System.in);

        //Pede a lista.
        System.out.print("Digite os números que queiras separados por ';' (Ponto e vírgula): ");
        String ordem = scan.nextLine();

        //Monta a lista dos números inseridos em STRING.
        List<String> numerosInseridos;
        numerosInseridos = Arrays.asList(ordem.split(";"));

        //Monta a lista dos números inseridos em INTEGER.
        List<Integer> numerosInseridosInteger;
        //Lists.transform é um método de uma biblioteca da Google, onde faz a conversão da lista de String para uma
        //lista de Integer.

        if (numerosInseridos.get(0).equals("")) {
            System.out.println("A lista está vazia.\nExecute o programa novamente e adicione os números que queiras");
            System.exit(0);
        }

        numerosInseridosInteger = Lists.transform(numerosInseridos, Integer::parseInt);

        //Passa a lista de Integer para a variável global.
        listaElementos = numerosInseridosInteger;

        //Pede o número inicial.
        System.out.print("Digite um número para ser o inicial: ");
        nrInicial = scan.nextInt();

        //Após ter captado as duas informações necessárias para o programa,
        //passamos para a escolha do tipo de escalonamento que o usuário pode escolher.
        escolheEscalonamento();
    }

    public void escalonadorFCFS() {
        EscalonadorFCFS escalonadorFCFS;

        //Transfere os dados da list para um ArrayList de Integer.
        elementos = new Integer[listaElementos.size()];
        for (int i = 0; i < listaElementos.size(); i++) {
            elementos[i] = listaElementos.get(i);
        }

        //Passa a lista dos elementos e o número inicial para o construtor da classe do escalonamento.
        escalonadorFCFS = new EscalonadorFCFS(nrInicial, elementos);

        //Chama o método que faz todo o processo de montagem e soma da lista.
        escalonadorFCFS.processoFcfs();
    }

    public void escalonadorSSTF() {
        EscalonadorSSTF escalonadorSSTF;

        //Transfere os dados da list para um ArrayList de Integer.
        elementos = new Integer[listaElementos.size()];
        for (int i = 0; i < listaElementos.size(); i++) {
            elementos[i] = listaElementos.get(i);
        }

        //Passa a lista dos elementos e o número inicial para o construtor da classe do escalonamento.
        escalonadorSSTF = new EscalonadorSSTF(nrInicial, elementos);

        //Chama o método que faz todo o processo de montagem e soma da lista.
        escalonadorSSTF.processoSstf();
    }

    public void escalonadorSCAN() {
        EscanoladorSCAN escanoladorSCAN;

        //Transfere os dados da list para um ArrayList de Integer.
        elementos = new Integer[listaElementos.size()];
        for (int i = 0; i < listaElementos.size(); i++) {
            elementos[i] = listaElementos.get(i);
        }

        //Passa a lista dos elementos e o número inicial para o construtor da classe do escalonamento.
        escanoladorSCAN = new EscanoladorSCAN(nrInicial, elementos);

        //Chama o método que faz todo o processo de montagem e soma da lista.
        escanoladorSCAN.processoScan();
    }

    public void escalonadorCSCAN() {
        EscalonadorCSCAN escalonadorCSCAN;

        //Transfere os dados da list para um ArrayList de Integer.
        elementos = new Integer[listaElementos.size()];
        for (int i = 0; i < listaElementos.size(); i++) {
            elementos[i] = listaElementos.get(i);
        }

        //Passa a lista dos elementos e o número inicial para o construtor da classe do escalonamento.
        escalonadorCSCAN = new EscalonadorCSCAN(nrInicial, elementos, limiteDisco);

        //Chama o método que faz todo o processo de montagem e soma da lista.
        escalonadorCSCAN.processoCscan();
    }

    public void escalonadorLOOK() {
        EscalonadorLOOK escalonadorLOOK;

        //Transfere os dados da list para um ArrayList de Integer.
        elementos = new Integer[listaElementos.size()];
        for (int i = 0; i < listaElementos.size(); i++) {
            elementos[i] = listaElementos.get(i);
        }

        //Passa a lista dos elementos e o número inicial para o construtor da classe do escalonamento.
        escalonadorLOOK = new EscalonadorLOOK(nrInicial, elementos);

        //Chama o método que faz todo o processo de montagem e soma da lista.
        escalonadorLOOK.processoLook();
    }

    public void escalonadorCLOOK() {
        EscalonadorCLOOK escalonadorLOOK;

        //Transfere os dados da list para um ArrayList de Integer.
        elementos = new Integer[listaElementos.size()];
        for (int i = 0; i < listaElementos.size(); i++) {
            elementos[i] = listaElementos.get(i);
        }

        //Passa a lista dos elementos e o número inicial para o construtor da classe do escalonamento.
        escalonadorLOOK = new EscalonadorCLOOK(nrInicial, elementos);

        //Chama o método que faz todo o processo de montagem e soma da lista.
        escalonadorLOOK.processoClook();
    }

    public void verificaLista() throws InterruptedException {
        /*
         * • Verifica se a lista contém algum número inteiro maior que o número limite,
         * que nesse caso é o 200.
         */

        for (Integer valor : listaElementos) {
            if (valor > verificador || valor < 0) {
                System.out.println("\n\nNa lista há um valor inválido!");

                //Mostra qual valor que é inválido e para a execução do programa nele.
                System.out.println("O valor inválido é '" + valor + "'.");
                System.out.println("\nNão foi possível processar. Execute o programa novamente.");

                //Finaliza o programa.
                System.exit(0);
                break;
            }
        }
    }

    public void escolheEscalonamento() throws InterruptedException, IOException {
        /*
         * • Onde tem a maior interação com o usuário, que pode escolher os tipos
         * de escalonamento que ele queira visualizar.
         */

        verificaLista();
        OUTER:
        for (int i = 0; i < 20; i++) {
            Scanner a = new Scanner(System.in);
            int x = 1;
            OUTER_1:

            //Processo de escolha do escalonamento.
            while (x < 10) {
                System.out.print("\n\n\nEscolha o escalonamento que queiras visualizar: "
                        + "\n1- FCFS"
                        + "\n2- SSTF"
                        + "\n3- SCAN"
                        + "\n4- CSCAN"
                        + "\n5- LOOK"
                        + "\n6- CLOOK"
                        + "\n\nDigite o número: ");
                String comando = a.nextLine();
                switch (comando) {
                    case "1":
                        escalonadorFCFS();
                        break OUTER_1;
                    case "2":
                        escalonadorSSTF();
                        break OUTER_1;
                    case "3":
                        escalonadorSCAN();
                        break OUTER_1;
                    case "4":
                        escalonadorCSCAN();
                        break OUTER_1;
                    case "5":
                        escalonadorLOOK();
                        break OUTER_1;
                    case "6":
                        escalonadorCLOOK();
                        break OUTER_1;
                    default:
                        System.out.println("Valor Inválido!");
                        break;
                }
            }

            //Pede se o usuário quer visualizar outro tipo de escalonamento.
            System.out.print("Deseja visualizar outro escalonamento? "
                    + "\n1- SIM"
                    + "\n2- NÃO"
                    + "\nDigite o número: ");
            Scanner b = new Scanner(System.in);
            String resposta = b.nextLine();
            switch (resposta) {
                case "1":
                    i++;
                    break;
                case "2":
                    System.out.println("Finalizando o sistema....");
                    System.out.print("Enquanto o processo finaliza, já pode dar a nota. Valeu, é nóis.");

                    //Método Sleep para que haja um efeito de "desligamento" do sistema.
                    t.sleep(3000);

                    //Finalização do Sistema.
                    daNota();
                    
                    t.sleep(10000);
                    System.exit(0);
                    break OUTER;
                default:
                    System.out.println("Resposta inválida!");
                    break OUTER;
            }
        }
    }

    private void daNota() throws IOException {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://ava.imed.edu.br/avalogin/Login.aspx?ReturnUrl=%2Favalogin"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
