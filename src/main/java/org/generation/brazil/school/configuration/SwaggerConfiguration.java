package org.generation.brazil.school.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * <p>
 * Esta classe é responsável por configurar a documentação da API REST implementada no projeto usando o padrão
 * <a href="https://www.openapis.org/">OpenAPI 3</a>, anteriormente conhecido como
 * <a href="https://swagger.io/">Swagger</a>.
 * </p>
 * <p>
 * O OpenAPI 3 é uma especificação para descrever APIs RESTful, permitindo que desenvolvedores possam visualizar e
 * interagir com a API de forma padronizada. Já o Swagger é uma ferramenta que ajuda na criação e documentação de APIs,
 * com suporte para a especificação OpenAPI.
 * </p>
 * <p>
 * Com a ajuda do OpenAPI 3 e Swagger, é possível definir detalhes da API, como endpoints, métodos HTTP suportados,
 * parâmetros, respostas esperadas, autenticação e segurança, entre outros aspectos importantes da documentação.
 * </p>
 *
 * @author Raphael F. Jesus
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.1.0.md">OpenAPI | Specification</a>
 * @see <a href="https://swagger.io/docs/specification/about/">Swagger | Documentation</a>
 * @see <a href="https://swagger.io/docs/specification/authentication/openid-connect-discovery/">Swagger | OpenID
 * Connect Discovery</a>
 * @see <a href="https://springdoc.org/v2/">OpenApi 3 & Spring Boot | Documentation</a>
 * @see <a href="https://springdoc.org/faq.html">OpenApi 3 & Spring Boot | FAQ</a>
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        final Contact contact = new Contact() //
                .name("Igor V Cavalcanti") //
                .email("igorv3872@gmail.com") //
                .url("https://github.com/Igorvcavalcanti"); //

        final Info info = new Info() //
                .title("API school") //
                .version("1.0.0") //
                .contact(contact) //
                .description("API para consulta e cadastro de alunos.");

        return new OpenAPI().info(info);
    }

}
