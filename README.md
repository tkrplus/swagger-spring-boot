# Swagger x Spring Boot サンプル

Spring Boot 2.x系での Swagger のサンプルです。

Spring Bootの最小構成から段階を踏みながらSwaggerの設定をしていきます。

## 手順

### Step.0 Spring Initializr

下記のSpring公式サイトで初期プロジェクト作成し、ダウンロードします。
https://start.spring.io/

各設定項目は下記の通りで作りました。

- Gradle Project
- Java
- 2.0.5
- Group: `com.github.tkrplus`
- Artifact: `swagger-spring-boot`
- Dependencies: `Web`

### Step.1 APIの作成

Swaggerを適用させる前に、サンプル用の簡単なAPIを作成します。

作成するAPIは下記の通り5つとします。

- /api/sample GET 一覧取得API
- /api/sample POST 登録API
- /api/sample/{id} GET 取得API
- /api/sample/{id} PUT 登録・更新API
- /api/sample/{id} DELETE 削除API


## 環境情報

- OS: `macOS Sierra 10.12.6`
- Java: `1.8.0_111`
- Editor: `Intellij IDEA community 2018.2`
- Check Style: `Google Checks` [Link](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
