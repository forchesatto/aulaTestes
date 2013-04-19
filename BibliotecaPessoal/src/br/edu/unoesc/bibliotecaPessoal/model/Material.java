package br.edu.unoesc.bibliotecaPessoal.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_material")
	@SequenceGenerator(name = "seq_id_material", sequenceName = "codmaterial", allocationSize = 1)
	private Integer codigo;
	private String nome;
	private Integer anoEdicao;
	@Enumerated(EnumType.STRING)
	private TipoMaterial tipoMaterial;
	
	public Material(){}

	public Material(String nome, Integer anoEdicao, TipoMaterial tipoMaterial) {
		super();
		if (nome == null) {
			throw new IllegalArgumentException("Nome não pode ser null");
		}
		if (tipoMaterial == null) {
			throw new IllegalArgumentException(
					"Tipo Material não pode ser null");
		}
		this.nome = nome;
		this.anoEdicao = anoEdicao;
		this.tipoMaterial = tipoMaterial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getAnoEdicao() {
		return anoEdicao;
	}

	public void setAnoEdicao(Integer anoEdicao) {
		this.anoEdicao = anoEdicao;
	}

	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
