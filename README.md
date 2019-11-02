# Trabalho-Escalonamento-Disco
Trabalho Escalonamento Disco - Sistemas Operacionais IMED

Trabalho desenvolvido para a matéria de Sistemas Operacionais do curso de Ciências da Computação IMED, pelos alunos Augusto Ortolan e Bruno dos Santos.

Este trabalho foi desenvolvido na linguagem de programação Java, usando a IDE NetBeans e tem como intuito simular o escalonamento 
de disco tais como: FCFS, SSTF, SCAN, C-SCAN, LOOK e C-LOOK. O programa realiza a soma de todo o caminho percorrido
pelo cilindro em cada algoritmo, sempre diminuindo o maior número pelo menor, e somando seus resultados.


#### FCFS:(Primeiro a chegar, primeiro a sair). 
O mais simples de todos, percorre a lista da forma que foi escrita, do primeiro ao ultimo de forma sequencial.



#### SSTF:(Busca pelo cilindro mais próximo). 
O mais complexo de se desenvolver, foi preciso guardar o cilindro em uma variável e ir comparando com os outros até descobrir qual é o mais próximo. Após comparar e descobrir qual é o próximo, ele é adicionado a  próxima pocisão.



#### SCAN:(A partir do ponto inicial, serão atendidas todas em um sentido e após para o outro, indo até o final do disco). 
Foram criadas duas listas, uma com os números menores que o inicial, e outro com os maiores. Após os números menores serem 
atendidos, são colocados em uma lista decrescente. Os maiores seguem o mesmo processo, só que colocados em uma lista crescente.



#### C-SCAN:(Semelhante ao SCAN, porém ao chegar ao final, "pula" para o lado oposto e começa a atender as solicitações no mesmo sentido).
Praticamente o mesmo funcionamento do SCAN, mas quando chega ao final da lista, ele pula para o 0 sem contabilizar os números
entre eles.



#### LOOK:(Semelhante ao SCAN, porém não existe a necessidade de ir até o final do disco, apenas até o “último” endereço a ser atendido).
Praticamente a mesma funcionalidade do SCAN, porém não é preciso ir até o 0.



#### C-LOOK:(Semelhante ao C-SCAN, porém não existe a necessidade de ir até o final do disco, apenas até o “último” endereço a ser atendido).
Da mesma forma que o LOOK, porém "pula" para o primeiro número sem contabilizar os números entre eles.
