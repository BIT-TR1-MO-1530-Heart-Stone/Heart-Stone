package Controller;

import io.javalin.http.Handler;
import util.*;

/**
 * Example Index HTML class using Javalin
 * <p>
 * Generate a static HTML page using Javalin by writing the raw HTML into a Java
 * String object
 *
 * @author Xinyu Chen, 2021. email: s3798356@student.rmit.edu.au
 */
public class IndexController {
    //Home page address-default is the login page
    public static Handler serverIndexPage = ctx -> ctx.render(Path.Template.INDEX);
}