/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.res;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.sistema_hospitalar.model.dao.*;




/**
 *
 * @author rafaelgentil
 */
public class Main {
    
    static char chrVetor[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoPBDPU");
    static List<CIDCategoria> categorias = new ArrayList<>();
    static List<CIDCategoria> subCategorias = new ArrayList<>();
    static List<CIDGrupo> grupos = new ArrayList<>();
    static List<CIDCapitulo> capitulos = new ArrayList<>();
    
    public static void main(String[] args) {

//        List<CIDCategoria> categorias;
//        readCsvFileCapitulo();
//        
        readCsvFileCategoria();
        
        
        readCsvFileGrupos();
        
        readCsvFileCapitulo();
        
        
        
        for (CIDCategoria subCategoria : subCategorias) {
            DAO<CIDCategoria> dao = new DAO<>();
            dao.salvarOuAtualizar(emf,subCategoria);
            System.out.println(subCategoria.toString());
            System.out.println("\n\n");
        }
        
        verificarSubCategoria();
        
        for (CIDCategoria categoria : categorias) {
            DAO<CIDCategoria> dao = new DAO<>();
            dao.salvarOuAtualizar(emf,categoria);
            System.out.println(categoria.toString());
            System.out.println("\n\n");
        }

        verificarCategoria();
        
        
         for (CIDGrupo grupo : grupos) {
            DAO<CIDGrupo> dao = new DAO<>();
            dao.salvarOuAtualizar(emf,grupo);
            System.out.println(grupo.toString());
            System.out.println("\n\n");
        } 
         verificarGrupos();
         for (CIDCapitulo capitulo : capitulos) {
            
            System.out.println(capitulo.toString());
            System.out.println("\n\n");
            DAO<CIDCapitulo> dao = new DAO<>();
            dao.salvarOuAtualizar(emf,capitulo);
        }
         
         System.out.println("\n\n\n\n\n\n\n\n");
         for (int i = 0; i < categorias.size(); i++) {
            CIDCategoria get = categorias.get(i);
             if (categorias.get(i).getSubCategorias().isEmpty()) {
                 
                  System.out.println(i+"vazio");
             }
            
        }
         
         
        
    }
    
    public static List<CIDCapitulo> readCsvFileCapitulo() {

//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
//excessões sejam tratadas
        try {

//Criação de um buffer para a ler de uma stream
            BufferedReader StrR = new BufferedReader(new FileReader("src/br/com/sistema_hospitalar/res/capitulos.csv"));
            
            String Str;
            String[] TableLine;
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoPBDPU");

//Essa estrutura do looping while é clássica para ler cada linha
//do arquivo 
            while ((Str = StrR.readLine()) != null) {
//Aqui usamos o método split que divide a linha lida em um array de String
//passando como parametro o divisor ";".
                TableLine = Str.split(";");
                capitulos.add(new CIDCapitulo(Integer.valueOf(TableLine[0]), TableLine[1], TableLine[2], TableLine[3]));
                
//                DAO<CIDCapitulo> dao = new DAO<>(emf);
//                dao.salvarOuAtualizar(new CIDCapitulo(Integer.valueOf(TableLine[0]), TableLine[1], TableLine[2], TableLine[3]));
//              capitulos.add(new CIDCapitulo(Integer.parseInt(TableLine[0]), TableLine[0], Str, Str, Str))
//O foreach é usadao para imprimir cada célula do array de String.
                for (String cell : TableLine) {
                    System.out.print(cell + " ");
                }
                System.out.println("\n");
            }
//Fechamos o buffer
            StrR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return capitulos;
    }
    
    public static void readCsvFileGrupos() {

//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
//excessões sejam tratadas
        try {

//Criação de um buffer para a ler de uma stream
            BufferedReader StrR = new BufferedReader(new FileReader("src/br/com/sistema_hospitalar/res/grupos.csv"));
            
            String Str;
            String[] TableLine;
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoPBDPU");

//Essa estrutura do looping while é clássica para ler cada linha
//do arquivo 
            while ((Str = StrR.readLine()) != null) {
//Aqui usamos o método split que divide a linha lida em um array de String
//passando como parametro o divisor ";".
                TableLine = Str.split(";");
                grupos.add(new CIDGrupo(TableLine[0], TableLine[1], TableLine[2]));

//                DAO<CIDGrupo> dao = new DAO<>(emf);
//                dao.salvarOuAtualizar(new CIDGrupo(TableLine[0], TableLine[1], TableLine[2]));
//              capitulos.add(new CIDCapitulo(Integer.parseInt(TableLine[0]), TableLine[0], Str, Str, Str))
//O foreach é usadao para imprimir cada célula do array de String.
                for (String cell : TableLine) {
                    System.out.print(cell + " ");
                }
                System.out.println("\n");
            }
//Fechamos o buffer
            StrR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        return grupos;
    }
    
    public static void readCsvFileCategoria() {

//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
//excessões sejam tratadas
        try {

//Criação de um buffer para a ler de uma stream
            BufferedReader StrR = new BufferedReader(new FileReader("src/br/com/sistema_hospitalar/res/busca.csv"));
            
            String Str;
            String[] TableLine;
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoPBDPU");

//Essa estrutura do looping while é clássica para ler cada linha
//do arquivo 
            while ((Str = StrR.readLine()) != null) {
//Aqui usamos o método split que divide a linha lida em um array de String
//passando como parametro o divisor ";".
                TableLine = Str.split(";");
                char caracteres[] = TableLine[0].toCharArray();
                String codigo = "";
                char codig[] = new char[caracteres.length];
                for (int i = 0; i < codig.length; i++) {
                    if (i == 0) {
                        codig[i] = String.valueOf(caracteres[0]).toUpperCase().charAt(0);
                    } else {
                        codig[i] = caracteres[i];
                    }
                    
                }
                
                codigo = String.copyValueOf(codig);
                TableLine[0] = codigo;
                 CIDCategoria categoria = new CIDCategoria(TableLine[0], TableLine[1]);
                if (TableLine[0].length() == 3) {
                    categorias.add(categoria);
                } else {
                    subCategorias.add(categoria);
                }

//             
//O foreach é usadao para imprimir cada célula do array de String.
                for (String cell : TableLine) {
                    System.out.print(cell + " ");
                }
                System.out.println("\n");
            }
//Fechamos o buffer
            StrR.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
//        return categorias;
    }
    
    public static void verificarSubCategoria() {
        for (CIDCategoria categoria : categorias) {
            for (CIDCategoria subCategoria : subCategorias) {
                char caracteres[] = subCategoria.getCodigo().toCharArray();
                String codigo = "";
                char codig[] = new char[3];
                codig[0] = caracteres[0];
                codig[1] = caracteres[1];
                codig[2] = caracteres[2];
                
                codigo = String.copyValueOf(codig);
                if (categoria.getCodigo().equals(codigo) && subCategoria.getCodigo().length() != categoria.getCodigo().length()) {
                    categoria.addSubCategoria(subCategoria);
                }
            }
        }
        
    }
    
    public static int posiçaoLeta(char letra) {
        int posicao = -1;
        for (int i = 0; i < chrVetor.length; i++) {
            if (letra == chrVetor[i]) {
                posicao = i;
                
            }
            
        }
        
        return posicao;
    }
    
    public static void verificarCategoria() {
        for (CIDGrupo grupo : grupos) {
            char codigoInicial[] = grupo.getCodigoCategoriaInicial().toCharArray();
            char codigoFinal[] = grupo.getCodigoCategoriaFinal().toCharArray();
            String letraFinal = String.valueOf(codigoFinal[0]);
            String letraInicial = String.valueOf(codigoFinal[0]);
            int numcodigoInicial = Integer.valueOf(String.valueOf(codigoInicial[1]) + String.valueOf(codigoInicial[2]));
            int numcodigoFinal = Integer.valueOf(String.valueOf(codigoFinal[1]) + String.valueOf(codigoFinal[2]));
            int posicaoLetraInicial = posiçaoLeta(codigoInicial[0]);
            int posicaoLetraFinal = posiçaoLeta(codigoFinal[0]);
            
            for (CIDCategoria categoria : categorias) {
                char codigocategora[] = categoria.getCodigo().toCharArray();
                int numcodigoCategora = Integer.valueOf(String.valueOf(codigocategora[1]) + String.valueOf(codigocategora[2]));
                String letraCategoria = String.valueOf(codigoFinal[0]);
                int posicaoLetra = posiçaoLeta(codigocategora[0]);
                if (posicaoLetra >= posicaoLetraInicial && posicaoLetra <= posicaoLetraFinal) {
                    if (numcodigoCategora >= numcodigoInicial && posicaoLetra != posicaoLetraFinal ) {
                        
//                     System.out.println();
//                     System.out.println("\n\n");
                     grupo.addCategoria(categoria);
                    }
                     if (numcodigoCategora >= numcodigoInicial && posicaoLetra == posicaoLetraFinal && numcodigoCategora <= numcodigoFinal ) {
//                    
                     grupo.addCategoria(categoria);
                    }
                }

//                 if (letraInicial.equals(letraCategoria) && numcodigoCategora >= numcodigoInicial && numcodigoCategora <= numcodigoFinal) {
//                     
//                     System.out.println();
//                     System.out.println("\n\n");
//                     grupo.addCategoria(categoria);
//                }
            }
        }
        
    }

    
    
     public static void verificarGrupos() {
        for (CIDCapitulo capitulo : capitulos) {
            char codigoInicial[] = capitulo.getCodigoCategoriaInicial().toCharArray();
            char codigoFinal[] = capitulo.getCodigoCategoriaFinal().toCharArray();
            String letraFinal = String.valueOf(codigoFinal[0]);
            String letraInicial = String.valueOf(codigoFinal[0]);
            int numcodigoInicial = Integer.valueOf(String.valueOf(codigoInicial[1]) + String.valueOf(codigoInicial[2]));
            int numcodigoFinal = Integer.valueOf(String.valueOf(codigoFinal[1]) + String.valueOf(codigoFinal[2]));
            int posicaoLetraInicial = posiçaoLeta(codigoInicial[0]);
            int posicaoLetraFinal = posiçaoLeta(codigoFinal[0]);
            
            for (CIDGrupo grupo : grupos) {
                char codigocategora[] = grupo.getCodigoCategoriaInicial().toCharArray();
                int numcodigoCategora = Integer.valueOf(String.valueOf(codigocategora[1]) + String.valueOf(codigocategora[2]));
                String letraCategoria = String.valueOf(codigoFinal[0]);
                int posicaoLetra = posiçaoLeta(codigocategora[0]);
                if (posicaoLetra >= posicaoLetraInicial && posicaoLetra <= posicaoLetraFinal) {
                    if (numcodigoCategora >= numcodigoInicial && posicaoLetra != posicaoLetraFinal ) {
                        
//                     System.out.println();
//                     System.out.println("\n\n");
                     capitulo.addGrupos(grupo);
                    }
                     if (numcodigoCategora >= numcodigoInicial && posicaoLetra == posicaoLetraFinal && numcodigoCategora <= numcodigoFinal ) {
//                    
                     capitulo.addGrupos(grupo);
                    }
                }

//                 if (letraInicial.equals(letraCategoria) && numcodigoCategora >= numcodigoInicial && numcodigoCategora <= numcodigoFinal) {
//                     
//                     System.out.println();
//                     System.out.println("\n\n");
//                     grupo.addCategoria(categoria);
//                }
            }
        }
        
    }

//     public static void verificarGrupos(){
//        for (CIDCapitulo capitulo : capitulos) {
//             char codigoInicial[] = capitulo.getCodigoCategoriaInicial().toCharArray();
//             char codigoFinal[] = capitulo.getCodigoCategoriaFinal().toCharArray();
//             String codigo = String.valueOf(codigoFinal[0]) + String.valueOf(codigoFinal[1]);
//            for (CIDCategoria categoria : categorias) {
//                 char codigocategora[] = categoria.getCodigo().toCharArray();
//                  String codigocateg = String.valueOf(codigocategora[0]) + String.valueOf(codigocategora[1]);
//                 if (codigo.equals(codigo)) {
//                     System.out.println(codigo + codigocateg);
//                     System.out.println("\n\n");
//                     capitulo.addCategoria(categoria);
//                }
//            }
//        }
//        
//    }
//    
}
