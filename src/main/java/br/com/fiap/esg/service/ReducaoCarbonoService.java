package br.com.fiap.esg.service;

import br.com.fiap.esg.dto.ReducaoCarbonoCadastroDTO;
import br.com.fiap.esg.dto.ReducaoCarbonoExibicaoDTO;
import br.com.fiap.esg.model.ReducaoCarbono;
import br.com.fiap.esg.repository.ReducaoCarbonoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReducaoCarbonoService {

    @Autowired
    private ReducaoCarbonoRepository reducaoCarbonoRepository;

    public ReducaoCarbonoExibicaoDTO salvar(ReducaoCarbonoCadastroDTO reducaoCarbonoDTO){
        ReducaoCarbono reducaoCarbono = new ReducaoCarbono();
        BeanUtils.copyProperties(reducaoCarbonoDTO, reducaoCarbono);
        ReducaoCarbono reducaoCarbonoSalvo = reducaoCarbonoRepository.save(reducaoCarbono);

        return new ReducaoCarbonoExibicaoDTO(reducaoCarbonoSalvo);
    }

    public ReducaoCarbonoExibicaoDTO buscarPorId(Long id){
        Optional<ReducaoCarbono> reducaoCarbonoOptional =
                reducaoCarbonoRepository.findById(id);

        if (reducaoCarbonoOptional.isPresent()){
            return new ReducaoCarbonoExibicaoDTO(reducaoCarbonoOptional.get());
        } else {
            throw new RuntimeException("Registro não existe!");
        }
    }

    public List<ReducaoCarbonoExibicaoDTO> listarTodos(){
        return reducaoCarbonoRepository
                .findAll()
                .stream()
                .map(ReducaoCarbonoExibicaoDTO::new)
                .toList();
    }

    public void excluir(Long id) {
        Optional<ReducaoCarbono> reducaoCarbonoOptional = reducaoCarbonoRepository.findById(id);
        if (reducaoCarbonoOptional.isPresent()) {
            reducaoCarbonoRepository.delete(reducaoCarbonoOptional.get());
        } else {
            throw new RuntimeException("Registro não encontrado!");
        }
    }

    public ReducaoCarbonoExibicaoDTO atualizar(ReducaoCarbonoExibicaoDTO reducaoCarbonoDTO){
        Optional<ReducaoCarbono> reducaoCarbonoOptional =
                reducaoCarbonoRepository.findById(reducaoCarbonoDTO.reducaoCarbonoId());

        if (reducaoCarbonoOptional.isPresent()){
            ReducaoCarbono reducaoCarbono = new ReducaoCarbono();
            BeanUtils.copyProperties(reducaoCarbonoDTO, reducaoCarbono);
            return new ReducaoCarbonoExibicaoDTO(reducaoCarbonoRepository.save(reducaoCarbono));
        } else {
            throw new RuntimeException("Registro não encontrado!");
        }
    }
}
