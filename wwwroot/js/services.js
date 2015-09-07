(function() {

    angular.module('cloudApp.services', [])

    .factory('postService', ['$http', '$q' , function($http, $q) {
    
        function loadPosts() {
            var deferred = $q.defer();
            $http.get('/post')
                .success(function(data) {
                    deferred.resolve(data);
                });
            return deferred.promise;
        }

        
        function addPost(content) {
            var deferred = $q.defer();
                var postData = 'body=' +content;
                $http({
                    method: 'POST',
                    url: '/post',
                    data: postData,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
                })
                .success(function(data) {
                    deferred.resolve(data);
                });
            return deferred.promise;
        }

        
        // I transform the error response, unwrapping the application dta from
        // the API response payload.
        function handleError(response) {

            // The API response from the server should be returned in a
            // nomralized format. However, if the request was not handled by the
            // server (or what not handles properly - ex. server error), then we
            // may have to normalize it on our end, as best we can.
            if (!angular.isObject(response.data) ||
                !response.data.message
            ) {

                return ($q.reject("An unknown error occurred."));

            }

            // Otherwise, use expected error message.
            return ($q.reject(response.data.message));

        }


        // I transform the successful response, unwrapping the application data
        // from the API response payload.
        function handleSuccess(response) {
            return (response.data);
        }

        return {
            addPost: addPost,
            loadPosts: loadPosts
        };

    }])

   

})();