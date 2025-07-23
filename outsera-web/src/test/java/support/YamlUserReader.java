package support;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class YamlUserReader {

    public static class Usuario {
        private String usuario;
        private String senha;

        public Usuario(String usuario, String senha) {
            this.usuario = usuario;
            this.senha = senha;
        }

        public String getUsuario() {
            return usuario;
        }

        public String getSenha() {
            return senha;
        }

        @Override
        public String toString() {
            return "Usuario: " + usuario + ", Senha: " + senha;
        }
    }

    public static Usuario getUsuarioAleatorio() {
        Yaml yaml = new Yaml();
        try {
            InputStream inputStream = YamlUserReader.class.getClassLoader().getResourceAsStream("support/usuarios.yml");

            if (inputStream == null) {
                throw new RuntimeException("Arquivo YAML não encontrado!");
            }

            Map<String, List<Map<String, String>>> data = yaml.load(inputStream);
            List<Map<String, String>> usuariosMap = data.get("usuarios");

            if (usuariosMap == null || usuariosMap.isEmpty()) {
                throw new RuntimeException("Lista de usuários vazia ou mal formatada.");
            }

            Map<String, String> escolhido = usuariosMap.get(new Random().nextInt(usuariosMap.size()));
            return new Usuario(escolhido.get("usuario"), escolhido.get("senha"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
