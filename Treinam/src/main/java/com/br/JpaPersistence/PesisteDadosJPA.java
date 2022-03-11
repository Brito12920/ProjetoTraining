/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.JpaPersistence;

import com.br.AvaliacaoTreinador.descricaoAvaliacao;
import com.br.Funcionarios.Funcionario;
import com.br.Funcionarios.Funcionario2;
import com.br.Obt.Obt;
import com.br.PDF.Pdf;
import com.br.Resposansavel.Responsavel;
import com.br.Treinamento.Treinamento;
import com.br.Unidade.Unidade;
import com.br.Usuario.Permissao;
import com.br.Usuario.Usuario;
import com.br.Video.AvaliacaoVideo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static javax.persistence.Persistence.createEntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author v103760
 */

@ManagedBean (name="PersistenceBean")
@ViewScoped
public class PesisteDadosJPA implements Serializable {
 private List<Funcionario> listaFuncionario=new ArrayList<>();
 private  List<AvaliacaoVideo> listaVideo=new ArrayList<>();

    public List<AvaliacaoVideo> getListaVideo() {
        return listaVideo;
    }

    public void setListaVideo(List<AvaliacaoVideo> listaVideo) {
        this.listaVideo = listaVideo;
    }

 private List<Usuario> listaUsuario=new ArrayList<>();
    public List<Funcionario> getListaFuncionario() {
        return listaFuncionario;
    }

    public void setListaFuncionario(List<Funcionario> listaFuncionario) {
        this.listaFuncionario = listaFuncionario;
    }

    private static final long serialVersionUID = 1L;
     public boolean Insert(Object dados){
       try
        {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
     // Funcionario2 p1 = new Funcionario2(0,"179425","Fabio Bando","Programador","Técnico","PPP","NA","Ativo","06/09/2021"); 
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(dados);
      System.out.println(em.getTransaction());
      em.getTransaction().commit();
        return true;
       }
        catch(Exception ex)
        { 
       return false;
  }  
     }  
         public void load(){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		Funcionario func = em.find(Funcionario.class, 3941);
                System.out.println(func.getNome());
		System.out.println(func.getRegistro());
		System.out.println(func.getUnidade());
                listaFuncionario.add(func);
		em.close();
		emf.close(); 
  }
         
       public boolean update(Object dados){
               
            try
        {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();

		em.merge(dados);
		em.getTransaction().commit();
		em.close();
		emf.close();
             return true;
       }
        catch(Exception ex)
        { 
       return false;    
       }  
       }  
       public boolean deleteFuncionario(int codigo, String objeto){
                     try
        {
                
              
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin(); 
		 switch(objeto){
                     case "Funcionario":
                       em.remove(em.getReference(Funcionario .class, codigo));
                      break; 
                      
                     case "Usuario":
                       em.remove(em.getReference(Usuario .class, codigo));
                      break;  
                 }
                          
                em.getTransaction().commit();
		
                em.close();
		emf.close();
               return true;
       }
        catch(Exception ex)
            
        {
          System.out.println(ex);  
       return false;    
       }     
       }
       
       public void listar(){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createQuery("select u from Funcionario2 u where u.codigo > 1");
		List<Funcionario2> usuarios = q.getResultList();
		for (Funcionario2 usuario : usuarios) {
			System.out.println(usuario.getNome());
			System.out.println(usuario.getRegistro());
			
		}
		tx.commit();
		em.close();
		emf.close();
       }
        public String BuscarVideo(String video){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createQuery("from avaliacaoVideo u where u.cod_obt = '"+video+"'");
		List<AvaliacaoVideo> usuarios = q.getResultList();
		for (AvaliacaoVideo usuario : usuarios) {
			
		        return usuario.getVideo();
		}
		tx.commit();
		em.close();
		emf.close();
                return "";
       }
        
        public String loadUsoFresa(String consulta){
             
                  try{
                EntityManagerFactory emf = createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	//	Query q = em.createQuery("from CutedgeRev where colunaCJ = "+sap+"");
		
                
                String hql = consulta ;
                Query query = em.createQuery(hql);
  
                @SuppressWarnings("unchecked")
                List<AvaliacaoVideo> dados = query.getResultList();
                listaVideo = dados;
                System.out.println("Video -->  "+dados.get(0).getVideo());
                if(!dados.get(0).getVideo().isEmpty()){
                    return dados.get(0).getVideo();
                }
                
		
                tx.commit();
		em.close();
		emf.close();
              
                }catch(Exception x){
                }
     return null;
                  
       }  
        
         public boolean findFunc(String consulta, Funcionario dadoFunc){
             
                  try{
                EntityManagerFactory emf = createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	//	Query q = em.createQuery("from CutedgeRev where colunaCJ = "+sap+"");
		Funcionario retorno = new Funcionario();
                
                String hql = consulta ;
                Query query = em.createQuery(hql);
  
                @SuppressWarnings("unchecked")
                List<Funcionario> dados = query.getResultList();
              //  dadoFunc = dados;
                System.out.println("Video -->  "+dados.get(0).getNome());
               
                 dadoFunc.setDepartamento(dados.get(0).getDepartamento());
                 dadoFunc.setUnidade(dados.get(0).getUnidade());
		
                tx.commit();
		em.close();
		emf.close();
                 retorno = dadoFunc;
              return true;
                }catch(Exception x){
                }
     return false;
                  
       }   
         
      public boolean deleteAnexo(int codigo){
                     try
        {
                
              
             EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Pdf pdf = entityManager.find(Pdf.class, codigo);

            entityManager.getTransaction().begin();
            entityManager.remove(pdf);
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
      
     public List<Treinamento> loadTreinamento(String consulta){
             
                  try{
                EntityManagerFactory emf = createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		
                
                String hql = consulta ;
                Query query = em.createQuery(hql);
  
                @SuppressWarnings("unchecked")
                List<Treinamento> dados = query.getResultList();
           //     treina = (Treinamento) dados;
                
                
		
                tx.commit();
		em.close();
		emf.close();
              return dados;
                }catch(Exception x){
                }
     return null;
                  
       }   
     
     public boolean deleteTreinador(int codigo){
                     try
        {
                
              
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin(); 
		
                       em.remove(em.getReference(Treinamento .class, codigo));
                     
                          
                em.getTransaction().commit();
		
                em.close();
		emf.close();
               return true;
       }
        catch(Exception ex)
            
        {
          System.out.println(ex);  
       return false;    
       }     
       }
     
      public boolean updateTreinamento(Treinamento dados){
               
            try
        {
                           
                EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Treinamento cliente = entityManager.find(Treinamento.class, dados.getCodigo());

            entityManager.getTransaction().begin();
            cliente.setNome(dados.getNome());
            cliente.setFuncao(dados.getFuncao());
            cliente.setUnidade(Permissao.getUnidade());
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

                
                
                return true;
       }
        catch(Exception ex)
        { 
       return false;    
       }  
       } 
      
      public List<Responsavel> loadGestor(String consulta){
             
                  try{
                EntityManagerFactory emf = createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		
                
                String hql = consulta ;
                Query query = em.createQuery(hql);
  
                @SuppressWarnings("unchecked")
                List<Responsavel> dados = query.getResultList();
                          
                
		
                tx.commit();
		em.close();
		emf.close();
              return dados;
                }catch(Exception x){
                }
     return null;
                  
       }   
      
      public boolean updateGestor(Responsavel dados){
               
            try
        {
                           
                EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Responsavel cliente = entityManager.find(Responsavel.class, dados.getCodigo());

            entityManager.getTransaction().begin();
            cliente.setNome(dados.getNome());
            cliente.setCargo(dados.getCargo());
            cliente.setUnidade(Permissao.getUnidade());
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

                
                
                return true;
       }
        catch(Exception ex)
        { 
       return false;    
       }  
       } 
       public boolean deleteGestor(int codigo){
                     try
        {
                
              
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin(); 
		
                       em.remove(em.getReference(Responsavel .class, codigo));
                     
                          
                em.getTransaction().commit();
		
                em.close();
		emf.close();
               return true;
       }
        catch(Exception ex)
            
        {
          System.out.println(ex);  
       return false;    
       }     
       }
       
       public List<descricaoAvaliacao> loadDecricao(String consulta){
             
                  try{
                EntityManagerFactory emf = createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		
                
                String hql = consulta ;
                Query query = em.createQuery(hql);
  
                @SuppressWarnings("unchecked")
                List<descricaoAvaliacao> dados = query.getResultList();
                          
                
		
                tx.commit();
		em.close();
		emf.close();
              return dados;
                }catch(Exception x){
                }
     return null;
                  
       }  
       
       public boolean updateDescr(descricaoAvaliacao dados){
               
            try
        {
                           
                EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            descricaoAvaliacao cliente = entityManager.find(descricaoAvaliacao.class, dados.getCodigo());

            entityManager.getTransaction().begin();
            cliente.setCategoria(dados.getCategoria());
            cliente.setDesc_categoria(dados.getDesc_categoria());
            cliente.setDescricao(dados.getDescricao());
            cliente.setNomeAvaliacao(dados.getNomeAvaliacao());
            cliente.setUnidade(Permissao.getUnidade());
            
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

                
                
                return true;
       }
        catch(Exception ex)
        { 
       return false;    
       }  
       } 
       
       public boolean deleteDescr(int codigo){
                     try
        {
                
              
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin(); 
		
                       em.remove(em.getReference(descricaoAvaliacao .class, codigo));
                     
                          
                em.getTransaction().commit();
		
                em.close();
		emf.close();
               return true;
       }
        catch(Exception ex)
            
        {
          System.out.println(ex);  
       return false;    
       }     
       }
       public List<Obt> loadObt(String consulta){
             
                  try{
                EntityManagerFactory emf = createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		
                
                String hql = consulta ;
                Query query = em.createQuery(hql);
  
                @SuppressWarnings("unchecked")
                List<Obt> dados = query.getResultList();
                          
                
		
                tx.commit();
		em.close();
		emf.close();
              return dados;
                }catch(Exception x){
                }
     return null;
                  
       }
       
       public boolean updateUnidDE(Unidade dados){
               
            try
        {
                           
                EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Unidade cliente = entityManager.find(Unidade.class, dados.getCodigo());

            entityManager.getTransaction().begin();
            cliente.setUnidade(dados.getUnidade());
            cliente.setTotalFuncionarios(dados.getTotalFuncionarios());
            entityManager.getTransaction().commit();

            entityManager.close();
            entityManagerFactory.close();

                
                
                return true;
       }
        catch(Exception ex)
        { 
       return false;    
       }  
       } 
       
       public boolean deleteUnidade(int codigo){
                     try
        {
                
              
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin(); 
		
                       em.remove(em.getReference(Unidade .class, codigo));
                     
                          
                em.getTransaction().commit();
		
                em.close();
		emf.close();
               return true;
       }
        catch(Exception ex)
            
        {
          System.out.println(ex);  
       return false;    
       }     
       }
}
