package com.example.mercancia.repositorios;

import com.example.mercancia.modelos.Mercancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//REPOSITORIOS: SE RECOMIENDA QUE SE CREEN INTERFACES Y NO CLASES
@Repository
public interface MercanciaRepositorio extends JpaRepository<Mercancia,Integer> {
}
