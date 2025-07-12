# tech-guide

Padrão usado será o Repository -> Service -> Controller

Onde o Repository será responsável por adicionar as classes com regra de negócio do banco de dados. Faremos CRUDs, consultas e afins.

O Service será responsável por processar os dados, como por exemplo verificar se a senha bate com um X padrão, ou até mesmo converter um nome para minusculo.

O Controller é meu contato com o Front, onde vou fazer o check com a API.


                  Repository        Service       Controller
                     __             __             __ 
     Banco     <-   |  |           |  |           |  |         <-   API
                    |  |   <-      |  |      <-   |  |
                    |__|           |__|           |__|

    
