/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.principal;

import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import br.com.sistema_hospitalar.model.fachada.CoreFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafaelgentil
 *
 *
 * Colocar no metodo delete uma verificação pra ver se o tabela tem um vinculo
 * com outra tabela se não tiver deleta
 */
public class App {

    public static void main(String[] args) {
        CoreFacade coreFacade = new CoreFacade();
        
//        Insumo insumo1 = new Insumo("Dipirona", 10, 10);
//        Insumo insumo2 = new Insumo("Paracetemol", 10, 15);
//        coreFacade.salvarOuAtualizarInsumo(insumo1);
//        coreFacade.salvarOuAtualizarInsumo(insumo2);


//            Insumo insumo = coreFacade.getPorIdInsumo(new Insumo(1L, null, 0, 0, 0));
//            Calendar dataValidade = Calendar.getInstance();
//                        dataValidade.set(2019, 7, 12);
//            Calendar dataFabricacao = Calendar.getInstance();
//                        dataFabricacao.set(2017, 10, 20);
//          Lote lote1 = new Lote(123560556L, 15, dataValidade, dataFabricacao, true, insumo);
//          Lote lote2 = new Lote(321560556L, 10, dataValidade, dataFabricacao, true, insumo);
//          coreFacade.salvarOuAtualizar(lote1);
//          coreFacade.salvarOuAtualizar(lote2);
          
          

//            Lote lote = coreFacade.getPorId(new Lote(1L, null, 0, null, null, true, null));
//            lote = new Lote(lote.getId(), lote.getCodigo(), 5, lote.getDataValidade(), lote.getDataFabricacao(), lote.isGenerico(), lote.getInsumo());
//            coreFacade.salvarOuAtualizar(lote);
            

    }
    
    

}
