package com.example.mercancia.controladores;

import com.example.mercancia.modelos.Mercancia;
import com.example.mercancia.servicios.MercanciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Mercancia")
public class MercanciaControlador {
    @Autowired
    MercanciaServicio mercanciaServicio;

    @PostMapping
    public ResponseEntity<?> crearRegistroMercancia(@RequestBody Mercancia datoMercancia){
        try {

            Mercancia mercancia = this.mercanciaServicio.crearRegistroMercancia(datoMercancia);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancia);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editarMercancia(@RequestBody Mercancia editarMercancia, @PathVariable Integer id ){
        try {

            Mercancia mercancia = this.mercanciaServicio.editarMercancia(editarMercancia,id);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancia);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> mostrarMercancias(){
        try {

            List<Mercancia> mercancia = this.mercanciaServicio.mostrarMercancias();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancia);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarMercancia(@PathVariable Integer id){
        try {

            Boolean mercancia = this.mercanciaServicio.eliminarMercancia(id);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(mercancia);

        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }





}
