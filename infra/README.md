1 - instale o docker e o docker compose conforme link e [https://gist.github.com/npearce/6f3c7826c7499587f00957fee62f8ee9]

2 - instale o postgres usando o docker-compose

3 - libere a porta do postgres para acesso de um ip especifico
    
    3.1 - Acesse o Console de Gerenciamento da AWS em https://aws.amazon.com/console/.

    3.2 - Vá para o EC2 no painel de serviços.

    3.3 - No painel de navegação à esquerda, clique em "Grupos de segurança" em "Network & Security".

    3.4 - Selecione o grupo de segurança associado à sua instância EC2.

    3.5 - Na guia "Inbound rules" (Regras de entrada), clique em "Edit inbound rules" (Editar regras de entrada).

    3.6 - Clique em "Add rule" (Adicionar regra).

    3.7 - No tipo de protocolo, selecione "PostgreSQL" na lista suspensa ou escolha "Custom TCP" e insira a porta 5432 (ou a porta que você configurou para o PostgreSQL) no campo de porta de entrada.

    3.8 - No campo "Source" (Origem), você pode especificar um IP específico, um intervalo de IPs ou "Anywhere" (Qualquer lugar) para permitir o acesso de qualquer lugar. Recomenda-se limitar o acesso às suas próprias faixas de IP ou a locais confiáveis, para garantir a segurança.

    3.9 - Clique em "Save rules" (Salvar regras).