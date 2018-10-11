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

### Step.2 Swagger Configの作成

SpringでSwaggerを使用するために、 `SpringFox`を使用します。

SpringFoxはSpringプロジェクトの内の１つで、API仕様書を自動で生成してくれるライブラリです。
SpringFoxは実行時に、自動でアプリケーションをスキャンしてAPIの仕様を推論します。

導入した `SpringFox` ライブラリとバージョンは下記の通り。（2018/10/11現在の最新バージョン）

- io.springfox:springfox-swagger2:2.9.2
- io.springfox:springfox-swagger-ui:2.9.2

次にSwaggerを有効にするためのJavaConfigを作成します。
このStepで設定する内容は最小限のものに留めています。

SwaggerのJavaConfigを作成するだけで Swagger が有効になりました。
下記のリンクで、Swaggerで作成されたAPI仕様書が確認できます。
http://localhost:8080/swagger-ui.html

### Step.3 API仕様書としての基本情報を設定する

API仕様書として必要な基本情報を設定します。

Step.2で作成した`SwaggerConfig.java`で基本情報を追加します。追加する情報は下記です。

- groupName: APIごとにグルーピングする場合は名前をつけます。（例：internal, public）
- title: API仕様書のタイトル
- description: APIに関する説明書
- version: APIのバージョン

API仕様書のタイトルや説明書は、編集しやすさを考えて`application.yaml`で指定された値を参照する形にしました。

次に、API仕様書に載せるAPIのpathを指定します。
Step.2までのAPI仕様書ではSpringBootがデフォルトで用意されているAPIも反映されてしまっていました。
今回は`/api`配下のAPIを対象とします。

### Step.4 API毎の情報を設定する

API毎の情報を記載していきます。

ここで設定が必要な情報は、APIやパラメータといった項目の名前と説明書、例です。

具体的には下記のアノテーションを使用します。

- `@Api`: APIをグルーピングするために使用する(?) Controller単位で設定しています。
- `@ApiOperation`: 1API毎の情報を設定するために使用。
- `@ApiParam`: APIの各パラメータの情報を設定するために使用。
- `@ApiModel`: FormやResponseのモデルの情報を設定するために使用。
- `@ApiModelProperty`: Form等のモデルの各プロパティを設定するために使用。

パラメータ、プロパティの必須項目設定はデフォルトではfalseなので注意してください。

サンプルで指定した情報項目以外にも設定できる項目はあります。

詳しくは各アノテーションの実装を見てみることをオススメします。

（モデルが異なっていてもモデル名に同じ名前を設定してしまうと、Swaggerでの表示が変になってしまうバグがあるようです。注意してください。）

## 環境情報

- OS: `macOS Sierra 10.12.6`
- Java: `1.8.0_111`
- Editor: `Intellij IDEA community 2018.2`
- Check Style: `Google Checks` [Link](https://github.com/checkstyle/checkstyle/blob/master/src/main/resources/google_checks.xml)
