/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsis.edu.model;

import com.unsis.edu.entity.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author labtw04
 */
public class UsuarioModelImpl implements IUsuarioModel{
    private SessionFactory sf = null;
    private Session s = null;
    
    
    @Override
    public void crearUsuario(Usuario usuario) {
        try {
            sf = new Configuration().configure().buildSessionFactory();
            s = sf.openSession();
            s.beginTransaction();
            s.save(usuario); //insert into usuario() values();
            s.getTransaction().commit();
            
            s.close();
            sf.close();
            
        } catch (HibernateException e) {
            System.out.println("Error al crear el registro: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        IUsuarioModel iusuario = new UsuarioModelImpl();
        Usuario usuario = new Usuario ("Jesús", "jesushernandezjimenez1998@gmail.com");
        
        iusuario.crearUsuario(usuario);
    }
}
