# Groovy Language Server

A [language server](https://microsoft.github.io/language-server-protocol/) for [Groovy](http://groovy-lang.org/).

The following language server protocol requests are currently supported:

- completion
- definition
- documentSymbol
- hover
- references
- rename
- signatureHelp
- symbol
- typeDefinition

## Build

To build from the command line, run the following command:

```sh
./gradlew build
```

This will create _build/libs/groovy-language-server-all.jar_.

## Run

To run the language server, use the following command:

```sh
java -jar groovy-language-server-all.jar
```

Language server protocol messages are passed using standard I/O.


## 中文

目前语言服务支持以下请求：

- 自动补全
- 定义
- 文档符号
- 悬停
- 参考
- 改名
- 签名帮助
- 象征
- 类型定义

此项目的websocket功能由 wangxi761/groovy-language-server 完成，他将websocket版本的提交放到了websocket分支下，
所以难以发现，我对其进行了测试，由monaco作为IDE与当前项目进行交互，可以实现代码补全，悬停，定义，参考，改名等功能。

## Monaco Demo
下面是我的一个monaco demo，可以实现代码补全，悬停，定义，参考，改名等功能。
[Monaco Groovy Demo](https://github.com/MartinKayJr/groovy-monaco-ide)

## 相比wangxi761/groovy-language-server 我所做的改动
- [ ] 将spring-boot 从 2.3.x 升级到 3.0.10
- [ ] 项目启动需要JDK17
- [ ] lsp4j使用了支持 jakarta 的版本

## 后续需要完成的功能

- [ ] 支持Java成员变量的补全 例如System.out，能识别out的所有成员(方法或者变量)。