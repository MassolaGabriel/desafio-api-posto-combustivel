# ⛽ Sistema de Gestão de Abastecimentos

API RESTful desenvolvida em Java com Spring Boot para o gerenciamento operacional de postos de combustíveis. A aplicação permite o controle rigoroso de tipos de combustíveis, inventário de bombas e o histórico detalhado de cada abastecimento realizado.

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**: Abstração de persistência de dados.
* **Hibernate**: Implementação de ORM para mapeamento objeto-relacional.
* **Lombok**: Produtividade através da redução de código boilerplate.
* **MySQL**: Armazenamento relacional dos dados.
* **Maven**: Gerenciamento de dependências e build.

## 🏗️ Arquitetura e Organização

O projeto segue o padrão de **Arquitetura em Camadas**, garantindo uma separação clara de responsabilidades:

1. **Model**: Entidades JPA que definem a estrutura do banco de dados (Combustível, Bomba, Abastecimento).
2. **Repository**: Interfaces que estendem `JpaRepository`, permitindo operações de banco sem a necessidade de implementar código SQL manualmente.
3. **Service**: Camada onde reside a lógica de negócio. Utiliza `@Transactional` para garantir a atomicidade em operações de escrita e manipula retornos `Optional` para evitar exceções de ponteiro nulo.
4. **Controller**: Gerenciamento dos endpoints REST e mapeamento das requisições HTTP.


---

## 📡 Documentação da API

### 1. Combustíveis (`/combustivel`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/combustivel` | Recupera todos os combustíveis cadastrados. |
| **GET** | `/combustivel/{id}` | Busca um combustível por ID. |
| **POST** | `/combustivel` | Registra um novo tipo de combustível e preço. |
| **PUT** | `/combustivel/{id}` | Atualiza o nome ou preço por litro de um combustível. |
| **DELETE** | `/combustivel/{id}` | Remove um combustível de forma transacional. |

### 2. Bombas (`/bomba`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/bomba` | Lista todas as bombas e seus respectivos combustíveis vinculados. |
| **POST** | `/bomba` | Cadastra uma nova bomba no sistema. |
| **PUT** | `/bomba/{id}` | Altera as informações da bomba ou o combustível associado. |
| **DELETE** | `/bomba/{id}` | Exclui uma bomba do registro. |

### 3. Abastecimentos (`/abastecimento`)
| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/abastecimento` | Exibe o histórico completo de transações. |
| **POST** | `/abastecimento` | Registra um abastecimento (Data/Hora, Volume, Valor e Bomba). |
| **PUT** | `/abastecimento/{id}` | Corrige dados de um registro de abastecimento existente. |
| **DELETE** | `/abastecimento/{id}` | Remove um registro de abastecimento do histórico. |

---

## 🛠️ Configuração e Execução

### Pré-requisitos
* JDK 17
* Maven 3.8+
* MySQL 8.0+

### Passo a Passo
1. **Clone o repositório**:
   ```bash
   git clone [https://github.com/MassolaGabriel/nome-do-repositorio.git](https://github.com/MassolaGabriel/nome-do-repositorio.git)

2. **Execução**:
  Para rodar a aplicação, utilize o Maven via terminal:
  ```bash
  mvn spring-boot:run
  ```
  Acesse a API em: http://localhost:8080

## ✅ Diferenciais e Segurança (Camada Service)

Neste projeto, a Camada Service foi implementada focando em robustez e integridade:

* Integridade de Dados (@Transactional): Uso da anotação @Transactional para garantir que operações complexas de banco de dados sejam atômicas. Se algo falhar durante a persistência, o sistema realiza o rollback automático.

* Tratamento de Nulos (Optional): Verificação sistemática da existência de registros utilizando Optional.isEmpty() antes de realizar updates ou deletes. Isso evita falhas de execução e garante respostas HTTP condizentes (404 Not Found).

* Mapeamento de Relacionamentos: Implementação correta de anotações @ManyToOne e @JoinColumn para garantir a integridade referencial entre Abastecimentos, Bombas e Combustíveis.

* Persistência de Estados: Lógica de atualização de campos específica, garantindo que apenas os dados enviados na requisição sejam processados, mantendo a consistência dos registros existentes.
  
