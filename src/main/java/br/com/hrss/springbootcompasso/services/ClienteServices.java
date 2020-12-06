package br.com.hrss.springbootcompasso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.hrss.springbootcompasso.adapter.DozerAdapter;
import br.com.hrss.springbootcompasso.data.entity.Cidade;
import br.com.hrss.springbootcompasso.data.entity.Cliente;
import br.com.hrss.springbootcompasso.data.vo.CidadeVO;
import br.com.hrss.springbootcompasso.data.vo.ClienteVO;
import br.com.hrss.springbootcompasso.exception.ResultNotFoundException;
import br.com.hrss.springbootcompasso.repository.ClienteRepository;

@Service
public class ClienteServices {
	@Autowired
	ClienteRepository repository;

	public ClienteVO create(Cliente Cliente) {
		Cliente entity = DozerAdapter.parseObject(Cliente, Cliente.class);
		ClienteVO vo = DozerAdapter.parseObject(repository.save(entity), ClienteVO.class);
		return vo;
	}

	public List<ClienteVO> findAll() {
		return DozerAdapter.parseListObjects(repository.findAll(), ClienteVO.class);
	}

	public ClienteVO findById(Long id) {

		Cliente entity = repository.findById(id)
				.orElseThrow(() -> new ResultNotFoundException("Cliente não encontrado pelo ID"));
		return DozerAdapter.parseObject(entity, ClienteVO.class);
	}
	
	public ClienteVO findClientByName(String nomeCompleto) {
		try {
			Cliente entity = repository.findClientByName(nomeCompleto);
			return DozerAdapter.parseObject(entity, ClienteVO.class);
		} catch (Exception e) {
			throw new RuntimeException("Cliente não encontrado");
		}	

	}

	public ClienteVO updateNameClient(ClienteVO cliente) {
		Cliente entity = repository.findById(cliente.getId())
				.orElseThrow(() -> new ResultNotFoundException("Cliente não encontrado"));

		entity.setNomeCompleto(cliente.getNomeCompleto());
//		entity.setSexo(cliente.getSexo());
//		entity.setDataNascimento(cliente.getDataNascimento());
//		entity.setIdade(cliente.getIdade());

		ClienteVO vo = DozerAdapter.parseObject(repository.save(entity), ClienteVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Cliente entity = repository.findById(id)
				.orElseThrow(() -> new ResultNotFoundException("Cliente não encontrado"));
		repository.delete(entity);
	}
}
