package modeladoysimulacion;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import modeladoysimulacion.MedioCurso.Distribuciones.Exponencial;
import modeladoysimulacion.MedioCurso.Distribuciones.Poisson;
import modeladoysimulacion.MedioCurso.Distribuciones.Uniforme;
import modeladoysimulacion.MedioCurso.GCMult;
import modeladoysimulacion.MedioCurso.GRandom;
import modeladoysimulacion.MedioCurso.GeneradorCongruencialMixto;

import modeladoysimulacion.MedioCurso.Pruebas.*;

public class ModeladoYSimulacion {

    public static void main(String[] args) {
        char sel = '0', bi = 0;
        char cont;

        Scanner scan = new Scanner(System.in);
        do {
            do {
                
                
                bi = 0;
                System.out.println("\n\nQue tipo de generador deseas:\nTeclee la opcion que desea y de enter o teclee 'Q' para salir\n\n\t"
                        + "A.Generador Congruencial Mixto\n\t" + "B.Generador Congruencial Multiplicativo\n\t"
                        + "C.Generador Alternativo(propio)\n\t" + "D.Prueba de Promedio\n\t" + "E.Prueba de Kolmogorov-Smirnov\n\t"
                        + "F.Prueba de Frecuencias\n\t" + "G.Series\n\t" + "H.Distribucion Exponencial\n\t"
                        + "I.Distribucion Uniforme\n\t" + "J.Distribucion de Poisson" + "\n\tK. Moneda" + "\n\tL. Proyecto" );
                sel = scan.next().charAt(0);

                switch (sel) {
                    case 'A':
                        GCMix();
                        break;
                    case 'B':
                        GCMult();
                        break;
                    case 'C':
                        GRndm();
                        break;
                    case 'D':
                        PEstadistica();
                        break;
                    case 'E':
                        PKolomogorov();
                        break;
                    case 'F':
                        PFrecuencias();
                        break;
                    case 'G':
                        Series();
                        break;
                    case 'H':
                        DExponencial();
                        break;
                    case 'I':
                        DUniforme();
                        break;
                    case 'J':
                        DPoisson();
                        break;
                    case 'K':
                        Moneda();
                        break;
                    case 'L':
                        Proyecto();
                        break;
                    case 'a':
                        GCMix();
                        break;
                    case 'b':
                        GCMult();
                        break;
                    case 'c':
                        GRndm();
                        break;
                    case 'd':
                        PEstadistica();
                        break;
                    case 'e':
                        PKolomogorov();
                        break;
                    case 'f':
                        PFrecuencias();
                        break;
                    case 'g':
                        Series();
                        break;
                    case 'h':
                        DExponencial();
                        break;
                    case 'i':
                        DUniforme();
                        break;
                    case 'j':
                        DPoisson();
                        break;
                    case 'k':
                        Moneda();
                        break;
                    case 'l':
                        Proyecto();
                        break;
                    case 'q':
                        bi = 67;
                        break;

                    case 'Q':
                        bi = 68;
                        break;
                    default:
                        System.out.println("Opcion no valda.");
                        bi = 1;
                }
            } while (bi == 1);

            System.out.println("\n\n\tVolver al Menú Principal o Salir?\n\t1.Menu\n\t2.Salir");

            cont = scan.next().charAt(0);

        } while (cont == '1');

    }

    private static void GCMix() {
        Scanner scan = new Scanner(System.in);
        boolean go = false;
        try {
            System.out.print("Ingresa Constante Multiplicativa (a): ");
            int a = scan.nextInt();
            System.out.print("Ingresa la semilla inicial (X0): ");
            int x = scan.nextInt();
            System.out.print("Ingresa la constante aditiva (c): ");
            int c = scan.nextInt();
            System.out.print("Ingresa el Modulo o divisor cte. (m): ");
            int m = scan.nextInt();
            if (m > a && m > x && m > c && x > 0 && a > 0 && c > 0) {

                System.out.println("INICIO DE GENERADOR CONGRUENCIAL MIXTO");
                GeneradorCongruencialMixto mix1 = new GeneradorCongruencialMixto(a, x, c, m);
                System.out.println("\n\nFormula: Xn+1 = (aXo+C)\n");
                System.out.println("Valores Asignados: \n");

                String valorA = "\na = " + mix1.getA();
                String valorX0 = "\nXo = " + mix1.getX0();
                String valorC = "\nc = " + mix1.getC();
                String valorM = "\nm = " + mix1.getM();

                mix1.makeThisHappen();
                System.out.println(mix1.letsPrintThisShit());
            } else {
                String toPrint = "\n\n";
                toPrint += "\tRecuerda las condiciones:\n\n";
                toPrint += "\tm debe ser mayor a los valores de: a, x0, c\n";
                toPrint += "\tx0, a y c deben de ser mayores a 0";
                System.out.println(toPrint);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
            return;
        }

    }

    private static void GCMult() {
        Scanner scan = new Scanner(System.in);
        boolean go = false;

        try {

            System.out.print("Ingresa la cte. multiplicativa (a): ");
            int a = scan.nextInt();
            System.out.print("Ingresa la semilla inicial (X0): ");
            int x = scan.nextInt();
            System.out.print("Ingresa el modulo o divisor (m): ");
            int m = scan.nextInt();
            if (m > a && m > x && x > 0 && a > 0) {
                System.out.println("Valores Asignados: \n");
                String valorA = "\na = " + a;
                String valorX0 = "\nXo = " + x;
                String valorM = "\nm = " + m + "\n";
                new GCMult(a, x, m).init();
            } else {
                System.out.println("INICIO DE GENERADOR CONGRUENCIAL MULTIPLICATIVO");
                String toPrint = "\n\n";
                toPrint += "\tRecuerda las condiciones:\n\n";
                toPrint += "\tm debe ser mayor a los valores de: a, x0\n";
                toPrint += "\tx0 y a deben de ser mayores a 0";
                System.out.println(toPrint);
            }

        } catch (Exception e) {
            System.out.println("Error");
            return;
        }

    }

    private static void GRndm() {
        Scanner scan = new Scanner(System.in);
        int size;
        System.out.println("¿Cuantos numeros desea generar?(Teclee el numero y presione enter)");
        try {
            size = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        System.out.println("INICIO DE GENERADOR DE NUMEROS RECTANGULARES\n");
        GRandom rA = new GRandom();
        double[] rndL = rA.getRndL(size);
        for (int i = 1; i < size + 1; i++) {
            System.out.println("Dato " + i + " : " + rndL[i - 1]);
        }
    }

    private static void PEstadistica() {
        Scanner scan = new Scanner(System.in);
        int n;
        float z;

        try{
            
            System.out.print("Ingrese cantidad de numeros Rectangulares(N) a generar: ");
            n = scan.nextInt();
            System.out.print("Ingrese El valor de Z a comparar: ");
            z = scan.nextFloat();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        System.out.println("INICIO DE PRUEBA DE PROMEDIO\n");
        System.out.println("\n\tFormula: Zo = |((!x - 0.5)\u221AN)/\u221A(1/12)");
        new Estadisticas(n).compareZ(z);
    }

    private static void PKolomogorov() {
        Scanner scan = new Scanner(System.in);
        int n;
        float d;

        try{
            System.out.print("Ingrese cantidad de numeros Rectangulares(N) a generar: ");
            n = scan.nextInt();
            System.out.print("Ingrese El valor de D a comparar: ");
            d = scan.nextFloat();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        System.out.println("\nINICIO DE PRUEBA DE KOLMOGOROV");
        System.out.println("");
        System.out.println("\tFormulas:\n F(Xi) = i/N, donde:\n\ti = Posicion del # Ordenado\n\tN = Cantidad"
                + " de numeros\n\tF(Xi) = Distancia acumulada\n\n\tDn = MAX|F(Xi)-Xi|, donde:\n\tDn = Esta"
                + "distico de Pruebas para cada numero rectangular\n\t"
                + "F(Xi) = Distancia acumulada\n\tX = Valor del ordenado\n\n");
        new KolmogorovSmirnov(n).print().compareD(d);
    }

    private static void PFrecuencias() {
        Scanner scan = new Scanner(System.in);
        int nr;
        int n;
        float x;

        try{
            System.out.print("Ingrese cantidad de numeros Rectangulares (N) a generar: ");
            nr = scan.nextInt();
            System.out.print("Ingrese la Cantidad de Intervalos (n): ");
            n = scan.nextInt();
            System.out.print("Ingrese El valor estadistico a comparar(X\u00B2\u03B1, n-1): ");
            x = scan.nextFloat();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        System.out.println("\nINICIO DE PRUEBAS DE FRECUENCIAS\n");
        System.out.println("Formula: \n\n"
                + "Xo\u00B2 = (1/FEi)\u03A3n, i=1 ((Foi - FEi)\u00B2), donde:\n\n"
                + "FEi = Frecuencia Esperada\n"
                + "Xo\u00B2 = Estadistico\n"
                + "Foi = Frecuencia Real");
        System.out.println("");
        new Frecuencias(n,nr).compareX(x);
    }

    private static void DExponencial() {
        Scanner scan = new Scanner(System.in);
        int n;
        int lambda;

        try{
            System.out.print("Ingrese El valor de λ(Media estadistica de la variable): ");
            lambda = scan.nextInt();
            System.out.print("Ingrese cantidad de numeros Rectangulares(N) a generar: ");
            n = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        
        System.out.println("\nINICIO DE DISTRIBUCION EXPONENCIAL/NO UNIFORME\n\n"
                + "Formulas:\n"
                + "- (1/λ)Ln R\n\n"
                + "x = variable aleatoria a obtener\n"
                + "λ = Media estadistica de la variable\n"
                + "Ln = Funcion matematica que obtiene el logaritmo natural de un numero\n"
                + "R = Numero rectangular previamente aprobado\n");

        System.out.println("");
        new Exponencial(lambda,n);
    }

    private static void DUniforme() {
        Scanner scan = new Scanner(System.in);
        int n;
        int a;
        int b;

        try{
            System.out.print("Ingrese El valor de a(Valor minimo de la Variable): ");
            a = scan.nextInt();
            System.out.print("Ingrese El valor de b(Valor Maximo de la Variable): ");
            b = scan.nextInt();
            System.out.print("Ingrese cantidad de numeros Rectangulares(N) a generar: ");
            n = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        
        System.out.println("\nINICIO DE DISTRIBUCION UNIFORME\n");
        System.out.println("Formulas:\n\t"
                + "X = a + (b-a)R, donde:\n\t"
                + "x = variable aleatoria a obtener\n\t"
                + "a = valor minimo que puede tomar la variable\n\t"
                + "b = valor maximo de la variable\n\t"
                + "R = #Rectangular previamente aprobado\n");
        
        
        
        System.out.println("");
        new Uniforme(a,b,n);
    }

    private static void DPoisson() {
        Scanner scan = new Scanner(System.in);
        int lambda;

        try{
            System.out.print("Ingrese El valor de λ(Media estadisitca de la variable): ");
            lambda = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Error");
            return;
        }
        System.out.println("");
        
        System.out.println("\n\nINICIO DE DISTRIBUCION DE POISSON\n\n");
        System.out.println("Formulas:\n"
                + "f(xi) = ((\u03B5^\u039B)*\u039B^x)/x!, donde: \n\t"
                + "\u03B5 = funcion exponencial"
                + "\n\t\u039B = Media estadistica de la variable"
                + "\n\tx = Valor supuesto de la variable aleatoria\n\n");
        new Poisson(lambda).print();
    }

    private static void Series() {
        Series serie = new Series();
        Scanner lec = new Scanner(System.in);
        boolean go = true;
        do {
            try {
               
                System.out.print("\n\tDime la cantidad de numeros rectangulares (N): ");
                serie.setSize(lec.nextInt());
                System.out.print("\tCantidad de sub-intervalos (n):  ");
                serie.setN(lec.nextInt());
                System.out.print("\tIngresa el valor estadistico a comparar (X\u00B2\u03B1,n-1): ");
                serie.setAlpha(lec.nextFloat());
                
                if (serie.getSize() >= 2 && serie.getN() > 1 && serie.getAlpha() > 0) {
                    System.out.println("\n\nINICIO DE PRUEBA DE SERIES");
                    System.out.println("\n\nFormulas:\n\n\t"
                            + "FEi = (N-1)/n\u00B2, donde:\n\t"
                            + "FEi = Frecuencia esperada\n\t"
                            + "N = Cantidad de numeros rectangulares\n\t"
                            + "n = Cantidad de subintervalos\n");
                    System.out.println("\tX\u00B2 = (n\u00B2/N-1) n\u03A3i=0 n\u03A3j=0 ((Foi -FEi)\u00B2)"
                            + ", donde:\n\t"
                            + "X\u00B2 = Estadistico\n\t"
                            + "n = Cantidad de subintervalos\n\t"
                            + "N = Cantidad de numeros rectangulares\n\t"
                            + "Foi = Frecuencia real\n\t"
                            + "FEi = Frecuencia esperada");
                    
                    serie = new Series(serie.getSize(), serie.getN(), serie.getAlpha());
                    serie.printRectNumbers();
                    serie.calculateFe();
                    serie.setCoords();
                    serie.checkCoordsInCart();
                    serie.printArray();
                    serie.printQuadrs();
                    serie.calculateResults();
                    serie.checkIfAccepted();
                    go = !go;
                }else{
                    System.out.println("\n\tDame un valor(es) válido(s)");
                }
                
            } catch (Exception e) {
                System.out.println("Error");

            }
        }while(go);
        
    }

    private static void Moneda() {
        System.out.println("Abriendo Problema de la Moneda en su Navegador Predeterminado");
        try {
            URL url = (new java.io.File("htmlSource/volado.html")).toURI().toURL();
            URI uri = url.toURI();
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            }
        } catch (URISyntaxException | IOException e) {
            System.out.println(e);
            System.out.println("Error, intenta abrir la pagina manualmente");
        }
    }

    private static void Proyecto() {
        System.out.println("Abriendo Problema de la Moneda en su Navegador Predeterminado");
        try {
            URL url = (new java.io.File("htmlSource/proyecto.html")).toURI().toURL();
            URI uri = url.toURI();
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);
            }
        } catch (URISyntaxException | IOException e) {
            System.out.println(e);
            System.out.println("Error, intenta abrir la pagina manualmente");
        }
    }
}
