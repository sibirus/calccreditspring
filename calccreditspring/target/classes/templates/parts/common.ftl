<!--Создадим макрос, в Фримаркере, макрос необходим, что бы не таскать за собой
одни и теже стили и заголовки.
Макрос состоит из заголовка macro+название+параметр (не всегда указывается)--->
<#macro page>
    <!DOCTYPE HTML>
    <html>
    <head>
        <title>Getting Started: Serving Web Content</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <!-- Bootstrap CSS -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!-- Bootstrap CSS -->
    </head>
    <body>
    <#nested><!--#nested данная секция позволяет принимать вложенный код, любой-->
    </body>

    </html>
</#macro>