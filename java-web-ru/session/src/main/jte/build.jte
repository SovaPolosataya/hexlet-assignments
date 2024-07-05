@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    @if(page.getError() != null)
        <div>
            ${page.getError()}
        </div>
    @endif

    <form action="${NamedRoutes.loginPath()}" method="post">
        <label>
            Имя
            <input type="text" placeholder="Name" name="name" value="${page.getName()}">
        </label>
        <label>
            Пароль
            <input type="password" placeholder="Password" name="password" />
        </label>

        <input type="submit" />
    </form>
  `
)
