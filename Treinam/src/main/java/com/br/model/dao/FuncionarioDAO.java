
package com.br.model.dao;


import com.br.Funcionarios.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author fschi
 */
public class FuncionarioDAO {
    
    private Connection connection;
    
    //get e set da conexao
    public Connection getConnection()
    {
        return connection;
    }
    
    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }
    
    //método inserir
    public boolean inserir(Funcionario funcionario)
    {
        String sql = "INSERT INTO Funcionario (registro, Nome,Funcao,Departamento,Unidade,Imagem) VALUES (?, ?, ?, ?, ?, ?)";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getRegistro());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getFuncao());
            stmt.setString(4, funcionario.getDepartamento());
            stmt.setString(5, funcionario.getUnidade());
            stmt.setString(6, funcionario.getImagem());
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível inserir do banco: " + ex);
            return false;  
        }
        
    }
    
    //método para alterar
    public boolean alterar(Funcionario funcionario)
    {
        String sql = "UPDATE Funcionario SET registro = ?, Nome = ?, Funcao= ?, Departamento=?, Unidade=?, imagem=? WHERE registro = ?";
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getRegistro());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getFuncao());
            stmt.setString(4, funcionario.getDepartamento());
            stmt.setString(5, funcionario.getUnidade());
            stmt.setString(6, funcionario.getImagem());
            stmt.setString(7, funcionario.getRegistro());           
            
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            return false;  
        }
    }
    
    //método para remover
    public boolean remover(Funcionario funcionario)
    {
        String sql = "DELETE FROM Funcionario WHERE registro = ?";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getRegistro()); 
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
    
    //método para listar
    public List<Funcionario> lista()
    {
        String sql = "SELECT * FROM Funcionario";
        
        List<Funcionario> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodigo(resultado.getInt("codigo"));
                funcionario.setRegistro(resultado.getString("registro"));
                funcionario.setNome(resultado.getString("Nome"));
                funcionario.setFuncao(resultado.getString("Funcao"));
                funcionario.setDepartamento(resultado.getString("Departamento"));
                funcionario.setUnidade(resultado.getString("Unidade"));
                funcionario.setImagem(resultado.getString("Imagem"));
                
                //vamos adicionando a liss retorno
                retorno.add(funcionario);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        
        return retorno;
        
    }
    
    //método para listar cidades e estado pela sigla do estado com inner join
    public List<Funcionario> listaFuncionarios()
    {
        String sql = "SELECT funcionario.codigo, funcionario.registro, funcionario.Nome, funcionario.Funcao,funcionario.Departamento,funcionario.Unidade,funcionario.Imagem"
                + " FROM Funcionarios" ;
        
        List<Funcionario> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setCodigo(resultado.getInt("funcionario.codigo"));
                funcionario.setRegistro(resultado.getString("funcionario.registro"));
                funcionario.setNome(resultado.getString("funcionario.Nome"));
                funcionario.setFuncao(resultado.getString("funcionario.Funcao"));
                funcionario.setDepartamento(resultado.getString("funcionario.Departamento"));
                funcionario.setUnidade(resultado.getString("funcionario.Unidade"));
                funcionario.setImagem(resultado.getString("funcionario.Imagem"));
                //vamos adicionando a liss retorno
                retorno.add(funcionario);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        
        return retorno;
        
    }
    
    //método para buscar
    public Funcionario buscar(Funcionario funcionario)
    {
        String sql = "SELECT * FROM Funcionario WHERE Registro = ?";
        
        Funcionario retorno = new Funcionario();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
           
            stmt.setString(1, funcionario.getRegistro());
            stmt.setString(2, funcionario.getNome());
            
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next())
            {
                funcionario.setCodigo(resultado.getInt("codigo"));
                funcionario.setRegistro(resultado.getString("registro"));
                funcionario.setNome(resultado.getString("Nome"));
                funcionario.setFuncao(resultado.getString("Funcao"));
                funcionario.setDepartamento(resultado.getString("Departamento"));
                funcionario.setUnidade(resultado.getString("Unidade"));
                funcionario.setImagem(resultado.getString("Imagem"));
                retorno = funcionario;
            }
            
        }
        catch(SQLException ex)
        { 
            showMessageDialog(null, "Não foi possível buscar do banco: " + ex);
             
        }
        
        return retorno;
    }
    
}
