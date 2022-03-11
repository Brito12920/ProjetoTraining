
 
package com.br.ControleTreinamento;

import Conexao.conexaoSQL;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author v103760
 */
public class GravarCurso {

    conexaoSQL con_sql;
    private String registroTreinamento;

    public String getRegistroTreinamento() {
        return registroTreinamento;
    }

    public void setRegistroTreinamento(String registroTreinamento) {
        this.registroTreinamento = registroTreinamento;
    }
    public GravarCurso() {
    }

    public void Gravar(String obtModelo,
            String registro,
            String re,
            String nome,
            String departamento,
            String Tipo,
            String codigoObt,
            String assinturaFunc,
            String aprovaFac,
            String revisao,
            String unidade,
            String tempo,
            String status
    ) {

      //  Revisao rev = new Revisao();
     //   rev.contTotalPerguntaBanco(obtModelo);

        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from obt");
        try {

            String sqlinsert = "insert into obt (obtModelo,"
                    
                    + " RegistroTreinamento,"
                    + " data,"
                    + " hora,"
                    + " re,"
                    + " nome,"
                    + " departamento,"
                    + " Tipo,"
                    + " codigoObt,"
                    + " assinturaFunc,"
                    + " aprovaFac,"
                    + " revisao,"
                    + " unidade,"
                    + " tempo,"
                    + "status) values ('"
                    + obtModelo + "','"
                    + registro + "','"
                    + java.time.LocalDate.now() + "','"
                    + java.time.LocalTime.now() + "','"
                    + re + "','"
                    + nome + "','"
                    + departamento + "','"
                    + Tipo + "','"
                    + codigoObt + "','"
                    + assinturaFunc + "','"
                    + aprovaFac + "','"
                    + revisao + "','"
                    + unidade + "','"
                    + tempo + "','"
                    + status + "')";

            con_sql.statement.executeUpdate(sqlinsert);
            //   showMessageDialog(null,"Gravação realizado com sucesso!");

            String data = "" + java.time.LocalDate.now();
            String hora = "" + java.time.LocalTime.now();
      //      GravarControle(codigoObt, re, nome, data, hora, "", "", "", obtModelo, obtModeloSub, cargo, departamento, unidade);
            //    tf_cal_obtido.setText("");
            con_sql.executeSQL("select * from CursoMatriz");

            //  con_reporta.resultset.first(); //posiciona no primeiro registro
        } catch (SQLException | NumberFormatException erro) {
            showMessageDialog(null, "Erro " + erro);

        }
    }

   

    public void GravarControle2(String CodObt,
            String RegistroTreina,
            String Registro2,
            String Nome,
            String Data_inclusao,
            String hora_inclusao,
            String Data_curso,
            String hora_curso,
            String Tempo,
            String dataValidade,
            String obtModelo,
            String obtModeloSub,
            String Cargo,
            String Departamento,
            String MapaProcesso,
            String MapaSubProcesso,
            String Unidade,
            String status,
            String gestor,
            String treinamento,
            String TipoTreinamento,
            String desc_treinamento,
            String Tema,
            String obs,
            String Tipo,
            String CustoTreinamento,
            String Fornecedor,
            String Ch,
            String AvaliacaoReacao,
            String Criterio_kpi_avalicao_eficacia,
            String avalicaoEficacia,
            String dataAvaliaEficacia,
            String certificado,
            String numeroDocumento
    ) {
        con_sql = new conexaoSQL();
        con_sql.conecta();
        con_sql.executeSQL("select * from ControleCurso");
        
        
        try {

            String sqlinsert = "insert into ControleCurso (CodigoObt,"
                    + " RegistroTreinamento,"
                    + " Registro,"
                    + " Nome,"
                    + " Data_inclusao,"
                    + " hora_inclusao,"
                    + " Data_curso,"
                    + " hora_curso,"
                    + " Tempo,"
                    + " dataValidade,"
                    + " obtModelo,"
                    + " obtModeloSub,"
                    + " Cargo,"
                    + " Departamento,"
                    + " mapaProcesso, "
                    + " subProcesso, "
                    + " Unidade,"
                    + " status,"
                    + " gestor,"
                    + " treinamento,"
                    + " TipoTreinamento,"
                    + " desc_treinamento,"
                    + " Tema,"
                    + " obs,"
                    + " Tipo,"
                    + " CustoTreinamento,"
                    + " Fornecedor,"
                    + " Ch,"
                    + " AvaliacaoReacao,"
                    + " Criterio_kpi_avalicao_eficacia,"
                    + " avalicaoEficacia,"
                    + " dataAvaliaEficacia,"
                    + " certificado,"
                    + " numeroDocumento) values ('"
                    + CodObt + "','"
                    + RegistroTreina + "','"
                    + Registro2 + "','"
                    + Nome + "','"
                    + Data_inclusao + "','"
                    + hora_inclusao + "','"
                    + Data_curso + "','"
                    + hora_curso + "','"
                    + Tempo + "','"
                    + dataValidade + "','"
                    + obtModelo + "','"
                    + obtModeloSub + "','"
                    + Cargo + "','"
                    + Departamento + "','"
                    + MapaProcesso + "','"
                    + MapaSubProcesso + "','"
                    + Unidade + "','"
                    + status + "','"
                    + gestor + "','"
                    + treinamento + "','"
                    + TipoTreinamento + "','"
                    + desc_treinamento + "','"
                    + Tema + "','"
                    + obs + "','"
                    + Tipo + "','"
                    + CustoTreinamento + "','"
                    + Fornecedor + "','"
                    + Ch + "','"
                    + AvaliacaoReacao + "','"
                    + Criterio_kpi_avalicao_eficacia + "','"
                    + avalicaoEficacia + "','"
                    + dataAvaliaEficacia + "','"
                    + certificado + "','"
                    + numeroDocumento+ "')";
                  

            con_sql.statement.executeUpdate(sqlinsert);
//            showMessageDialog(null, "Gravação realizado com sucesso!");

            //    tf_cal_obtido.setText("");
            con_sql.executeSQL("select * from CursoMatriz");

            //  con_reporta.resultset.first(); //posiciona no primeiro registro
        } catch (SQLException | NumberFormatException erro) {
          //  showMessageDialog(null, "Erro " + erro);
           System.out.println(erro);
        }
    }
   
 public void buscar(){
 
       
 Calendar cal = Calendar.getInstance();
int day = cal.get(Calendar.DATE);
int month = cal.get(Calendar.MONTH) + 1;
int year = cal.get(Calendar.YEAR);
int dow = cal.get(Calendar.DAY_OF_WEEK);
int dom = cal.get(Calendar.DAY_OF_MONTH);
int doy = cal.get(Calendar.DAY_OF_YEAR);
        
        
        String registro;
        
                   
   
         con_sql = new conexaoSQL(); 
         con_sql.conecta();
         con_sql.executeSQL("select * from ControleCurso");           
        
        
         try

        {

            String sql = "select * from ControleCurso order by codigo asc";
         
            con_sql.executeSQL(sql);

            if (con_sql.resultset.last())
            {
               int codigo = Integer.parseInt(con_sql.resultset.getString("codigo"));
               codigo++;
                registro ="RT"+codigo+"PPP"+" - "+year;
           //     Registro.setRegistroBT(registro); 
                registroTreinamento = registro;
              //  JOptionPane.showMessageDialog(null,"Registro"+registro);
            }
            else
            {

                {
                     //  JOptionPane.showMessageDialog(null,"Funcionario não cadastrado");

                }

            }

        }
        catch(SQLException | NullPointerException erro)
        {

        }
        
} 
  public String getRandomPass(int len){
//Scanner scan = new Scanner(System.in);
     
      String codigo;
      Random ran = new Random();
      String[] letras ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	  String b = "";
	//  System.out.print("Digite o numero de caracteres para sua senha: ");
	  int num = len;
	  for ( int i = 0; i < num; i++){
	    int a = ran.nextInt(letras.length);
		b += letras[a];
	  }
	  codigo = b;
         return codigo;
   } 
}