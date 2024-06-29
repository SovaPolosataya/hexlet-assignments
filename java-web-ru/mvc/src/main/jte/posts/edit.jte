@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                @if(page.getErrors() != null)
                <div class="mb-3">
                  <ul>
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                  </ul>
                </div>
                @endif

        <div class="mx-auto p-4 py-md-5">
            <form action="${NamedRoutes.postPath(page.getId())}" method="post">
              <div class="mb-3">
                <h3>Текущее название: </h3>
                <p>${page.getName()}</p>
                  <h4>Новое название:
                    <label class="form-label">
                      <input type="text" class="form-control" name="name" value="${page.getName()}"/>
                    </label>
                  </h4>
              </div>

              <div class="mb-3">
                <h3>Текущее содержание:</h3>
                <p>${page.getBody()}</p>
                 <h4>Новое содержание:
                   <label class="form-label">
                     <textarea class="form-control" rows="20" cols="70" type="text" name="body">${page.getBody()}</textarea>
                   </label>
                 </h4>
              </div>

              <input type="submit" class="btn btn-primary" value="Обновить" />
            </form>
        </div>
    `
)
