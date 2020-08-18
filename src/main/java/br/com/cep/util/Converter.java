package br.com.cep.util;

import br.com.cep.dto.CepDTO;
import br.com.cep.dto.CidadeDTO;
import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;

import java.util.ArrayList;
import java.util.List;

public class Converter{

    public static CepDTO convertFromEntity(Cep entity) {

        CepDTO dto = new CepDTO();
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setComplemento(entity.getComplemento());
        dto.setLogradouro(entity.getLogradouro());
        dto.setCidade(convertFromEntity(entity.getCidade()));

        return dto;
    }

    public static CidadeDTO convertFromEntity(Cidade entity) {

        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setIbge(entity.getIbge());
        cidadeDTO.setLocalidade(entity.getLocalidade());
        cidadeDTO.setUf(entity.getUf());

        return cidadeDTO;
    }

    public static List<CepDTO> convertFromEntity(List<Cep> entities) {
        List<CepDTO> dtos = new ArrayList<>();

        for (Cep entity: entities) {
            dtos.add(convertFromEntity(entity));
        }

        return dtos;
    }

}
