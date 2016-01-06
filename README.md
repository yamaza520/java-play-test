java-play-test

# 余談

styleguideはgoogleがよさそう。
https://github.com/HPI-Information-Systems/Metanome/wiki/Installing-the-google-styleguide-settings-in-intellij-and-eclipse

# 環境構築

対象はmac
mysqlでデータベース作っとく。

```
create database testdb;
```

※java入ってない人はコレを

```
brew cask search java
brew cask install java
```

```
java -version                                                                     java version "1.8.0_66"
Java(TM) SE Runtime Environment (build 1.8.0_66-b17)
Java HotSpot(TM) 64-Bit Server VM (build 25.66-b17, mixed mode)
```

### activator

```
brew install typesafe-activator
brew install sbt
```

### app

```
cd test-java-play
activator run
```
※初回はめっちゃ時間かかる

## groovy

spock用にいれる
```
brew install groovy
```

