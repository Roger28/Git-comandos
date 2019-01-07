package com.example.android.gitcomandos;

import com.example.android.gitcomandos.db.entity.Comando;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerar os dados, é static, não pode ser instanciada.
 * É só declarar o nome da mesma e utilizar os seus métodos
 * Inserir novos comandos aqui.
 **/

public class DataGenerator {

    public static List<Comando> generateCommandos() {
        List<Comando> comandos = new ArrayList<>();

        comandos.add(new Comando("git help <qualquer_comando_git>", "Exibe informações sobre o comando desejado."));
        comandos.add(new Comando("git config --global user.name <seu_nome>", "Seta seu usuário no computador."));
        comandos.add(new Comando("git config --global user.email <seu_email@email.com>", "Seta seu email no computador."));
        comandos.add(new Comando("git config --global core.editor vim", "Seta um editor."));
        comandos.add(new Comando("git config --global merge.tool vimdiff", "Seta uma ferramenta de merge."));
        comandos.add(new Comando("git config --global core.excludesfile ~/.gitignore", "Seta arquivos a serem ignorados."));
        comandos.add(new Comando("git config --list", "Lista as configurações."));
        comandos.add(new Comando("git init", "Inicia um novo repositório local na pasta do seu projeto."));
        comandos.add(new Comando("git status", "Verifica estado dos arquivos/diretório."));
        comandos.add(new Comando("git add <meu_arquivo>/<meu_diretório>", "Adiciona arquivo/diretório (staged area)."));
        comandos.add(new Comando("git remote add origin <repositório_remoto>", "Associa seu repositório local ao repositório remoto com o apelido de <origin>."));
        comandos.add(new Comando("git add .", "Adiciona todos os arquivos (staged area)."));
        comandos.add(new Comando("git pull origin <branch>", "Atualiza seu repositório local em relação ao repositório remoto."));
        comandos.add(new Comando("git push -u origin master", "Envia seu repositório local para o repositório remoto. (Obs: nas próximas vezes basta fazer: git push)"));
        comandos.add(new Comando("git commit -m \"mensagem\"", "Salva uma nova versão do projeto passando uma mensagem explicativa."));
        comandos.add(new Comando("git log --oneline", "Lista histórico de commits."));
        comandos.add(new Comando("git clean -df / git checkout -- .", "Desfaz tudo que foi feito desde o último commit.(Obs: executar o comando da esquerda para direita.)"));
        comandos.add(new Comando("git reset --soft HEAD~1", "Remove o último commit, porém mantém os arquivos do jeito que estão."));
        comandos.add(new Comando("git reset --hard HEAD~1", "Remove o último commit, inclusive as alterações nos arquivos."));
        comandos.add(new Comando("git checkout <código_do_commit>", "Altera temporariamente o estado dos arquivos do projeto de modo a ficarem no estado do commit informado. (Obs: não pode haver alterações não commitadas no projeto (staged area))."));
        comandos.add(new Comando("git checkout <branch>", "Retorna para o último commit. (Obs: informar a branch atual)."));
        comandos.add(new Comando("git push -f origin HEAD^:<branch>", "Apaga o último commit no Github.(Obs: informar a branch, não pode haver alterações não commitadas no projeto (staged area))."));
        comandos.add(new Comando("git remote set-url origin <url_do_projeto>", "Altera o repositório remoto origin."));
        comandos.add(new Comando("git add -f arquivo_gitignore.txt", "Adiciona um arquivo que está listado no .gitignore"));
        comandos.add(new Comando("git commit arquivo.txt outro_arquivo.txt", "Comita vários arquivos."));
        comandos.add(new Comando("git commit arquivo.txt", "Comita um arquivo."));
        comandos.add(new Comando("git rm arquivo.txt", "Remove um arquivo."));
        comandos.add(new Comando("git rm -r diretório", "Remove um diretório."));
        comandos.add(new Comando("git log", "Exibe histórico."));
        comandos.add(new Comando("git log -p -2", "Exibe históricom diff das duas últimas alterações."));
        comandos.add(new Comando("git log --stat", "Exibe resumo do histórico (hash completa, autor, data, comentário e qtde de alterações (+/-))"));
        comandos.add(new Comando("git log --pretty=oneline", "Exibe informações resumidas em uma linha (hash completa e comentário)"));
        comandos.add(new Comando("git log --pretty=format:\"%h - %an, %ar : %s\"", "%h: Abreviação do hash, %an: Nome do autor, %ar: Data, %s: Comentário."));
        comandos.add(new Comando("git log --<caminho_do_arquivo>", "Exibe histórico de um arquivo específico."));
        comandos.add(new Comando("git log --summary -S<palavra> [<caminho_do_arquivo>]", "Exibe histórico de um arquivo específico que contêm uma determinada palavra."));
        comandos.add(new Comando("git log --diff-filter=M -- <caminho_do_arquivo>", "Exibe histórico modificação de um arquivo. (Obs: O pode ser substituido por: Adicionado (A), Copiado (C), Apagado (D), Modificado (M), Renomeado (R), entre outros.)"));
        comandos.add(new Comando("git log --author=usuario", "Exibe histórico de um determinado autor."));
        comandos.add(new Comando("git blame -L 12,22 arquivo.txt ", "Exibe revisão e autor da última modificação de um bloco de linhas"));
        comandos.add(new Comando("git remote", "Exibe os repositórios remotos."));
        comandos.add(new Comando("git remote -v", "Exibe os repositórios remotos."));
        comandos.add(new Comando("git remote show origin", "Exibe informações dos repositórios remotos."));
        comandos.add(new Comando("git remote rename origin novo-git", "Renomeia um repositório remoto."));
        comandos.add(new Comando("git remote rm curso-git", "Desvincula um repositório remoto."));
        comandos.add(new Comando("git pull", "Atualiza repositório local de acordo com o repositório remoto."));
        comandos.add(new Comando("git fetch", "Busca as alterações, mas não aplica no branch atual."));
        comandos.add(new Comando("git clone <url>", "Clona um repositório remoto existente."));
        comandos.add(new Comando("git tag vs-1.1", "Cria uma tag leve."));
        comandos.add(new Comando("git tag -a vs-1.1 -m \"Minha versão 1.1\"", "Cria uma tag anotada."));
        comandos.add(new Comando("git tag -s vs-1.1 -m \"Minha tag assinada 1.1\"", "Cria uma tag assinada."));
        comandos.add(new Comando("git tag -a vs-1.2 <commit>", "Cria tag a partir de um commit (hash)."));
        comandos.add(new Comando("git push origin vs-1.2", "Cria tags no repositório remoto"));
        comandos.add(new Comando("git push origin --tags", "Cria todas as tags locais no repositório remoto"));
        comandos.add(new Comando("git branch <branch>", "Cria um novo branch local."));
        comandos.add(new Comando("git merge <branch>", "Fazer merge entre os branchs. Para realizar o merge, é necessário estar no branch que deverá receber as alterações. O merge pode ser automático ou manual. O merge automático será feito em arquivos textos que não sofreram alterações nas mesmas linhas, já o merge manual será feito em arquivos textos que sofreram alterações nas mesmas linhas."));
        comandos.add(new Comando("git branch -d <branch>", "Apaga o branch local."));
        comandos.add(new Comando("git branch", "Lista todos branchs locais."));
        comandos.add(new Comando("git branch -v", "Lista branches com informações dos últimos commits."));
        comandos.add(new Comando("git branch --merged", "Lista branches que já foram fundidos (merged) com o master."));
        comandos.add(new Comando("git branch --no-merged", "Lista branches que não foram fundidos (merged) com o master."));
        comandos.add(new Comando("git push origin <branch>", "Cria um branch remoto com o mesmo nome."));
        comandos.add(new Comando("git push origin <branch>:new-branch", "Cria um branch remoto com diferente."));
        comandos.add(new Comando("git checkout -b <branch> origin/<branch>", "Baixa a branch remoto para edição."));
        comandos.add(new Comando("git push origin:<branch>", "Apaga o branch remoto."));
        comandos.add(new Comando("git checkout <branch> / git rebase master", "Faz o rebase entre o branch informado e o master. (Obs: executar o comando da esquerda para direita.)"));
        comandos.add(new Comando("git stash", "Para alternar entre um branch e outro é necessário fazer o commit das alterações atuais para depois trocar para um outro branch. Se existir a necessidade de realizar a troca sem fazer o commit é possível criar um stash. O Stash como se fosse um branch temporário que contem apenas as alterações ainda não commitadas."));
        comandos.add(new Comando("git stash list", "Lista todos stashs."));
        comandos.add(new Comando("git stash apply", "Volta para o último stash."));
        comandos.add(new Comando("git stash apply stash@{2}", "Volta para um stash específico. (Obs: o 2 é o índice do stash desejado)."));
        comandos.add(new Comando("git stash branch <branch>", "Cria um branch a partir de um stash."));
        comandos.add(new Comando("git commit --amend -m \"Minha nova mensagem\"", "Altera mensagens de commits."));
        comandos.add(new Comando("git bisect start", "O bisect (pesquisa binária) é útil para encontrar um commit que esta gerando um bug ou uma inconsistência entre uma sequência de commits."));
        comandos.add(new Comando("git bisect bad", "Marca commit atual como ruim."));
        comandos.add(new Comando("git bisect good vs-1.1", "Marca o commit de uma tash que está sem bug/inconsistência"));
        comandos.add(new Comando("git bisect good", "Marca o commit como bom. (Obs: O GIT irá navegar entre os commits para ajudar a indentificar o commit que esta com o problema. Se o commit atual não estiver quebrado, então é necessário marca-lo como bom)."));
        comandos.add(new Comando("git bisect reset", "Finaliza a pesquisa binária."));
        comandos.add(new Comando("git config --get remote.origin.url", "Exibe a url do repositório."));
        comandos.add(new Comando("git rm --cached -r <nome_diretório>", "Remove um diretório adicionado por engano."));

        return comandos;
    }
}

