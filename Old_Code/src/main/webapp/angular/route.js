app.config(function ($routeProvider) {
    $routeProvider
        .when("/dashboard", {
            templateUrl: "dashboard.html"
        })
        .when("/login", {
            templateUrl: "login.html"
        })
        .when("/register", {
            templateUrl: "register.html"
        })
        .when("/article/all", {
            templateUrl: "articles.html"
        })
        .when("/article/user/all", {
            templateUrl: "articles_user.html"
        })
        /*.when("/article/new", {
            templateUrl: "new_article.html"
        })*/
        .when("/article/view/:id", {
            templateUrl: "article_single.html"
        })
        .when("/profile", {
            templateUrl: "profile.html"
        })
        .when("/qa/all", {
            templateUrl: "qa.html"
        })
        .when("/qa/user/all", {
            templateUrl: "qa_user.html"
        })
        /*.when("/qa/new", {
            templateUrl: "new_qa.html"
        })*/
        .when("/qa/view/:id", {
            templateUrl: "qa_single.html"
        })
        .when("/user/list", {
            templateUrl: "user_list.html"
        })
        .when("/single/user/view/:id", {
            templateUrl: "single_user_view.html"
        })
        .when("/messages", {
            templateUrl: "messages.html"
        })
        .otherwise('/dashboard');
});