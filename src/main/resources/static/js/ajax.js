"use strict"

/*
 * ajax GET 통신
 */
var ajaxCall = function (url, param, successCallback, failCallback) {
    var contentType = "application/json;charset=UTF-8";
    var dataType = "json";
    var dataParam;
    if(typeof param == "string") {
        dataParam = param;
    } else if(typeof param == "object") {
        dataParam = $.param(param);
    } else {
        alert("ajaxCall Type Error");
    }

    $.ajax({
        type : 'GET',
        url : url,
        contentType : contentType,
        data : dataParam,
        dataType : dataType,
        beforeSend : function () {
        },
        success : function (data) {
            try {
                if(data) {
                    if(typeof successCallback !== 'undefined') {
                        successCallback(data);
                    }
                }
            } catch (e) {
                alert("ajaxCall Error: " + e.message);
            }
        },
        error : function (error) {
            alert("Server Response Error: " + error);
        }
    });
};

/*
 * ajax POST 통신
 */
var ajaxPostCall = function (url, param, successCallback, failCallback) {
    var contentType = "application/json;charset=UTF-8";
    var dataType = "json";
    var dataParam;
    if(typeof param == "string") {
        dataParam = param;
    } else if(typeof param == "object") {
        dataParam = JSON.stringify(param);
    } else {
        $.alert("ajaxCall Type Error");
    }

    $.ajax({
        type : 'POST',
        url : url,
        contentType : contentType,
        data : dataParam,
        dataType : dataType,
        beforeSend : function () {
        },
        success : function (data) {
            try {
                if(data) {
                    if(typeof successCallback !== 'undefined') {
                        successCallback(data);
                    }
                }
            } catch (e) {
                $.alert("ajaxCall Error: " + e.message);
            }
        },
        error : function (error) {
            $.alert("Server Response Error: " + error);
        }
    });
};

/*
 * ajax GET 동기 통신
 */
var ajaxSyncCall = function (url, param, successCallback, failCallback) {
    var contentType = "application/json;charset=UTF-8";
    var dataType = "json";
    var dataParam;
    if(typeof param == "string") {
        dataParam = param;
    } else if(typeof param == "object") {
        dataParam = $.param(param);
    } else {
        $.alert("ajaxCall Type Error");
    }

    $.ajax({
        type : 'GET',
        url : url,
        async : false,
        contentType : contentType,
        data : dataParam,
        dataType : dataType,
        beforeSend : function () {
        },
        success : function (data) {
            try {
                if(data) {
                    if(typeof successCallback !== 'undefined') {
                        successCallback(data);
                    }
                }
            } catch (e) {
                $.alert("ajaxCall Error: " + e.message);
            }
        },
        error : function (error) {
            $.alert("Server Response Error: " + error);
        }
    });
};