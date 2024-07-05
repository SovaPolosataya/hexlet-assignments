@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`

    @if(page.getName() == null)
        <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
    @endif

    @if(page.getName() != null)
        <h4>Добро пожаловать, ${page.getName().toString()}.</h4>

        <form action="${NamedRoutes.logoutPath()}" method="post">
            <button type="submit">Выйти</button>
        </form>
    @endif
  `
)
