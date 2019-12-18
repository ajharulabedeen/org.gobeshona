app.run(function ($rootScope, $location, $cookieStore) {
    $rootScope.config = {
        base_url: $location.protocol() + "://" + $location.host() + ":" + $location.port() + "/gobeshonabdfinalVote"
    };

    if (typeof $cookieStore.get("is_logged_in") !== 'undefined' && $cookieStore.get("is_logged_in")) {
        $rootScope.guser_is_logged_in = $cookieStore.get("is_logged_in")
    }
    else {
        $rootScope.guser_is_logged_in = 0;
        $cookieStore.put("logged_id", 0);
    }

    if (typeof $cookieStore.get("logged_id") !== 'undefined' && $cookieStore.get("logged_id")) {
        $rootScope.guser_logged_id = $cookieStore.get("logged_id")
    }
    else {
        $rootScope.guser_logged_id = 0;
        $cookieStore.put("logged_id", 0);
    }

    $rootScope.$on('$routeChangeSuccess', function (e, current, pre) {

        if (typeof $cookieStore.get("is_logged_in") !== 'undefined' && $cookieStore.get("is_logged_in")) {
            $rootScope.guser_is_logged_in = $cookieStore.get("is_logged_in")
        }
        else {
            $rootScope.guser_is_logged_in = 0;
        }

        if (typeof $cookieStore.get("logged_id") !== 'undefined' && $cookieStore.get("logged_id")) {
            $rootScope.guser_logged_id = $cookieStore.get("logged_id")
        }
        else {
            $rootScope.guser_logged_id = 0;
        }

        $rootScope.rlocation = current.$$route.originalPath;
        if (
            $rootScope.rlocation == '/profile' ||
            $rootScope.rlocation == '/article/user/all' ||
            //$rootScope.rlocation == '/article/new' ||
            //$rootScope.rlocation == '/qa/new' ||
            $rootScope.rlocation == '/qa/user/all'
        ) {
            if ($rootScope.guser_is_logged_in == 0) {
                $location.path("/dashboard");
            }
        }


        if (
            $rootScope.rlocation == '/login' ||
            $rootScope.rlocation == '/register'
        ) {
            if ($rootScope.guser_is_logged_in == 1) {
                $location.path("/dashboard");
            }
        }
    });
});

app.controller('footerCtrl', ['$scope', function ($scope) {
    $scope.date = new Date();
}]);

app.controller('registerController', ['$scope', '$http', '$rootScope', '$location', function ($scope, $http, $rootScope, $location) {
    $scope.registration = function () {
        $http.post($rootScope.config.base_url + "/userRegistration", {
            'emailID': $scope.registration.user.email,
            'password': $scope.registration.user.password
        })
            .then(function (response) {
                var status = response.data.operationStatus
                if (status == "successInsert") {
                    $.notify("Thank you for Registration", "success");
                    $location.path("/login");
                }
                else {
                    $.notify(status, "danger");
                }
            });
    }
}]);

app.controller('loginController', ['$scope', '$http', '$rootScope', '$location', '$cookieStore', function ($scope, $http, $rootScope, $location, $cookieStore) {
    $scope.login = function () {
        $http.post($rootScope.config.base_url + "/checkUserId?uname=" + $scope.login.user.email + "&pass=" + $scope.login.user.password)
            .then(function (response) {
                if (response.data.status == "ok") {
                    $cookieStore.put("is_logged_in", 1);
                    $cookieStore.put("logged_id", response.data.userid);
                    $location.path("/dashboard");
                }
                else {
                    $.notify("Sorry Can Not Login Right now", "danger");
                }
            });
    }
}]);

app.controller('userMenuController', ['$scope', '$http', '$rootScope', '$location', '$cookieStore', function ($scope, $http, $rootScope, $location, $cookieStore) {
    $scope.initUser = function () {
        $http.get($rootScope.config.base_url + "/userProfileDetails/" + $rootScope.guser_logged_id)
            .then(function (response) {
                $scope.logged_user = response.data;
                $rootScope.guser = $scope.logged_user[0];
            });
    }

    $scope.logout = function () {
        $location.path("/login");
        /*$rootScope.guser_is_logged_in = 0;
        $rootScope.guser_logged_id = 0;*/
        $cookieStore.put("is_logged_in", 0);
        $cookieStore.put("logged_id", 0);
    }

}]);

app.controller('profileController', ['$scope', '$http', '$rootScope', function ($scope, $http, $rootScope) {

    $scope.getProfile = function () {
        $http.get($rootScope.config.base_url + "/userProfileDetails/" + $rootScope.guser_logged_id)
            .then(function (response) {
                $scope.logged_user = response.data;
                $scope.user = $scope.logged_user[0];
            });
    }

    $scope.initProfile = function () {

        if ($rootScope.guser)
            $scope.user = angular.copy($rootScope.guser);
        else
            $scope.getProfile();
    }

    $scope.user_update = function () {
        $http.put($rootScope.config.base_url + "/updateUser", {
            'userID': $rootScope.guser_logged_id,
            'emailID': $scope.user.emailID,
            'password': $scope.user.password,
            'userFirstName': $scope.user.userFirstName,
            'userLastName': $scope.user.userLastName,
            'contactInfo': $scope.user.contactInfo,
            'joinDate': $scope.user.joinDate,
            'expriences': $scope.user.expriences,
            'skills': $scope.user.skills,
            'dateOfBarth': $scope.user.dateOfBarth,
            'religiousView': $scope.user.religiousView,
            'address': $scope.user.address,
            'educationalQualification': $scope.user.educationalQualification,
        }).then(function (response) {
            console.log(response)
            $.notify("Successfully saved data", "success");
            $rootScope.guser = angular.copy($scope.user);
        });
    }

}]);

app.controller('articleController', ['$scope', '$http', '$rootScope', '$routeParams', '$location', function ($scope, $http, $rootScope, $routeParams, $location) {
    var currentId = $routeParams.id;

    $scope.article_init = function () {
        $http.get($rootScope.config.base_url + "/getArticlesSummuryWithOutContent")
            .then(function (response) {
                $scope.articles = response.data;
                console.log($scope.articles);
            });
    }

    $scope.article_my_init = function () {
        $http.get($rootScope.config.base_url + "/getArticlesByParticularUser/" + $rootScope.guser_logged_id)
            .then(function (response) {
                $scope.articles = response.data;
                console.log($scope.articles);
            });
    }

    $scope.viewroute = function () {
        console.log($rootScope.rlocation);
    }

    var currentId = $routeParams.id;

    $scope.view_article_single = function () {
        $http.get($rootScope.config.base_url + "/getSpecificArticleDetails/" + currentId)
            .then(function (response) {
                var data = response.data;
                $scope.article = data;
                console.log($scope.article);

                $http.get($rootScope.config.base_url + "/getCommentsOfParticularArticle/" + $scope.article.articleID)
                    .then(function (response) {
                        var data = response.data;
                        $scope.article.articlesComments = data;
                    });
            });
    }

    $scope.create_article_modal = function () {
        $("#article_create_modal").modal();
    }

    $scope.article_new = function () {
        $http.post($rootScope.config.base_url + "/postArticle", {
            'articleSubject': $scope.cr.articleSubject,
            'articleContent': $scope.cr.articleContent,
            'articleType': $scope.cr.articleType,
            'userID_articleByUser': $rootScope.guser_logged_id
        })
            .then(function (response) {
                console.log(response)
                $.notify("successfully saved article", "success");
                $("#article_create_modal").modal("hide");
                $scope.articles.unshift(response.data);
                $scope.cr = {};
            });
    }

    $scope.saveArticleVote = function (aid, uid, vv) {
            $http.post($rootScope.config.base_url + '/saveArticleVote', {
                "vote_articleID": aid,
                "vote_userID": $rootScope.guser_logged_id,
                "voteValue": vv
            }).then(function (response) {
                console.log(response);
                $.notify("Vote Counted.");
                console.log($scope.article.articleUpvote);
                if (vv == 1)
                {
                    $scope.article.articleUpvote += 1;
                }
                if (vv == -1)
                {
                    $scope.article.articleDownvote += 1;
                }

            })    
    }//$scope.saveArticleVote = function (aid, uid, vv) 

    $scope.deleteArticleVote = function (aid, uid, vv) {
        $http.post($rootScope.config.base_url + '/saveArticleVote', {
            "vote_articleID": aid,
            "vote_userID": $rootScope.guser_logged_id,
            "voteValue": vv
        }).then(function (response) {
            console.log(response);
            $.notify("Vote Counted.");
        })
    }//$scope.saveArticleVote = function (aid, uid, vv) 

    $scope.article_comment_new = function () {
        console.log($scope.article.articleID);

        $http.post($rootScope.config.base_url + '/postArticleComment', {
            "articleId": $scope.article.articleID,
            "articleID_Comment": $scope.article.articleID,
            "userID": $rootScope.guser_logged_id,
            "commentContent": $scope.comment.article
        }).then(function (response) {
            console.log(response.data);
            var comment = response.data;

            if (!$scope.article.articlesComments) {
                $scope.article.articlesComments = [];
            }

            $scope.article.articlesComments.unshift({
                userFirstName: $rootScope.guser.userFirstName,
                userLastName: $rootScope.guser.userLastName,
                commentContent: comment.commentContent,
                commentDate: comment.commentDate,
                commentUpVote: comment.commentUpVote,
                commentDownVote: comment.commentDownVote
            });

            $scope.comment.article = '';
        })

    }

    $scope.remove_article = function (index, id) {
        $http({
            method: 'DELETE',
            url: $rootScope.config.base_url + '/deleteArticle',
            data: {
                articleID: id
            },
            headers: {
                'Content-type': 'application/json;charset=utf-8'
            }
        })
            .then(function (response) {
                console.log(response);
                if (response.data.operationStatus == "successDelete") {
                    $.notify("Successfully Deleted Article", "success");
                    $scope.articles.splice(index, 1);

                }
            });
    }

    $scope.update_article_modal = function (index, id) {
        $scope.up = angular.copy($scope.articles[index]);
        $scope.up.index = index;
        console.log($scope.up);
        $("#article_update_modal").modal();
    }

    $scope.update_article = function () {
        $http.put($rootScope.config.base_url + "/updateArticle", {
            'articleID': $scope.up.articleID,
            'articleSubject': $scope.up.articleSubject,
            'articleContent': $scope.up.articleContent,
            'articleType': $scope.up.articleType,
            'userID_articleByUser': $rootScope.guser_logged_id
        }).then(function (response) {
            $.notify("Successfully updated article", "success");
            $("#article_update_modal").modal("hide");
            $scope.articles[$scope.up.index] = angular.copy($scope.up);
            $scope.up = {};
        });
    }

    $scope.search = function () {
        if ($scope.article.searchbox) {
            $http.post($rootScope.config.base_url + "/searchArticle", {
                'searchColumnName': $("#search_type").val(),
                'searchString': $scope.article.searchbox
            }).then(function (response) {
                //console.log(response.data);
                $scope.articles = response.data;
            });
        }
        else {
            $http.get($rootScope.config.base_url + "/getArticlesSummuryWithOutContent")
                .then(function (response) {
                    $scope.articles = response.data;
                    console.log($scope.articles);
                });
        }
    }
}]);

app.controller('qaController', ['$scope', '$http', '$rootScope', '$routeParams', '$location', function ($scope, $http, $rootScope, $routeParams, $location) {
    var currentId = $routeParams.id;

    $scope.qa_init = function () {
        $http.get($rootScope.config.base_url + "/getAllQuestionsOnly")
            .then(function (response) {
                $scope.questions = response.data;
                console.log($scope.questions);
            });
    }

    $scope.qa_my_init = function () {
        $http.get($rootScope.config.base_url + "/getQuestionAndAnswerByParticularUser/" + $rootScope.guser_logged_id)
            .then(function (response) {
                $scope.questions = response.data;
                console.log($scope.questions);
            });
    }

    $scope.viewroute = function () {
        console.log($rootScope.rlocation);
    }

    var currentId = $routeParams.id;

    $scope.view_qa_single = function () {
        $http.get($rootScope.config.base_url + "/getSpecificQuestionsDetails/" + currentId)
            .then(function (response) {
                var data = response.data;
                $scope.qa = data;
                console.log($scope.qa);

                $http.get("getCommentsOfParticularQuestionAndAnswer/" + $scope.qa.questionID)
                    .then(function (response) {
                        var data = response.data;
                        $scope.qa.questionComments = data;
                        console.log(data);
                    });
            });
    }

    $scope.create_question_modal = function () {
        $("#question_create_modal").modal();
    }

    $scope.qa_new = function () {
        $http.post($rootScope.config.base_url + "/postQuestion", {
            'question': $scope.cr.question,
            'questionDescription': $scope.cr.questionDescription,
            'questionType': $scope.cr.questionType,
            'userID_questionsAskedByUser': $rootScope.guser_logged_id
        }).then(function (response) {
            //console.log(response);
            $.notify("successfully saved question", "success");
            $("#question_create_modal").modal("hide");
            $scope.questions.unshift(response.data);
        });
    }

    $scope.qa_comment_new = function () {

        $http.post($rootScope.config.base_url + '/postQuestionAndAnswerComment', {
            "userID": $rootScope.guser_logged_id,
            "questionID": $scope.qa.questionID,
            "questionCommentContent": $scope.comment.qa
        }).then(function (response) {
            console.log(response.data);
            var comment = response.data;
            if (!$scope.qa.questionComments) {
                $scope.qa.questionComments = [];
            }

            $scope.qa.questionComments.unshift({
                userFirstName: $rootScope.guser.userFirstName,
                userLastName: $rootScope.guser.userLastName,
                questionCommentDate: comment.questionCommentDate,
                questionCommentContent: comment.questionCommentContent,
                questionCommentUpVote: comment.questionCommentUpVote,
                questionCommentDownVote: comment.questionCommentDownVote
            });
            $scope.comment.qa = '';
        })

    }

    $scope.remove_qa = function (index, id) {
        $http({
            method: 'DELETE',
            url: $rootScope.config.base_url + '/deleteQuestion',
            data: {
                questionID: id
            },
            headers: {
                'Content-type': 'application/json;charset=utf-8'
            }
        })
            .then(function (response) {
                console.log(response);
                if (response.data.operationStatus == "successDelete") {
                    $.notify("Successfully Deleted Question", "success");
                    $scope.questions.splice(index, 1);
                }
            });
    }

    $scope.update_qa_modal = function (index, id) {
        $scope.up = angular.copy($scope.questions[index]);
        $scope.up.index = index;
        console.log($scope.up);
        $("#qa_update_modal").modal();
    }

    $scope.update_qa = function () {
        $http.put($rootScope.config.base_url + "/updateQuestion", {
            'questionID': $scope.up.questionID,
            'question': $scope.up.question,
            'questionDescription': $scope.up.questionDescription,
            'questionType': $scope.up.questionType,
            'userID_questionsAskedByUser': $rootScope.guser_logged_id
        }).then(function (response) {
            $.notify("Successfully update question", "success");
            $scope.questions[$scope.up.index] = angular.copy($scope.up);
            $("#qa_update_modal").modal("hide");
        });
    }

    $scope.search = function () {
        if ($scope.qa.searchbox) {
            $http.post($rootScope.config.base_url + "/searchQuestionAndAnswar", {
                'searchColumnName': $("#qa_search_type").val(),
                'searchString': $scope.qa.searchbox
            }).then(function (response) {
                console.log(response.data);
                $scope.questions = response.data;
            });
        }
        else {
            $http.get($rootScope.config.base_url + "/getAllQuestionsOnly")
                .then(function (response) {
                    $scope.questions = response.data;
                    console.log($scope.questions);
                });
        }
    }
}]);

app.controller('userController', ['$scope', '$http', '$rootScope', '$routeParams', '$location', function ($scope, $http, $rootScope, $routeParams, $location) {
    $scope.user_init = function () {
        $http.get($rootScope.config.base_url + "/showUsersPublicData")
            .then(function (response) {
                $scope.users = response.data;
                console.log($scope.users);
            });
    }

    $scope.search = function () {
        if ($scope.user.searchbox) {
            $http.post($rootScope.config.base_url + "/searchUser", {
                'searchColumnName': $("#user_search_type").val(),
                'searchString': $scope.user.searchbox
            }).then(function (response) {
                console.log(response.data);
                $scope.users = response.data;
            });
        }
        else {
            $http.get($rootScope.config.base_url + "/showUsersPublicData")
                .then(function (response) {
                    $scope.users = response.data;
                    //console.log($scope.users);
                });
        }
    }

    $scope.single_user_view = function () {
        $http.get($rootScope.config.base_url + "/userProfileDetails/" + $routeParams.id)
            .then(function (response) {
                $scope.user = response.data[0];
                console.log($scope.user);
            });

        $http.get($rootScope.config.base_url + "/getArticlesByParticularUser/" + $routeParams.id)
            .then(function (response) {
                $scope.articles = response.data;
            });

        $http.get($rootScope.config.base_url + "/getQuestionAndAnswerByParticularUser/" + $routeParams.id)
            .then(function (response) {
                $scope.questions = response.data;
            });
        $scope.follow_status = "un-followed";
    }

    $scope.send_message = function () {
        $http.post($rootScope.config.base_url + "/sendMessage", {
            'messageSenderID': $rootScope.guser_logged_id,
            'messageReceiverID': $scope.user.userID,
            'message': $scope.cm.message,
            'subject': $scope.cm.subject
        }).then(function (response) {
            //console.log(response);
            $scope.cm.message = '';
            $scope.cm.subject = '';
            $.notify("successfully Send message", "success");
        });
    }

    $scope.follower_init = function () {
        $http.get($rootScope.config.base_url + "/listColumnB/" + $routeParams.id)
            .then(function (response) {
                $scope.followers = response.data;
                console.log($scope.followers);
            });
    }

    $scope.add_follower = function () {
        $http.post($rootScope.config.base_url + "/addFollower", {
            'columnA': $rootScope.guser_logged_id,
            'columnB': $scope.user.userID
        }).then(function (response) {
            //console.log(response);
            $scope.follow_status = "followed";
            $.notify("successfully Followed", "success");
        });
    }

    $scope.remove_follower = function () {

    }

}]);

app.controller('messagesController', ['$scope', '$http', '$rootScope', '$routeParams', '$location', function ($scope, $http, $rootScope, $routeParams, $location) {
    $scope.currentFolder = 'unread';
    $scope.initialize_messages = function () {
        $http.get($rootScope.config.base_url + "/unreadMessagesList/" + $rootScope.guser_logged_id)
            .then(function (response) {
                console.log(response.data);
                $scope.messages = response.data;
            });

    }

    $scope.initialize_users = function () {
        $http.get($rootScope.config.base_url + "/showUsersPublicData")
            .then(function (response) {
                $scope.users = response.data;
                console.log($scope.users);
                $(".select2").select2();
            });
    }

    $scope.changeFolder = function (val) {
        $scope.currentFolder = val;
        $scope.messages = {};
        switch (val) {
            case "read":
                $http.get($rootScope.config.base_url + "/readMessagesList/" + $rootScope.guser_logged_id)
                    .then(function (response) {
                        //console.log(response.data);
                        $scope.messages = response.data;
                    });
                break;
            case "unread":
                $http.get($rootScope.config.base_url + "/unreadMessagesList/" + $rootScope.guser_logged_id)
                    .then(function (response) {
                        //console.log(response.data);
                        $scope.messages = response.data;
                    });
                break;
            case "sent":
                $http.get($rootScope.config.base_url + "/sentMessages/" + $rootScope.guser_logged_id)
                    .then(function (response) {
//                        console.log(response.data);
                        $scope.messages = response.data;
                    });
                break;
//            not yet completed
            case "blocked":
                $http.get($rootScope.config.base_url + "/see_Who_You_Blocked_list/" + $rootScope.guser_logged_id)
                    .then(function (response) {
                        //console.log(response.data);
                        $scope.block_users = response.data;
                    });
                break;
            case "exception":
                $http.get($rootScope.config.base_url + "/see_who_you_made_exception/" + $rootScope.guser_logged_id)
                    .then(function (response) {
                        //console.log(response.data);
                        $scope.exception_users = response.data;
                    });
                break;
            case "message_manager":
                $http.get($rootScope.config.base_url + "/availableList_for_block_exception/" + $rootScope.guser_logged_id)
                    .then(function (response) {
                        //console.log(response.data);
                        $scope.message_users = response.data;
                    });
                break;
//            not yet completed
            default:
                $scope.messages = {};

        }
        //console.log($scope.currentFolder);
    }

    $scope.blockUser = function ($userID, $index) {
        $http.post($rootScope.config.base_url + "/add_To_Block_List?userID_who_will_block=" + $rootScope.guser_logged_id + "&userID_who_will_be_blocked=" + $userID)
            .then(function (response) {
                //console.log(response.data);
                $.notify("Successfully Blocked this User", "danger");
                $scope.message_users.splice($index, 1);
            });
    }

    $scope.unBlockUser = function ($userID, $index) {
        $http.delete($rootScope.config.base_url + "/remove_From_Block_List/", {
            params: {
                userID_who_will_unblock: $rootScope.guser_logged_id,
                userID_who_will_be_unblocked: $userID
            }
        }).then(function (response) {
            //console.log(response.data);
            $.notify("Successfully Un Blocked this User", "success");
            $scope.block_users.splice($index, 1);
        });
    }

    $scope.exceptionUser = function ($userID, $index) {
        $http.post($rootScope.config.base_url + "/add_to_exception_list?user_who_will_make_exception=" + $rootScope.guser_logged_id + "&user_who_will_be_made_exception=" + $userID)
            .then(function (response) {
                //console.log(response.data);
                $.notify("Successfully Exception this User", "primary");
                $scope.message_users.splice($index, 1);
            });
    }

    $scope.unExceptionUser = function ($userID, $index) {
        $http.delete($rootScope.config.base_url + "/remove_from__exception_list/", {
            params: {
                user_who_will_make_unexception: $rootScope.guser_logged_id,
                user_who_will_be_made_unexception: $userID
            }
        }).then(function (response) {
            //console.log(response.data);
            $.notify("Successfully Removed User from Exception List", "success");
            $scope.exception_users.splice($index, 1);
        });
    }

    $scope.composer_modal = function () {
        $("#composer_modal").modal();
    }

    $scope.send_message = function () {
        $http.post($rootScope.config.base_url + "/sendMessage", {
            'messageSenderID': $rootScope.guser_logged_id,
            'messageReceiverID': $("#username_message_to").val(),
            'message': $scope.cm.message,
            'subject': $scope.cm.subject
        }).then(function (response) {
            //console.log(response);
            $("#composer_modal").modal("hide");
        });
    }

    $scope.show_message = function (index, id, folder) {
        $scope.single_message = angular.copy($scope.messages[index]);
        //console.log($scope.single_message.message);
        $("#single_message_modal").modal();
        if (folder == "unread") {
            $http.get($rootScope.config.base_url + "/makeMessageRead/" + id)
                .then(function (response) {
                    console.log(response.data);
                    //$scope.messages = response.data;
                });
            $scope.messages.splice(index, 1);
        }
    }

}]);