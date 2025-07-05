# 🌍 Roteiro de Viagens com Clima ☀️☁️

Este é um projeto em Java que permite que você monte um **roteiro de viagem** de forma interativa via terminal. Ao digitar o nome de cidades que deseja visitar, o sistema consulta a **WeatherAPI** e retorna as informações climáticas atuais de cada local.

No final, o roteiro completo com os dados climáticos é salvo em um arquivo `viagens.json`, que pode ser reutilizado ou integrado em outros sistemas.

---

## 🧠 Como funciona o projeto

1. O usuário digita o **nome da viagem** (ex: "Europa 2025").
2. Em seguida, o programa solicita que o usuário digite o **nome de uma cidade**.
3. Para cada cidade informada:
   - O programa consulta a **WeatherAPI** para buscar o clima atual.
   - Os dados são salvos internamente como um destino.
4. O usuário pode continuar digitando cidades.
5. Quando digitar `"sair"`, o programa finaliza:
   - Cria uma estrutura de viagem contendo todos os destinos.
   - Gera um arquivo `viagens.json` com os dados.
