(function () {

    angular.module('cloudApp.controllers', [])

            .controller('PostController', ['$scope', '$routeParams', 'postService',
                function ($scope, $routeParams, postService) {


                   $scope.posts = [];

                   loadPosts = function () {
                        postService.loadPosts()
                            .then(function (data) {
                                $scope.posts = data;
                            });
                    };
                    
                    loadPosts();

                    $scope.submitPost = function (content) {
                        postService.addPost(content);
                        $scope.postContent = '';
                        loadPosts();
                    };

                }])

})();