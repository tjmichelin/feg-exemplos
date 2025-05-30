# Roteiro para o laboratório 6 da disciplina de SMC

Código-fonte LaTeX do roteiro do laboratório 6 da disciplina de SMC. Os recursos utilizados neste laboratório estão divididos entre os seguintes diretórios:
- ```doc```: código-fonte do arquivo do roteiro.
- ```ex```: código-fonte do arquivo de exercícios.
- ```img```: contém as imagens utilizadas no roteiro.
- ```programs```: arquivos de código-fonte dos programas de exemplo.
- ```ref```: arquivos de referências bibliográficas.

## Compilação dos documentos

Dentro de cada diretório de cada documento existe um arquivo ```Makefile``` para uso com a ferramenta ```make```.

> **ATENÇÃO**: os arquivos ```Makefile``` consideram que as ferramentas LaTeX, make e Inkscape já estão instaladas e configuradas corretamente no sistema.

### Compilação do documento do roteiro
Para compilar o roteiro, basta digitar na linha de comando ```make pdfbib```. Este comando irá compilar o documento e incluir as referências corretamente.

### Compilação do documento com exercícios
Este documento não contém nenhuma referência bibliográfica. Basta digitar, na linha de comando, o comando ```make```.