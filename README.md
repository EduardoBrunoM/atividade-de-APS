# Sistema de Notas — Atividade APS (Capítulo 5)

## Integrantes
- [Eduardo Bruno, Leticia Martins]

## Como executar
vai precisar de JDK 8 ou superior. Abrir o terminal nesta pasta e executar:

```bash
javac *.java
java Main
```


## Problemas e soluções

1. **Falta de ocultamento de informação:** `Boletim` mantém `notas` privada, valida `adicionarNota` (somente números finitos entre 0 e 10) e oferece `getNotas` sem permissão de modificação. A nota 12 lança `IllegalArgumentException` e não entra na lista.
2. **Baixa coesão e múltiplas responsabilidades:** `Boletim` gerencia as notas, `CalculadoraDeMedia.calcularMedia` calcula a média (0 se vazia), `RepositorioMySQL.salvar` simula a persistência e `NotificadorEmail.enviar` simula o envio. `ProcessadorDeNotas` apenas coordena as operações.
3. **Alto acoplamento ao MySQL:** `RepositorioDeNotas` define o contrato de persistência e `ProcessadorDeNotas` recebe essa interface pelo construtor, aplicando inversão de dependências.

## Como substituir o MySQL
Crie outra classe que implemente `RepositorioDeNotas`, como `RepositorioArquivo`. Na montagem do sistema (`Main`), injete `new RepositorioArquivo()` no construtor de `ProcessadorDeNotas`, sem modificar a classe coordenadora.

## Teste no Main
O programa inclui as notas 8, 9 e 7 (média 8), rejeita 12, mostra que ela não entrou, simula salvamento MySQL e envio de e-mail e demonstra a troca do repositório por arquivo.