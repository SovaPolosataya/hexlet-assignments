@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <table class="table table-striped">
          @for(var user : page.getUsers())
            <tr>
              <td>
                ${user.getId()}
              </td>
              <td>
                <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
              </td>
            </tr>
          @endfor
        </table>
    `,
    footer = @`
        <p>Copyright (c) 2024. Все права защищены.</p>
    `
)
