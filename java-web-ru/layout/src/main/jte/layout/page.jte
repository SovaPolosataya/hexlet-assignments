@import gg.jte.Content

@param Content content
@param Content footer = null

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
        crossorigin="anonymous">
    <title>Hexlet Javalin Example</title>
  </head>

  <body>
    <p>
      <a href="/">Главная страница</a>
    </p>
    <p>
      <a href="/users">Список пользователей</a>
    </p>

    <div class="content">
      ${content}
    </div>

    @if (footer != null)
      <div class="footer">
        ${footer}
      </div>
    @endif
  </body>
</html>
