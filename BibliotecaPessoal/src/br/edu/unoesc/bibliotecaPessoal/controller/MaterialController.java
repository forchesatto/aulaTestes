package br.edu.unoesc.bibliotecaPessoal.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.bibliotecaPessoal.model.Material;
import br.edu.unoesc.bibliotecaPessoal.service.ServiceFactory;

@Resource
public class MaterialController {

	private Result result;
	
	public MaterialController(Result result) {
		this.result = result;
	}

	@Get
	@Path("/material")
	public void index(){
		
	}
	
	@Post
	@Path("/material")
	public void salvar(Material material){
		ServiceFactory.getMaterialService().salvar(material);
		result.redirectTo(this).sucesso();
	}
	
	@Get
	public void sucesso(){
		
	}
}
