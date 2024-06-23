@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
      <dl>
         <dt>ID:</dt>
            <dd>${page.getUser().getId()}</dd>
         <dt>NAME:</dt>
            <dd>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</dd>
         <dt>EMAIL:</dt>
            <dd>${page.getUser().getEmail()}</dd>
      </dl>
    `,
    footer = @`
        <p>Copyright (c) 2024. Все права защищены.</p>
    `
)
