package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void show(Context ctx) {
        var name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = UsersRepository.findByName(name);
        var hashPassword = encrypt(password);

        if (user != null && hashPassword.equals(user.getPassword())) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect("/");
        } else {
            var error = "Wrong username or password";
            var page = new LoginPage(name, error);

            ctx.render("build.jte", model("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }

    // END
}
