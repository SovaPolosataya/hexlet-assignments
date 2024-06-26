@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage
@param PostPage page

<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="view-port" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
              crossorigin="anonymous">
        <title>Пост</title>
    </head>
    <body>
        <main>
            <h2>${page.getPost().getName()}</h2>
            <p>${page.getPost().getId()}</p>
            <p>${page.getPost().getBody()}</p>
            <a href="${NamedRoutes.postsPath()}">Все посты</a>
        </main>
    </body>
</html>
