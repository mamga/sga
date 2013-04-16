-- Create Table: tb_protocoloanexado
--------------------------------------------------------------------------------
CREATE TABLE tb_protocoloanexado
(
	codigo serial NOT NULL 
	,codigoprotocolo INTEGER NOT NULL 
	,numeroprotocolo VARCHAR(9) NOT NULL 
	,CONSTRAINT PK_tb_protocoloanexado_codigo PRIMARY KEY (codigo)
);



-- Create Table: tb_protocolo
--------------------------------------------------------------------------------
CREATE TABLE tb_protocolo
(
	codigo serial NOT NULL 
	,numeroprotocolo VARCHAR(9) NOT NULL 
	,orgaocadastro VARCHAR(12) NOT NULL 
	,datacadastro TIMESTAMP NOT NULL 
	,protocolosigiloso VARCHAR(1)  NULL 
	,protocoloanteriornumero VARCHAR(9)  NULL 
	,protocoloanteriorano VARCHAR(4)  NULL 
	,protocoloanteriororgao VARCHAR(12)  NULL 
	,anexo VARCHAR(8)  NULL 
	,dvanexo VARCHAR(1)  NULL 
	,especie VARCHAR(2)  NULL 
	,origem VARCHAR(12)  NULL 
	,numerodocumento VARCHAR(9)  NULL 
	,anodocumento VARCHAR(4)  NULL 
	,cidade VARCHAR(30)  NULL 
	,estado VARCHAR(2)  NULL 
	,assunto VARCHAR(5)  NULL 
	,palavra1 VARCHAR(20)  NULL 
	,palavra2 VARCHAR(20)  NULL 
	,dataenvio TIMESTAMP  NULL 
	,localde VARCHAR(12)  NULL 
	,localpara VARCHAR(12)  NULL 
	,motivo VARCHAR(2)  NULL 
	,temconclusao VARCHAR(1)  NULL 
	,interessadotipo1 VARCHAR(12)  NULL 
	,interessadonome1 VARCHAR(40)  NULL 
	,interessadorg1 VARCHAR(15)  NULL 
	,interessadoqtd1 VARCHAR(3) NOT NULL 
	,interessadotipo2 VARCHAR(12)  NULL 
	,interessadonome2 VARCHAR(40)  NULL 
	,interessadorg2 VARCHAR(15)  NULL 
	,interessadoqtd2 VARCHAR(3)  NULL 
	,detalhamento VARCHAR(750)  NULL 
	,conclusao VARCHAR(2400)  NULL 
	,CONSTRAINT PK_tb_protocolo_codigo PRIMARY KEY (codigo)
);



-- Create Table: tb_tramitacao
--------------------------------------------------------------------------------
CREATE TABLE tb_tramitacao
(
	codigo serial NOT NULL 
	,codigoprotocolo INTEGER NOT NULL 
	,parecer VARCHAR(1) NOT NULL 
	,sequencia INTEGER NOT NULL 
	,data TIMESTAMP NOT NULL 
	,localde VARCHAR(12) NOT NULL 
	,localpara VARCHAR(12)  NULL 
	,tramitacao VARCHAR(30)  NULL 
	,parecerid VARCHAR(11) NOT NULL 
	,CONSTRAINT PK_tb_tramitacao_codigo PRIMARY KEY (codigo)
);



-- Create Table: tb_parecer
--------------------------------------------------------------------------------
CREATE TABLE tb_parecer
(
	codigo serial NOT NULL 
	,coditotramitacao INTEGER NOT NULL 
	,parecer VARCHAR(250) NOT NULL 
	,CONSTRAINT PK_tb_parecer_codigo PRIMARY KEY (codigo)
);



-- Create Foreign Key: tb_protocoloanexado.codigoprotocolo -> tb_protocolo.codigo
ALTER TABLE tb_protocoloanexado ADD CONSTRAINT FK_tb_protocoloanexado_codigoprotocolo_tb_protocolo_codigo FOREIGN KEY (codigoprotocolo) REFERENCES tb_protocolo(codigo);


-- Create Foreign Key: tb_parecer.coditotramitacao -> tb_tramitacao.codigo
ALTER TABLE tb_parecer ADD CONSTRAINT FK_tb_parecer_coditotramitacao_tb_tramitacao_codigo FOREIGN KEY (coditotramitacao) REFERENCES tb_tramitacao(codigo);


-- Create Foreign Key: tb_tramitacao.codigoprotocolo -> tb_protocolo.codigo
ALTER TABLE tb_tramitacao ADD CONSTRAINT FK_tb_tramitacao_codigoprotocolo_tb_protocolo_codigo FOREIGN KEY (codigoprotocolo) REFERENCES tb_protocolo(codigo);


