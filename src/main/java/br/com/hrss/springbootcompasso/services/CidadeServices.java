package br.com.hrss.springbootcompasso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hrss.springbootcompasso.adapter.DozerAdapter;
import br.com.hrss.springbootcompasso.data.entity.Cidade;
import br.com.hrss.springbootcompasso.data.vo.CidadeVO;
import br.com.hrss.springbootcompasso.exception.ResultNotFoundException;
import br.com.hrss.springbootcompasso.repository.CidadeRepository;

@Service
public class CidadeServices {

	@Autowired
	CidadeRepository repository;

	public CidadeVO create(Cidade cidade) {
		Cidade entity = DozerAdapter.parseObject(cidade, Cidade.class);
		CidadeVO vo = DozerAdapter.parseObject(repository.save(entity), CidadeVO.class);
		return vo;
	}

	public List<CidadeVO> findAll() {
		return DozerAdapter.parseListObjects(repository.findAll(), CidadeVO.class);
	}

	public CidadeVO findById(Long id) {

		Cidade entity = repository.findById(id)
				.orElseThrow(() -> new ResultNotFoundException("Cidade não encontrada pelo ID"));
		return DozerAdapter.parseObject(entity, CidadeVO.class);
	}

	public CidadeVO findCityByName(String nomeCidade) {
		try {
			Cidade entity = repository.findCityByName(nomeCidade);
			return DozerAdapter.parseObject(entity, CidadeVO.class);
		} catch (Exception e) {
			throw new RuntimeException("Cidade não encontrada");
		}	

	}
	
	public CidadeVO findCityByState(String estado) {
		try {
			Cidade entity = repository.findCityByState(estado);
			return DozerAdapter.parseObject(entity, CidadeVO.class);
		} catch (Exception e) {
			throw new RuntimeException("Cidade não encontrada");
		}	
	}
}
