@import exercise.dto.users.UserPage
@param UserPage page

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>Hello Hexlet!</title>
  </head>
  <body>
    <div class="mx-auto p-4 py-md-5">
      <main>
            <dl>
              <dt>ID:</dt>
                <dd>${page.getUser().getId()}</dd>
              <dt>NAME:</dt>
                <dd>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</dd>
              <dt>EMAIL:</dt>
                <dd>${page.getUser().getEmail()}</dd>
            </dl>
      </main>
    </div>
  </body>
</html>
