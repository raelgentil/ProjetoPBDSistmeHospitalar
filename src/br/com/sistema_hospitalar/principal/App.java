/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.principal;

import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
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
 * 
 * Usar as viws pra restrigir acesso acesso, usando pra verificar quem vai pooder visualizar determinadas coisas
 * 
 * da pra usar a view pra gerar as consultas marcadas pro dia, tb da pra usar a view pra reset senha e pra questão de medicamentos
 */


public class App {

    public static void main(String[] args) {
        CoreFacade coreFacade = new CoreFacade();

    }

}
