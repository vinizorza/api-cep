package br.com.cep.model;

import java.util.List;

public class Cidade {
  
  private String ibge;
  
  private String uf;
  
  private String localidade;
  
  private List<Cep> ceps; 

  public String getIbge() {
    return ibge;
  }

  public void setIbge(String ibge) {
    this.ibge = ibge;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public List<Cep> getCeps() {
    return ceps;
  }

  public void setCeps(List<Cep> ceps) {
    this.ceps = ceps;
  }
  
  

}
