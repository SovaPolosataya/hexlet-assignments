@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
    content = @`
    <h1>Список постов</h1>
        @if(page.getPosts().isEmpty())
            <p>Сообщения отсутствуют.</p>
        @else
        <table class="table table-striped">
            @for(var post: page.getPosts())
                <div>
                    <tr>
                        <td>
                            ${post.getId()}
                        </td>
                        <td>
                            <a href="${NamedRoutes.postsPath()}/${post.getId()}">${post.getName()}</a>
                        </td>
                    </tr>
                </div>
            @endfor
        </table>
        @endif

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="?page=${page.getPage() < 2 ? 1 : page.getPage() - 1}">Предыдущая</a></li>
                <li class="page-item active"><a class="page-link" href="#">${page.getPage()}</a></li>
                <li class="page-item"><a class="page-link" href="?page=${page.getPage() + 1}">Следующая</a></li>
            </ul>
        </nav>
    `
)
