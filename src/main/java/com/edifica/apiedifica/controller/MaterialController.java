package com.edifica.apiedifica.controller;

import com.edifica.apiedifica.model.GruposMateriais;
import com.edifica.apiedifica.model.Material;
import com.edifica.apiedifica.repository.MaterialRepository;
import com.edifica.apiedifica.service.MaterialService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/materiais")
public class MaterialController {

    private final MaterialService materialService;

    private MaterialRepository materialRepository;

    /*
    @GetMapping("/arrumado")
    public List<List<Material>> listarMateriaisOrganizados(){

        List<Material> materiais = materialRepository.findAll();
        List<List<Material>> materiaisClassificados = materialService.classificarMateriais(materiais);

        System.out.println(materiaisClassificados);

        return materiaisClassificados;

    }

     */

    @GetMapping("/curva")
    public GruposMateriais getMateriais() {
        List<Material> materiais = materialRepository.findAll();

        GruposMateriais gruposMateriais = materialService.classificarMateriais(materiais);

        return gruposMateriais;
    }

    @GetMapping
    public List<Material> listar(){
        return materialRepository.findAll();
    }

    @GetMapping("/{materialId}")
    public ResponseEntity<Material> buscar(@PathVariable Long materialId){
        return materialRepository.findById(materialId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Material adicionar(@Valid @RequestBody Material material) {
        //material.setValor(material.getValor().divide(BigDecimal.valueOf(material.getQuantidade())));
        return materialRepository.save(material);
    }

    @PutMapping("/{materialId}")
    public ResponseEntity<Material> atualizar(@PathVariable Long materialId, @Valid @RequestBody Material material){
        if(!materialRepository.existsById(materialId)) {
            return ResponseEntity.notFound().build();
        }

        material.setId(materialId);
        material = materialRepository.save(material);

        return ResponseEntity.ok(material);

    }

    @DeleteMapping("/{materialId}")
    public ResponseEntity<Void> remover(@PathVariable Long materialId){
        if(!materialRepository.existsById(materialId)) {
            return ResponseEntity.notFound().build();
        }

        materialRepository.deleteById(materialId);

        return ResponseEntity.noContent().build();
    }

}
