/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.Funcionarios;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author v103760
 */
@ManagedBean (name="JPABean")
@ViewScoped
public class FuncionarioJPA_bean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
   
    
  public void teste(){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
      Funcionario2 p1 = new Funcionario2(0,"179425","Fabio Bando","Programador","Técnico","PPP","NA","Ativo","06/09/2021"); 
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(p1);
      System.out.println(em.getTransaction());
      em.getTransaction().commit();
    
  }  
   
         public void load(){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		Funcionario2 func = em.find(Funcionario2.class, 1);
		System.out.println(func.getNome());
		System.out.println(func.getRegistro());
		System.out.println(func.getUnidade());
		em.close();
		emf.close(); 
  }
         
       public void update(){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin();
		Funcionario2 usuario = new Funcionario2();
		usuario.setCodigo(1);
		usuario.setNome("Teste");
		usuario.setRegistro("179");
		usuario.setUnidade("PTG");
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
		emf.close();
       }  
       
       public void delete(){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SistemaTreinamentoPU");
		EntityManager em  = emf.createEntityManager();
		em.getTransaction().begin(); 
		em.remove(em.getReference(Funcionario2 .class, 1));
		em.getTransaction().commit();
		em.close();
		emf.close();
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
    
}
