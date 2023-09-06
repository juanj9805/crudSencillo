package com.example.mercancia.servicios;

import com.example.mercancia.modelos.Mercancia;
import com.example.mercancia.repositorios.MercanciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercanciaServicio {
    @Autowired
    MercanciaRepositorio mercanciaRepositorio;

    public Mercancia crearRegistroMercancia( Mercancia datoMercancia)throws Exception{
        try{
            return (this.mercanciaRepositorio.save(datoMercancia));

        }catch (Exception error){
            throw new Exception("los datos no se validaron correctamente");
        }
    }

    public Mercancia editarMercancia(Mercancia editarMercancia, Integer id ) throws Exception{
        try {
            Optional<Mercancia> mercanciaOpcional = this.mercanciaRepositorio.findById(id);
            if(mercanciaOpcional.isEmpty()){
                throw new Exception("id de la mercancia no encontrada");
            }

            Mercancia mercanciaEncontrada=mercanciaOpcional.get();
            mercanciaEncontrada.setNombre(editarMercancia.getNombre());
            mercanciaEncontrada.setPrecio(editarMercancia.getPrecio());

            return (this.mercanciaRepositorio.save(mercanciaEncontrada));


        }catch (Exception error){
            throw new Exception("los datos no se validaron correctamente");
        }
    }

    public List<Mercancia> mostrarMercancias()throws Exception{
        try{

            List<Mercancia> mostrarMercancias = this.mercanciaRepositorio.findAll();
            return mostrarMercancias;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean eliminarMercancia(Integer id)throws Exception{
        try {
            Optional<Mercancia> mercanciaOpcional = this.mercanciaRepositorio.findById(id);
            if(mercanciaOpcional.isEmpty()){
                throw new  Exception("no se encontro la mercancia");

            }else {
                this.mercanciaRepositorio.deleteById(id);
                return true;
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }



}
