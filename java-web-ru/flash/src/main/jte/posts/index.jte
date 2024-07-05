@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
        <div class="mx-auto p-4 py-md-5">
          <main>
            <h1>Все статьи</h1>
                <form action="${NamedRoutes.buildPostPath()}" method="get">
                    <button type="submit">Создать новую статью</button>
                </form>

                <table class="table table-striped">
                    @for(var post : page.getPosts())
                      <tr>
                        <td>
                          <strong>${post.getName()}</strong>
                        </td>
                        <td>
                          ${post.getBody()}
                        </td>
                      </tr>
                    @endfor
                </table>
          </main>
        </div>
    `
)
