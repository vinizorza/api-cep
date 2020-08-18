package br.com.cep.repository;

import br.com.cep.model.Cep;
import br.com.cep.model.Cidade;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class ViacepClient {

    public ViacepClient() {
    }

    public Cep findCep(String id){

        Cep cep = null;

        try {

            URL url = new URL("http://viacep.com.br/ws/" + id + "/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Erro: " + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            StringBuilder output = new StringBuilder();
            String outputLine;
            while ((outputLine = br.readLine()) != null) {
                output.append(outputLine);
            }

            JSONObject json = new JSONObject(output.toString());

            cep = new Cep();
            cep.setBairro(json.get("bairro").toString());
            cep.setCep(json.get("cep").toString());
            cep.setComplemento(json.get("complemento").toString());
            cep.setLogradouro(json.get("logradouro").toString());

            Cidade cidade = new Cidade();
            cidade.setIbge(json.get("ibge").toString());
            cidade.setUf(json.get("uf").toString());
            cidade.setLocalidade(json.get("localidade").toString());

            cep.setCidade(cidade);

            conn.disconnect();

        } catch (Exception e) {
            System.out.println(e);
        }

        return cep;
    }
}
