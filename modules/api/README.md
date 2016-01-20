# api
API返す

## 起動

VMOptionで環境ファイルを読み込む
```
-Dconfig.resource=env/dev.conf
```

```
sbt api/run
```

## test

※IDE上のJUnitでテストしたほうが見やすい

```
sbt api/test
```
