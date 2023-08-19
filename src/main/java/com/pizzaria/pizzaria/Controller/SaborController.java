package com.pizzaria.pizzaria.Controller;

import com.pizzaria.pizzaria.DTO.SaborDTO;
import com.pizzaria.pizzaria.DTO.UsuarioDTO;
import com.pizzaria.pizzaria.Service.SaborService;
import com.pizzaria.pizzaria.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/sabor")
public class SaborController {

    @Autowired
    private SaborService saborService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody final SaborDTO saborDTO){
        try {
            saborService.cadastrar(saborDTO);
            return ResponseEntity.ok("Sabor, cadastrado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<String> editar(@RequestParam("id") Long id, @RequestBody SaborDTO saborDTO){
        try {
            saborService.editar(id,saborDTO);
            return ResponseEntity.ok(saborDTO.getNome() + "Alterado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/deleta/{id}")
    public ResponseEntity<String> deleta(@RequestParam("id") Long id){
        try {
            saborService.deletar(id);
            return ResponseEntity.ok("Deletado com sucesso");
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<SaborDTO>> findAllSabor(){
        try {
            return ResponseEntity.ok(saborService.findAllSabor());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
