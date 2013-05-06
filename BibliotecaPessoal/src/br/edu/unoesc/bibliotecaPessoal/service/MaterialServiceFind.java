package br.edu.unoesc.bibliotecaPessoal.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.bibliotecaPessoal.model.Material;
import br.edu.unoesc.bibliotecaPessoal.model.StatusMaterial;

public class MaterialServiceFind {
	
	private MaterialService materialService;
	
	public MaterialServiceFind(MaterialService materialService){
		this.materialService = materialService;
	}

	public List<Material> findAllDisponivel(){
		List<Material> materiais = new ArrayList<>();
		for(Material material: materialService.findAll()){
			if(material.getStatus().equals(StatusMaterial.Disponivel)){
				materiais.add(material);
			}
		}
		return materiais;
	}
}
